package com.fnds.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.fnds.model.Contact;

public class ContactDao {
	private JdbcTemplate jdbcTemplate;

	public static ContactDao init(Connection connection) {
		ContactDao dao = new ContactDao();
		dao.jdbcTemplate = new JdbcTemplate();
		dao.jdbcTemplate.setDataSource(new SingleConnectionDataSource(connection, false));
		return dao;
	}

	public List<Map<String, Object>> list() {
		return jdbcTemplate.queryForList("SELECT * FROM contact");
	}

	public int save(Contact contact) {
		return jdbcTemplate.update("INSERT INTO contact(name, phone) VALUES(?,?)", contact.getName(), contact.getPhone());
	}

	public int update(Contact contact) {
		return jdbcTemplate.update("UPDATE contact SET name=? WHERE phone=?", contact.getName(), contact.getPhone());
	}

	public int delete(String phone) {
		return jdbcTemplate.update("DELETE FROM contact WHERE phone=?", phone);
	}

	public Map<String, Object> get(String phone) {
		try {
			return jdbcTemplate.queryForMap("SELECT * FROM contact WHERE phone=?", phone);
		} catch (DataAccessException e) {
			return null;
		}
	}
}
