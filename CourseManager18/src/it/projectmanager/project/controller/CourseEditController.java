package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
import it.projectmanager.project.model.Course;
import it.projectmanager.project.utils.CourseValidator;
import it.projectmanager.project.utils.DialogUtils;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class CourseEditController extends CourseController {
	
	@FXML
	private Button editButton;
	
	/* Other references */
	//private Course course;

	
	private MainClass main;
	
	
	private boolean modified;
	
	
	public CourseEditController(){
		System.out.println("Constructer called");
		
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
				//Reset color to black because after validation is red.
				//TODO maybe create a separate class of this listener since it has many features.
				//Find a more efficient way to restore the color property?
				//https://stackoverflow.com/questions/16549296/how-perform-task-on-javafx-textfield-at-onfocus-and-outfocus
				else {
					StringProperty p = (StringProperty) observable;
					TextField txt = (TextField) p.getBean();
					txt.setStyle("-fx-text-inner-color: black;");
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
		
		super.setCourse(c);
		
		showCourse(c);
		
		//set change listeners to determine if the course has changed
		setListeners();
		
	}
	
	
	
/* Define button clicks */
	/**
	 * Called when edit button is clicked. Input is validated and edited if
	 */
	@FXML
	private void editClick() {
		if(validator.isValid()) {
			System.out.println("DEBUG: course = " + course.toString());
			System.out.println("name = " + name.getText());
			editCourse();
			DialogUtils.showInfo("Course Manager 2018", "Course information edited succesfully!");
			goBack();
		}
		else {
			DialogUtils.showWarning("Invalid input", "Please check information entered.");
		}
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
	private void editCourse() {
		System.out.println("DEBUG: course = " + course.toString() + ", name = " + name.getText());
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
	
	
	
	
	
	
	
	
	
}
