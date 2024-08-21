package com.inomera.wsps.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PimsPartnerWebServiceConfig {
    private String commonXsdLocation;
    private SubscriptionConfig subscription;

    @Getter
    @Setter
    public static class SubscriptionConfig {
        private String portTypeName;
        private String locationUri;
        private String xsdLocation;
        private String namespace;
    }
}
