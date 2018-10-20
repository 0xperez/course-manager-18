package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
import it.projectmanager.project.utils.DialogUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CourseAddController extends CourseController {
	
	private MainClass main;
	
	private CourseInputListener modListener;
	
	@FXML
	private Button addButton;
	
	
	public CourseAddController() {
		modListener = new CourseInputListener(this);
	}
	
	
	@FXML
	public void initialize() {
		this.setListeners();
	}
	
	
	private void setListeners() {
		name.textProperty().addListener(modListener);
		year.textProperty().addListener(modListener);
		professor.textProperty().addListener(modListener);
		mark.textProperty().addListener(modListener);
		credits.textProperty().addListener(modListener);
		field.textProperty().addListener(modListener);
		folder.textProperty().addListener(modListener);
		project.textProperty().addListener(modListener);
	}
	
	
	public void setEnabled(boolean enabled) {
		if(!enabled)
			addButton.setDisable(true);
		else
			addButton.setDisable(false);
		
		this.enabled = enabled;
	}
	
	
	
	
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
		course.setCredits(Integer.parseInt(credits.getText()));
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
