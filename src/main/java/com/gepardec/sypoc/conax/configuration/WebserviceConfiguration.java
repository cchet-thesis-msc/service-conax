package com.gepardec.sypoc.conax.configuration;

import com.gepardec.sypoc.conax.jaxws.ConaxWebserviceImpl;
import com.gepardec.sypoc.wsdl.conax.outgoingmessage.OutgoingMessagePortType;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/11/18
 */
@Configuration
public class WebserviceConfiguration {

    private final Bus bus;

    @Autowired
    public WebserviceConfiguration(final Bus bus) {
        this.bus = bus;
    }

    @Bean
    OutgoingMessagePortType createConaxWebserviceImpl() {
        return new ConaxWebserviceImpl();
    }

    @Bean("conaxEndpoint")
    Endpoint createConaxWebserviceEndpoint(final OutgoingMessagePortType service) {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.setWsdlLocation("classpath:/wsdl/OutgoingMessage.wsdl");
        endpoint.setServiceName(new QName("http://gepardec.com/sypoc/wsdl/conax/outgoingMessage", "OutgoingMessage"));
        endpoint.publish("/conax");

        return endpoint;
    }
}
