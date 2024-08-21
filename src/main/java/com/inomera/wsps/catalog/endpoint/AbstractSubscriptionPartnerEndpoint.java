package com.inomera.wsps.catalog.endpoint;

import com.inomera.ws.schema.wsps.subscription.SubscriptionServiceResult;
import com.inomera.ws.schema.wsps.subscription.SubscriptionServiceResultCode;
import com.inomera.ws.schema.wsps.subscription.SubscriptionToBeDeactivatedServiceResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractSubscriptionPartnerEndpoint {

    protected SubscriptionServiceResult createSuccessServiceResult() {
        var result = new SubscriptionServiceResult();
        result.setResultCode(SubscriptionServiceResultCode.OK);
        result.setResultTxt("Service processed successfully");
        return result;
    }

    protected SubscriptionToBeDeactivatedServiceResult createSubscriptionToBeDeactivatedSuccessServiceResult() {
        var result = new SubscriptionToBeDeactivatedServiceResult();
        result.setResultCode(SubscriptionServiceResultCode.OK);
        result.setResultTxt("Service processed successfully");
        return result;
    }

    protected SubscriptionServiceResult createFailServiceResult() {
        var result = new SubscriptionServiceResult();
        result.setResultCode(SubscriptionServiceResultCode.FAILED);
        result.setResultTxt("WSPS: Simulating partner error.");
        return result;
    }
}
