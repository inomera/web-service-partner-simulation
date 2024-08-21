# Web Service Partner Simulation

## Overview

This project provides a set of web service endpoints for managing subscriptions. The endpoints are implemented using
Spring Boot and are exposed via SOAP web services.

## WSDL and Endpoint

The WSDL for the web service can be accessed at the following URL:

- **PIMS Partner WSDL**: [http://localhost:8080/PimsPartnerSubscription.wsdl](http://localhost:8080/PimsPartnerSubscription.wsdl)
- **PIMS Partner Endpoint**: [http://localhost:8080/services](http://localhost:8080/services)

## Endpoints

### SubscriptionPartnerEndpoint

This endpoint handles various subscription-related requests. The namespace URI for all operations
is `http://www.avea.com.tr/pims-partner/schema/subscription`.

#### Operations

1. **SubscriptionCreatedRequest**
    - **Local Part**: `SubscriptionCreatedRequest`
    - **Method**: `handleSubscriptionCreatedRequest`
    - **Description**: Handles the creation of a new subscription.
    - **Response**: `SubscriptionCreatedResponse`

2. **SubscriptionToBeDeactivatedRequest**
    - **Local Part**: `SubscriptionToBeDeactivatedRequest`
    - **Method**: `handleSubscriptionToBeDeactivatedRequest`
    - **Description**: Handles the request to deactivate a subscription at the end of the current period.
    - **Response**: `SubscriptionToBeDeactivatedResponse`

3. **SubscriptionDeactivatedRequest**
    - **Local Part**: `SubscriptionDeactivatedRequest`
    - **Method**: `handleSubscriptionDeactivatedRequest`
    - **Description**: Handles the deactivation of a subscription.
    - **Response**: `SubscriptionDeactivatedResponse`

## Example Requests

### SubscriptionCreatedRequest

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns0:SubscriptionCreatedRequest xmlns:ns0="http://www.avea.com.tr/pims-partner/schema/subscription">
            <NotificationKey>NOT260778</NotificationKey>
            <Subscription>
                <Key>SUB3538</Key>
                <OfferKey>OFRMEDYA</OfferKey>
                <ProductKey>PRDMEDYA</ProductKey>
                <CreateDate>2024-08-21T19:44:13.468+03:00</CreateDate>
                <StartDate>2024-08-21T19:44:13.468+03:00</StartDate>
                <LastRenewalDate>2024-08-21T19:44:13.468+03:00</LastRenewalDate>
                <RenewalCount>1</RenewalCount>
                <Status>ACTIVE</Status>
                <RecurringPricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP27750</Key>
                        <SubscriptionKey>SUB3538</SubscriptionKey>
                        <PricingPlanKey>OPP190083</PricingPlanKey>
                        <CreateDate>2024-08-21T19:44:13.468+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <CurrentInterval>1</CurrentInterval>
                    <AutoRenew>true</AutoRenew>
                    <CreateDate>2024-08-21T19:44:13.468+03:00</CreateDate>
                    <StartDate>2024-08-21T19:44:13.468+03:00</StartDate>
                    <LastRenewalDate>2024-08-21T19:44:13.468+03:00</LastRenewalDate>
                    <NextRenewalDate>2024-09-20T19:44:13.468+03:00</NextRenewalDate>
                    <UnpaidPeriodEndDate>2024-12-20T19:44:13.468+03:00</UnpaidPeriodEndDate>
                    <PeriodBalanceInMillis>0</PeriodBalanceInMillis>
                </RecurringPricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP27748</Key>
                        <SubscriptionKey>SUB3538</SubscriptionKey>
                        <PricingPlanKey>OPP190081</PricingPlanKey>
                        <CreateDate>2024-08-21T19:44:13.468+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVCONTENTMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-21T19:44:13.468+03:00</StartDate>
                </UsagePricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP27746</Key>
                        <SubscriptionKey>SUB3538</SubscriptionKey>
                        <PricingPlanKey>OPP190080</PricingPlanKey>
                        <CreateDate>2024-08-21T19:44:13.468+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVSMSMOMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-21T19:44:13.468+03:00</StartDate>
                </UsagePricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP27744</Key>
                        <SubscriptionKey>SUB3538</SubscriptionKey>
                        <PricingPlanKey>OPP190082</PricingPlanKey>
                        <CreateDate>2024-08-21T19:44:13.468+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVSMSMTMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-21T19:44:13.468+03:00</StartDate>
                </UsagePricingPlans>
            </Subscription>
            <Address>
                <Msisdn>905554443323</Msisdn>
            </Address>
            <TxKey>TX1672760</TxKey>
            <NamedParam>
                <Key>activationCode</Key>
                <Value>32ChdQePYw</Value>
            </NamedParam>
        </ns0:SubscriptionCreatedRequest>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### SubscriptionCreatedResponse

#### Success

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns3:SubscriptionCreatedResponse xmlns:ns3="http://www.avea.com.tr/pims-partner/schema/subscription">
            <ServiceResult>
                <ResultCode>OK</ResultCode>
                <ResultTxt>Service processed successfully</ResultTxt>
            </ServiceResult>
        </ns3:SubscriptionCreatedResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

#### Fail

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns3:SubscriptionCreatedResponse xmlns:ns3="http://www.avea.com.tr/pims-partner/schema/subscription">
            <ServiceResult>
                <ResultCode>FAILED</ResultCode>
                <ResultTxt>WSPS: Simulating partner error.</ResultTxt>
            </ServiceResult>
        </ns3:SubscriptionCreatedResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### SubscriptionToBeDeactivatedRequest

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns0:SubscriptionToBeDeactivatedRequest xmlns:ns0="http://www.avea.com.tr/pims-partner/schema/subscription">
            <NotificationKey>NOT260844</NotificationKey>
            <Subscription>
                <Key>SUB3604</Key>
                <OfferKey>OFRMEDYA</OfferKey>
                <ProductKey>PRDMEDYA</ProductKey>
                <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                <EndDate>2024-09-21T10:39:38.643+03:00</EndDate>
                <LastRenewalDate>2024-08-22T10:39:38.643+03:00</LastRenewalDate>
                <RenewalCount>1</RenewalCount>
                <Status>ACTIVE</Status>
                <RecurringPricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28108</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190083</PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <CurrentInterval>1</CurrentInterval>
                    <AutoRenew>true</AutoRenew>
                    <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                    <LastRenewalDate>2024-08-22T10:39:38.643+03:00</LastRenewalDate>
                    <NextRenewalDate>2024-09-21T10:39:38.643+03:00</NextRenewalDate>
                    <UnpaidPeriodEndDate>2024-12-21T10:39:38.643+03:00</UnpaidPeriodEndDate>
                    <PeriodBalanceInMillis>0</PeriodBalanceInMillis>
                </RecurringPricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28106</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190081</PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVCONTENTMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                </UsagePricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28102</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190082</PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVSMSMTMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                </UsagePricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28104</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190080</PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVSMSMOMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                </UsagePricingPlans>
            </Subscription>
            <Address>
                <Msisdn>905554443323</Msisdn>
            </Address>
            <TxKey>TX1673013</TxKey>
            <NamedParam>
                <Key>subscriptionStopReason</Key>
                <Value>İş ortağının isteğiyle abonelik iptal edildi.</Value>
            </NamedParam>
            <NamedParam>
                <Key>com.inomera.pims.sal.so.subscription.SubscriptionStopRequestReason</Key>
                <Value>PARTNER_DEACTIVE</Value>
            </NamedParam>
            <NamedParam>
                <Key>stopChannel</Key>
                <Value>PTRAPI</Value>
            </NamedParam>
            <NamedParam>
                <Key>activationCode</Key>
                <Value>32ChdQePYw</Value>
            </NamedParam>
        </ns0:SubscriptionToBeDeactivatedRequest>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### SubscriptionToBeDeactivatedResponse

#### Success

```xml

<SOAP-ENV:Envelope
        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns3:SubscriptionToBeDeactivatedResponse
                xmlns:ns3="http://www.avea.com.tr/pims-partner/schema/subscription">
            <ServiceResult>
                <ResultCode>OK</ResultCode>
                <ResultTxt>Service processed successfully</ResultTxt>
            </ServiceResult>
        </ns3:SubscriptionToBeDeactivatedResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

#### Fail

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns3:SubscriptionToBeDeactivatedResponse xmlns:ns3="http://www.avea.com.tr/pims-partner/schema/subscription">
            <ServiceResult>
                <ResultCode>FAILED</ResultCode>
                <ResultTxt>WSPS: Simulating partner error.</ResultTxt>
            </ServiceResult>
        </ns3:SubscriptionToBeDeactivatedResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### SubscriptionDeactivatedRequest

```xml

<SOAP-ENV:Envelope
        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns0:SubscriptionDeactivatedRequest xmlns:ns0="http://www.avea.com.tr/pims-partner/schema/subscription">
            <NotificationKey>NOT260845</NotificationKey>
            <Subscription>
                <Key>SUB3604</Key>
                <OfferKey>OFRMEDYA</OfferKey>
                <ProductKey>PRDMEDYA</ProductKey>
                <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                <LastRenewalDate>2024-08-22T10:39:38.643+03:00</LastRenewalDate>
                <RenewalCount>1</RenewalCount>
                <Status>DEACTIVE</Status>
                <RecurringPricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28108</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190083</PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <CurrentInterval>1</CurrentInterval>
                    <AutoRenew>true</AutoRenew>
                    <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                    <LastRenewalDate>2024-08-22T10:39:38.643+03:00</LastRenewalDate>
                    <NextRenewalDate>2024-09-21T10:39:38.643+03:00</NextRenewalDate>
                    <UnpaidPeriodEndDate>2024-12-21T10:39:38.643+03:00
                    </UnpaidPeriodEndDate>
                    <PeriodBalanceInMillis>-2586538526</PeriodBalanceInMillis>
                </RecurringPricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28106</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190081</PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVCONTENTMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                </UsagePricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28102</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190082
                        </PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVSMSMTMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                </UsagePricingPlans>
                <UsagePricingPlans>
                    <AbstractSubscriptionPricingPlan>
                        <Key>SPP28104</Key>
                        <SubscriptionKey>SUB3604</SubscriptionKey>
                        <PricingPlanKey>OPP190080</PricingPlanKey>
                        <CreateDate>2024-08-22T10:39:38.643+03:00</CreateDate>
                    </AbstractSubscriptionPricingPlan>
                    <ServiceKey>SRVSMSMOMEDYA</ServiceKey>
                    <ChargingModel>PUNIT</ChargingModel>
                    <StartDate>2024-08-22T10:39:38.643+03:00</StartDate>
                </UsagePricingPlans>
            </Subscription>
            <Address>
                <Msisdn>905554443323</Msisdn>
            </Address>
            <TxKey>TX1673019</TxKey>
            <NamedParam>
                <Key>subscriptionStopReason</Key>
                <Value>İş ortağının isteğiyle abonelik iptal edildi.</Value>
            </NamedParam>
            <NamedParam>
                <Key>com.inomera.pims.sal.so.subscription.SubscriptionStopRequestReason</Key>
                <Value>PARTNER_DEACTIVE</Value>
            </NamedParam>
            <NamedParam>
                <Key>stopChannel</Key>
                <Value>PTRAPI</Value>
            </NamedParam>
            <NamedParam>
                <Key>activationCode</Key>
                <Value>32ChdQePYw</Value>
            </NamedParam>
        </ns0:SubscriptionDeactivatedRequest>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### SubscriptionDeactivatedResponse

#### Success

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns3:SubscriptionDeactivatedResponse xmlns:ns3="http://www.avea.com.tr/pims-partner/schema/subscription">
         <ServiceResult>
            <ResultCode>OK</ResultCode>
            <ResultTxt>Service processed successfully</ResultTxt>
         </ServiceResult>
      </ns3:SubscriptionDeactivatedResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

#### Fail

```xml

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns3:SubscriptionDeactivatedResponse xmlns:ns3="http://www.avea.com.tr/pims-partner/schema/subscription">
         <ServiceResult>
            <ResultCode>FAILED</ResultCode>
            <ResultTxt>WSPS: Simulating partner error.</ResultTxt>
         </ServiceResult>
      </ns3:SubscriptionDeactivatedResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

## Logging

The endpoint methods log various details about the requests and responses for debugging purposes. The logs include
information such as subscription keys, offer keys, creation dates, start dates, and activation codes.

## Security

The `PimsApiSecurityInterceptor` class handles basic authentication for the web service. It checks the `Authorization`
header for valid credentials.

## Contact

For any questions or issues, please contact the development team.

