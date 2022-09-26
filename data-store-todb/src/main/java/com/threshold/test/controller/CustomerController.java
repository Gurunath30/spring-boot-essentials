package com.threshold.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.threshold.test.dao.CustomerRepo;
import com.threshold.test.pojo.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerRepo repo;

	@RequestMapping("/")
	public String getForm() {
		return "customer";
	}

	@RequestMapping("/addCustomer")
	public String saveCustomer(Customer customer) {
		repo.save(customer);
		ModelAndView view = new ModelAndView();
		view.addObject(customer);
		return "getcustomer";
	}

	@RequestMapping("/get")
	public ModelAndView getCustomer(@RequestParam("id") int id, @RequestParam("name") String name) {
		Customer customer = repo.findById(id).orElse(null);
		ModelAndView view = new ModelAndView("getcustomer");
		view.addObject(customer);
		System.out.println(repo.findByName(name)+" "+customer);
		//System.out.println(repo.findByNameSorted(name));
		return view;
	}

}
