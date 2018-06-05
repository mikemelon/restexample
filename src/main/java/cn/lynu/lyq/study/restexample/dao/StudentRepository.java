package cn.lynu.lyq.study.restexample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.lynu.lyq.study.restexample.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	List<Student> findByName(String name);
	List<Student> findByNameAndAge(String name, Integer age);
	
	@Query("from Student s where s.name=:name")
    List<Student> queryUserByName(@Param("name") String name);
}
