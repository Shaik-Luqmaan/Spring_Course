package com.Luqmaan.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.Luqmaan.springdemo.mvc.validation.CourseCode;

public class Student {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=1,message="Roll number should be greater than 0")
	@Max(value=120,message="Roll number should be less than 120")
	private Integer rollNumber;
	
	@CourseCode(value="BE",message="Course should start with BE")
	private String courseCode;
	
	@Pattern(regexp="[a-zA-Z0-9]{5}",message="Only 5 characters or digits")
	private String postalCode;
	
	private String country;
	private String favouriteLanguage;
	private String[] operatingSystem;
	
	
	
	LinkedHashMap<String,String> countryOptions;
	
	Student(){
		countryOptions = new LinkedHashMap<String,String>();
		
		countryOptions.put("India", "India");
		countryOptions.put("KSA", "KSA");
		countryOptions.put("Qatar", "Qatar");
		countryOptions.put("USA", "USA");
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}	

}
