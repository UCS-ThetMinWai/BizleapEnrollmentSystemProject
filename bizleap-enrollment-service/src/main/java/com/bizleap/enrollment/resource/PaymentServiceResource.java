package com.bizleap.enrollment.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface PaymentServiceResource {
	List<Payment> getAllPayment(HttpServletRequest request) throws ServiceUnavailableException;

	boolean createPayment(HttpServletRequest request, String input);

	List<Payment> findByPaymentBoId(HttpServletRequest request, String boId) throws ServiceUnavailableException;
}
