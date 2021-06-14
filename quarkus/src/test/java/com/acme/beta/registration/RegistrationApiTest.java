package com.acme.beta.registration;


import com.acme.beta.registration.jaxrs.BetaRegistrationEndpoint;
import com.acme.beta.registration.model.DevEnv;
import com.acme.beta.registration.model.DevId;
import com.acme.beta.registration.model.DevLang;
import com.acme.beta.registration.model.Developer;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.time.ZonedDateTime;
import java.util.Objects;

import static com.acme.beta.registration.jaxrs.BetaRegistrationEndpoint.DELETE_RESPONSE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class RegistrationApiTest extends CommonApiTest<BetaRegistrationEndpoint> {



    /**
     * Test and verify a creation
     */
    @Test
    public void testSingleCreate() {
        Developer random = randomDeveloper();
        Developer result = getApi().create(random);
        DeveloperComparisons.compare(random, result, DeveloperComparisons.all());
    }

    /**
     * Test and verify a read
     */
    @Test
    public void testSingleRead() {
        Developer random = randomDeveloper();
        Developer result = getApi().create(random);
        DeveloperComparisons.compare(random, result, DeveloperComparisons.all());

        Developer fetched = getApi().findById(result.getId());
        DeveloperComparisons.compare(result, fetched, DeveloperComparisons.all());
    }

    /**
     * Test and verify an update
     */
    @Test
    public void testSingleUpdate() {
        Developer random = randomDeveloper();
        Developer result = getApi().create(random);

        DeveloperComparisons.compare(random, result, DeveloperComparisons.all());

        Developer fetched = getApi().findById(result.getId());
        DeveloperComparisons.compare(result, fetched, DeveloperComparisons.all());

        Developer update = new Developer(fetched);
        String newLastName = GeneratedStuff.randomLast();
        while (Objects.equals(fetched.getLastName(), newLastName)) {
            newLastName = GeneratedStuff.randomLast();
        }
        update.setLastName(newLastName);

        Developer updated = getApi().updateId(update.getId(), update);
        DeveloperComparisons.compare(fetched, updated, DeveloperComparisons.swap(DeveloperComparisons.LAST_NAME_SAME, DeveloperComparisons.LAST_NAME_NOT_SAME));
    }

    /**
     * Test and verify a deletion
     */
    @Test
    public void testSingleDelete() {
        assertThrows(NotFoundException.class, () -> getApi().deleteById(new DevId(Long.MAX_VALUE)));

        Developer random = randomDeveloper();
        Developer result = getApi().create(random);
        DeveloperComparisons.compare(random, result, DeveloperComparisons.all());

        Developer fetched = getApi().findById(result.getId());
        DeveloperComparisons.compare(result, fetched, DeveloperComparisons.all());
        
        String deletion = getApi().deleteById(fetched.getId());
        assertEquals(DELETE_RESPONSE, deletion);

        assertThrows(NotFoundException.class, () -> getApi().deleteById(fetched.getId()));

    }

    // TODO: Add test methods creating X number of unique random users and then cherry pick modifying/deleting them

    /**
     * Method to return a randomized Developer payload
     * @return
     */
    public Developer randomDeveloper() {
        return new Developer(
                null,
                ZonedDateTime.now(),
                GeneratedStuff.randomFirst(),
                GeneratedStuff.randomLast(),
                null,
                null,
                GeneratedStuff.randomEnum(DevEnv.values()),
                GeneratedStuff.randomEnum(DevLang.values()),
                null
        );
    }

    @Override
    protected Class<BetaRegistrationEndpoint> apiClass() {
        return BetaRegistrationEndpoint.class;
    }
}
