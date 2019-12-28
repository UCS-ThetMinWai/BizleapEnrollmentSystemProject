package com.bizleap.enrollment.domain.utils;

import org.apache.log4j.Logger;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.simple.SimpleBatch;
import com.bizleap.enrollment.domain.simple.SimpleCourse;
import com.bizleap.enrollment.domain.simple.SimpleEmployee;
import com.bizleap.enrollment.domain.simple.SimplePayment;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.simple.SimpleStudent;

public class ConvensionUtils {

	private static final Logger logger = Logger.getLogger(ConvensionUtils.class);

	public static Section toSection(SimpleSection simpleSection) {
		logger.info("Here ConvensionUtils---1");
		Section section = new Section();
		if (simpleSection == null) {
			logger.info("Section is null.");
			return null;
		}
		section.setBoId(simpleSection.getBoId());
		section.setName(simpleSection.getName());
		logger.info("name: " + simpleSection.getName());
		section.setDayType(simpleSection.getDayType());
		section.setStartTime(simpleSection.getStartTime());
		logger.info("start time : " + simpleSection.getStartTime());
		section.setEndTime(simpleSection.getEndTime());
		logger.info("end time : " + simpleSection.getStartDate());
		section.setStartDate(simpleSection.getStartDate());
		logger.info("start date : " + simpleSection.getStartDate());
		section.setEndDate(simpleSection.getEndDate());
		logger.info("end date : " + simpleSection.getEndDate());
		// logger.info("Student: " +
		// simpleSection.getSimpleStudentList().get(0).getName());
		if (!simpleSection.getSimpleStudentList().isEmpty()) {
			logger.info("Section: ");
			for (SimpleStudent simpleStudent : simpleSection.getSimpleStudentList()) {
				Student student = new Student();
				student.setBoId(simpleStudent.getBoId());
				student.setName(simpleStudent.getName());
				// logger.info("Student Name:"+simpleStudent.getName());
				student.setDescription(simpleStudent.getDescription());
				// logger.info("Student desc : " +
				// simpleStudent.getDescription());
				student.setAddress(simpleStudent.getAddress());
				student.setDescription(simpleStudent.getDescription());
				student.setEmail(simpleStudent.getEmail());
				student.setPhoneNumber(simpleStudent.getPhoneNumber());
				student.setStudentStatus(simpleStudent.getStudentStatus());

				// logger.info("Simple Student:" + simpleStudent.getName());
				// Student student = toStudent(simpleStudent);
				// logger.info("real student : " + student.toString());

				section.getStudentList().add(student);
				student.setSection(section);
			}
		}
		logger.info("Here ConvensionUtils--2");
		if (!simpleSection.getSimpleEmployeeList().isEmpty()) {
			for (SimpleEmployee simpleEmployee : simpleSection.getSimpleEmployeeList()) {
				logger.info("employee : " + simpleEmployee);
				Employee employee = new Employee();
				employee.setBoId(simpleEmployee.getBoId());
				employee.setName(simpleEmployee.getName());
				employee.setAddress(simpleEmployee.getAddress());
				employee.setAge(simpleEmployee.getAge());
				employee.setEmail(simpleEmployee.getEmail());
				employee.setPhoneNumber(simpleEmployee.getPhoneNumber());
				employee.setSalary(simpleEmployee.getSalary());
				employee.setPosition(simpleEmployee.getPosition());
				section.getEmployeeList().add(employee);
				logger.info("section's employee list : " + section.getEmployeeList().get(0).getName());
				employee.getSectionList().add(section);
				logger.info("employee's section list: " + employee.getSectionList().get(0).getName());
			}
		}
		if (simpleSection.getSimpleCourse() != null) {
			Course course = new Course();
			course.setId((simpleSection.getSimpleCourse().getId()));
			course.setBoId(simpleSection.getSimpleCourse().getBoId());
			course.setName(simpleSection.getSimpleCourse().getName());
			course.setFee(simpleSection.getSimpleCourse().getFee());
			section.setCourse(course);
		}
		logger.info("Here ConvensionUtils---3");
		return section;
	}

	public static Employee toEmployee(SimpleEmployee simpleEmployee) {
		Employee employee = new Employee();
		if (simpleEmployee == null) {
			return null;
		}
		employee.setName(simpleEmployee.getName());
		employee.setAge(simpleEmployee.getAge());
		employee.setAddress(simpleEmployee.getAddress());
		employee.setPhoneNumber(simpleEmployee.getPhoneNumber());
		employee.setSalary(simpleEmployee.getSalary());
		for (SimpleSection simpleSection : simpleEmployee.getSimpleSectionList()) {
			Section section = new Section();
			section.setName(simpleSection.getName());
			section.setStartTime(simpleSection.getStartTime());
			section.setEndTime(simpleSection.getEndTime());
			section.setStartDate(simpleSection.getEndDate());
			section.setEndDate(simpleSection.getEndDate());
			employee.getSectionList().add(section);
			section.getEmployeeList().add(employee);
		}
		return employee;
	}

	public static Student toStudent(SimpleStudent simpleStudent) {
		logger.info("SimpleStudent:" + simpleStudent);
		Student student = new Student();
		if (simpleStudent == null) {
			logger.info("Student is null.");
			return null;
		}
		student.setBoId(simpleStudent.getBoId());
		student.setName(simpleStudent.getName());
		// logger.info("Student Name:"+simpleStudent.getName());
		student.setDescription(simpleStudent.getDescription());
		// logger.info("Student desc : " + simpleStudent.getDescription());
		student.setAddress(simpleStudent.getAddress());
		student.setDescription(simpleStudent.getDescription());
		student.setEmail(simpleStudent.getEmail());
		student.setPhoneNumber(simpleStudent.getPhoneNumber());
		student.setStudentStatus(simpleStudent.getStudentStatus());

		if (!simpleStudent.getPaymentList().isEmpty()) {
			for (SimplePayment simplePayment : simpleStudent.getPaymentList()) {
				Payment payment = toPayment(simplePayment);
				payment.setStudent(student);
				student.getPaymentList().add(payment);
			}
		}

		logger.info("to student success");
		return student;
	}

	public static Payment toPayment(SimplePayment simplePayment) {
		Payment payment = new Payment();
		if (simplePayment == null) {
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
		if (simpleCourse == null) {
			return null;
		}
		course.setBoId(simpleCourse.getBoId());
		course.setName(simpleCourse.getName());
		course.setFee(simpleCourse.getFee());
		return course;
	}

	public static Batch toBatch(SimpleBatch simpleBatch) {
		Batch batch = new Batch();
		if (simpleBatch == null) {
			return null;
		}
		batch.setName(simpleBatch.getName());
		batch.setStartDate(simpleBatch.getStartDate());
		batch.setEndDate(simpleBatch.getEndDate());
		for (SimpleSection simpleSection : simpleBatch.getSectionList()) {
			Section section = toSection(simpleSection);
			section.setBatch(batch);
			batch.getSectionList().add(section);
		}
		return batch;
	}
}
