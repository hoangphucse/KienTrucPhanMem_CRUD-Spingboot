package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repositoty.StudentRepository;
import com.example.demo.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student add(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void delete(int idStudent) {
		boolean check = studentRepository.existsById(idStudent);
		if(check) {
			 studentRepository.deleteById(idStudent);
		}
		
	}

	@Override
	public Student update(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(int idStudent) {
		return studentRepository.findById(idStudent).orElse(null);
	}
	
	

}
