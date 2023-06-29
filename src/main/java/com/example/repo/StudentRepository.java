package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StudentEntity;

public interface StudentRepository extends JpaRepository <StudentEntity, Integer>{

	
}
