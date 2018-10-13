package it.projectmanager.project.controller;

import it.projectmanager.project.MainClass;
import it.projectmanager.project.model.Course;
import it.projectmanager.project.utils.DialogUtils;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/*Remember to:
 * Link the controller to the view in the SceneBuilder Controller menu
 * Associate every grafic element with its SceneBuilder counterpart by using fx:id inside the application
 * If needed, Buttons and other FX entities can be referenced here in the code, but they require and fx:id and
 * an @FXML annotation. Try to avoid this approach if possible.
 */
public class CoursePaneController {

	@FXML
	private TableView<Course> courseTable;

	@FXML
	private TableColumn<Course, String> nameCol;

	@FXML
	private TableColumn<Course, Integer> yearCol;

	@FXML
	private Label nameLbl;

	@FXML
	private Label yearLbl;

	@FXML
	private Label professorLbl;

	@FXML
	private Label markLbl;

	@FXML
	private Label creditsLbl;

	@FXML
	private Label fieldLbl;

	@FXML
	private Label folderLbl;

	@FXML
	private Label projectLbl;
	
	//Test to bind an object to his fx:id
	//@FXML
	//private Button customDelete;

	private MainClass main;
	
	
	

	public CoursePaneController() {

	}

	// initializes the controller class (called after the fxml file has been loaded)
	@FXML
	private void initialize() {
		// specifies how to populate the cells in the two cols
		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		// asObject needed when dealing with something that is not a string
		yearCol.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());

		this.clearText();

		// Add a selection listener which shows course details each time a selection is
		// made in the table
		courseTable.getSelectionModel().selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> this.showCourseDetails(newValue));
		

	}

	// called from main to set the data
	public void setMain(MainClass main) {
		this.main = main;
		// fetch items from the main panel
		ObservableList<Course> courses = main.getCourses();
		if(!courses.isEmpty()) {
			courseTable.setItems(courses);
			courseTable.getSelectionModel().selectFirst();
		}
		else {
			
		}

	}

	private void showCourseDetails(Course c) {

		if (c != null) {

			nameLbl.setText(c.getName());
			yearLbl.setText(c.getYear() + "");
			professorLbl.setText(c.getProfessor());
			markLbl.setText(c.getMark() + "");
			creditsLbl.setText(c.getCredits() + "");
			fieldLbl.setText(c.getField());
			folderLbl.setText(c.getFolder());
			projectLbl.setText(c.getProject());
		} else {

			this.clearText();
		}

	}

	private void clearText() {

		nameLbl.setText("");
		yearLbl.setText("");
		professorLbl.setText("");
		markLbl.setText("");
		creditsLbl.setText("");
		fieldLbl.setText("");
		folderLbl.setText("");
		projectLbl.setText("");

	}

	/**
	 * Deletes the selected course.
	 */
	@FXML
	public void deleteCourse() {
		
		int selected = courseTable.getSelectionModel().getSelectedIndex();
		if(selected >= 0) {
			DialogUtils.showConfirm("MyCourseManager", "Are you sure you want to delete this course?")
			.filter(response -> response == ButtonType.OK)
			.ifPresent(
					response -> courseTable.getItems().remove(selected)
					);
		}
		else {
			
			DialogUtils.showInfo("MyCourseManager", "You did not select any course.");
			
		}
	}
	
	@FXML
	public void openEditPane() {
		
		main.showEditCoursePane();
		
	}

}
