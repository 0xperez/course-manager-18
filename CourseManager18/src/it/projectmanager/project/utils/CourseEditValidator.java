package it.projectmanager.project.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.projectmanager.project.controller.CourseEditController;

//https://stackoverflow.com/questions/24702542/how-to-change-the-color-of-text-in-javafx-textfield
public class CourseEditValidator {
	
	private CourseEditController c;
	
	
	public CourseEditValidator(CourseEditController controller) {
		this.c = controller;
	}
	
	
	public boolean isValid() {
		return true;
	}
	
	//Name can be any sequence of alphanumerics and space chars, of minimum length 1 and max length 50.
	public boolean checkName() {
		return c.getName().getText().matches("^[a-zA-Z0-9\\+\\, ]{1,50}$");
	}
	
	
	public boolean checkYear() {
		int year = Integer.parseInt(c.getYear().getText());
		return year > 0 && year < 3;
	}
	

}
