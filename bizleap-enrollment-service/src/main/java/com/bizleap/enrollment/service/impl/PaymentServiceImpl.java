package com.bizleap.enrollment.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bizleap.enrollment.dao.PaymentDao;
import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.PaymentService;

@Service("paymentService")
public class PaymentServiceImpl extends AbstractServiceImpl implements PaymentService {
	
	@Autowired
	PaymentDao paymentDao;

	@Override
	public List<Payment> findByPaymentBoId(String boId) throws ServiceUnavailableException {
		String queryStr = "select payment from Payment payment where payment.boId=:dataInput";
		List<Payment> paymentList = paymentDao.findByString(queryStr, boId);
		return paymentList;
	}

	@Override
	public Payment findByPaymentBoIdSingle(String boId) throws ServiceUnavailableException {
		List<Payment> paymentList = findByPaymentBoId(boId);
		if (!CollectionUtils.isEmpty(paymentList)) {
			if (paymentList.size() > 0) {
				return paymentList.get(0);
			}
		}
		return null;
	}
	
//	@Transactional(readOnly = true)
//	public void savePayment(Payment payment) throws ServiceUnavailableException {
//			if (payment.isBoIdRequired()) {
//				payment.setBoId(getNextBoId());
//			}
//			paymentDao.save(payment);
//	}

	@Override
	public List<Payment> getAllPayment() throws ServiceUnavailableException {
		List<Payment> paymentList = paymentDao.getAll("From Payment payment");
		return paymentList;
	}

	@Override
	public long getCount() {
		return paymentDao.getCount("select count(payment) from Payment payment");
	}

}
