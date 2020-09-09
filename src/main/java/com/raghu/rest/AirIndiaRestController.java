package com.raghu.rest;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.request.PassengerInfo;
import com.raghu.response.TicketInfo;

@RestController
public class AirIndiaRestController {
	@PostMapping (value="/bookticket",
			produces= {"application/xml",
						"application/json"},
			consumes= {"application/json",
						"application/xml"})
	
	
	public ResponseEntity<TicketInfo> bookticket(@RequestBody PassengerInfo pinfo){
		//logic
		TicketInfo ticket= new TicketInfo();
		ticket.setName(pinfo.getFname()+""+pinfo.getLname());
		ticket.setFrom(pinfo.getFrom());
		ticket.setTo(pinfo.getTo());
		ticket.setTicketstatus("active");
		ticket.setTicketprice("400.00");
		ticket.setJourneydate(pinfo.getJounerydate());
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
		
		
	}
 
}
