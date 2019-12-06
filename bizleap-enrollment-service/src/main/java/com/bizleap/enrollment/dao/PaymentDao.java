package com.bizleap.enrollment.dao;

import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

public interface PaymentDao extends AbstractDao<Payment, String> {
	public void save(Payment payment) throws ServiceUnavailableException;
}
