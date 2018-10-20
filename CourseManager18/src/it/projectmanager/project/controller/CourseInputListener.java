package it.projectmanager.project.controller;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class CourseInputListener implements ChangeListener<String> {
	
	private CourseController controller;
	
	public CourseInputListener(CourseController controller) {
		this.controller = controller;
	}
	
	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		if(!controller.isModified()) {
			controller.setEnabled(true);
			controller.setModified(true);
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

}
