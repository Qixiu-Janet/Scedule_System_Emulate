package com.schedulesystem.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

import com.scehdulesystem.domain.Appointment;
import com.scehdulesystem.service.AppointmentService;
import com.scehdulesystem.service.CustomerService;
import com.scehdulesystem.service.ProductService;
import com.scehdulesystem.service.impl.AppointmentServiceImpl;
import com.scehdulesystem.service.impl.CustomerServiceImpl;
import com.scehdulesystem.service.impl.ProductServiceImpl;


public class ScduleMenu{
	
	
	
	/**
	 * author Janet£º
	 * in this application I make a user name Jone id 1 as a end user to do all  the options. 
	 * @throws ParseException 
	 * 
	 */
	
	
	static Set<Appointment> appintmentinUserPreriod;
	
	 ScduleMenu(){}
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
     Scanner scanner = new Scanner(System.in); 
     AppointmentService appointmentservice = new AppointmentServiceImpl() ;
     CustomerService customerservice=new CustomerServiceImpl();
     ProductService productservice=new ProductServiceImpl();
 
	 @SuppressWarnings("deprecation")
	public void Scedule() throws ParseException{
	//remind the user today's date
     Date dateofnow=new Date();
     String today = dateFormat.format(dateofnow); 
     System.out.println("Time of now is:  "+ today);   
     //get user input date
     System.out.println("In this system you can check the exit scedule first to avoid time duplicates");
     System.out.println("Input the start time you want to scedule in format: yyyy-MM-dd HH:mm:ss");
     System.out.println("====================================================================");     
     String startdates=scanner.nextLine();
     try {
     Date startdate=dateFormat.parse(startdates);
     if(startdate.before(dateofnow))
     {
    	 System.out.println("Can not sechedule a date before now,please check and enter again");   
    	 Scedule();
     }
     System.out.println("Input how many hours you can wait: ");
     int hours=Integer.parseInt(scanner.nextLine());
     Date enddate=new Date(startdate.getTime());
     int hr=enddate.getHours();
     enddate.setHours(hr+hours);
     System.out.println("The end time you set is: "+dateFormat.format(enddate));
     System.out.println("====================================================================");    
     appintmentinUserPreriod=appointmentservice.getAppointmentBytime(startdate, enddate);
     if(appintmentinUserPreriod==null||appintmentinUserPreriod.size()==0)
         {
    	  System.out.println("There is no appointment in the period you pick.");        
         }
      else 
         {
    	  System.out.println("There is a list of appointments in the period you pick. Please check  or press ESC to return to main menu ");   	    
    	  appointmentservice.printApointmentList(appintmentinUserPreriod);
          }
     //pick start time
     System.out.println("====================================================================");    
     System.out.println("Input the start time you want to scedule in format: yyyy-MM-dd HH:mm:ss");
     System.out.println("The minute must be 00 or 15 or 30 or 45");
     String startdatess=scanner.nextLine();
     Date real_startdate=dateFormat.parse(startdatess);
   
     System.out.println("you entered "+ dateFormat.format(real_startdate) +" as a start time");
     if(real_startdate.after(enddate)||real_startdate.before(startdate))
     {
    	 if(!real_startdate.equals(startdate)){
    		 
    	 }
    	 else{
    		 System.out.println("The time you pick is not in the period you check please check and enter again");   
    		 Scedule();
    	 }
     }
      System.out.println("Please enter a service type, type 1 represents Haircut ONLY, type 2 or another key represents Shampoo & Haircut");
      int P_id=Integer.parseInt(scanner.nextLine().trim());
      Appointment apoinment=new Appointment();
      if(P_id==1)
      {
    	  apoinment.setP_id(1);
    	  apoinment.setC_Id(1);
    	  apoinment.setStarttime(real_startdate);
    	  Date real_endtime= new Date(real_startdate.getTime());
    	  real_endtime.setMinutes(real_endtime.getMinutes()+productservice.getProductById(1).getService_time());
    	  apoinment.setEndtime(real_endtime);
        }
      else{
    	  apoinment.setP_id(2);
    	  apoinment.setC_Id(1);
    	  apoinment.setStarttime(real_startdate);
    	  Date real_endtime= new Date(real_startdate.getTime());
    	  real_endtime.setMinutes(real_endtime.getMinutes()+productservice.getProductById(2).getService_time());	
    	  apoinment.setEndtime(real_endtime);	  
         }	
       boolean res=appointmentservice.scedule(apoinment,appintmentinUserPreriod);
       if(res)
       {
    	   System.out.println("You make a scedule sucessful!");
    	   MainMenu mm=new MainMenu();
       }
       else{
           System.out.println("You can not make a scedule in the exit time of another scedule");
           MainMenu mm=new MainMenu();
       }
      
     }catch(ParseException e)
     {
    	 System.out.println("The formart you input is not correct try agian");
    	 Scedule();
     }
    
    }  
}
 