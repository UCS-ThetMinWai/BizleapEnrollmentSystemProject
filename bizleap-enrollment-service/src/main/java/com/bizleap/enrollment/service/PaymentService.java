package com.bizleap.enrollment.service;

import java.util.List;

import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface PaymentService extends AbstractService {
	public List<Payment> findByPaymentBoId(String boId)throws ServiceUnavailableException;
	public Payment findByPaymentBoIdSingle(String boId)throws ServiceUnavailableException;
	public void savePayment(Payment payment)throws ServiceUnavailableException;
	public List<Payment> getAllPayment()throws ServiceUnavailableException;
	
}
