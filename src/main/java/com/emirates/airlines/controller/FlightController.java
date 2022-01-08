package com.emirates.airlines.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.airlines.model.Flight;
import com.emirates.airlines.model.FlightSearchCriteria;
import com.emirates.airlines.service.FlightInformationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/emirates")
public class FlightController {
	
    private ObjectMapper mapper=new ObjectMapper();
   

	@Autowired
	FlightInformationService flightInformationService;
	
    
    @GetMapping( path = "/flight" , consumes = {MediaType.APPLICATION_JSON_VALUE} , produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Flight> getFlightsAvailable(@RequestBody String flightSearch) throws JsonMappingException, JsonProcessingException {
    	
    FlightSearchCriteria flightSearchCriteria = mapper.readValue(flightSearch, FlightSearchCriteria.class);
    
    Long oldTime =Instant.now().toEpochMilli();
    ArrayList<Flight> flightAvailable= flightInformationService.getFlightInformationService(
    		LocalDate.parse(flightSearchCriteria.getJourneyDate()),flightSearchCriteria.getDepatureCode(), flightSearchCriteria.getArrivalCode());
    System.out.println(Instant.now().toEpochMilli()-oldTime);
        return Flux.fromIterable(flightAvailable);
    }

}
