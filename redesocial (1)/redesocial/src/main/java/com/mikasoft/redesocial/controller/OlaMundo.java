package com.mikasoft.redesocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OlaMundo {
	

	@RequestMapping("/")
	@ResponseBody()
	public String hello() {
		return "ola mundoooo";
	}
	

}
