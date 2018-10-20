package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
import it.projectmanager.project.utils.CourseValidator;
import it.projectmanager.project.utils.DialogUtils;
import javafx.fxml.FXML;

public class CourseAddController extends CourseController {
	
	private MainClass main;
	
	
	public CourseAddController() {}
	
	/* Button clicks */
	@FXML
	private void cancelClick() {
			goBack();
	}
	
	@FXML
	private void addClick() {
		if(validator.isValid()) {
			this.setCourseInfo();
			main.getCourses().add(course);
			DialogUtils.showInfo("Course Manager 2018", "Course added successfully!");
			goBack();
		}
		else
			DialogUtils.showWarning("Invalid Input", "Please check information added");
	}
	

	public void setCourseInfo() {
		
		course.setName(name.getText());
		course.setYear(Integer.parseInt(year.getText()));
		course.setProfessor(professor.getText());
		course.setMark(Integer.parseInt(mark.getText()));
		course.setCredits(Integer.parseInt(mark.getText()));
		course.setField(field.getText());
		course.setFolder(folder.getText());
		course.setProject(project.getText());
	}
	
	private void goBack() {
		main.showCoursePane();
	}

	public void setMain(MainClass main) {
		this.main = main;
		
	}

}
