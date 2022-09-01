//モデル設定
package com.boot.demo.domain;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  //JPAのデータクラス(エンティティ)であることを指定。
//↓データのテーブル指定
@Table(name="student")
public class Student implements Serializable{
//public class Product{

	//private static final long serialVersionUID = 1L;

	@Id   //プライマリーキー指定
	@GeneratedValue(strategy = GenerationType.AUTO) //プライマリーキーの値を自動生成
	@Column //フィールドに割り当てられるコラム名指定
	private Integer id;

	@Column(nullable = false)  //フィールドに割り当てられるコラム名指定
	private String name;

	@Column(nullable = false)   //   "
	private Integer age;

	@Column(nullable=false)   //   "
	private String sex;

	@Column(nullable=false)   //   "
	private String birth;

	@Column(nullable=false)   //   "
	private String address;

	@Column(nullable=false)   //   "
	private String tel;

	@Column(nullable=false)   //   "
	private String mail;

	public Student() {
		super();
	}

	public Student(Integer id, String name, Integer age, String sex, String birth, String address, String tel, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birth = birth;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
	}

	//Getter, Setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
