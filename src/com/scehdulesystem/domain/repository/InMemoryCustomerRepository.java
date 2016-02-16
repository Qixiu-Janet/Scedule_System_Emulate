package com.scehdulesystem.domain.repository;

import java.util.HashSet;
import java.util.Set;

import com.scehdulesystem.domain.Customer;


public class InMemoryCustomerRepository {
   
	private Set<Customer> listOfCustomers=new HashSet<Customer>();
	public InMemoryCustomerRepository()
	{
		Customer c1=new Customer();
		c1.setName("Jone");
		c1.setC_Id(1);
		c1.setAddress("2013 jinewod Ave, 95132, San Jose,CA");
		c1.setPassword("111111");
		listOfCustomers.add(c1);		
	}
	public Set<Customer> getAllCustomers() {
		return listOfCustomers;
	
	
}
	public String getNameById(int id) {
		String name=null;
		for(Customer s:listOfCustomers)
		{
			if(s.getC_Id()==id)
			{
				name=s.getName();
			    break;
			}
				}
		return name;
		}
	}
