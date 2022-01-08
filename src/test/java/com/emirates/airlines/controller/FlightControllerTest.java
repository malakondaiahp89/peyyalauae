package com.emirates.airlines.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FlightControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getFlightsAvailable() throws Exception {

		 MvcResult mvcResult = mockMvc.perform(get("/emirates/flight")
				  .content("{\n" + 
				  		"\n" + 
				  		"    \"journeyDate\" : \"2022-01-07\",\n" + 
				  		"    \"depatureCode\": \"HYD\",\n" + 
				  		"    \"arrivalCode\" : \"UAE\"\n" + 
				  		"}")
	    	      .contentType(MediaType.APPLICATION_JSON)
	    	      .accept(MediaType.APPLICATION_JSON)
	    	      ).andReturn();
		 
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);  	  
	}



}
