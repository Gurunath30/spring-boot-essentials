package com.threshold.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.threshold.test.pojo.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
//Methods based on our choice
	List<Customer>  findByName(String name);
	@Query("from CUSTOMER where name=?1 order by id")
	List<Customer>  findByNameSorted(String name);
}
