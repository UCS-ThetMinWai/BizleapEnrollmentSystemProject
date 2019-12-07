package com.bizleap.enrollment.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.enrollment.dao.StudentDao;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

@Repository
public class StudentDaoImpl extends AbstractDaoImpl<Student, String> implements StudentDao {

	protected StudentDaoImpl() {
		super(Student.class);
	}

	@Override
	public void save(Student student) throws ServiceUnavailableException {
		saveOrUpdate(student);
	}
}

