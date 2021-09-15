package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	public Student add(Student student);
	public void delete(int idStudent);
	public Student update(Student student);
	public List<Student> getAll();
	public Student getStudent(int idStudent);
}
