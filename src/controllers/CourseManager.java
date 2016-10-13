package controllers;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.image.Image;
import models.CourseModel;

public class CourseManager {
	private static final int size = 150;
	private static final Logger logger = Logger.getLogger(CourseManager.class.getName());

	public static Set<CourseModel> getAllCourses() {
		Set<CourseModel> allCourses = new HashSet<>();
		try {
			allCourses.add(new CourseModel("Meld Cards", new Image(new File("resource/Brisela.jpg").toURI().toString(), size, size, false, false)));
			allCourses.add(
					new CourseModel("Casting a Spell", new Image(new File("resource/Cryptic.jpg").toURI().toString(), size, size, false, false)));
			allCourses.add(new CourseModel("Layers", new Image(new File("resource/Humility.jpg").toURI().toString(), size, size, false, false)));
			allCourses.add(
					new CourseModel("Triggered Abilities", new Image(new File("resource/Bob.png").toURI().toString(), size, size, false, false)));
			allCourses.add(new CourseModel("Two-Headed Giant",
					new Image(new File("resource/Borborygmos.jpg").toURI().toString(), size, size, false, false)));
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}

		return allCourses;
	}
}
