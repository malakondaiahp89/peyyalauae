
  package com.emirates.airlines.service;
  
  import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emirates.airlines.model.Flight;
  
  @RunWith(SpringRunner.class)
  @AutoConfigureMockMvc
  @SpringBootTest
  public class FlightInformationServiceTest {
	  
	
  @Autowired FlightInformationService flightInformationService;
  
  @Test 
  public void getFlightInformationService() {
  
	 ArrayList<Flight> listFlight= flightInformationService.getFlightInformationService(LocalDate.parse("2022-01-07"), "HYD", "UAE");
	 assertNotNull(listFlight);
	 assertTrue(listFlight.size()>0);
	 assertNotNull(listFlight.stream().filter(item->item.getFlightNumber().equalsIgnoreCase("FN1001")));
  }
  
  }
 