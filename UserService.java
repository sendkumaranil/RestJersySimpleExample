package com.restful.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/UserService")
public class UserService {

	UserDao userDao=new UserDao();
	
	@GET
	@Path("/users")
	@Produces({MediaType.APPLICATION_XML})
	public List<User> getUsers(){
		
		return userDao.getAllUsers();
		
	}
	
	@POST
	@Path("/saveUsers")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response saveUser(
			@FormParam("userid") int id,
			@FormParam("username") String name,
			@FormParam("Profession")String profession){
		
		User user=new User(id, name, profession);
		userDao.saveUsers(user);
		
		return Response.ok("User Saved Successfully!!").build();
	}
}
