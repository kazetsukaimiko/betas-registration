package com.acme.beta.registration.model;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Developer implements Model<DevId> {
    private DevId id;
    private ZonedDateTime registeredAt;
    private String firstName;
    private String lastName;
    private String instagramUsername;
    private String twitterUsername;
    private DevEnv developmentEnvironment;
    private DevLang developmentLanguage;
    private String location;

    public Developer() {
    }

    public Developer(Developer d) {
        this(
                d.id,
                d.registeredAt,
                d.firstName,
                d.lastName,
                d.instagramUsername,
                d.twitterUsername,
                d.developmentEnvironment,
                d.developmentLanguage,
                d.location
        );
    }

    public Developer(DevId id, ZonedDateTime registeredAt, String firstName, String lastName, String instagramUsername, String twitterUsername, DevEnv developmentEnvironment, DevLang developmentLanguage, String location) {
        this.id = id;
        this.registeredAt = registeredAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instagramUsername = instagramUsername;
        this.twitterUsername = twitterUsername;
        this.developmentEnvironment = developmentEnvironment;
        this.developmentLanguage = developmentLanguage;
        this.location = location;
    }

    public Developer(ZonedDateTime registeredAt, String firstName, String lastName, String instagramUsername, String twitterUsername, DevEnv developmentEnvironment, DevLang developmentLanguage, String location) {
        this.registeredAt = registeredAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instagramUsername = instagramUsername;
        this.twitterUsername = twitterUsername;
        this.developmentEnvironment = developmentEnvironment;
        this.developmentLanguage = developmentLanguage;
        this.location = location;
    }

    @Override
    public void setId(DevId id) {
        this.id = id;
    }

    @Override
    public DevId getId() {
        return id;
    }

    public ZonedDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(ZonedDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public DevEnv getDevelopmentEnvironment() {
        return developmentEnvironment;
    }

    public void setDevelopmentEnvironment(DevEnv developmentEnvironment) {
        this.developmentEnvironment = developmentEnvironment;
    }

    public DevLang getDevelopmentLanguage() {
        return developmentLanguage;
    }

    public void setDevelopmentLanguage(DevLang developmentLanguage) {
        this.developmentLanguage = developmentLanguage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(id, developer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
