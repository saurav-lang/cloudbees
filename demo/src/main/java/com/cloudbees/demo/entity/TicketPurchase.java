package com.cloudbees.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
public class TicketPurchase {


    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String from;

    private String to;

    private String price;

    private String section;

    private String seatNo;




}
