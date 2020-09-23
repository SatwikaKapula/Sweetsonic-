package com.rest.dto;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@XmlRootElement
@Entity
public class ConcertInfo {
	@Id@GeneratedValue
	private int concertId;
	private String concertName;
	private String concertDate;
	private String concertVenue;
	
	private int ticketPrice;
	private int concertTotalTickets;
	private int availableTickets;
	private int bookedTickets;
	
	@OneToMany(mappedBy="concertInfo",fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ConcertReg> concertReg = new ArrayList<ConcertReg>();

	
	
	public ConcertInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConcertInfo(int concertId, String concertName, String concertDate, String concertVenue, int ticketPrice,
			int concertTotalTickets, int availableTickets, int bookedTickets) {
		super();
		this.concertId = concertId;
		this.concertName = concertName;
		this.concertDate = concertDate;
		this.concertVenue = concertVenue;
		this.ticketPrice = ticketPrice;
		this.concertTotalTickets = concertTotalTickets;
		this.availableTickets = availableTickets;
		this.bookedTickets = bookedTickets;
	}
	public int getConcertId() {
		return concertId;
	}
	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}
	public String getConcertName() {
		return concertName;
	}
	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}
	public String getConcertDate() {
		return concertDate;
	}
	public void setConcertDate(String concertDate) {
		this.concertDate = concertDate;
	}
	public String getConcertVenue() {
		return concertVenue;
	}
	public void setConcertVenue(String concertVenue) {
		this.concertVenue = concertVenue;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getConcertTotalTickets() {
		return concertTotalTickets;
	}
	public void setConcertTotalTickets(int concertTotalTickets) {
		this.concertTotalTickets = concertTotalTickets;
	}
	public int getAvailableTickets() {
		return availableTickets;
	}
	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}
	public int getBookedTickets() {
		return bookedTickets;
	}
	public void setBookedTickets(int bookedTickets) {
		this.bookedTickets = bookedTickets;
	}
	public List<ConcertReg> getConcertReg() {
		return concertReg;
	}
	public void setConcertReg(List<ConcertReg> concertReg) {
		this.concertReg = concertReg;
	}
	
	
}
