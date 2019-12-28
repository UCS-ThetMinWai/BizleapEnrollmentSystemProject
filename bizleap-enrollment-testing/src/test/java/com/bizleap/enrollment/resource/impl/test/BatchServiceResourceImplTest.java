package com.bizleap.enrollment.resource.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.SystemConstant;
import com.bizleap.enrollment.domain.SystemConstant.DayType;
import com.bizleap.enrollment.domain.simple.SimpleBatch;
import com.bizleap.enrollment.domain.simple.SimpleSection;
import com.bizleap.enrollment.loader.test.ServiceTest;
import com.bizleap.enrollment.rest.client.BatchServiceRestClient;
import com.bizleap.enrollment.service.SectionService;

public class BatchServiceResourceImplTest extends ServiceTest {
	BatchServiceRestClient batchServiceRestClient = new BatchServiceRestClient();
	@Autowired
	SectionService sectionService;
	private static Logger logger = Logger.getLogger(BatchServiceResourceImplTest.class);

	@Test
	public void testSaveBatch() throws ParseException {
		SimpleBatch simpleBatch = new SimpleBatch();
		simpleBatch.setBoId(SystemConstant.BOID_REQUIRED);
		simpleBatch.setName("Batch ABC");

		SimpleSection simpleSection = new SimpleSection();
		simpleSection.setBoId(SystemConstant.BOID_REQUIRED);
		simpleSection.setName("SECTION_T");
		simpleSection.setDayType(DayType.TUESDAY);
		simpleSection.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-1-1"));
		simpleSection.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-3-1"));
		simpleSection.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("09:00:00"));
		simpleSection.setEndTime(new SimpleDateFormat("HH:mm:ss").parse("12:00:00"));
		simpleBatch.getSectionList().add(simpleSection);
		batchServiceRestClient.saveBatch(simpleBatch);
	}

	@Ignore
	@Test
	public void testFindByBatchBoId() {
		logger.info("Start ......");
		batchServiceRestClient.findByBatchBoId("BATCH00002");
		logger.info("Success ......");
	}

	@Ignore
	@Test
	public void testGetAllBatchs() {
		logger.info("Start ......");
		batchServiceRestClient.getAllBatch();
		logger.info("Success ......");
	}

}
