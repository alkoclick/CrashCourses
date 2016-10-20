package controllers;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.image.Image;
import models.CourseModel;
import views.CourseView;

public class CourseManager {
	private static final int size = 150;
	private static final Logger logger = Logger.getLogger(CourseManager.class.getName());

	public static Map<CourseModel, CourseView> getAllCoursesAndViews() {
		Map<CourseModel, CourseView> allCoursesAndViews = new TreeMap<>();
		try {
			allCoursesAndViews.putAll(createExamples());
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}

		return allCoursesAndViews;
	}

	private static Map<? extends CourseModel, ? extends CourseView> createExamples() {
		Map<CourseModel, CourseView> allCoursesAndViews = new TreeMap<>();
		CourseModel courseModel1 = new CourseModel("Meld Cards",
				new Image(new File("resource/Brisela.jpg").toURI().toString(), size, size, false, false));
		CourseModel courseModel2 = new CourseModel("Casting a Spell",
				new Image(new File("resource/Cryptic.jpg").toURI().toString(), size, size, false, false));
		CourseModel courseModel3 = new CourseModel("Layers",
				new Image(new File("resource/Humility.jpg").toURI().toString(), size, size, false, false));
		CourseModel courseModel4 = new CourseModel("Triggered Abilities",
				new Image(new File("resource/Bob.png").toURI().toString(), size, size, false, false));
		CourseModel courseModel5 = new CourseModel("Two-Headed Giant",
				new Image(new File("resource/Borborygmos.jpg").toURI().toString(), size, size, false, false));

		allCoursesAndViews.put(courseModel1, new CourseView(courseModel1, null));
		allCoursesAndViews.put(courseModel2, new CourseView(courseModel2, null));
		allCoursesAndViews.put(courseModel3, new CourseView(courseModel3, null));
		allCoursesAndViews.put(courseModel4, new CourseView(courseModel4, null));
		allCoursesAndViews.put(courseModel5, new CourseView(courseModel5, null));
		
		return allCoursesAndViews;
	}
}
