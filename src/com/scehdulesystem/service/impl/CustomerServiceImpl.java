package com.scehdulesystem.service.impl;

import java.util.Set;

import com.scehdulesystem.domain.Customer;
import com.scehdulesystem.domain.repository.InMemoryCustomerRepository;
import com.scehdulesystem.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
    
	
	private InMemoryCustomerRepository customerRepository=new InMemoryCustomerRepository();
	public Set<Customer> getAllCustomers() {
	   return customerRepository.getAllCustomers();
	}
	public String getNameById(int id)
	{
	 	return customerRepository.getNameById(id);
	}
 
}
