package com.jpa_crud_restapi_mysql.demo.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String roll_no;
private String name;
private float cgpa;




public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id, String roll_no, String name, float cgpa) {
	super();
	this.id = id;
	this.roll_no = roll_no;
	this.name = name;
	this.cgpa = cgpa;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRoll_no() {
	return roll_no;
}
public void setRoll_no(String roll_no) {
	this.roll_no = roll_no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getCgpa() {
	return cgpa;
}
public void setCgpa(float cgpa) {
	this.cgpa = cgpa;
}
@Override
public String toString() {
	return "Student [id=" + id + ", roll_no=" + roll_no + ", name=" + name + ", cgpa=" + cgpa + "]";
}



}