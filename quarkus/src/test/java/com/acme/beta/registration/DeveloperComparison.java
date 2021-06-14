package com.acme.beta.registration;

import com.acme.beta.registration.model.Developer;

/**
 * Interface to run a comparison between two developer model payloads
 */
public interface DeveloperComparison {
    void compare(Developer origin, Developer result);
    boolean isDefaultComparison();
}
