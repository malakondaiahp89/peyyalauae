package com.emirates.airlines.model;

import java.time.LocalDate;
import java.util.Date;

public class Flight {

	public Flight(String flightNumber, String flightName, String depatureCode, String arrivalCode, LocalDate startDate) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.depatureCode = depatureCode;
		this.arrivalCode = arrivalCode;
		this.startDate = startDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getDepatureCode() {
		return depatureCode;
	}
	public void setDepatureCode(String depatureCode) {
		this.depatureCode = depatureCode;
	}
	public String getArrivalCode() {
		return arrivalCode;
	}
	public void setArrivalCode(String arrivalCode) {
		this.arrivalCode = arrivalCode;
	}

	String flightNumber;
	String flightName;
	String depatureCode;
	String arrivalCode;
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	LocalDate startDate;
}
