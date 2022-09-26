package com.guru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.guru.model.Student;

@Controller
public class StudentController {
	@Autowired
	com.guru.dao.StudentDao studentDao;

	@GetMapping("/")
	public String save() {
		return "student";
	}

	@GetMapping("/students")
	public List<Student> getAll() {
		List<Student> students = studentDao.getStudents();
		return students;
	}
}
