package com.acme.beta.registration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

/**
 * Developer Id class- represented as a string in
 * public facing endpoints but as a long internally.
 */
public class DevId {
    private final long internalId;

    public DevId(long internalId) {
        this.internalId = internalId;
    }

    @JsonCreator
    public DevId(String publicFacing) {
        this.internalId = asInternalId(publicFacing);
    }

    public long getInternalId() {
        return internalId;
    }

    @JsonValue
    public String getPublicFacingId() {
        return asPublicFacing(internalId);
    }

    public static String asPublicFacing(long input) {
        return Base64.getEncoder().encodeToString(String.valueOf(input).getBytes(StandardCharsets.UTF_8));
    }

    public static long asInternalId(String input) {
        return Long.parseLong(new String(Base64.getDecoder().decode(input), StandardCharsets.UTF_8));
    }

    @Override
    public String toString() {
        return getPublicFacingId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (long.class.isInstance(o) || Long.class.isInstance(o)) {
            return equals(new DevId((Long) o));
        }
        if (o == null || getClass() != o.getClass()) return false;
        DevId devId = (DevId) o;
        return internalId == devId.internalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalId);
    }

}
