package com.ts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.Musicians;

import com.ts.db.HibernateTemplate;

public class MusiciansDAO {

	private SessionFactory factory = null;
	
	

	public int register(Musicians musicians) {		
		return HibernateTemplate.addObject(musicians);
	}

	/*public Musicians getUsiciansByUserPass(String userName,String password) {

		return (Musicians)HibernateTemplate.getObjectByUserPass(userName,password);
	}*/



	public List<Musicians> getAllMusicians() {
		List<Musicians> musicians=(List)HibernateTemplate.getObjectListByQuery("From Musicians");
		System.out.println("Inside All Musicians ..."+musicians);
		return musicians;	
	}
	
	
	public Musicians getMusicianById(int musicianId) {
		return (Musicians)HibernateTemplate.getObjectById(musicianId);
	}
	
	

	public Musicians getMusicianByLocality(String Locality) {
		return (Musicians)HibernateTemplate.getObjectByLocality(Locality);
	}
	public int delete(Musicians musicians){
		int result = HibernateTemplate.deleteObject(Musicians.class, musicians);
		return result;
	}
	public int updateMusicians(Musicians musicians){
		int result = HibernateTemplate.updateObject(musicians);
		return result;
		
		
	}
	
}