package com.bizleap.enrollment.dao;

import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface CourseDao extends AbstractDao<Course, String> {
	public void save(Course course) throws ServiceUnavailableException;
}
