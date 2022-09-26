package com.threshold.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threshold.test.pojo.Customer;

public interface CustomerRepo extends  JpaRepository<Customer, Integer>{

}
