package com.bizleap.enrollment.loader.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Batch;
import com.bizleap.enrollment.domain.Employee;
import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.DayType;
import com.bizleap.enrollment.domain.SystemConstant.Position;
import com.bizleap.enrollment.exception.ServiceUnavailableException;
import com.bizleap.enrollment.service.BatchService;
import com.bizleap.enrollment.service.SectionService;

public class BatchServiceImplTest extends ServiceTest {

	@Autowired
	BatchService batchService;
	@Autowired
	SectionService sectionService;

	private static Logger logger = Logger.getLogger(BatchServiceImplTest.class);

	@Ignore
	@Test
	public void testGetAllBatch() {
		try {
			System.out.print("starting test getAllEmployee method..........");
			List<Batch> batchList = batchService.getAllBatch();
			for (Batch batch : batchList) {
				logger.info(batch);
			}
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}

	
	@Test
	public void testSaveBatch() throws ParseException {

		Batch batch = new Batch();
		batch.setBoId(SystemConstant.BOID_REQUIRED);
		batch.setName("BATCH_20");
		batch.setStartDate(new SimpleDateFormat("HH:mm:ss").parse("09:00:00"));
		batch.setEndDate(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));
		Section section = new Section();
		section.setBoId(SystemConstant.BOID_REQUIRED);
		section.setName("SECTION_Z");
		section.setDayType(DayType.SATURDAY);
		section.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-1-1"));
		section.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-3-1"));
		section.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("09:00:00"));
		section.setEndTime(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));
		section.setBatch(batch);
		batch.getSectionList().add(section);
		try {
			batchService.saveBatch(batch);
			logger.info("Saved Batch Success");
		} catch (ServiceUnavailableException e) {
			logger.error("Error is:::" + e);
		}
	}

	@Ignore
	@Test
	public void testFindByBatchBoId() {
		try {
			System.out.println("starting testing testFindByEmployeeBoId method");
			List<Batch> batchList = batchService.findByBatchBoId("EMPLOYEE00001");
			for (Batch batch : batchList) {

				logger.info(batch);
			}
		} catch (ServiceUnavailableException e) {
			logger.info("Error is" + e);
		}
	}
}
