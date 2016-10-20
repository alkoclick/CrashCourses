package models;

import javafx.scene.image.Image;

public class CourseModel implements Comparable<CourseModel>{
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

	@Override
	public int compareTo(CourseModel otherObject) {
		return this.name.compareTo(otherObject.getName());
	}
}
