package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
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

}
