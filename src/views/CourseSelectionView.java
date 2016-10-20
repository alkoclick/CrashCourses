package views;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import controllers.CourseManager;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.CourseModel;

public class CourseSelectionView extends Stage {

	private Scene scene;
	private BorderPane mainPane;
	private final static String TITLE = "Available courses:";

	public CourseSelectionView() {
		scene = new Scene(mainPane = mainPane(), 600, 500);
		setScene(scene);
		show();
	}

	private BorderPane mainPane() {
		BorderPane borderPane = new BorderPane();
		Label titleLabel = new Label(TITLE);
		titleLabel.setStyle("-fx-font-size: 200%;");
		borderPane.setTop(titleLabel);
		borderPane.setCenter(contentsPane());
		borderPane.setStyle("-fx-background-color: steelblue;");

		return borderPane;
	}

	private FlowPane contentsPane() {
		FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
		pane.setHgap(5);
		pane.setVgap(5);

		List<Parent> courseViews = new ArrayList<>();
		
		CourseManager.getAllCoursesAndViews().entrySet().forEach(entry -> {
			CourseView courseView = entry.getValue();
			courseView.setBack(mainPane);
			VBox courseViewIcon = entry.getValue().getIconBox();
			courseViewIcon.setOnMouseClicked(mouseClick -> switchToCourseView(courseView));
			courseViews.add(courseViewIcon);
		});
		pane.getChildren().addAll(courseViews);
		pane.setPadding(new Insets(10, 0, 0, 0));

		return pane;
	}

	private void switchToCourseView(CourseView courseView) {
		scene.setRoot(courseView);
	}
}
