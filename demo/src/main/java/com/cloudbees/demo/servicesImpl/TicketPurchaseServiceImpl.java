package com.cloudbees.demo.servicesImpl;

import com.cloudbees.demo.dto.SectionSeatDTO;
import com.cloudbees.demo.dto.TicketPurchaseDTO;
import com.cloudbees.demo.entity.TicketPurchase;
import com.cloudbees.demo.services.TicketPurchaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketPurchaseServiceImpl implements TicketPurchaseService {

    private String price="$20";
    private String seatNo="10";
    private String section []={"A","B"};
    List<TicketPurchase> ticketPurchaseList=new ArrayList<>();
    @Override
    public List<TicketPurchase> getTicket(TicketPurchaseDTO ticketPurchaseDTO) {

        //TicketPurchase ticketPurchase=new TicketPurchase();
        TicketPurchase ticketPurchase=TicketPurchase.builder()
                .userName(ticketPurchaseDTO.getUser())
                .firstName(ticketPurchaseDTO.getFirstName())
                .lastName(ticketPurchaseDTO.getLastName())
                .email(ticketPurchaseDTO.getEmail())
                .from(ticketPurchaseDTO.getFrom())
                .to(ticketPurchaseDTO.getTo())
                .section(section[0])
                .price(price)
                .seatNo(seatNo)
                .build();
        /*ticketPurchase.setUserName(ticketPurchaseDTO.getUser());
        ticketPurchase.setFirstName(ticketPurchaseDTO.getFirstName());
        ticketPurchase.setLastName(ticketPurchaseDTO.getLastName());
        ticketPurchase.setEmail(ticketPurchaseDTO.getEmail());
        ticketPurchase.setFrom(ticketPurchaseDTO.getFrom());
        ticketPurchase.setTo(ticketPurchaseDTO.getTo());
        ticketPurchase.setSection(section[0]);
        ticketPurchase.setPrice(price);
        ticketPurchase.setSeatNo(seatNo);*/
        ticketPurchaseList.add(ticketPurchase);
        return ticketPurchaseList;
    }

    @Override
    public List<TicketPurchase> getAllDetails(String userName) {

        List<TicketPurchase> result=ticketPurchaseList.stream().filter(s -> s.getUserName().equals(userName)).collect(Collectors.toList());

        return result;
    }

    @Override
    public Map<String,List<SectionSeatDTO>> getSeatDetails(String userName) {

List<SectionSeatDTO> sectionSeatDTOList=new ArrayList<>();
Map<String,List<SectionSeatDTO>> results=new HashMap<>();
        List<TicketPurchase> matchedResult=ticketPurchaseList.stream().filter(s -> s.getUserName().equals(userName)).collect(Collectors.toList());
        matchedResult.forEach(s->{
            SectionSeatDTO sectionSeatDTO=new SectionSeatDTO();
            sectionSeatDTO.setSection(s.getSection());
            sectionSeatDTO.setSeat(s.getSeatNo());
            sectionSeatDTOList.add(sectionSeatDTO);
        });
        results.put(userName,sectionSeatDTOList);
        return results;
    }

    @Override
    public void deleteUser(String userName) {
        List<TicketPurchase> result=ticketPurchaseList.stream().filter(s -> s.getUserName().equals(userName)).collect(Collectors.toList());
        ticketPurchaseList.removeAll(result);
    }

    @Override
    public void updateSeat(String userName, String seatNo) {
        ticketPurchaseList.stream().forEach(s -> {
            if(s.getUserName().equals(userName) && s.getSection().equals("A")){
                s.setSeatNo(seatNo);
            }
        });
    }


}
