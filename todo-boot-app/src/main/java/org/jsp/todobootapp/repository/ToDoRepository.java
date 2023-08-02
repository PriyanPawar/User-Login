package org.jsp.todobootapp.repository;

import org.jsp.todobootapp.dto.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

}
