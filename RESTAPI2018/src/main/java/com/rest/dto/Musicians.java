package com.rest.dto;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.JoinColumnOrFormula;

@XmlRootElement
@Entity
public class Musicians implements Serializable {
	@Id@GeneratedValue
	private int musicianId;
	private String musicianName;
	private String locality;
	private String skills;
	private String experience;
	private String status;
	private String mob;
	
	public Musicians() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Musicians(int musicianId, String musicianName, String locality, String skills, String experience, String status,
			String mob) {
		super();
		this.musicianId = musicianId;
		this.musicianName = musicianName;
		this.locality = locality;
		this.skills = skills;
		this.experience = experience;
		this.status = status;
		this.mob = mob;
	}
	public int getMusicianId() {
		return musicianId;
	}
	public void setMusicianId(int musicianId) {
		this.musicianId = musicianId;
	}
	public String getMusicianName() {
		return musicianName;
	}
	public void setMusicianName(String musicianName) {
		this.musicianName = musicianName;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	
	

	
	
}