package com.example.demo.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
