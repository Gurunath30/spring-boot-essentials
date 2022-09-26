package com.fnds.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fnds.model.Contact;
import com.fnds.service.ContactService;

@Controller
public class ContactController {
	private ContactService svc;

	public ContactController(Connection connection) {
		svc = ContactService.init(connection);
	}

	@RequestMapping(value = "/")
	public ModelAndView list(ModelAndView model) throws IOException {
		List<Map<String, Object>> contacts = svc.list();
		model.addObject("contacts", contacts);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Contact contact) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> res = svc.save(contact);
		if (res.containsKey("errors"))
			view.addObject("msg", res.get("errors"));
		else
			view.addObject("msg", "Saved successfully");
		view.setViewName("message");
		return view;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute Contact contact) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> res = svc.update(contact);
		if (res.containsKey("errors"))
			view.addObject("msg", res.get("errors"));
		else
			view.addObject("msg", "Updated successfully");
		view.setViewName("message");
		return view;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> res = svc.delete(request.getParameter("phone"));
		if (res.containsKey("errors"))
			view.addObject("msg", res.get("errors"));
		else
			view.addObject("msg", "Deleted successfully");
		view.setViewName("message");
		return view;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView get(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Map<String, Object> contact = svc.get(request.getParameter("phone"));
		view.addObject("contact",contact);
		view.setViewName("updateform");
		return view;
	}
}
