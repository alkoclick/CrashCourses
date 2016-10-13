package models;

import javafx.scene.image.Image;

public class CourseModel {
	private String name;
	private Image thumbNail;

	public CourseModel(String name, Image thumbNail) {
		super();
		this.name = name;
		this.thumbNail = thumbNail;
	}

	public String getName() {
		return name;
	}

	public Image getThumbNail() {
		return thumbNail;
	}
}
