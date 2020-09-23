package com.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.ConcertInfo;
import com.rest.dto.ConcertReg;
import com.rest.dto.Musicians;
import com.rest.dto.User;
import com.ts.dao.ConcertInfoDAO;
import com.ts.dao.ConcertRegDAO;
import com.ts.dao.MusiciansDAO;
import com.ts.dao.UserDAO;

@Path("myresource1")
public class MyResource1 {
	
	@Path("regMusician")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
public void regMusician(Musicians musicians){
    	
    	System.out.println("Data Received in Register:" + musicians);
    	MusiciansDAO musicianDao = new MusiciansDAO();
    	musicianDao.register(musicians);
    	
   }
	@Path("addConcertReg")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
public void addConcertReg(ConcertReg concertreg){
    	
    	System.out.println("Data Received in Register:" + concertreg);
    	
    	ConcertRegDAO concertReg = new ConcertRegDAO();
    	concertReg.add(concertreg);
    	
   }
	
	@Path("addConcert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
public void addConcert(ConcertInfo concertinfo){
    	
    	System.out.println("Data Received in Register:" + concertinfo);
    	
    	ConcertInfoDAO concertinfoDao = new ConcertInfoDAO();
    	concertinfoDao.add(concertinfo);
    	
   }
	

    
    @Path("regUser")
    @POST
    //@Produces("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    //@GET
    //@Produces(MediaType.TEXT_PLAIN)
   /* public String daoTest(){
    User user = new User();
    	user.setUserName("Satwika Kapula");
    	user.setEmail("satwika@gmail.com");
    	user.setPassword("satwika");
    	user.setMob("7997604228");
    	UserDAO userDAO = new UserDAO();
        userDAO.register(user);
    	return "success";
    }*/
    
   public void regUser(User user){
    	
    	System.out.println("Data Received in Register:" + user);
    	UserDAO userDAO = new UserDAO();
    	userDAO.register(user);
    	
   }
    
    @Path("loginUser/{details}")
    @GET
  
    @Produces(MediaType.APPLICATION_JSON)
    public User login(@PathParam("details") String details){
    	String email, password, words[];
    	words = details.split(" ");
    	email = words[0];
    	password = words[1];
    	System.out.println(details);
    	User user = new User();
    	UserDAO userDAO = new UserDAO();
    	user = userDAO.login(email,password);
    	System.out.println(user);
    	return user;
    	
    	
    }
   
    
    
    
    
 
    /*	@Path("getEmployeeX")
    	@GET
    	@Produces(MediaType.APPLICATION_XML)
    	public Employee getEmployeeX(){
    	/*	Employee employee = new Employee(101,"PASHA","M",9999.99,new Date("1/21/14"),"998989888","INDIA");
    		return employee;
    	*/
    	//	return null;
    	//	}

    	/*@Path("getEmployeeJ")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public Employee getEmployeeJ(){
    	/*	Employee employee = new Employee(101,"PASHA","M",9999.99,new Date("1/21/14"),"998989888","INDIA");
    		return employee;*/
    		//return null;
    	//}

    	@Path("getAllMusicians")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public List<Musicians> getMusicianAll(){
    		System.out.println("Recieved in musicians : " ); 
    		MusiciansDAO musicianDao = new MusiciansDAO();
    		List<Musicians> musiciansList = musicianDao.getAllMusicians();	
    		return musiciansList;	
    	}
    	

    	@Path("getAllConcerts")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public List<ConcertInfo> getAllConcerts(){
    		System.out.println("Recieved in concertInfo : " ); 
    		ConcertInfoDAO concertinfoDao = new ConcertInfoDAO();
    		List<ConcertInfo> concertList = concertinfoDao.getAllConcertInfo();	
    		return concertList;	
    	}
    	
    	@Path("getAllUser")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public List<User> getAllUser(){
    		System.out.println("Recieved in user : " ); 
    		UserDAO userDao = new UserDAO();
    		List<User> userList = userDao.getAllUser();	
    		return userList;	
    	}

    	@Path("getMusicianByLocality/{locality}")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public Musicians getMusicianByLocality(@PathParam("locality") String locality ){
    		System.out.println("Recieved in Musicians : " + locality); 
    		MusiciansDAO musiciansDao = new MusiciansDAO();
    		Musicians musicians = musiciansDao.getMusicianByLocality(locality);	
    		System.out.println(musicians); 
    		return musicians;
    	}
    	
    	@Path("getConcertById/{concertId}")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public ConcertInfo getConcertById(@PathParam("concertId") int concertId ){
    		System.out.println("Recieved in Musicians : " + concertId); 
    		ConcertInfoDAO concertinfoDao = new ConcertInfoDAO();
    		ConcertInfo concertinfo = concertinfoDao.getConcertById(concertId);	
    		System.out.println(concertinfo); 
    		return concertinfo;
    	}
    	
    	@Path("deleteMusician/{musicianId}")
    	@DELETE
    	@Produces(MediaType.APPLICATION_JSON)
    	public void deleteMusician(@PathParam("musicianId") int musicianId){
    		System.out.println("Data Recieved in delete : " + musicianId);
    		/*MusiciansDAO musiciansDao = new MusiciansDAO();
    		Musicians musicians = musiciansDao.getMusicianById(musicianId);	

    		musiciansDao.delete(musicians);
    		System.out.println("Musician Deleted");
    		*/
    		
    	}	
    	
    	@Path("deleteMusician1/{musicianId}")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public void deleteMusician1(@PathParam("musicianId") int musicianId){
    		System.out.println("Data Recieved in delete : " + musicianId);
    		    		
    	}	

    	/*@Path("deleteMusician/{musicianId}")
    	@DELETE
    	@Produces(MediaType.APPLICATION_JSON)
    	public void deleteMusician(@PathParam("musicianId") int musicianId){
    		System.out.println("Data Recieved in delete : " + musicianId);
    		Musicians musician = new Musicians();
    		musician.setMusicianId(2);
    		MusiciansDAO musiciansDao = new MusiciansDAO();
    		
    		Musicians musicians = musiciansDao.getMusicianById(2);	

    		musiciansDao.delete(musicians);
    		System.out.println("Musician Deleted");
    		
    	}	*/

    	@Path("updateMusicians")
    	@PUT
    	@Consumes(MediaType.APPLICATION_JSON)
    	public void updateMusicians(Musicians musicians){
    		System.out.println("Data Recieved in update : " + musicians); 
    		MusiciansDAO musiciansDao = new MusiciansDAO();
		
    		musiciansDao.updateMusicians(musicians);
    		
    	}	

    	

    	
    /*	@Path("registerEmp")
    	@POST
    	@Consumes(MediaType.APPLICATION_JSON)
    	public void resisterEmp(Employee employee) {
    		System.out.println("Data Recieved in Register : " + employee); 
    		EmployeeDaoH empDao = new EmployeeDaoH();
    		empDao.register(employee); 
    	}

    	@Path("deleteEmp/{empId}")
    	@DELETE
    	@Produces(MediaType.APPLICATION_JSON)
    	public void deleteUser(@PathParam("empId") int empId){
    		System.out.println("Data Recieved in delete : " + empId);
    		EmployeeDaoH empDao = new EmployeeDaoH();
    		Employee employee = empDao.getEmployee(empId);
    		empDao.deleteEmp(employee);
    		
    	}	
    	@Path("updateEmp")
    	@PUT
    	@Consumes(MediaType.APPLICATION_JSON)
    	public void updateEmp(Employee employee){
    		System.out.println("Data Recieved in update : " + employee); 
    		EmployeeDaoH empDao = new EmployeeDaoH();
    		empDao.updateEmp(employee);
    		
    	}	


    	@Path("getAllDepartments")
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public List<Department> getAllDepartments(){
    		System.out.println("Recieved in getAllDepartments : " ); 
    		DepartmentDaoH deptDaoH = new DepartmentDaoH();
    		List<Department> deptList = deptDaoH.getAllDepartments();	
    		return deptList;	
    	}

    	
    }

*/
    
    
}
