package com.bizleap.enrollment.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.exception.ServiceUnavailableException;


public interface StudentServiceResource {
	List<Student> getAllStudent(HttpServletRequest request) throws ServiceUnavailableException;
	Boolean createStudent(HttpServletRequest request,String input);
    Student findByStudentBoId(HttpServletRequest request,String boId)throws ServiceUnavailableException;
}

