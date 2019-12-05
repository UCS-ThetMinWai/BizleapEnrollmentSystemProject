package com.bizleap.enrollment.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;

public interface AbstractServiceResource {		
	 @RequestMapping( value = "/**", method = RequestMethod.OPTIONS ) 
	  public ResponseEntity handle(); 
}
