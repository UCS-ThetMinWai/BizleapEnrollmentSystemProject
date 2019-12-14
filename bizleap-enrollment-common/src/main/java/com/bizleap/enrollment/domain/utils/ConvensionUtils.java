package com.bizleap.enrollment.domain.utils;

import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.simple.SimpleCourse;
import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.simple.SimplePayment;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.simple.SimpleStudent;

public class ConvensionUtils {

	public static Section toSection(SimpleSection simpleSection) {
		Section section = new Section();
		if(simpleSection == null) {
			return null;
		}
		section.setName(simpleSection.getName());
		section.setStartTime(simpleSection.getStartTime());
		section.setEndTime(simpleSection.getEndTime());
		section.setStartDate(simpleSection.getEndDate());
		section.setEndDate(simpleSection.getEndDate());
//		for(SimpleStudent simpleStudent : simpleSection.getSimpleStudentList()) {
//			Student student = toStudent(simpleStudent);
//			section.getStudentList().add(student);
//		}
//		for(SimpleEmployee simpleEmployee : simpleSection.getSimpleEmployeeList()) {
//			Employee employee = new Employee();
//			employee.setName(simpleEmployee.getName());
//			employee.setAddress(simpleEmployee.getAddress());
//			employee.setAge(simpleEmployee.getAge());
//			employee.setEmail(simpleEmployee.getEmail());
//			employee.setPhoneNumber(simpleEmployee.getPhoneNumber());
//			employee.setSalary(simpleEmployee.getSalary());
//			employee.setPosition(simpleEmployee.getPosition());
//			section.getEmployeeList().add(employee);
//			employee.getSectionList().add(section);
//		}
		
		return section;
		
	}
	
	public static Employee toEmployee(SimpleEmployee simpleEmployee) {
		Employee employee = new Employee();
		if(simpleEmployee == null) {
			return null;
		}
		employee.setName(simpleEmployee.getName());
		employee.setAge(simpleEmployee.getAge());
		employee.setAddress(simpleEmployee.getAddress());
		employee.setPhoneNumber(simpleEmployee.getPhoneNumber());
		employee.setSalary(simpleEmployee.getSalary());
		for(SimpleSection simpleSection : simpleEmployee.getSimpleSectionList()) {
			Section section = new Section();
			section.setName(simpleSection.getName());
			section.setStartTime(simpleSection.getStartTime());
			section.setEndTime(simpleSection.getEndTime());
			section.setStartDate(simpleSection.getEndDate());
			section.setEndDate(simpleSection.getEndDate());
			
		}
		
		return employee;
		
	}
	
	
	public static Student toStudent(SimpleStudent simpleStudent) {
		Student student = new Student();
		if(simpleStudent == null) {
			return null;
		}
		student.setName(simpleStudent.getName());
		student.setDescription(simpleStudent.getDescription());
		student.setSection(simpleStudent.getSection());
		for(SimplePayment simplePayment:simpleStudent.getPaymentList()) {
			Payment payment = toPayment(simplePayment);
			payment.setStudent(student);
			student.getPaymentList().add(payment);
		}
		student.setStudentStatus(simpleStudent.getStudentStatus());
		return student;
		
	}
	
	public static Payment toPayment(SimplePayment simplePayment) {
		Payment payment = new Payment();
		if(simplePayment == null) {
			return null;
		}
		payment.setName(simplePayment.getName());
		payment.setDiscount(simplePayment.getDiscount());
		payment.setDiscription(simplePayment.getDiscription());
		payment.setFee(simplePayment.getFee());
		return payment;
		
	}
	
	public static Course toCourse(SimpleCourse simpleCourse) {
		
		Course course = new Course();
		if(simpleCourse == null) {
			return null;
		}
		course.setName(simpleCourse.getName());
		course.setFee(simpleCourse.getFee());
		return course;
	}
	
}
