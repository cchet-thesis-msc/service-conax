package com.gepardec.sypoc.conax;

import com.gepardec.sypoc.conax.service.impl.ConaxWebserviceImpl;
import com.gepardec.sypoc.wsdl.conax.outgoingmessage.OutgoingMessagePortType;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/04/18
 */
@SpringBootApplication
@PropertySource("${CONFIG_LOCATION_EXTERNAL}")
@ComponentScan(basePackageClasses = Application.class)
@EnableAutoConfiguration
public class Application {

    // must have a main method spring-boot can run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final Bus bus;

    @Autowired
    public Application(final Bus bus) {
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
