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

public class ProfileOwner extends Application implements Navigable{

    @FXML
    private ImageView profOwnBackButton;

    @FXML
    private Button profOwnChangeAdress;

    @FXML
    private Button profOwnChangeDesc;

    @FXML
    private Button profOwnChangeEmail;

    @FXML
    private Button profOwnChangeMenu;

    @FXML
    private Button profOwnChangeName;

    @FXML
    private Button profOwnChangePhone;

    @FXML
    private Button profOwnChangePic;

    @FXML
    private ImageView profOwnPicture;

    @FXML
    private TextField profOwnTFAdress;

    @FXML
    private TextField profOwnTFDesc;

    @FXML
    private TextField profOwnTFEmail;

    @FXML
    private TextField profOwnTFName;

    @FXML
    private TextField profOwnTFPhone;

    @FXML
    private TextField profOwnTFRating;

    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ProfileOwner.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Owner Profile");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
    }

    //Navigation
    public void navigate() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProfileOwner.fxml"));

        try {
            MealReelApplication.profileOwn = (Parent) fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.profileOwn);
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}
