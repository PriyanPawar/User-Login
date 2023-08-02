package org.jsp.todobootapp.controller;

import java.util.List;

import org.jsp.todobootapp.dto.ResponseStructure;
import org.jsp.todobootapp.dto.ToDo;
import org.jsp.todobootapp.service.ToDOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000/")
@RestController
public class Test {
@Autowired
private ToDOService service;

@PostMapping("/todo")
public ResponseEntity<ResponseStructure<ToDo>> saveToDo(@RequestBody ToDo todo){
	return service.saveToDo(todo);
}
@PutMapping("/todo")
public ResponseEntity<ResponseStructure<ToDo>> updateToDo(@RequestBody ToDo todo){
	return service.updateToDO(todo);
}
@GetMapping("/todo/{id}")
public ResponseEntity<ResponseStructure<ToDo>> findToDo(@PathVariable int id){
	return service.findToDo(id);
}
@GetMapping("/todo")
public ResponseEntity<ResponseStructure<List<ToDo>>> findAllToDo(){
	return service.findAllToDo();
}
@DeleteMapping("/todo/{id}")
public ResponseEntity<ResponseStructure<String>> deleteToDo(@PathVariable int id){
	return service.deleteToDo(id);
}
}
