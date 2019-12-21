package com.bizleap.enrollment.service.controller;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bizleap.enrollement.util.Parser;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.BatchService;
import com.bizleap.enrollment.service.CourseService;
import com.bizleap.enrollment.service.EmployeeService;
import com.bizleap.enrollment.service.PaymentService;
import com.bizleap.enrollment.service.SectionService;
import com.bizleap.enrollment.service.StudentService;



@Controller
public class DetailController {

	@Autowired
	private SectionService sectionService;
	@Autowired
	private BatchService batchService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;

	private static Logger logger = Logger.getLogger(DetailController.class);

	@RequestMapping(value = "detail/{entityType}", method = RequestMethod.GET)
	public String detail(@RequestParam("input") String input, @PathVariable("entityType") String entityType,
			Model model) throws ServiceUnavailableException {
		JSONObject json = Parser.parseJSon(input);
		if (json == null) {
			model.addAttribute("status", "Error");
			return "detail";
		}
		String boId = (String) json.get("boId");
		switch (entityType) {
		case "COURSE":
			Course course = courseService.findByCourseBoId(boId).get(0);
			model.addAttribute("course", course);
			break;

//		case "MAJOR":
//			Major major = majorService.findByMajorBoId(boId).get(0);
//			model.addAttribute("major", major);
//			break;
//
//		case "TEACHER":
//			Teacher teacher = teacherService.findByTeacherBoId(boId).get(0);
//			model.addAttribute("teacher", teacher);
//			break;
//
//		case "STAFF":
//			Staff staff = staffService.findByStaffBoId(boId).get(0);
//			model.addAttribute("staff", staff);
//			break;
//
//		case "STUDENT":
//			Student student = studentService.findByStudentBoId(boId).get(0);
//			model.addAttribute("student", student);
//			break;
		default:
			break;
		}
		return "detail";
	}
}
