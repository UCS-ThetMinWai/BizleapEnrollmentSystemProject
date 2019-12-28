
package com.bizleap.enrollment.loader.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Payment;
import com.bizleap.enrollment.domain.Student;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.PaymentService;
import com.bizleap.enrollment.service.StudentService;


public class PaymentServiceImplTest extends ServiceTest {

	@Autowired
	StudentService studentService;
	@Autowired
	PaymentService paymentService;
	private static Logger logger = Logger.getLogger(StudentServiceImplTest.class);

	@Test
	public void testSavePayment() {
		Payment payment = new Payment();
		payment.setBoId(SystemConstant.BOID_REQUIRED);
		payment.setName("First Time Payment");
		payment.setDiscount(0);
		payment.setFee(100000.00);
		payment.setDiscription("First Time Payment For student Mg Mg");
		try {
			
			Student student = studentService.findByStudentBoIdSingle("STUDENT00001");
			payment.setStudent(student);
			student.getPaymentList().add(payment);
			paymentService.savePayment(payment);
			logger.info("Saved Payment success");
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}
}
