import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MealReelApplication extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        MealReelApplication.stage = stage;
        stage.getIcons().add(new Image("Meal_Reel.png"));
        stage.setTitle("Meal Reel");
        stage.setResizable(false);
        stage.setFullScreen(true);

        LoginChoice loginChoice = new LoginChoice();
        loginChoice.open();

        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
