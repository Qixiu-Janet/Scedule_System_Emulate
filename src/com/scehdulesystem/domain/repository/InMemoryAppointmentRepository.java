package com.scehdulesystem.domain.repository;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.scehdulesystem.domain.Appointment;

public class InMemoryAppointmentRepository{

   
    static Set<Appointment> listOfAppointment = new HashSet<Appointment>();
 
	public InMemoryAppointmentRepository() {
     /* Appointment apoinment=new Appointment();
      apoinment.setP_id(1);
   	  apoinment.setC_Id(1);
   	  Date now=new Date();
   	  now.setHours(now.getHours()+12);
      now.setMinutes(0);
 	  apoinment.setStarttime(now);
   	  Date real_endtime=now;
   	  real_endtime.setMinutes(real_endtime.getMinutes()+30); 
   	  apoinment.setEndtime(real_endtime);
      listOfAppointment.add(apoinment);*/
	  }
   public Set<Appointment> getAllAppointment() {
  	 return listOfAppointment;
   }

public boolean addAppointment(Appointment appointment) {
	
	 listOfAppointment.add(appointment);
	 return true; 
}



public Set<Appointment> getAppointmentbyTime(Date starttime,Date endtime) {
	Set<Appointment>  Appointmentbytime = new HashSet<Appointment>();
	for(Appointment ap:listOfAppointment)
	{	
		if(ap.getEndtime().after(starttime)&&ap.getStarttime().before(endtime))	
		{	
				Appointmentbytime.add(ap);
		}		
	}
	return Appointmentbytime;
}

}