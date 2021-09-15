package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	@GetMapping("")
	public List<Student> getStudents() {
		return studentService.getAll();
	}
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student addStudent(@RequestBody Student student) {
		return studentService.add(student);
	}
	
	@PutMapping("/{id}")
	public Student update(@PathVariable("id") int id, @RequestBody Student student) {
		student.setId(id);
		return studentService.update(student);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {

		try {
			
			studentService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
