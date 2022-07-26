package com.boot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// Fetch products by brand
	Optional<Student> findById(Integer id);

	Student save(Student product);

	void deleteById(Integer id);
}