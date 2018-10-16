package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
import it.projectmanager.project.model.Course;
import it.projectmanager.project.utils.CourseEditValidator;
import it.projectmanager.project.utils.DialogUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
	
	@FXML
	private Button editButton;
	
	
	private Course course;

	
	private MainClass main;
	
	
	private boolean modified;
	
	private CourseEditValidator validator;
	
	
	public CourseEditController(){
		System.out.println("Constructer called");
		validator = new CourseEditValidator(this);
		
	}
	
	@FXML
	public void initialize() {
		
		System.out.println("Initialize called");
	}
	
	
	/**
	 * Add a listener to each textfield to check whether a field has been modifed or not. If so, the EDIT button gets enabled.
	 */
	private void setListeners() {
		
		ChangeListener<String> modListener = new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(!modified) {
					editButton.setDisable(false);
					modified = true;
				}
			}
		};
		name.textProperty().addListener(modListener);
		year.textProperty().addListener(modListener);
		professor.textProperty().addListener(modListener);
		mark.textProperty().addListener(modListener);
		credits.textProperty().addListener(modListener);
		field.textProperty().addListener(modListener);
		folder.textProperty().addListener(modListener);
		project.textProperty().addListener(modListener);
	}
	
	
	/**
	 * Sets the main class to be able to switch back to the previous pane.
	 * @param main
	 */
	public void setMain(MainClass main) {
		this.main = main;
	}
	
	/**
	 * Sets the course to show and edit. The attributes of the course are fetched and shown in the corresponding TextField.
	 * Also sets the listeners.
	 * @param c
	 */
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
		//set change listeners to determine if the course has changed
		setListeners();
		
	}
	
	/**
	 * Called when the CANCEL button is clicked. If some field has been modified, asks the user whether they are sure to go
	 * back and lose the modifications. Else, simply goes back to the previous panel.
	 */
	@FXML
	private void cancelClick() {
		if(this.modified) {
			DialogUtils.showConfirm("Unsaved changes", "If you do not edit your changes, you will lose them. Continue?")
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response -> goBack());
		}
		else
			goBack();
	}
	
	//input has to be validated prior be edited
	/**
	 * Sets the course fields, overwriting 
	 */
	private void edit() {
		course.setName(name.getText());
		course.setYear(Integer.parseInt(year.getText()));
		course.setProfessor(professor.getText());
		course.setMark(Integer.parseInt(mark.getText()));
		course.setCredits(Integer.parseInt(mark.getText()));
		course.setField(field.getText());
		course.setFolder(folder.getText());
		course.setProject(project.getText());
		
		DialogUtils.showInfo("Course Manager 2018", "Course information edited succesfully!");
		
		goBack();
	}
	
	@FXML
	private void editClick() {
		if(validator.isValid()) {
			edit();
		}
		else {
			DialogUtils.showWarning("Invalid input", "Please check information entered.");
		}
	}
	
	
	private void goBack() {
		main.showCoursePane();
	}
	
	
	
	
	
}
