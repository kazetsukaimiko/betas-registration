package com.acme.beta.registration.jpa;

import com.acme.beta.registration.model.DevEnv;
import com.acme.beta.registration.model.DevId;
import com.acme.beta.registration.model.DevLang;
import com.acme.beta.registration.model.Developer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
public class PersistedDeveloper {

    @Id
    @GeneratedValue
    private Long id;
    private ZonedDateTime registeredAt;
    private String firstName;
    private String lastName;
    private String instagramUsername;
    private String twitterUsername;
    private DevEnv developmentEnvironment;
    private DevLang developmentLanguage;
    private String location;

    public PersistedDeveloper() {
    }

    public PersistedDeveloper(Developer d) {
        this(
                d.getId() != null ? d.getId().getInternalId() : null,
                d.getRegisteredAt(),
                d.getFirstName(),
                d.getLastName(),
                d.getInstagramUsername(),
                d.getTwitterUsername(),
                d.getDevelopmentEnvironment(),
                d.getDevelopmentLanguage(),
                d.getLocation()
        );
    }

    public PersistedDeveloper(Long id, ZonedDateTime registeredAt, String firstName, String lastName, String instagramUsername, String twitterUsername, DevEnv developmentEnvironment, DevLang developmentLanguage, String location) {
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

    public PersistedDeveloper(ZonedDateTime registeredAt, String firstName, String lastName, String instagramUsername, String twitterUsername, DevEnv developmentEnvironment, DevLang developmentLanguage, String location) {
        this.registeredAt = registeredAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instagramUsername = instagramUsername;
        this.twitterUsername = twitterUsername;
        this.developmentEnvironment = developmentEnvironment;
        this.developmentLanguage = developmentLanguage;
        this.location = location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    @Transient
    @JsonIgnore
    public Developer toDeveloper() {
        return new Developer(
                new DevId(getId()),
                getRegisteredAt(),
                getFirstName(),
                getLastName(),
                getInstagramUsername(),
                getTwitterUsername(),
                getDevelopmentEnvironment(),
                getDevelopmentLanguage(),
                getLocation()
        );
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
        PersistedDeveloper developer = (PersistedDeveloper) o;
        return Objects.equals(id, developer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
