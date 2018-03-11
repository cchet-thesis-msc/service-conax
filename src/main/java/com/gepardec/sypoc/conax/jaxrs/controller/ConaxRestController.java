package com.gepardec.sypoc.conax.jaxrs.controller;

import com.gepardec.sypoc.conax.jaxrs.model.ConaxRequest;
import com.gepardec.sypoc.conax.utils.LogHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/11/18
 */
@RestController()
@RequestMapping(path = "/rest-api")
public class ConaxRestController {

    private final Logger log;

    @Autowired
    public ConaxRestController(final Logger log) {
        this.log = log;
    }

    @PostMapping(path = "/conax", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String postConax(@RequestBody ConaxRequest request) {
        log.info(LogHelper.buildReceivedMessageOnRestEndpoint("/conax", request));

        return "received";
    }
}
