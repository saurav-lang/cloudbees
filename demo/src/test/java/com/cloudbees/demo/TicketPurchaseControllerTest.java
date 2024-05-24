package com.cloudbees.demo;

import com.cloudbees.demo.controllers.TicketPurchaseController;
import com.cloudbees.demo.dto.SectionSeatDTO;
import com.cloudbees.demo.dto.TicketPurchaseDTO;
import com.cloudbees.demo.entity.TicketPurchase;
import com.cloudbees.demo.servicesImpl.TicketPurchaseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class TicketPurchaseControllerTest {

    @InjectMocks
    private TicketPurchaseController ticketPurchaseController;
    @Mock
    private TicketPurchaseServiceImpl ticketPurchaseService;

    @Test
    public void ticketPurchase(){
        List<TicketPurchase> ticketPurchaseList=new ArrayList<>();
        TicketPurchaseDTO ticketPurchaseDTO=TicketPurchaseDTO.builder().
                from("London").to("France").user("CloudBees").firstName("Saurav").lastName("Kumar")
                .email("saurav@gmail.com").build();
        TicketPurchase ticketPurchase=TicketPurchase.builder().
                from("London").to("France").firstName("Saurav").lastName("Kumar")
                .email("saurav@gmail.com").price("$10").seatNo("10").section("A").build();
        ticketPurchaseList.add(ticketPurchase);
        Mockito.when(ticketPurchaseService.getTicket(Mockito.any())).thenReturn(ticketPurchaseList);
        ResponseEntity results=  ticketPurchaseController.ticketPurchase(ticketPurchaseDTO);
        Assert.assertEquals(results.getStatusCode(), HttpStatus.OK);


    }

    @Test
    public void ticketDetails(){
        List<TicketPurchase> ticketPurchaseList=new ArrayList<>();
        TicketPurchase ticketPurchase=TicketPurchase.builder().
                from("London").to("France").firstName("Saurav").lastName("Kumar")
                .email("saurav@gmail.com").price("$10").seatNo("10").section("A").build();
        ticketPurchase.setUserName("CloudBees");
        Mockito.when(ticketPurchaseService.getAllDetails(Mockito.any())).thenReturn(ticketPurchaseList);
        ResponseEntity results=ticketPurchaseController.ticketDetails("CloudBees");
        Assert.assertEquals(results.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void getSeatDetail(){
        List<SectionSeatDTO> sectionSeatDTOList=new ArrayList<>();
        Map<String,List<SectionSeatDTO>> results=new HashMap<>();

        SectionSeatDTO sectionSeatDTO=new SectionSeatDTO();
        sectionSeatDTO.setSection("A");
        sectionSeatDTO.setSeat("10");
        sectionSeatDTOList.add(sectionSeatDTO);
        results.put("CloudBees",sectionSeatDTOList);
        Mockito.when(ticketPurchaseService.getSeatDetails(Mockito.any())).thenReturn(results);
        ResponseEntity result=ticketPurchaseController.getSeatDetail("CloudBees");
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);



    }


}
