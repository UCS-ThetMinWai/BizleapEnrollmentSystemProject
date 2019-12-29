package com.bizleap.enrollment.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.enrollement.util.Parser;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.SystemConstant.StudentStatus;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.domain.simple.SimpleStudent;
import com.bizleap.enrollment.domain.utils.ConvensionUtils;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.StudentServiceResource;
import com.bizleap.enrollment.service.CourseService;
import com.bizleap.enrollment.service.EmployeeService;
import com.bizleap.enrollment.service.SectionService;
import com.bizleap.enrollment.service.StudentService;

@RestController
@RequestMapping(value= {"/students"})
public class StudentServiceResourceImpl extends AbstractServiceResourceImpl implements StudentServiceResource{
    @Autowired
    StudentService studentService;
    @Autowired
    SectionService sectionService;
    @Autowired
    CourseService courseService;
    @Autowired
    EmployeeService employeeService;
    
    private final Logger logger=Logger.getLogger(StudentServiceResourceImpl.class);
    
    @RequestMapping(method=RequestMethod.GET,value="/list")
	public @ResponseBody  List<Student> getAllStudent(HttpServletRequest request) throws ServiceUnavailableException {
		return studentService.getAllStudent();
	}

	@RequestMapping(method=RequestMethod.POST,value="/create")
	public @ResponseBody Boolean createStudent(HttpServletRequest request,@RequestParam String input) {
		JSONObject json = Parser.parseJSon(input);
		Student student = new Student();
		student.setName((String) json.get("name"));
		student.setAddress((String) json.get("address"));
		student.setEmail((String) json.get("email"));
		student.setPhoneNumber((String) json.get("phoneNumber"));
		student.setAge(Integer.parseInt((String) json.get("age")));
		student.setStudentStatus(StudentStatus.valueOf((String)json.get("enrollType")));
		
		String courseBoId = (String) json.get("courseBoId");
		String employeeBoId = (String) json.get("employeeBoId");
		String sectionBoId = (String) json.get("sectionBoId");
		logger.info("Create Student>>>>>>>>>>>>>>>>>>>>>");
		try {
			Section section = sectionService.findBySectionBoIdSingle(sectionBoId);
			Employee employee = employeeService.findByEmployeeBoIdSingle(employeeBoId);
			Course course = courseService.findByCourseBoIdSingle(courseBoId);
			section.getEmployeeList().add(employee);
			section.setCourse(course);
			student.setSection(section);
			studentService.saveStudent(student);
			
		} catch(ServiceUnavailableException e) {
			return false;
		}
		return true;
	}

	@RequestMapping(method=RequestMethod.GET,value="/find/{boId}")
	public @ResponseBody Student findByStudentBoId(HttpServletRequest request,@PathVariable String boId)
			throws ServiceUnavailableException {
		logger.info("In resource .......");
		return studentService.findByStudentBoIdSingle(boId);
	}

}


