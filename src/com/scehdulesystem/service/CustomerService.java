package com.scehdulesystem.service;

import java.util.Set;

import com.scehdulesystem.domain.Customer;

public interface CustomerService {
	public String getNameById(int id);
	public Set<Customer> getAllCustomers();
}
