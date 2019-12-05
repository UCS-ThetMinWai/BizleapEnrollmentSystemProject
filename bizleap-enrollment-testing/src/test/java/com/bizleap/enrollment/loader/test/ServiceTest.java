package com.bizleap.enrollment.loader.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml","classpath:/hibernateContext.xml"})
@PropertySource({"classpath:log4j.properties", "classpath:/application.properties"})
public class ServiceTest {	
	
	@Test
	public void test() {}

}
