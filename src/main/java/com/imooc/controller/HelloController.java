package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.properties.GirlProperties;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private GirlProperties girlProperties;

	@RequestMapping(value = "/say", method = RequestMethod.GET)
	// @GetMapping(value = "/say") @GetMapping spring4.3之后出现
	public String say(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
		// return girlProperties.getSex();
		return "id:" + myId;
		// return "index";
	}
}
