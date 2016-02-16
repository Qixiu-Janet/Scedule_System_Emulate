package com.scehdulesystem.service;

import java.util.Date;
import java.util.Set;

import com.scehdulesystem.domain.Appointment;

public interface AppointmentService {
	
	 Set<Appointment> getAllAppointment();
	 boolean scedule(Appointment appointment, Set<Appointment> checklist);
	 Set<Appointment> getAppointmentBytime(Date startTime,Date endtime);
	 void printApointmentList(Set<Appointment> list);
	
}
