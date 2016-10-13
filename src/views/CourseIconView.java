package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.CourseModel;

public class CourseIconView extends VBox {
	private CourseModel courseModel;
	private ImageView thumbnail;

	private static final Border BORDER = new Border(
			new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(15), BorderWidths.DEFAULT));
	private static final Border HOVER_BORDER = new Border(
			new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, new CornerRadii(15), BorderWidths.DEFAULT));
	private static final int SPACING = 10;
	private static final Insets INSETS = new Insets(5);

	public CourseIconView(CourseModel courseModel, double width) {
		super();
		this.courseModel = courseModel;
		this.thumbnail = new ImageView(courseModel.getThumbNail());
		getChildren().add(thumbnail);
		getChildren().add(new Label(courseModel.getName()));

		setAlignment(Pos.CENTER);
		setBorder(BORDER);
		setSpacing(SPACING);
		setPadding(INSETS);

		setOnMouseEntered(mouseIn -> setBorder(HOVER_BORDER));
		setOnMouseExited(mouseIn -> setBorder(BORDER));
	}

}
