package org.jsp.todobootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.todobootapp.dao.ToDoDao;
import org.jsp.todobootapp.dto.ResponseStructure;
import org.jsp.todobootapp.dto.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDOService {
@Autowired
private ToDoDao dao;
	public ResponseEntity<ResponseStructure<ToDo>> saveToDo(ToDo todo){
		ResponseStructure<ToDo> rs=new ResponseStructure<ToDo>();
		rs.setMessage("New Task Added Sucessfully!!");
		rs.setBody(dao.saveToDo(todo));
		rs.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<ToDo>>(rs,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<ToDo>> updateToDO(ToDo todo){
		ResponseStructure<ToDo> rs=new ResponseStructure<ToDo>();
		rs.setMessage("Task Updated SucessFully!!");
		rs.setBody(dao.updateToDo(todo));
		rs.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<ToDo>>(rs,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<ToDo>> findToDo(int id){
		ResponseStructure<ToDo> rs=new ResponseStructure<ToDo>();
		Optional<ToDo> recall=dao.findToDO(id);
		if(recall.isPresent()) {
			rs.setMessage("Task For ToDo");
			rs.setBody(recall.get());
			rs.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ToDo>>(rs,HttpStatus.OK);
		}
		rs.setMessage("Id Not Found !!!");
		rs.setBody(null);
		rs.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<ToDo>>(rs,HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<List<ToDo>>> findAllToDo(){
		ResponseStructure<List<ToDo>> rs=new ResponseStructure<>();
		rs.setMessage("All Tasks");
		rs.setBody(dao.findAllTODO());
		rs.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<ToDo>>>(rs,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<String>> deleteToDo(int id){
	ResponseStructure<String> rs=new ResponseStructure<String>();
	Optional<ToDo> recall=dao.findToDO(id);
	if(recall.isPresent()) {
		dao.deleteToDo(id);
		rs.setMessage("Task Found!!");
		rs.setBody("Task Deleted!!!");
		rs.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	rs.setMessage("Task Not Found!!!");
	rs.setBody("Task Not Deleted!!!!!");
	rs.setCode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
}
