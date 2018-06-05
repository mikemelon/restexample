package cn.lynu.lyq.study.restexample.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.lynu.lyq.study.restexample.dao.StudentRepository;
import cn.lynu.lyq.study.restexample.entity.Student;

@Transactional
@Service
public class StudentService {
	@Resource
	private StudentRepository studentDao;
	
	public Student findById(Integer id){
		return studentDao.findOne(id);
	}
	
	public List<Student> findAll(){
		return studentDao.findAll();
	}
	
	public List<Student> findByName(String name){
//		return studentDao.findByName(name);//使用继承JpaRepository接口的方法
		return studentDao.queryUserByName(name);//使用JPA命名Query的方法
	}
	
	public List<Student> findByNameAndAge(String name, Integer age){
		return studentDao.findByNameAndAge(name, age);
	}
	
	public void save(Student student){
		studentDao.save(student);
	}
	
	public void update(Student student){
		studentDao.save(student);
	}
	
	public void delete(Integer id){
		studentDao.delete(id);
	}
}
