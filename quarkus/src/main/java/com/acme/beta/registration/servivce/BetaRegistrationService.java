package com.acme.beta.registration.servivce;

import com.acme.beta.registration.jaxrs.BetaRegistrationEndpoint;
import com.acme.beta.registration.jpa.DeveloperPersistence;
import com.acme.beta.registration.jpa.PersistedDeveloper;
import com.acme.beta.registration.model.DevId;
import com.acme.beta.registration.model.Developer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import java.time.ZonedDateTime;
import java.util.function.Consumer;

@Path("/beta/developers")
@ApplicationScoped
public class BetaRegistrationService implements BetaRegistrationEndpoint {
    @Inject
    DeveloperPersistence persistence;

    @Transactional
    @Override
    public Developer create(Developer input) throws BadRequestException {
        PersistedDeveloper toCreate = new PersistedDeveloper(input);
        toCreate.setRegisteredAt(ZonedDateTime.now());
        return persistence.save(toCreate).toDeveloper();
    }

    @Transactional
    @Override
    public String deleteById(DevId idParam) throws NotFoundException, NotAuthorizedException {
        int rows = persistence.delete(idParam.getInternalId());
        if (rows != 1) {
            throw new NotFoundException("Deletion target not found");
        }
        return DELETE_RESPONSE;
    }

    @Override
    public Developer findById(DevId idParam) throws NotFoundException, NotAuthorizedException {
        return persistence.get(idParam.getInternalId())
                .orElseThrow(NotFoundException::new)
                .toDeveloper();
    }

    @Transactional
    @Override
    public Developer updateId(DevId idParam, Developer update) throws NotFoundException, BadRequestException, NotAuthorizedException {
        // Preserve immutable data
        PersistedDeveloper fetched = persistence.get(idParam.getInternalId())
                .orElseThrow(NotFoundException::new);

        // Mutable fields
        ifNotNull(update.getFirstName(), fetched::setFirstName);
        ifNotNull(update.getLastName(), fetched::setLastName);
        ifNotNull(update.getDevelopmentEnvironment(), fetched::setDevelopmentEnvironment);
        ifNotNull(update.getDevelopmentLanguage(), fetched::setDevelopmentLanguage);
        ifNotNull(update.getInstagramUsername(), fetched::setInstagramUsername);
        ifNotNull(update.getTwitterUsername(), fetched::setTwitterUsername);
        ifNotNull(update.getLocation(), fetched::setLocation);

        return persistence.save(fetched)
                .toDeveloper();
    }

    private <X> void ifNotNull(X canBeNull, Consumer<X> doThis) {
        if (canBeNull != null) {
            doThis.accept(canBeNull);
        }
    }
}
