import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MainScreen extends Application {
    
    @FXML
    private Button mainScButtonLogin;

    @FXML
    private Button mainScButtonSearch;

    @FXML
    private Button mainScButtonSignUp;

    @FXML
    private TextField mainScSearchBar;

    @FXML
    private ImageView mainScShortCBorek;

    @FXML
    private ImageView mainScShortCBurger;

    @FXML
    private ImageView mainScShortCChicken;

    @FXML
    private ImageView mainScShortCDoner;

    @FXML
    private ImageView mainScShortCKebap;

    @FXML
    private ImageView mainScShortCPasta;

    @FXML
    private ImageView mainScShortCPizza;

    @FXML
    private ImageView mainScShortCSalad;

    public void start(Stage primaryStage) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ProfileCustomer.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Customer Profile");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}