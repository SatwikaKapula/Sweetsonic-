package com.ts.dao;

import com.rest.dto.ConcertReg;
import com.ts.db.HibernateTemplate;

public class ConcertRegDAO {
	public int add(ConcertReg concertreg) {		
		return HibernateTemplate.addObject(concertreg);
	}


}
