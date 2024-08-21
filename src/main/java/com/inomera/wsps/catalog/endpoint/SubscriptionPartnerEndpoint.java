package com.inomera.wsps.catalog.endpoint;

import com.inomera.ws.schema.wsps.subscription.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class SubscriptionPartnerEndpoint extends AbstractSubscriptionPartnerEndpoint {
    private static final String NAMESPACE_URI = "http://www.avea.com.tr/pims-partner/schema/subscription";

    @ResponsePayload
    @PayloadRoot(localPart = "SubscriptionCreatedRequest", namespace = NAMESPACE_URI)
    public SubscriptionCreatedResponse handleSubscriptionCreatedRequest(
            @RequestPayload SubscriptionCreatedRequest request) {
        LOG.debug("SubscriptionCreatedRequest: {}", ReflectionToStringBuilder.toString(request));

        // PIMS Abonelik benzersiz key. Abonelik sorgulama ve iptal işlemlerinde kullanılabilir
        LOG.info("SubscriptionCreatedEndpoint subsKey: {}", request.getSubscription().getKey());

        // PIMS Aboneliğinin bağlı olduğu Jetders paketlerine karşılık gelen PIMS katalog unique key
        // JetDers Matematik paketi olduğu durumda PIMS katalogda X TL'lik teklif oluşturulur.
        LOG.info("SubscriptionCreatedEndpoint offerKey: {}", request.getSubscription().getOfferKey());

        // Jetders için abonelik createDate ve startDate aynı olacaktır.
        // PIMS Abonelik oluşturulma tarihi
        LOG.info("SubscriptionCreatedEndpoint createDate: {}", request.getSubscription().getCreateDate());
        // PIMS Abonelik başlangıç tarihi
        LOG.info("SubscriptionCreatedEndpoint startDate: {}", request.getSubscription().getStartDate());

        // Abonelik ile ilişkilendirilmiş aktivasyon kodu
        request.getNamedParam().stream()
                .filter(namedParam -> namedParam.getKey().equalsIgnoreCase("activationCode"))
                .forEach(namedParam -> LOG.info("SubscriptionCreatedEndpoint activationCode: {}", namedParam.getValue()));

        SubscriptionCreatedResponse response = new SubscriptionCreatedResponse();
        response.setServiceResult(createSuccessServiceResult());
        LOG.debug("SubscriptionCreatedResponse: {}", ReflectionToStringBuilder.toString(response));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "SubscriptionToBeDeactivatedRequest", namespace = NAMESPACE_URI)
    public SubscriptionToBeDeactivatedResponse handleSubscriptionToBeDeactivatedRequest(
            @RequestPayload SubscriptionToBeDeactivatedRequest request) {
        LOG.debug("SubscriptionToBeDeactivatedRequest: {}", ReflectionToStringBuilder.toString(request));

        // PIMS Abonelik unique key. Abonelik sorgulama ve iptal işlemlerinde kullanılabilir.
        LOG.info("SubscriptionToBeDeactivatedEndpoint subsKey: {}", request.getSubscription().getKey());

        // PIMS Aboneliğinin bağlı olduğu Jetders paketlerine karşılık gelen PIMS katalog unique key
        // JetDers Matematik paketi olduğu durumda PIMS katalogda X TL'lik teklif oluşturulur.
        LOG.info("SubscriptionToBeDeactivatedEndpoint offerKey: {}", request.getSubscription().getOfferKey());

        // Aboneliğin sonlandırılacağı tarih. Abonelik bitiş tarihi geçmiş abonelikler PIMS tarafından
        // otomatik olarak iptal edilir.
        LOG.info("SubscriptionToBeDeactivatedEndpoint endDate: {}", request.getSubscription().getEndDate());

        // Abonelik ile ilişkilendirilmiş aktivasyon kodu
        request.getNamedParam().stream()
                .filter(namedParam -> namedParam.getKey().equalsIgnoreCase("activationCode"))
                .forEach(namedParam -> LOG.info("SubscriptionToBeDeactivatedEndpoint activationCode: {}", namedParam.getValue()));

        SubscriptionToBeDeactivatedResponse response = new SubscriptionToBeDeactivatedResponse();
        response.setServiceResult(createSubscriptionToBeDeactivatedSuccessServiceResult());
        LOG.debug("SubscriptionToBeDeactivatedResponse: {}", ReflectionToStringBuilder.toString(response));

        return response;
    }


    @ResponsePayload
    @PayloadRoot(localPart = "SubscriptionDeactivatedRequest", namespace = NAMESPACE_URI)
    public SubscriptionDeactivatedResponse handleSubscriptionDeactivatedRequest(
            @RequestPayload SubscriptionDeactivatedRequest request) {
        LOG.debug("SubscriptionDeactivatedRequest: {}", ReflectionToStringBuilder.toString(request));

        // PIMS Abonelik unique key. Abonelik sorgulama ve iptal işlemlerinde kullanılabilir.
        LOG.info("SubscriptionDeactivatedEndpoint subsKey: {}", request.getSubscription().getKey());

        // PIMS Aboneliğinin bağlı olduğu Jetders paketlerine karşılık gelen PIMS katalog unique key
        // JetDers Matematik paketi olduğu durumda PIMS katalogda X TL'lik teklif oluşturulur.
        LOG.info("SubscriptionDeactivatedEndpoint offerKey: {}", request.getSubscription().getOfferKey());

        // Abonelik ile ilişkilendirilmiş aktivasyon kodu
        request.getNamedParam().stream()
                .filter(namedParam -> namedParam.getKey().equalsIgnoreCase("activationCode"))
                .forEach(namedParam -> LOG.info("SubscriptionDeactivatedEndpoint activationCode: {}", namedParam.getValue()));

        SubscriptionDeactivatedResponse response = new SubscriptionDeactivatedResponse();
        response.setServiceResult(createSuccessServiceResult());
        LOG.debug("SubscriptionDeactivatedResponse: {}", ReflectionToStringBuilder.toString(response));

        return response;
    }
}
