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

public class ProfileCustomer extends Application {

    @FXML
    private ImageView profCusBackButton;

    @FXML
    private Button profCusChangeAdress;

    @FXML
    private Button profCusChangeEmail;

    @FXML
    private Button profCusChangeName;

    @FXML
    private Button profCusChangePhone;

    @FXML
    private Button profCusChangePic;

    @FXML
    private ImageView profCusPicture;

    @FXML
    private Button profCusRevHistory;

    @FXML
    private TextField profCusTFAdress;

    @FXML
    private TextField profCusTFEmail;

    @FXML
    private TextField profCusTFName;

    @FXML
    private TextField profCusTFPhone;

    @FXML
    private TextField profCusTFRecComment;

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