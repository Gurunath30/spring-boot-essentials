package com.guru.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.guru.model.Student;

public class RowMapper implements org.springframework.jdbc.core.RowMapper<Student> {
	Student student = new Student();

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setMobile(rs.getString(3));
		student.setCountry(rs.getString(4));
		return student;
	}

}
