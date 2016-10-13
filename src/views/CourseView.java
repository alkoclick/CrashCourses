package views;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import models.CourseModel;

public class CourseView extends BorderPane {

	private CourseModel courseModel;

	public CourseView(CourseModel courseModel) {
		this.courseModel = courseModel;
		setTop(titleBox());
		setLeft(sideBar());
		this.setStyle("-fx-background-color: steelblue;");
	}

	private VBox titleBox() {
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		Label titleLabel = new Label(courseModel.getName());
		titleLabel.setStyle("-fx-font-size: 200%;");

		box.getChildren().add(titleLabel);
		return box;
	}

	private VBox sideBar() {
		VBox box = new VBox(10);
		Label vidLabel = new Label("Sample video");
		vidLabel.setOnMouseClicked(mouseClick -> {
			WebView webView = new WebView();
			webView.getEngine().load("http://www.youtube.com/embed/9bZkp7q19f0");
			setMainContent(webView);
		});
		Label textLabel = new Label("Read the comp");
		textLabel.setOnMouseClicked(
				mouseClick -> setMainContent(new TextArea("This will be a copy/paste of the rules")));
		Label test1 = new Label("Easy Test");
		test1.setOnMouseClicked(
				mouseClick -> setMainContent(new Label("Well, you can get to work helping with this quiz")));
		Label test2 = new Label("Exhaustive Test");
		test2.setOnMouseClicked(
				mouseClick -> setMainContent(new Label("Well, you can get to work helping with this quiz")));
		box.getChildren().addAll(vidLabel, textLabel, test1, test2);
		box.setAlignment(Pos.CENTER);

		return box;
	}

	private void setMainContent(Node newCenter) {
		setCenter(newCenter);
	}

}
