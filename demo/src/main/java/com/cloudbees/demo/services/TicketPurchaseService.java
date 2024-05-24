package com.cloudbees.demo.services;

import com.cloudbees.demo.dto.SectionSeatDTO;
import com.cloudbees.demo.dto.TicketPurchaseDTO;
import com.cloudbees.demo.entity.TicketPurchase;

import java.util.List;
import java.util.Map;

public interface TicketPurchaseService {

     List<TicketPurchase> getTicket(TicketPurchaseDTO ticketPurchaseDTO);
     List<TicketPurchase> getAllDetails(String userName);

    Map<String,List<SectionSeatDTO>> getSeatDetails(String userName);
    void deleteUser(String userName);

   void  updateSeat(String username,String seatNo);

}
