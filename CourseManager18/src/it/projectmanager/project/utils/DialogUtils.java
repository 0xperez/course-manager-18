package it.projectmanager.project.utils;

import java.util.Optional;

import it.projectmanager.project.model.Course;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.ButtonType;


/**
 * Utility class used to display predefined dialogs.<br>The methods of this class show a blocking dialog with the required parameters and return an Optional object containing the
 * selection made.
 * This value can be polled and used to define the subsequent action, depending by the result of the selection in the dialog.
 * <p><b>Note:</b> the task of this class is to construct and show a dialog. Polling the result and take a subsequent action is 
 * a responsibility of the caller class. This has be done to reduce coupling between this class and its callers.
 * @author Davide Perez
 *
 */
public class DialogUtils {
	
	public static final String defaultTitle = "MyCourseManager";
	public static final String defaultHeader = null;
	public static final String defaultText = null;
	
	
	public static Optional<ButtonType> showConfirm(String title, String content){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(defaultTitle);
		alert.setHeaderText(defaultHeader);
		alert.setContentText(content);
		return alert.showAndWait();
	}
	
	public static Optional<ButtonType> showWarning(String title, String content){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(defaultTitle);
		alert.setHeaderText(defaultHeader);
		alert.setContentText(content);
		return alert.showAndWait();
	}
	
	public static Optional<ButtonType> showInfo(String title, String content){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(defaultTitle);
		alert.setHeaderText(defaultHeader);
		alert.setContentText(content);
		return alert.showAndWait();
	}
	
	
	public static Optional<ButtonType> showCustom(AlertType type, String title, String header, String content){
		Alert alert = new Alert(type);
		alert.setTitle(defaultTitle);
		alert.setHeaderText(header);
		alert.setContentText(content);
		return alert.showAndWait();
	}
	
	
	

}
