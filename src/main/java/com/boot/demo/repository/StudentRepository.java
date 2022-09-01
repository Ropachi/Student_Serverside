package com.boot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// Idで検索
	Optional<Student> findById(Integer id);

	Student save(Student product);

	// Idで検索して削除
	void deleteById(Integer id);
}