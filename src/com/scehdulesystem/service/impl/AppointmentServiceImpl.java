package com.scehdulesystem.service.impl;

import java.util.Date;
import java.util.Set;

import com.scehdulesystem.domain.Appointment;
import com.scehdulesystem.domain.repository.InMemoryAppointmentRepository;
import com.scehdulesystem.service.AppointmentService;
import com.scehdulesystem.service.CustomerService;
import com.scehdulesystem.service.ProductService;

public class AppointmentServiceImpl implements AppointmentService{

	private InMemoryAppointmentRepository ap=new InMemoryAppointmentRepository();
	@Override
	public Set<Appointment> getAllAppointment() {
	  return ap.getAllAppointment();	
	}

	@Override
	public boolean scedule(Appointment appointment,Set<Appointment> checklist) {
		boolean res=true;
		//check for the time conflict
		for(Appointment app:checklist)
		{
			
			if((appointment.getStarttime().getTime()>=app.getStarttime().getTime())&&(appointment.getStarttime().getTime()<=app.getEndtime().getTime()))
			{
				res=false;
				
				return res;
			}
			if((appointment.getEndtime().getTime()>=app.getStarttime().getTime())&&(appointment.getEndtime().getTime()<=app.getEndtime().getTime()))
			{
				res=false;
				return res;
			}
		}
		 res=ap.addAppointment(appointment);
		 return res;
	}

	@Override
	public Set<Appointment> getAppointmentBytime(Date StartTime,Date endtime) {
		return ap.getAppointmentbyTime(StartTime, endtime);
	}

	public void printApointmentList(Set<Appointment> list){
	     for(Appointment ap:list) 
		  {
			System.out.println("---------------------------------------------------");
		    CustomerService customerservice=new CustomerServiceImpl();
		    ProductService productservice=new ProductServiceImpl();
			System.out.println("Customer: "+ customerservice.getNameById(ap.getC_Id())+ "|\tProduct : "
			                     +productservice.getProductById(ap.getP_id()).getPname() );  
			System.out.println("Time: " +ap.getStarttime()+"---"+ ap.getEndtime());
		  }
	 }

	
	
}
