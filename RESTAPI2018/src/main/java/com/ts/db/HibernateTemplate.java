package com.ts.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rest.dto.ConcertInfo;
import com.rest.dto.Musicians;
import com.rest.dto.User;

public class HibernateTemplate {

	private static final String locality = null;
	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static User getUserByUserPass(String email,String password) {
	
	String queryString = "from User where email = :email and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("email", email);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  User user = (User)queryResult;
	  System.out.println(user);
	  return user; 
	}
	public static Object getObjectById(int musicianId) {
		
		String queryString = "from ConcertInfo where concertId = :concertId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("concertId", musicianId);
		  Object queryResult = query.uniqueResult();
		  ConcertInfo concertInfo = (ConcertInfo)queryResult;
		  return concertInfo; 
		}
	public static Object getObjectByLocality(String locality) {
		
		String queryString = "from Musicians where locality = :locality";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("locality", locality);
		  Object queryResult = query.uniqueResult();
		  Musicians musicians = (Musicians)queryResult;
		  return musicians; 
		}
	/*public static Object getObjectByEmail(String email) {
		
		String queryString = "from User where email = :locality";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("locality", locality);
		  Object queryResult = query.uniqueResult();
		  Musicians musicians = (Musicians)queryResult;
		  return musicians; 
		}
*/	
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
}
