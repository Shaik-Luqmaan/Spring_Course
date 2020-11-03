package com.Luqmaan.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "view-page";
	}
	
	@RequestMapping("/processFormV2")
	public String shoutName(HttpServletRequest request , Model model) {
		
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Hey.." + theName;
		
		model.addAttribute("message", result);
		
		return "view-page";
	}

	@RequestMapping("/processFormV3")
	public String shoutNameLoud(@RequestParam("studentName") String theName , Model model) {
		
		
		theName = theName.toUpperCase();
		
		String result = "Hello...." + theName;
		
		model.addAttribute("message", result);
		
		
		return "view-page";
	}
	
}
