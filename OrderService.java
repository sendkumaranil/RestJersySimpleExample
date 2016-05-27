package com.restful.service;

import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Anil Kumar
 * This service class is example of path param and query param
 */
@Path("/orders")
public class OrderService {

	private static Map<String,String> ordermap=new TreeMap<String, String>();
	
	@Path("/{order}")
	@PUT
	@Produces("text/html")
	public Response create(@PathParam("order")String order,@QueryParam("customer_name")String customername){
		ordermap.put(order, customername);
		OrderDao orderdao=new OrderDao();
		int status=orderdao.saveOrder(ordermap);
		if(status==1){
			return Response.ok("Added order:#"+order).build();
		}else{
			throw new WebApplicationException(Response.ok("Err:Order creation failed!!").build());
		}		
	}
	
	@Path("/{order}")
	@GET
	@Produces("text/html")
	public String find(@PathParam("order")String order){
		OrderDao orderdao=new OrderDao();
		try{
			Map<String,String> orderdata=orderdao.findOrder(order);
		
			if(orderdata.containsKey(order)){
				return "<h2>Details an order#"+order+"</h2>Customer name: "+orderdata.get(order);
			}else{
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			}
		}catch(WebApplicationException e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	
	@Path("/list")
	@GET
	@Produces("text/html")
	public String list()
	{
		OrderDao orderdao=new OrderDao();
		try{
			Map<String,String> orderdata=orderdao.getOrderList();
		
			String header = " <h2>All Orders</h2>";

			header += "<ul>";
			for (Map.Entry<String, String> order : orderdata.entrySet())
				header += "\n <li>#" + order.getKey() + " for " + order.getValue() + "</li>";

			header += "\n</ul>";

			return header;
		
		}catch(WebApplicationException e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
}
