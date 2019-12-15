package com.bizleap.enrollment.service;

import java.util.List;

import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface StudentService extends AbstractService {
	public List<Student> findByStudentBoId(String boId) throws ServiceUnavailableException;

	public Student findByStudentBoIdSingle(String boId) throws ServiceUnavailableException;

	public void saveStudent(Student student) throws ServiceUnavailableException;

	public List<Student> getAllStudent() throws ServiceUnavailableException;

	public void hibernateInitializeStudent(Student student);
	
	public void hibernateInitializeStudentList(List<Student> studentList);
}
