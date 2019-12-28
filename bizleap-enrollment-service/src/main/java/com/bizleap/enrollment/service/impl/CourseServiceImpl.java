package com.bizleap.enrollment.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.enrollment.dao.CourseDao;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.SystemConstant.EntityType;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.CourseService;

@Service("courseService")
@Transactional(readOnly = true)
public class CourseServiceImpl extends AbstractServiceImpl implements CourseService{

	@Autowired
	CourseDao courseDao;
	
	private static final Logger logger = Logger.getLogger(CourseServiceImpl.class);

	
	@Override
	public List<Course> findByCourseBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select course from Course course where course.boId=:dataInput";
		List<Course> courseList = courseDao.findByString(queryStr, boId);
		if (CollectionUtils.isEmpty(courseList))
			return null;
		return courseList;
	}

	@Override
	public Course findByCourseBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Course> courseList = findByCourseBoId(boId);
		if (!CollectionUtils.isEmpty(courseList)) {
			if (courseList.size() > 0) {
				return courseList.get(0);
			}
		}
		return null;
	}

	@Transactional(readOnly = false)
	@Override
	public void saveCourse(Course course) throws ServiceUnavailableException {
		logger.info("Course" + course);
		if (course.isBoIdRequired()) {
			course.setBoId(getNextBoId());
		}

		courseDao.save(course);		
	}

	@Override
	public List<Course> getAllCourse() throws ServiceUnavailableException {
		List<Course> courseList = courseDao.getAll("From Course course");
		if (CollectionUtils.isEmpty(courseList))
			return null;
		return courseList;
	}

	private String getNextBoId() {
		return getNextBoId(EntityType.COURSE);
	}
	@Override
	public long getCount() {
		return courseDao.getCount("select count(course) from Course course");
	}
	
}
