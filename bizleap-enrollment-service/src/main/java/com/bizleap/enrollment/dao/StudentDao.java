package com.bizleap.enrollment.dao;

import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface StudentDao extends AbstractDao<Student, String> {
	public void save(Student student) throws ServiceUnavailableException;
}