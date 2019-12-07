package com.bizleap.enrollment.resource.impl.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.enrollment.rest.client.SectionServiceRestClient;

public class SectionServiceResourceImplTest {
	SectionServiceRestClient sectionServiceRestClient = new SectionServiceRestClient();
	private static Logger logger = Logger.getLogger(SectionServiceResourceImplTest.class);

	// @Ignore
	// @Test
	// public void testSaveSection() {

	// }
	@Ignore
	@Test
	public void testFindBySectionBoId() {
		logger.info("Start ......");
		sectionServiceRestClient.findBySectionBoId("SECTION00002");
		logger.info("Success ......");
	}

	@Test
	public void testGetAllSections() {
		logger.info("Start ......");
		sectionServiceRestClient.getAllSection();
		logger.info("Success ......");
	}

}
