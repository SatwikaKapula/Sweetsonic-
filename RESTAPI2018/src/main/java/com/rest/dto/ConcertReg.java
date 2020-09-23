package com.rest.dto;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
public class ConcertReg {
	
	

	@Id@GeneratedValue
	private int regId;
	
	
	
	private int NumofTickets;
	private int totalbill;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "email")
	
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "concertId")
	
	private ConcertInfo concertInfo;

	public ConcertReg(int regId, int numofTickets, int totalbill, User user, ConcertInfo concertInfo) {
		super();
		this.regId = regId;
		NumofTickets = numofTickets;
		this.totalbill = totalbill;
		this.user = user;
		this.concertInfo = concertInfo;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public int getNumofTickets() {
		return NumofTickets;
	}

	public void setNumofTickets(int numofTickets) {
		NumofTickets = numofTickets;
	}

	public int getTotalbill() {
		return totalbill;
	}

	public void setTotalbill(int totalbill) {
		this.totalbill = totalbill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ConcertInfo getConcertInfo() {
		return concertInfo;
	}

	public void setConcertInfo(ConcertInfo concertInfo) {
		this.concertInfo = concertInfo;
	}
	
	
	
	
	
}

