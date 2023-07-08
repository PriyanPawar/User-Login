package org.jsp.userbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.userbootapp.dao.UserDao;
import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.exception.IdNotFoundException;
import org.jsp.userbootapp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("User Registered Sucessfully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("User Updated Sucessfully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<User>> findUser(int id){
		ResponseStructure<User> structure=new ResponseStructure<User>();
		Optional<User> recUser=dao.findUser(id);
		if(recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
//		structure.setBody(null);
//		structure.setMessage("User Not Found");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<List<User>>>findAll(){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setBody(dao.findAll());
		structure.setMessage("All User Are Displayed");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		Optional<User> recUser=dao.findUser(id);
		if(recUser.isPresent()) {
			dao.deleteUser(id);
			structure.setBody("User Deleted");
			structure.setMessage("User Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setBody("User Not Deleted!!");
		structure.setMessage("User Not Found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.verifyUser(phone, password);
		if(recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User Verified Sucessfully!");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
//		structure.setBody(null);
//		structure.setMessage("Invalid User Phone Number Or Password");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.verifyUser(email, password);
		if(recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User Verified Sucessfully!");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
//		structure.setBody(null);
//		structure.setMessage("Invalid User Email Id Or Password");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new InvalidCredentialsException();
	}
}
