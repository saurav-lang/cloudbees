package com.cloudbees.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TicketPurchaseDTO {

    @JsonProperty
    private String from;
    @JsonProperty
    private String to;
    @JsonProperty
    private String date;

    @JsonProperty
    private String user;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String email;


}
