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

	//全てのデータを取得
	  //ルーティング
	@GetMapping("/find")
	public List<Student> findAll(){
		List<Student> list = repository.findAll();
		return list;
	}

	//IDで検索
	  //リクエスト時のアドレス指定
	@RequestMapping(value = "/findid/{id}", method = RequestMethod.GET)
									  //↓パラメータ取得
	public Optional<Student> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}

	//IDで検索して削除
	@ResponseStatus(code= HttpStatus.NO_CONTENT)  //応答ステータスを指定
	//リクエスト時のアドレス指定
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
                              //↓パラメータ取得
	public void deleteStudent(@PathVariable Integer id){
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){}
	}

	//データを追加
	  //リクエスト時のアドレス指定
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)  //応答ステータスを指定
	                           //クライアントから送られてくる値を受け取る。
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

	//IDでデータを検索して編集
	  //リクエスト時のアドレス指定
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	                    //クライアントから送られてくる値を受け取る。
	public Student edit(@RequestBody Student Student, @PathVariable Integer id ){
		Optional<Student> d1 = repository.findById(id);
		if ( d1.isPresent()) {
			Student.setId(id);
			return repository.save(Student);
		}
		return repository.save(Student);
	}
}