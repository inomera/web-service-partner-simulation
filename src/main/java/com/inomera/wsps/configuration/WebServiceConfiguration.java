package com.inomera.wsps.configuration;

import com.inomera.wsps.WspsApplication;
import com.inomera.wsps.configuration.PimsPartnerWebServiceConfig.SubscriptionConfig;
import com.inomera.wsps.interceptor.PimsApiSecurityInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {
    @Bean
    public Jaxb2Marshaller subscriptionMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.inomera.ws.schema.wsps.subscription");
        Map<String, Object> map = new HashMap<>();
        map.put("jaxb.formatted.output", true);
        marshaller.setMarshallerProperties(map);
        return marshaller;
    }

    @Bean
    public PayloadValidatingInterceptor payloadValidatingInterceptor(PimsPartnerWebServiceConfig partnerWebServiceConfig) {
        final PayloadValidatingInterceptor payloadValidatingInterceptor = new PayloadValidatingInterceptor();
        payloadValidatingInterceptor.setSchemas(
                new ClassPathResource(partnerWebServiceConfig.getCommonXsdLocation()),
                new ClassPathResource(partnerWebServiceConfig.getSubscription().getXsdLocation())
        );
        payloadValidatingInterceptor.setValidateRequest(true);
        payloadValidatingInterceptor.setValidateResponse(true);
        return payloadValidatingInterceptor;
    }

    @Bean
    @ConfigurationProperties(prefix = "pims.partner.ws")
    public PimsPartnerWebServiceConfig subscriptionWebServiceConfig() {
        return new PimsPartnerWebServiceConfig();
    }

    @Bean("PimsPartnerSubscription")
    public DefaultWsdl11Definition defaultWsdl11Definition(PimsPartnerWebServiceConfig partnerWebServiceConfig) {
        SubscriptionConfig subscriptionConfig = partnerWebServiceConfig.getSubscription();

        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(subscriptionConfig.getPortTypeName());
        wsdl11Definition.setLocationUri(subscriptionConfig.getLocationUri());
        wsdl11Definition.setTargetNamespace(subscriptionConfig.getNamespace());
        wsdl11Definition.setSchemaCollection(pimsSubscriptionSchemaCollection(partnerWebServiceConfig));
        return wsdl11Definition;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/services", "/PimsPartnerSubscription.wsdl");
    }

    @Bean
    public XsdSchemaCollection pimsSubscriptionSchemaCollection(PimsPartnerWebServiceConfig partnerWebServiceConfig) {
        var subscriptionXsd = new ClassPathResource(partnerWebServiceConfig.getSubscription().getXsdLocation());
        var commonXsd = new ClassPathResource(partnerWebServiceConfig.getCommonXsdLocation());
        var commonsXsdSchemaCollection = new CommonsXsdSchemaCollection(commonXsd, subscriptionXsd);
        commonsXsdSchemaCollection.setInline(true);
        return commonsXsdSchemaCollection;
    }


    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {
        final SoapFaultDefinition defaultFault = new SoapFaultDefinition();
        defaultFault.setFaultCode(SoapFaultDefinition.SERVER);

        final Properties exceptionMappings = new Properties();
        exceptionMappings.setProperty("org.springframework.oxm.ValidationFailureException", "CLIENT,Invalid request");

        final SoapFaultMappingExceptionResolver resolver = new SoapFaultMappingExceptionResolver();
        resolver.setDefaultFault(defaultFault);
        resolver.setExceptionMappings(exceptionMappings);
        resolver.setOrder(1);
        resolver.setWarnLogCategory(WspsApplication.class.getName());
        return resolver;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(pimsApiSecurityInterceptor());
    }

    @Bean
    public PimsApiSecurityInterceptor pimsApiSecurityInterceptor() {
        return new PimsApiSecurityInterceptor();
    }
}
