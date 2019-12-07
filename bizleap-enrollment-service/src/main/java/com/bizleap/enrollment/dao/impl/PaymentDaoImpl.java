package com.bizleap.enrollment.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizleap.enrollment.dao.PaymentDao;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.exception.ServiceUnavailableException;

@Repository
public class PaymentDaoImpl extends AbstractDaoImpl<Payment, String> implements PaymentDao {

	protected PaymentDaoImpl() {
		super(Payment.class);
		
	}

	public void save(Payment payment) throws ServiceUnavailableException {
		saveOrUpdate(payment);
		
	}

}
