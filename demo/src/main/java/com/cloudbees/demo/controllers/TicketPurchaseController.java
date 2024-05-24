package com.cloudbees.demo.controllers;

import com.cloudbees.demo.dto.SectionSeatDTO;
import com.cloudbees.demo.dto.TicketPurchaseDTO;
import com.cloudbees.demo.entity.TicketPurchase;
import com.cloudbees.demo.services.TicketPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TicketPurchaseController {

    @Autowired
    private TicketPurchaseService ticketPurchaseService;
    @PostMapping(value = "/purchase")
    public ResponseEntity ticketPurchase(@RequestBody TicketPurchaseDTO ticketPurchaseDTO){

        List<TicketPurchase> results= ticketPurchaseService.getTicket(ticketPurchaseDTO);

        return  ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @GetMapping(value = "/details/{username}")
    public ResponseEntity ticketDetails(@PathVariable String username){

        List<TicketPurchase> results= ticketPurchaseService.getAllDetails(username);

        return  ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @GetMapping(value = "/seat/{username}")
    public ResponseEntity getSeatDetail(@PathVariable String username){

        Map<String,List<SectionSeatDTO>> results= ticketPurchaseService.getSeatDetails(username);

        return  ResponseEntity.status(HttpStatus.OK).body(results);
    }
    @DeleteMapping(value = "/remove/{username}")
    public ResponseEntity deleteUser(@PathVariable String username){

         ticketPurchaseService.deleteUser(username);

        return  ResponseEntity.status(HttpStatus.OK).body(  " User " + username + "removed successfully");
    }

    @PutMapping(value = "/update/{username}/{seatNo}")
    public ResponseEntity updateSeat(@PathVariable String username, @PathVariable String seatNo){

        ticketPurchaseService.updateSeat(username,seatNo);

        return  ResponseEntity.status(HttpStatus.OK).body(  " Seat No : " + seatNo + " for user " + username + "updated successfully");
    }
}
