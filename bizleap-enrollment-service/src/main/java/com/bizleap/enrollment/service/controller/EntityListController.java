package com.bizleap.enrollment.service.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.domain.Course;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.BatchService;
import com.bizleap.enrollment.service.CourseService;
import com.bizleap.enrollment.service.EmployeeService;
import com.bizleap.enrollment.service.PaymentService;
import com.bizleap.enrollment.service.SectionService;
import com.bizleap.enrollment.service.StudentService;



@Controller
public class EntityListController {

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

	@RequestMapping(value = "getAll/{entityType}", method = RequestMethod.GET)
	public String getAllEntitydetail(@PathVariable("entityType") String entityType,
			Model model) throws ServiceUnavailableException {
		
		if (entityType == null) {
			model.addAttribute("status", "Error");
			return "detail";
		}
		switch (entityType) {
		case "COURSE":
			List<Course> courseList = courseService.getAllCourse();
			model.addAttribute("courseList", courseList);
			break;

		case "SECTION":
			List<Section> sectionList = sectionService.getAllSection();
			model.addAttribute("sectionList", sectionList);
			break;
		
		case "EMPLOYEE":
			List<Employee> employeeList = employeeService.getAllEmployee();
			model.addAttribute("employeeList", employeeList);
			break;

		case "STUDENT":
			List<Student> studentList = studentService.getAllStudent();
			model.addAttribute("studentList", studentList);
			break;

		case "BATCH":
			List<Batch> batchList = batchService.getAllBatch();
			model.addAttribute("batchList", batchList);
			break;
		case "PAYMENT":
			List<Payment> paymentList = paymentService.getAllPayment();
			model.addAttribute("paymentList", paymentList);
			break;
		default:
			break;
		}
		return "detail";
	}
}

