package com.bizleap.enrollment.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.hql.internal.classic.Parser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.resource.PaymentServiceResource;
import com.bizleap.enrollment.service.PaymentService;
import com.bizleap.enrollment.service.SectionService;

@RestController
@RequestMapping(value= {"/payments"})
public class PaymentServiceResourceImpl extends AbstractServiceResourceImpl implements PaymentServiceResource {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired 
	SectionService sectionService;
	
	Logger logger = Logger.getLogger(PaymentServiceResourceImpl.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public @ResponseBody List<Payment> getAllPayment(HttpServletRequest request) throws ServiceUnavailableException {
		return paymentService.getAllPayment();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody boolean createPayment(HttpServletRequest request,@RequestParam String input) {
//		JSONObject json = Parser.parseJSon(input);
//		String name = (String) json.get("name");
//		String sectionBoId = (String) json.get("sectionBoId");
//		Payment payment = new Payment();
//		payment.setBoId(SystemConstant.BOID_REQUIRED);
//		payment.setName(name);
//		try {
//			Section section = sectionService.findBySectionBoIdSingle(sectionBoId);
//			payment.setSection(section);
//			section.getSectionList().add(payment);
//		}catch (ServiceUnavailableException e) {
//			return false;
//		}
//		try {
//			sectionService.saveSection(payment);
//
//		} catch (ServiceUnavailableException e) {
//			return false;
//		}
		return true;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{boId}")
	public @ResponseBody List<Payment> findByPaymentBoId(HttpServletRequest request,@PathVariable  String boId)
			throws ServiceUnavailableException {

		return paymentService.findByPaymentBoId(boId);
	}
}
