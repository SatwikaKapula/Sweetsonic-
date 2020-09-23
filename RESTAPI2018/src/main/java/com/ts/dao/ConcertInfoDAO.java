package com.ts.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.ConcertInfo;
import com.rest.dto.Musicians;

import com.ts.db.HibernateTemplate;

public class ConcertInfoDAO {
	
	   private SessionFactory factory = null;
		
		

		public int add(ConcertInfo concertinfo) {		
			return HibernateTemplate.addObject(concertinfo);
		}



		public List<ConcertInfo> getAllConcertInfo() {
			List<ConcertInfo> concerts=(List)HibernateTemplate.getObjectListByQuery("From ConcertInfo");

			return concerts;	
		}
		
		public int updateObject(ConcertInfo concertinfo){
			return HibernateTemplate.updateObject(concertinfo);
			
		}
		public ConcertInfo getConcertById(int concertId) {
			return (ConcertInfo)HibernateTemplate.getObjectById(concertId);
		}

		

}
