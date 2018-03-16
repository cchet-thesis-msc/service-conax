package com.gepardec.sypoc.conax.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gepardec.sypoc.conax.annotation.Nullable;
import org.immutables.value.Value;

import java.time.LocalDateTime;

/**
 * This models represents the conax request model for the rest interface.
 * It uses immutables or creation of an immutable implementation and jackson json as the json provider.
 *
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/11/18
 */
@Value.Immutable
@JsonSerialize(as = ImmutableConaxRequest.class)
@JsonDeserialize(as = ImmutableConaxRequest.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ConaxRequest {

    @JsonProperty("service")
    String service();

    @JsonProperty("action")
    String action();

    @JsonProperty("data")
    ConaxRequestData data();

    @Value.Immutable
    @JsonSerialize(as = ImmutableConaxRequestData.class)
    @JsonDeserialize(as = ImmutableConaxRequestData.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    interface ConaxRequestData {


        @JsonProperty("orderList")
        String orderList();

        @JsonProperty("country")
        String country();

        @JsonProperty("nofsmartcards")
        byte nofsmartcards();

        @JsonProperty("active")
        boolean active();

        @JsonProperty("errorDate")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy hh:mm:ss")
        @Nullable
        LocalDateTime errorDate();

        @JsonProperty("errorDescription")
        @Nullable
        String errorDescription();

        @JsonProperty("priority")
        int priority();

        @JsonProperty("productId")
        String productId();

        @JsonProperty("subscriptionStart")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
        LocalDateTime subscriptionStart();

        @JsonProperty("subscriptionEnd")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
        LocalDateTime subscriptionEnd();

        @JsonProperty("smartcard")
        String smartcard();
    }
}
