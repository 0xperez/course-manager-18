package it.projectmanager.project;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import it.projectmanager.project.controller.*;
import it.projectmanager.project.model.*;

public class MainClass extends Application {
	
	private Stage primaryStage;
	private BorderPane rootPane;
	
	private ObservableList<Course> courses = FXCollections.observableArrayList();

	
	
	public MainClass() {
		courses.add(new Course("Analysis", 1));
		courses.add(new Course("Data Structures", 1));
		courses.add(new Course("Introduction to Programming", 1));
		courses.add(new Course("Architecture of Digital Systems", 1));
		courses.add(new Course("English", 1));
		courses.add(new Course("German", 1));
	
	}
	
	
	public ObservableList<Course> getCourses(){
		return courses;
	}
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MyCourseManager");
		this.loadRootPane();
		this.showCoursePane();
		
	}
	
	/**
	 * Loads the main layout.
	 */
	public void loadRootPane() {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/MainPane.fxml"));
		try {
			rootPane = loader.load();
			primaryStage.setScene(new Scene(rootPane));
			primaryStage.show();
		} catch (IOException e) {
			System.err.println("Exception while loading root pane.");
			e.printStackTrace();
		}
	}
	
	//TODO do something about this class' logic.
	//Same method is repeated multiple times with slight changes each time I have to load a panel.
	//Maybe a more generic Loader class would be better, leaving only the main stage here.
	public void showCoursePane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/CoursePane.fxml"));
		AnchorPane coursePane = null;
		try {
			coursePane = (AnchorPane) loader.load();
			rootPane.setCenter(coursePane);
			
			CoursePaneController controller = loader.getController();
			controller.setMain(this);
		} catch (IOException e) {
			System.err.println("Exception while loading course pane.");
			e.printStackTrace();
		}
	}
	
	
	public void showEditCoursePane(Course c) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/CourseEditPane.fxml"));
		AnchorPane courseEditPane = null;
		try {
			courseEditPane = (AnchorPane) loader.load();
			rootPane.setCenter(courseEditPane);
			CourseEditController controller = loader.getController();
			controller.setMain(this);
			controller.setCourse(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
