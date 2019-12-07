package com.bizleap.enrollment.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.enrollment.dao.CourseDao;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

@Repository
public class CourseDaoImpl extends AbstractDaoImpl<Course, String> implements CourseDao {

	protected CourseDaoImpl() {
		super(Course.class);
	}

	@Override
	public void save(Course course) throws ServiceUnavailableException {
		saveOrUpdate(course);
	}
}

