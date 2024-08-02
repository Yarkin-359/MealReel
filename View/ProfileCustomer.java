import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProfileCustomer extends Application implements Navigable{

    @FXML
    private ImageView profCusBackButton;
    private Image backButton = new Image("backButton.png");

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
    private Image profilePic = new Image("defaultProfPic.png");

    @FXML
    private Button profCusRevHistory;

    @FXML
    public TextField profCusTFAdress;

    @FXML
    public TextField profCusTFEmail;

    @FXML
    public TextField profCusTFName;

    @FXML
    public TextField profCusTFPhone;

    @FXML
    public TextField profCusTFRecComment;

    public void start(Stage primaryStage) {
        //Set ImageView pictures
        //profCusPicture.setImage(profilePic);
        //profCusBackButton.setImage(backButton);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("ProfileCustomer.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Customer Profile");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
    }

    //Navigation
    public void navigate() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProfileCustomer.fxml"));

        try {
            MealReelApplication.profileCus = (Parent) fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.profileCus);
    }
 
    public static void main(String[] args) {
        launch(args);
    }


}