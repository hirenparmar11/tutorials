package com.learn.rest.jersey.todo.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.learn.rest.jersey.todo.model.Todo;

@Path("todo")
public class TodoResource {

	private static Map<Long, Todo> todosCache;
	
	@GET
	@Path("/fetch-static")
	@Produces(MediaType.APPLICATION_JSON)
	public Todo fetchStaticTodo() {
		Long todoID = staticTodoCache();
		return todosCache.get(todoID);
		
	}
	
	@GET
	@Path("/fetch/{todoID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Todo fetchByID(@PathParam(value="todoID") Long todoID) {
		return todosCache.get(todoID);
	}
	
	@POST
	@Path("/add-new")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewTodo(Todo todo) {
		String result = "Todo saved " + todo;
		if(todosCache == null) {
			todosCache = new HashMap<Long, Todo>();
		}
		todosCache.put(todo.getTodoID(), todo);
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/fetch-all-todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> fetchAll() {
		if(todosCache == null) {
			todosCache = new HashMap<Long, Todo>();
		}
		return new ArrayList<Todo>(todosCache.values());
	}
	
	@PUT
	@Path("/modify/{todoID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateByTodoID(@PathParam("todoID") Long todoID, Todo todo) {
		if(todosCache == null || (todosCache != null && !todosCache.containsKey(todoID))) {
			return Response.status(404).entity("Todo Item with this " + todoID + " not available").build();
		} else {
			todosCache.put(todoID, todo);
			return Response.status(204).entity(todo).build();
		}
	}
	
	@DELETE
	@Path("/remove/{todoID}")
	@Produces(MediaType.TEXT_HTML)
	public Response deleteByTodoID(@PathParam(value="todoID") Long todoID) {
		if(todosCache == null || (todosCache != null && !todosCache.containsKey(todoID))) {
			return Response.status(404).entity("Todo Item with this " + todoID + " not available").build();
		} else {
			todosCache.remove(todoID);
			return Response.status(204).build();
		}
	}
	
	public static Long staticTodoCache() {
		if(todosCache == null) {
			todosCache = new HashMap<Long, Todo>();
		}
		Long randomID = Math.round(Math.random() * 100);
		Todo staticTodoOne = new Todo();
		staticTodoOne.setCompleted(false);
		staticTodoOne.setTodoID(randomID);
		staticTodoOne.setHeader("My First TODO");
		staticTodoOne.setDescription("My First TODO Description");
		todosCache.put(randomID, staticTodoOne);
		return randomID;
	}
}
