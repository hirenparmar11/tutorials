package com.learn.rest.jersey.todo.model;

public class Todo {

	private Long todoID;
	private Boolean completed;
	private String header;
	private String description;
	
	public Long getTodoID() {
		return todoID;
	}
	public void setTodoID(Long todoID) {
		this.todoID = todoID;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
