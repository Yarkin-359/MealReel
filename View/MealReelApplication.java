import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

        //prevents the user from exiting the fullscreen by hitting the escape button
       defaultScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)) {
                    MealReelApplication.stage.setFullScreen(true);    
                } 
            }
            
        });

        LoginChoice loginChoice = new LoginChoice();
        loginChoice.navigate();

        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
