import javafx.application.Application;
import javafx.stage.Stage;
import views.CourseSelectionView;

public class Main extends Application {

	public static Stage primaryStage;

	@Override
	public void start(Stage arg0) throws Exception {
		Main.primaryStage = arg0;
		new CourseSelectionView();
	}

	public static void main(String[] args) {
		launch(Main.class, args);
	}

}
