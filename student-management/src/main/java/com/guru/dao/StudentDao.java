package com.guru.dao;

import java.util.List;

import com.guru.model.Student;
public interface StudentDao {
	List<Student> getStudents();

	Student get(int id);

	void delete(int id);

	int save(Student student);
}
