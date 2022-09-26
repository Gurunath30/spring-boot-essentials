package com.guru.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.guru.dao.StudentDao;
import com.guru.model.Student;
import com.guru.rowmapper.RowMapper;
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	JdbcTemplate template;

	public List<Student> getStudents() {
		List<Student> students = template.query("SELECT * FROM student", new RowMapper());
		System.out.println(students.get(0).getMobile());
		return students;
	}

	public Student get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public int save(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

}
