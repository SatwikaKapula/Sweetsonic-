package com.rest.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@XmlRootElement
@Entity
public class User {
	
	private String userName;
	@Id
	private String email;
	private String password;
	private String mob;
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<ConcertReg> concertReg = new ArrayList<ConcertReg>();
	
	

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String email, String password, String mob, List<ConcertReg> concertReg) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.mob = mob;
		this.concertReg = concertReg;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public List<ConcertReg> getConcertReg() {
		return concertReg;
	}
	public void setConcertReg(List<ConcertReg> concertReg) {
		this.concertReg = concertReg;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ", mob=" + mob
				+ ", concertReg=" + concertReg + "]";
	}
	
	
	

	
	

	}