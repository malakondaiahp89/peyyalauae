package com.emirates.airlines.model;

import java.time.LocalDate;

public class FlightSearchCriteria {

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
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	String depatureCode;
	String arrivalCode;
	String journeyDate;
}
