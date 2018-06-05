package cn.lynu.lyq.study.restexample.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.lynu.lyq.study.restexample.entity.Student;
import cn.lynu.lyq.study.restexample.exception.StudentNotFoundException;
import cn.lynu.lyq.study.restexample.service.StudentService;

@RestController
public class StudentController {
	@Resource
	private StudentService studentService;

//	@RequestMapping("/")
//	public String hello() {
//		return "index";
//	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> findStudents() {
		return studentService.findAll();
	}
	
	@RequestMapping(value = "/students/name/{name}", method = RequestMethod.GET)
	public List<Student> findStudentsByName(@PathVariable("name") String name) {
		return studentService.findByName(name);
	}
	
	@RequestMapping(value = "/students/na/{name}/{age}", method = RequestMethod.GET)
	public List<Student> findStudentsByNameAndAge(@PathVariable("name") String name,
			@PathVariable("age") Integer age) {
		return studentService.findByNameAndAge(name, age);
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public void add(@RequestBody @Valid Student student, BindingResult result) {
		System.out.println("add:" + student);
		studentService.save(student);
	}

	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public void update(@RequestBody @Valid Student student, BindingResult result) {
		System.out.println("update:" + student);
		studentService.update(student);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		if (studentService.findById(id) == null) {
			throw new StudentNotFoundException();
		}
		System.out.println("delete:" + id);
		studentService.delete(id);
	}

}
