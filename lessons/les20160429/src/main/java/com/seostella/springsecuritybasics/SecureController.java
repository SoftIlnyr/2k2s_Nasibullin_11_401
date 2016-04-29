package com.seostella.springsecuritybasics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecureController {
	@RequestMapping(value = "/secure/", method = RequestMethod.GET)
	public String secure() {
		return "secure";
	}
	
}
