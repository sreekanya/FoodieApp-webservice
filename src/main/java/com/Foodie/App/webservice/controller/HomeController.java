package com.Foodie.App.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	//Query Parameters(@RequestParam)
		@RequestMapping(value="/",method = RequestMethod.GET)
		@ResponseBody
		public String indexMapping() {
			return "Hello, Server is up and running";
		}
		

}
