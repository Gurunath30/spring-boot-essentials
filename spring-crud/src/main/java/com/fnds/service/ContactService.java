package com.fnds.service;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fnds.dao.ContactDao;
import com.fnds.model.Contact;
import com.fnds.util.Utility;

public class ContactService {
	private ContactDao dao;

	public static ContactService init(Connection connection) {
		ContactService svc = new ContactService();
		svc.dao = ContactDao.init(connection);
		return svc;
	}

	public List<Map<String, Object>> list() {
		return dao.list();
	}

	public Map<String, Object> save(Contact contact) {
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		String phone = contact.getPhone();
		int id = 0;
		if (Utility.isValidPhone(phone)) {
			if (Utility.hasData(dao.get(phone)))
				res.put("errors", "Phone number already exists");
			else
				id = dao.save(contact);
		} else {
			res.put("errors", "Invalid phone number");
		}
		if (id > 0)
			res.put("success", true);
		return res;
	}

	public Map<String, Object> update(Contact contact) {
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		int id = dao.update(contact);
		if (id < 0)
			res.put("errors", "Unable to update");
		return res;
	}
	
	public Map<String, Object> delete(String phone) {
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		int id = dao.delete(phone);
		if (id < 0)
			res.put("errors", "Unable to delete");
		return res;
	}

	public Map<String, Object> get(String phone) {
		return dao.get(phone);
	}

}
