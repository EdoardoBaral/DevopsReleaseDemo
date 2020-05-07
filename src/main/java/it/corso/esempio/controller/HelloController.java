package it.corso.esempio.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.corso.esempio.pojo.HelloResponse;

@RestController
@RequestMapping(value="/hello")
public class HelloController {

	@RequestMapping(value="/status", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
	public HelloResponse getStatus() {
		HelloResponse res = new HelloResponse();
		res.setStatus("OK");
		
		return res;
	}

	@RequestMapping(value="/greeting", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
	public HelloResponse getGreeting() {
		HelloResponse res = new HelloResponse();
		res.setStatus("Hello World!");

		return res;
	}



}
