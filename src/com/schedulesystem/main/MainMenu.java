package com.schedulesystem.main;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;

import com.scehdulesystem.domain.Appointment;
import com.scehdulesystem.service.AppointmentService;
import com.scehdulesystem.service.impl.AppointmentServiceImpl;

public class MainMenu {
	
	 Scanner scanner = new Scanner(System.in); 
     AppointmentService appointmentservice = new AppointmentServiceImpl() ;
     ScduleMenu sc=new ScduleMenu();
	 public MainMenu() throws ParseException
	 {
	 // main menu there 
	 System.out.println("====================================================================");
     System.out.println('\t'+"Scecedule System");
     System.out.println("====================================================================");
     System.out.println('\t'+"1.list all apointment");
     System.out.println('\t'+"2.make a schedule");
     System.out.println('\t'+"3.exit"); 
     System.out.println('\t'+"Please input the number you need to choose£¡"); 
     System.out.println("====================================================================");     
	  int choice =Integer.parseInt(scanner.nextLine().trim());
	  switch(choice){
	  case 1: //listing
	      {
		  if(appointmentservice.getAllAppointment().isEmpty())
			  System.out.println("There is no appintment made now");
		  Set<Appointment> alist = appointmentservice.getAllAppointment();
		  appointmentservice.printApointmentList(alist);	
		  MainMenu mm=new MainMenu();
		  break;
	      }
	  case 2: //secedule
	      {
	      
	       sc.Scedule();
	       
	       break; 
	      } 
	  case 3:
	  {
		  System.exit(0);
		  break;	  
	  }
	  default:
		
		  break;
	  }      
   }
	 
	 public static void main(String[] args) throws ParseException {
		 MainMenu mm=new MainMenu();
		} 
   
}
