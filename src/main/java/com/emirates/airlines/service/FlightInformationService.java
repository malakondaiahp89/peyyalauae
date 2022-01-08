package com.emirates.airlines.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.emirates.airlines.model.Flight;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FlightInformationService {
	ArrayList<Flight> flightsList=new ArrayList<Flight>();
	
	public FlightInformationService() {
		//mock data created
		super();
			Flight flight1=new Flight("FN1001","Emirates_UAE_ZET_1001","HYD","UAE",LocalDate.parse("2022-01-07"));
			Flight flight2=new Flight("FN1002","Emirates_UAE_ZET_1002","MUB","UAE",LocalDate.parse("2022-01-03"));
			Flight flight3=new Flight("FN1003","Emirates_UAE_ZET_1003","BGLR","UAE",LocalDate.parse("2022-01-04"));
			Flight flight4=new Flight("FN1004","Emirates_UAE_ZET_1004","HYD","UAE",LocalDate.parse("2022-01-07"));

			this.flightsList.add(flight1);
			this.flightsList.add(flight2);
			this.flightsList.add(flight3);
			this.flightsList.add(flight4);
	
		
	}

	public ArrayList<Flight> getFlightInformationService(LocalDate date, String depatureCode, String arrivalCode)  {
		
		CompletableFuture downstream1= CompletableFuture.runAsync(
				() -> {
					 getDownstream1();
					 System.out.println("downstream1 returned");
				}
				);
		
		CompletableFuture downstream2= CompletableFuture.runAsync(
				() -> {
					 getDownstream2();
					 System.out.println("downstream2 returned");
				}
				);
		
		CompletableFuture downstream3= CompletableFuture.runAsync(
				() -> {
					 getDownstream3();
					 System.out.println("downstream3 returned");

				}
				);
		CompletableFuture downstream4= CompletableFuture.runAsync(
				() -> {
					 getDownstream4();
					 System.out.println("downstream4 returned");

				}
				);
		CompletableFuture downstream5= CompletableFuture.runAsync(
				() -> {
					 getDownstream5();
					 System.out.println("downstream5 returned");
				});
		
		CompletableFuture.allOf(downstream1,downstream2,downstream3,downstream4,downstream5).join();
		
		ArrayList<Flight> matchedFlights= (ArrayList<Flight>)this.flightsList.stream().filter(
				item-> item.getArrivalCode().equalsIgnoreCase(arrivalCode) 
				&& item.getDepatureCode().equalsIgnoreCase(depatureCode) 
				&& item.getStartDate().compareTo(date) == 0).collect(Collectors.toList());
	
		return matchedFlights;
	
	}
	
	 public Flux<Flight> getDownstream1() {
		    Flux<Flight> flightFlux = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8081/emirates/downstream1")
		    	      .retrieve()
		    	      .bodyToFlux(Flight.class);
		    flightFlux.subscribe(flight -> System.out.println(flight.getFlightNumber()));
		    return flightFlux;
	    	 }
	 public Flux<Flight> getDownstream2() {
		    Flux<Flight> flightFlux = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8082/emirates/downstream2")
		    	      .retrieve()
		    	      .bodyToFlux(Flight.class);
		    flightFlux.subscribe(flight -> System.out.println(flight.getFlightNumber()));
		    return flightFlux;
	    	 }
	 public Flux<Flight> getDownstream3() {
		    Flux<Flight> flightFlux = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8083/emirates/downstream3")
		    	      .retrieve()
		    	      .bodyToFlux(Flight.class);
		    flightFlux.subscribe(flight -> System.out.println(flight.getFlightNumber()));
		    return flightFlux;
	    	 }
	 public Flux<Flight> getDownstream4() {
		    Flux<Flight> flightFlux = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8084/emirates/downstream4")
		    	      .retrieve()
		    	      .bodyToFlux(Flight.class);
		    flightFlux.subscribe(flight -> System.out.println(flight.getFlightNumber()));
		    return flightFlux;
	    	 }
	 public Flux<Flight> getDownstream5() {
		   Flux<Flight> flightFlux = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8085/emirates/downstream5")
		    	      .retrieve()
		    	      .bodyToFlux(Flight.class);
		    flightFlux.subscribe(flight -> System.out.println(flight.getFlightNumber()));
		    return flightFlux;
	 }
	 
	    
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	    
}
