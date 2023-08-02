package org.jsp.todobootapp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable = false)
private String todotask;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTodotask() {
	return todotask;
}
public void setTodotask(String todotask) {
	this.todotask = todotask;
}
}
