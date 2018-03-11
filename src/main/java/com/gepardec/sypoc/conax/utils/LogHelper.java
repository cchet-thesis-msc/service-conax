package com.gepardec.sypoc.conax.utils;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/03/18
 */
public class LogHelper {

    public static final String TEMPLATE_RECEVIED_MESSAGE_ON_rest_ENDPOINT = "Received message on rest endpoint '%s': data=%s";

    private LogHelper() {
    }

    public static String buildReceivedMessageOnRestEndpoint(final String endpoint, final Object data) {
        return String.format(TEMPLATE_RECEVIED_MESSAGE_ON_rest_ENDPOINT, endpoint, (data != null) ? data.toString() : "null");
    }
}
