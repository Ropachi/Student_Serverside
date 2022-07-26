package com.boot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.boot.demo.domain.Student;
import com.boot.demo.repository.StudentRepository;

@RestController
public class StudentController {

	private StudentRepository repository;

	public StudentController(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping("/find")
	public List<Student> findAll(){
		List<Student> list = repository.findAll();
		return list;
	}

	@RequestMapping(value = "/findid/{id}", method = RequestMethod.GET)
	public Optional<Student> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}

	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	@DeleteMapping("delete/{id}")
	public void deleteStudent(@PathVariable Integer id){
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){}
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Student postStudent(@RequestBody Student Student){
		Student d1 = new Student();
		d1.setName(Student.getName());
		d1.setAge(Student.getAge());
		d1.setSex(Student.getSex());
		d1.setBirth(Student.getBirth());
		d1.setAddress(Student.getAddress());
		d1.setTel(Student.getTel());
		d1.setMail(Student.getMail());
		return repository.save(d1);
	}

	@RequestMapping(value="/edit/{id}", method = RequestMethod.PUT)
	public Student edit(@RequestBody Student Student, @PathVariable Integer id ){
		Optional<Student> d1 = repository.findById(id);
		if ( d1.isPresent()) {
			Student.setId(id);
			return repository.save(Student);
		}
		return repository.save(Student);
	}
}