package it.projectmanager.project.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.projectmanager.project.controller.CourseEditController;

//https://stackoverflow.com/questions/24702542/how-to-change-the-color-of-text-in-javafx-textfield
public class CourseEditValidator {
	
	private CourseEditController controller;
	
	
	public CourseEditValidator(CourseEditController controller) {
		this.controller = controller;
	}
	
	
	public boolean isValid() {
		return true;
	}
	
	
	public boolean checkName() {
		return false;
	}
	

}
