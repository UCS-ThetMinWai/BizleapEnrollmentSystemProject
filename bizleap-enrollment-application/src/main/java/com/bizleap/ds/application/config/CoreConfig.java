package com.bizleap.ds.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ AppConfig.class })
@ComponentScan(basePackages = { 
		"com.bizleap.commons.domain",
		"com.bizleap.ds.loader",
		"com.bizleap.ds.service"})
public class CoreConfig {

}