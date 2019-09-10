package com.anjan.api.restapi;
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



@Path("items")
public class Controller {
	
	ItemRepository repo=new ItemRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Item> getItems() {
		
		System.out.println("getAlien called...");
		return repo.getItems();
	}
	
	@GET
	@Path("item/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Item getItem(@PathParam("id")int id) {
		
		System.out.println("getAlien called...");
		return repo.getItem(id);
	}
	
	@POST
	@Path("item")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Item createItem(Item a1) {
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("item")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Item updateItem(Item a1){
		
		if(repo.getItem(a1.getId()).getId()==0) {
			repo.create(a1);
		}else {
		repo.update(a1);
		}
		return a1;
	}
	
	@DELETE
	@Path("item/{id}")
	public Item deleteItem(@PathParam("id")int id) {
	
		Item a = repo.getItem(id);
		if(a.getId()!=0)
		repo.delete(id);
		
	return a;
	
}
}
