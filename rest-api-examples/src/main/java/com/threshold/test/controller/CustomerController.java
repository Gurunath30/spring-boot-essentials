package com.threshold.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threshold.test.dao.CustomerRepo;
import com.threshold.test.pojo.Customer;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepo repo;

	@PostMapping(path="/customer",consumes = { "application/json" })
	public Customer save(@RequestBody Customer customer) {
		repo.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customer/{id}")
	public String delete(@PathVariable("id") int id) {
		// check b4 delete a record
		Customer cust = repo.getOne(id);
		repo.delete(cust);
		return "deleted";
	}
	
	@PutMapping(path="/customer",consumes = { "application/json" })
	public Customer update(@RequestBody Customer customer) {
		repo.save(customer);
		return customer;
	}

	@GetMapping(path = "/get/{id}", produces = { "application/json" })
	public java.util.Optional<Customer> get(@PathVariable("id") int id) {
		return repo.findById(id);
	}

	@RequestMapping("/getall")
	public java.util.List<Customer> getAll() {
		return repo.findAll();
	}

}
