package com.speed.mixer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class BookServiceController {
	
	private static Logger log = LoggerFactory.getLogger(BookServiceController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallback", commandProperties=
			@HystrixProperty(
					name="execution.isolation.thread.timeoutInMilliseconds",
					//name="hystrix.command.HystrixCommandKey.execution.isolation.thread.timeoutInMilliseconds",
					value="1000")
	)
	@GetMapping(value="/client/available")
	public String getAvailable(){
		String url="http://BOOK-SERVICE/available";
		log.info("Before calling the server");
		String response = restTemplate.getForObject(url, String.class);
		log.info("Before calling the server");
		return response;
	}
	
	@HystrixCommand(fallbackMethod="fallback", commandProperties=
			@HystrixProperty(
					name="execution.isolation.thread.timeoutInMilliseconds",
					//name="hystrix.command.HystrixCommandKey.execution.isolation.thread.timeoutInMilliseconds",
					value="1000")
	)
	@GetMapping(value="/client/checkout")
	public String getCheckout(){
		String url="http://BOOK-SERVICE/checked-out";
		log.info("Before calling the server");
		String response = restTemplate.getForObject(url, String.class);
		log.info("After calling the server");
		return response;
	}
	
	public String fallback(Throwable hystrixCommand){
		return "Fallback Book-Service";
	}
}
