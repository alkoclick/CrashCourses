package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import models.CourseModel;

public class CourseView extends BorderPane {

	private CourseModel courseModel;
	private Parent back;
	private VBox iconBox;

	private static final Border BORDER = new Border(
			new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(15), BorderWidths.DEFAULT));
	private static final Border HOVER_BORDER = new Border(
			new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, new CornerRadii(15), BorderWidths.DEFAULT));
	private static final int SPACING = 10;
	private static final Insets INSETS = new Insets(5);

	public CourseView(CourseModel courseModel, Parent backParam) {
		this.courseModel = courseModel;
		back = backParam;

		setTop(titleBox());
		setLeft(sideBar());
		setBottom(footer());

		iconBox = createIcon();
		this.setStyle("-fx-background-color: steelblue;");
	}

	public VBox createIcon() {
		VBox iconBox = new VBox();
		ImageView thumbnail = new ImageView(courseModel.getThumbNail());
		iconBox.getChildren().add(thumbnail);
		iconBox.getChildren().add(new Label(courseModel.getName()));

		iconBox.setAlignment(Pos.CENTER);
		iconBox.setBorder(BORDER);
		iconBox.setSpacing(SPACING);
		iconBox.setPadding(INSETS);

		iconBox.setOnMouseEntered(mouseIn -> iconBox.setBorder(HOVER_BORDER));
		iconBox.setOnMouseExited(mouseIn -> iconBox.setBorder(BORDER));

		return iconBox;
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
				mouseClick -> setMainContent(new Label("Well, you can get to work helping even more with this quiz")));
		box.getChildren().addAll(vidLabel, textLabel, test1, test2);
		box.setAlignment(Pos.CENTER);

		return box;
	}

	private Node footer() {
		HBox footerBox = new HBox();
		footerBox.setPadding(new Insets(10));
		footerBox.setAlignment(Pos.CENTER);

		Button backButton = new Button("Back");
		backButton.setOnAction(ae -> {
			this.getScene().setRoot(back);
		});

		footerBox.getChildren().add(backButton);

		return footerBox;
	}

	private void setMainContent(Node newCenter) {
		setCenter(newCenter);
	}

	public VBox getIconBox() {
		return iconBox;
	}

	public void setBack(Parent back) {
		this.back = back;
	}

}
