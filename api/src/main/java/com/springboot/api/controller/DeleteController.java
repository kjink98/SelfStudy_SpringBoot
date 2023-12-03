package com.springboot.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
	// http://localhost:9090/api/v1/delete-api/{String 값}
	@DeleteMapping(value="/{variable}")
	public String DeleteVariable(@PathVariable String variable) {
		return variable;
	}
	
	// http://localhost:9090/api/v1/delete-api/request1?email=value
	@DeleteMapping(value="/request1")
	public String getRequestparam1(@RequestParam String email) {
		return "e-mail: " + email ; 
	}
	
	
}
