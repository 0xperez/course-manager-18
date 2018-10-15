package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
import it.projectmanager.project.model.Course;
import it.projectmanager.project.utils.DialogUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CourseEditController {
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField year;
	
	@FXML
	private TextField professor;
	
	@FXML
	private TextField mark;
	
	@FXML
	private TextField credits;
	
	@FXML
	private TextField field;
	
	@FXML
	private TextField folder;
	
	@FXML
	private TextField project;
	
	private Course course;
	
	private MainClass main;
	
	
	public void setMain(MainClass main) {
		this.main = main;
	}
	
	
	public void setCourse(Course c) {
		
		this.course = c;
		
		name.setText(c.getName());
		year.setText(c.getYear()+ "");
		professor.setText(c.getProfessor());
		mark.setText(c.getMark() + "");
		credits.setText(c.getCredits() + "");
		field.setText(c.getField());
		folder.setText(c.getFolder());
		project.setText(c.getProject());
		
	}
	
	
	//input has to be validated prior be edited
	@FXML
	public void editCourse() {
		course.setName(name.getText());
		course.setYear(Integer.parseInt(year.getText()));
		course.setProfessor(professor.getText());
		course.setMark(Integer.parseInt(mark.getText()));
		course.setCredits(Integer.parseInt(mark.getText()));
		course.setField(field.getText());
		course.setFolder(folder.getText());
		course.setProject(project.getText());
		
		DialogUtils.showInfo("Course Manager 2018", "Course information edited succesfully!");
		
		main.showCoursePane();
	}

}
