package com.acme.beta.registration;

import com.acme.beta.registration.model.Developer;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Enumeration of DeveloperComparisons so that we can run them
 * without repeating code in test method bodies
 */
public enum DeveloperComparisons implements DeveloperComparison {
    ID_NOT_NULL_AND_SAME(true) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertNotNull(result.getId(), name() + ": Id should be set in resulting payload");
            if (origin.getId() != null) {
                assertEquals(origin.getId(), result.getId(), name() + ": Ids should match");
            }
        }
    },
    REGISTERED_AT_PRESENT_AND_VALID(true) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertNotNull(result.getRegisteredAt(), name() + ": Registered at should be set");
            assertTrue(result.getRegisteredAt().compareTo(origin.getRegisteredAt()) >= 0,
                    name() + ": RegisteredAt should be updated, thus be the same or greater");
        }
    },
    FIRST_NAME_SAME(true) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertEquals(result.getFirstName(), origin.getFirstName(), name());
        }
    },
    FIRST_NAME_NOT_SAME(false) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertNotEquals(result.getFirstName(), origin.getFirstName(), name());
        }
    },
    LAST_NAME_SAME(true) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertEquals(result.getLastName(), origin.getLastName(), name());
        }
    },
    LAST_NAME_NOT_SAME(false) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertNotEquals(result.getLastName(), origin.getLastName(), name());
        }
    },
    INSTAGRAM_SAME(true) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertEquals(result.getInstagramUsername(), origin.getInstagramUsername(), name());
        }
    },
    TWITTER_SAME(true) {
        @Override
        public void compare(Developer origin, Developer result) {
            assertEquals(result.getTwitterUsername(), origin.getTwitterUsername(), name());
        }
    }
    ;

    private final boolean defaultComparison;

    DeveloperComparisons(boolean defaultComparison) {
        this.defaultComparison = defaultComparison;
    }

    @Override
    public boolean isDefaultComparison() {
        return defaultComparison;
    }

    public static Stream<DeveloperComparisons> all() {
        return Stream.of(values())
                .filter(DeveloperComparison::isDefaultComparison);
    }

    public static Stream<DeveloperComparisons> minus(DeveloperComparisons... comp) {
        return all()
                .filter(c -> Stream.of(comp).noneMatch(neg -> Objects.equals(c, neg)));
    }

    public static Stream<DeveloperComparisons> swap(DeveloperComparisons a, DeveloperComparisons b) {
        return Stream.concat(minus(a), Stream.of(b));
    }


    public static void compare(Developer origin, Developer result, Stream<DeveloperComparisons> comparisonsStream) {
        comparisonsStream
                .forEach(comparison -> comparison.compare(origin, result));
    }
}
