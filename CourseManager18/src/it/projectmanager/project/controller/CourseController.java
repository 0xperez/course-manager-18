package it.projectmanager.project.controller;

import it.projectmanager.project.model.Course;
import it.projectmanager.project.utils.CourseValidator;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CourseController {
	
	@FXML
	protected TextField name;
	
	@FXML
	protected TextField year;
	
	@FXML
	protected TextField professor;
	
	@FXML
	protected TextField mark;
	
	@FXML
	protected TextField credits;
	
	@FXML
	protected TextField field;
	
	@FXML
	protected TextField folder;
	
	@FXML
	protected TextField project;
	
	
	protected Course course;
	
	protected CourseValidator validator;
	
	protected boolean enabled = false;
	
	protected boolean modified = false;
	
	
	public CourseController() {
		course = new Course();
		validator = new CourseValidator(this);
	}
	
	public void showCourse(Course c) {
		name.setText(c.getName());
		year.setText(c.getYear()+ "");
		professor.setText(c.getProfessor());
		mark.setText(c.getMark() + "");
		credits.setText(c.getCredits() + "");
		field.setText(c.getField());
		folder.setText(c.getFolder());
		project.setText(c.getProject());
	}
	
	
	public void highlight(TextField t, String cssColorId) {
		String style = "-fx-text-inner-color: " + cssColorId.trim() + ";";
		t.setStyle(style);
	}

	public TextField getName() {
		return name;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public TextField getYear() {
		return year;
	}

	public void setYear(TextField year) {
		this.year = year;
	}

	public TextField getProfessor() {
		return professor;
	}

	public void setProfessor(TextField professor) {
		this.professor = professor;
	}

	public TextField getMark() {
		return mark;
	}

	public void setMark(TextField mark) {
		this.mark = mark;
	}

	public TextField getCredits() {
		return credits;
	}

	public void setCredits(TextField credits) {
		this.credits = credits;
	}

	public TextField getField() {
		return field;
	}

	public void setField(TextField field) {
		this.field = field;
	}

	public TextField getFolder() {
		return folder;
	}

	public void setFolder(TextField folder) {
		this.folder = folder;
	}

	public TextField getProject() {
		return project;
	}

	public void setProject(TextField project) {
		this.project = project;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course c) {
		this.course = c;
	}
	
	
	public CourseValidator getValidator() {
		return validator;
	}
	
	
	public void setValidator(CourseValidator validator) {
		this.validator = validator;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public boolean isModified() {
		return modified;
	}
	
	public void setModified(boolean modified) {
		this.modified = modified;
	}

	
	
	
	
	

}
