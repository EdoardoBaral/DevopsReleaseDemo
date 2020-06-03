package it.corso.esempio.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import it.corso.esempio.pojo.HelloResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloController2Test {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testStatusOk() {
		HelloResponse actual = this.restTemplate.getForObject("/hello2/status", HelloResponse.class);
		HelloResponse expected = buildExpectedOkResponseStatus();
		assertThat(actual).isEqualTo(expected);
	}
	
	private HelloResponse buildExpectedOkResponseStatus() {
		HelloResponse res = new HelloResponse();
		res.setStatus("OK");
		return res;
	}
}
