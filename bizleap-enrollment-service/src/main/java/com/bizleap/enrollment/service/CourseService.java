package com.bizleap.enrollment.service;

import java.util.List;

import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface CourseService extends AbstractService {
	public List<Course> findByCourseBoId(String boId) throws ServiceUnavailableException;

	public Course findByCourseBoIdSingle(String boId) throws ServiceUnavailableException;

	public void saveCourse(Course course) throws ServiceUnavailableException;

	public List<Course> getAllCourse() throws ServiceUnavailableException;

}
