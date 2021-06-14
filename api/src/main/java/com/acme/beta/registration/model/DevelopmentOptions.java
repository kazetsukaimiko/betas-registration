package com.acme.beta.registration.model;

import java.util.Arrays;
import java.util.List;

public class DevelopmentOptions {
    private List<DevEnv> developmentEnvironments = Arrays.asList(DevEnv.values());
    private List<DevLang> developmentLanguage = Arrays.asList(DevLang.values());

    public DevelopmentOptions() {
    }

    public List<DevEnv> getDevelopmentEnvironments() {
        return developmentEnvironments;
    }

    public void setDevelopmentEnvironments(List<DevEnv> developmentEnvironments) {
        this.developmentEnvironments = developmentEnvironments;
    }

    public List<DevLang> getDevelopmentLanguage() {
        return developmentLanguage;
    }

    public void setDevelopmentLanguage(List<DevLang> developmentLanguage) {
        this.developmentLanguage = developmentLanguage;
    }
}
