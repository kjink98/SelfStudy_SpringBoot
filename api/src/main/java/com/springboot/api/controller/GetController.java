package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	// http://localhost:9090/api/v1/get-api/hello
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String getHello() {
		return "Hello World";
	}
	
	// http://localhost:9090/api/v1/get-api/name
	@GetMapping(value="/name")
	public String getname() {
		return "Flature";
	}
	
	// http://localhost:9090/api/v1/get-api/variable1/{String 값}
	@GetMapping(value="/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		return variable;
	}
	
	// http://localhost:9090/api/v1/get-api/variable2/{String 값}
	@GetMapping(value="/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		return var;
	}
	
	@ApiOperation(value="GET 메서드 예제", notes="@RequestParam을 활용한 GET Method")
	@GetMapping(value="/request1")
	public String getRequestParam1(
			@ApiParam(value="이름", required=true) @RequestParam String name,
			@ApiParam(value="이메일", required=true) @RequestParam String email,
			@ApiParam(value="회사", required=true) @RequestParam String organization
			) {
		return name + " " + email + " " + organization;
	}
	
	// http://localhost:9090/api/v1/get-api/request2?key1=value1&key2=value2
	@GetMapping(value="/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// http://localhost:9090/api/v1/get-api/request3?name=value1&email=value2&organization=value3
	@GetMapping(value="/request3")
	public String getRequestparam3(MemberDto memberDto) {
//		return memberDto.getName() + " " + memberDto.getEmail() + " "  + memberDto.getOrganization();
		return memberDto.toString();
	}
	

}
