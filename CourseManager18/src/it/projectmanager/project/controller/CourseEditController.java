package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
import it.projectmanager.project.model.Course;
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
	
	
	private MainClass main;
	
	
	public void setMain(MainClass main) {
		this.main = main;
	}
	
	
	public void setCourse(Course c) {
		
		name.setText(c.getName());
		year.setText(c.getYear()+ "");
		professor.setText(c.getProfessor());
		mark.setText(c.getMark() + "");
		credits.setText(c.getCredits() + "");
		field.setText(c.getField());
		folder.setText(c.getFolder());
		project.setText(c.getProject());
		
	}

}
