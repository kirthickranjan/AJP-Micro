package com.jpa_crud_restapi_mysql.demo.Controller;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpa_crud_restapi_mysql.demo.Model.Student;
import com.jpa_crud_restapi_mysql.demo.Repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	@Autowired
	private StudentRepository stuRepo;
	@PostMapping("/student")
	public String createStu(@RequestBody Student stu)
	{
	stuRepo.save(stu);
	return "inserted";
	}
	@PutMapping("/student/{id}")
	public String updateStu(@PathVariable int id, @RequestBody Student stu)
	{
	stu.setId(id);
	stuRepo.save(stu);
	return "Updated";
	}
	@GetMapping("/student")
	public List<Student> getStu()
	{
	return (List<Student>) stuRepo.findAll();
	}
	@GetMapping("/student/{id}")
	public Optional<Student> getById(@PathVariable int id)
	{
	return stuRepo.findById(id);
	}
	@DeleteMapping("/student/{id}")
	public String deleteStu(@PathVariable int id)
	{
	stuRepo.deleteById(id);
	return "deleted";
	}
}
