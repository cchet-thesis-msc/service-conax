package com.gepardec.sypoc.conax.soap.impl;

import com.gepardec.sypoc.wsdl.conax.outgoingmessage.MessageRequest;
import com.gepardec.sypoc.wsdl.conax.outgoingmessage.MessageResponse;
import com.gepardec.sypoc.wsdl.conax.outgoingmessage.OutgoingMessagePortType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/04/18
 */
public class ConaxWebserviceImpl implements OutgoingMessagePortType {

    private final Logger log;

    public ConaxWebserviceImpl() {
        this.log = LoggerFactory.getLogger(ConaxWebserviceImpl.class);
    }

    @Override
    public MessageResponse messageRequest(MessageRequest parameters) {
        log.info("Message received");

        return null;
    }
}
