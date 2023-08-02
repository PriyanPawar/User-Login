package org.jsp.todobootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.todobootapp.dto.ToDo;
import org.jsp.todobootapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoDao {
@Autowired
private ToDoRepository repository;
	public ToDo saveToDo(ToDo todo) {
		return repository.save(todo);
	}
	public ToDo updateToDo(ToDo todo) {
		return repository.save(todo);
	}
	public Optional<ToDo> findToDO(int id){
		return repository.findById(id);
	}
	public List<ToDo> findAllTODO(){
		return repository.findAll();
	}
	public void deleteToDo(int id) {
		repository.deleteById(id);
	}
}
