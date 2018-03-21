package com.tirmizee.core.backend.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.core.backend.rest.data.MemberDTO;

@RestController
@RequestMapping(path = "service/csrf")
public class RestCsrfController {

	@GetMapping(path = "/getString")
	public MemberDTO get(@RequestParam String name){
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUsername(name);
		return memberDTO;
	}
	
	
	
	@PostMapping(path = "/getObject" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MemberDTO post(@RequestBody MemberDTO memberDto){
		System.out.println(memberDto.getUsername());
		return memberDto;
	}
	
}
