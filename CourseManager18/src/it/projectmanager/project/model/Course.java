package it.projectmanager.project.model;

import javafx.beans.property.*;

public class Course {
	
	private final StringProperty name;
	private final IntegerProperty year;
	private final StringProperty professor;
    private final IntegerProperty mark;
    private final IntegerProperty credits;
    private final StringProperty field;
    private final StringProperty folder;
    private final StringProperty project;
    
    
    public Course() {
    	this(null, 0);
    }
    
    
    public Course(String name, int year) {
    	this.name = new SimpleStringProperty(name);
    	this.year = new SimpleIntegerProperty(year);
    	
    	this.professor = new SimpleStringProperty("OL");
    	this.mark = new SimpleIntegerProperty(30);
    	this.credits = new SimpleIntegerProperty(12);
    	this.field = new SimpleStringProperty("Analysis");
    	this.folder = new SimpleStringProperty("/Desktop/Analysis");
    	this.project = new SimpleStringProperty("NO");
    }
    


	public String getName() {
		return name.get();
	}


	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
	}


	public int getYear() {
		return year.get();
	}


	public void setYear(int year) {
		this.year.set(year);
	}
	
	
	public IntegerProperty yearProperty() {
		return year;
	}


	public String getProfessor() {
		return professor.get();
	}


	public void setProfessor(String professor) {
		this.professor.set(professor);
	}
	
	
	public StringProperty professorProperty() {
		return professor;
	}


	public int getMark() {
		return mark.get();
	}


	public void setMark(int mark) {
		this.mark.set(mark);
	}
	
	
	public IntegerProperty markProperty() {
		return mark;
	}


	public int getCredits() {
		return credits.get();
	}


	public void setCredits(int credits) {
		this.credits.set(credits);
	}
	
	
	public IntegerProperty creditsProperty() {
		return credits;
	}


	public String getField() {
		return field.get();
	}


	public void setField(String field) {
		this.field.set(field);
	}
	
	
	public StringProperty fieldProperty() {
		return field;
	}


	public String getFolder() {
		return folder.get();
	}


	public void setFolder(String folder) {
		this.folder.set(folder);
	}
	
	
	public StringProperty folderProperty() {
		return folder;
	}


	public String getProject() {
		return project.get();
	}


	public void setProject(String project) {
		this.project.set(project);
	}
	
	
	public StringProperty projectProperty() {
		return project;
	}
		

}
