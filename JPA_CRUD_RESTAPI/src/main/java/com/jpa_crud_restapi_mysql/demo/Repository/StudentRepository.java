package com.jpa_crud_restapi_mysql.demo.Repository;
import org.springframework.data.repository.CrudRepository;
import com.jpa_crud_restapi_mysql.demo.Model.Student;
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
