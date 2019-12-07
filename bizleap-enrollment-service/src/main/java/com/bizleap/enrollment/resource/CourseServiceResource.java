package com.bizleap.enrollment.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.exception.ServiceUnavailableException;


public interface CourseServiceResource {
	List<Course> getAllCourse(HttpServletRequest request) throws ServiceUnavailableException;
	// createSection(HttpServletRequest request,SimpleSection section);
    Course findByCourseBoId(HttpServletRequest request,String boId)throws ServiceUnavailableException;
}

