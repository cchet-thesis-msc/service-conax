package com.gepardec.sypoc.conax.configurations;

import com.gepardec.sypoc.conax.soap.impl.ConaxWebserviceImpl;
import com.gepardec.sypoc.wsdl.conax.outgoingmessage.OutgoingMessagePortType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/12/18
 */
@Configuration
public class WebserviceConfiguration {

    @Bean
    OutgoingMessagePortType createConaxWebserviceImpl() {
        return new ConaxWebserviceImpl();
    }

}
