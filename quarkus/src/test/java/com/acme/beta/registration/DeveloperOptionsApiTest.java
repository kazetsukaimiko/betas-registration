package com.acme.beta.registration;

import com.acme.beta.registration.jaxrs.DevelopmentEndpoint;
import com.acme.beta.registration.model.DevEnv;
import com.acme.beta.registration.model.DevLang;
import com.acme.beta.registration.model.DevelopmentOptions;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class DeveloperOptionsApiTest extends CommonApiTest<DevelopmentEndpoint> {
    @Override
    protected Class<DevelopmentEndpoint> apiClass() {
        return DevelopmentEndpoint.class;
    }

    /**
     * Make sure enum options are avaiable to the frontend
     */
    @Test
    public void testApiOptions() {
        DevelopmentOptions options = getApi().getOptions();
        assertTrue(options.getDevelopmentLanguage().containsAll(Arrays.asList(DevLang.values())));
        assertTrue(options.getDevelopmentEnvironments().containsAll(Arrays.asList(DevEnv.values())));
    }
}
