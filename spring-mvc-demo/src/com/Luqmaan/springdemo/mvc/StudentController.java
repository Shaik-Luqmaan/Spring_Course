package com.Luqmaan.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//initBinder to remove whitespace
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
	}
	
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		Student theStudent = new Student();
		
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult) {
		
		System.out.println("Last Name : |" + theStudent.getLastName() + " | ");
		System.out.println("Binding REsult" + theBindingResult);
		
		
		if(theBindingResult.hasErrors()) {
			return "student-form";
		}
		else {
			return "student-configuration";
		}
	}
	
}
