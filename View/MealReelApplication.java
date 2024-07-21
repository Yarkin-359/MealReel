import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MealReelApplication extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        VBox defaultRoot = new VBox();
        Scene defaultScene = new Scene(defaultRoot);

        MealReelApplication.stage = stage;
        stage.getIcons().add(new Image("Meal_Reel.png"));
        stage.setTitle("Meal Reel");
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setScene(defaultScene);

        LoginChoice loginChoice = new LoginChoice();
        loginChoice.navigate();

        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
