package com.bizleap.enrollment.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bizleap.enrollment.dao.StudentDao;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.SystemConstant.EntityType;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.StudentService;

@Service("studentService")
@Transactional(readOnly = true)
public class StudentServiceImpl extends AbstractServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<Student> findByStudentBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select student from Student student where student.boId=:dataInput";
		List<Student> studentList = studentDao.findByString(queryStr, boId);
		if (CollectionUtils.isEmpty(studentList))
			return null;
		hibernateInitializeStudentList(studentList);
		return studentList;
	}

	@Override
	public Student findByStudentBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Student> studentList = findByStudentBoId(boId);
		if (!CollectionUtils.isEmpty(studentList)) {
			hibernateInitializeStudentList(studentList);
			if (studentList.size() > 0) {
				return studentList.get(0);
			}
		}
		return null;
	}

	@Override
	public void saveStudent(Student student) throws ServiceUnavailableException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getAllStudent() throws ServiceUnavailableException {
		List<Student> studentList = studentDao.getAll("From Student student");
		if (CollectionUtils.isEmpty(studentList))
			return null;
		hibernateInitializeStudentList(studentList);
		return studentList;
	}
	
	private String getNextBoId() {
		return getNextBoId(EntityType.STUDENT);
	}

	@Override
	public long getCount() {
		return studentDao.getCount("select count(student) from Student student");
	}

	private void hibernateInitializeStudentList(List<Student> studentList) {
		if (CollectionUtils.isEmpty(studentList))
			return;

		for (Student student : studentList) {
			hibernateInitializeStudent(student);
		}
	}
	
	private void hibernateInitializeStudent(Student student) {
		if (student == null)
			return;

		Hibernate.initialize(student);

		for (Payment payment : student.getPaymentList()) {
			Hibernate.initialize(payment);
		}
		Hibernate.initialize(student.getSection());
	}

}
