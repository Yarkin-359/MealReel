import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainScreen extends Application implements Navigable{
    ProfileCustomer newProfCus = new ProfileCustomer();
    ProfileOwner newProfOwn = new ProfileOwner();
    public static String searchString;
    
    @FXML
    private Button mainScButtonProfile;

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
    private Image borek = new Image("borek.jpg");

    @FXML
    private ImageView mainScShortCBurger;
    private Image burger = new Image("burger.jpg");

    @FXML
    private ImageView mainScShortCChicken;
    private Image chicken = new Image("chicken.jpg");

    @FXML
    private ImageView mainScShortCDoner;
    private Image doner = new Image("doner.jpg");

    @FXML
    private ImageView mainScShortCKebap;
    private Image kebap = new Image("kebap.jpg");

    @FXML
    private ImageView mainScShortCPasta;
    private Image pasta = new Image("pasta.jpg");

    @FXML
    private ImageView mainScShortCPizza;
    private Image pizza = new Image("pizza.jpg");

    @FXML
    private ImageView mainScShortCSalad;
    private Image salad = new Image("salad.jpg");

    public void start(Stage primaryStage) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Main Screen");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }

        //Setting Images
        //mainScShortCBorek.setImage(borek);
        //mainScShortCBurger.setImage(burger);
        //mainScShortCChicken.setImage(chicken);
        //mainScShortCDoner.setImage(doner);
        //mainScShortCKebap.setImage(kebap);
        //mainScShortCPasta.setImage(pasta);
        //mainScShortCPizza.setImage(pizza);
        //mainScShortCSalad.setImage(salad);

        //Login navigation via button.
        mainScButtonLogin = new Button();
        mainScButtonLogin.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event){
                LoginChoice loginChoice = new LoginChoice();
                loginChoice.navigate();
            }
        });

        //Sign Up navigation via button.
        mainScButtonSignUp = new Button();
        mainScButtonSignUp.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event){
                SignUpChoice signUpChoice = new SignUpChoice();
                //signUpChoice.navigate();
            }
        });

        //Profile button
        mainScButtonProfile = new Button();
        mainScButtonProfile.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event){
                if (MealReelApplication.listOfUsers.getUserList().get(MealReelApplication.listOfUsers.getUserList().size() - 1) instanceof Customer) {
                    //Customer newCust = MealReelApplication.listOfUsers.get(MealReelApplication.listOfUsers.size() - 1);
                    
                    //newProfCus.profCusTFName.setText(newProfCus.getCustName());
                    
                    
                } else {
                    
                }
            }
        });

        //Search bar usage
        mainScSearchBar = new TextField();

        mainScButtonSearch = new Button();
        mainScButtonSearch.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event){
                searchString = mainScSearchBar.getText();
                SearchPage searchpage = new SearchPage();
                searchpage.navigate();      
            }
        });

    }

    //Navigate to Login Choice
    public void loginChoiceNav(ActionEvent event){
        LoginChoice loginChoice = new LoginChoice();
        loginChoice.navigate();
        
    }

    //Navigate to Sign Up Choice
    //public void signUpChoiceNav(ActionEvent event){
    //    try 
    //    {
    //        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpChoice.fxml"));
    //        MealReelApplication.signUpChoice = (Parent) fxmlLoader.load();
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    }
    //    MealReelApplication.stage.getScene().setRoot(MealReelApplication.signUpChoice);
    //}

    //Navigate to Profile
    public void profileNav(ActionEvent event){
        System.out.println("Test");
    }


    //Navigation
    public void navigate() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));

        try {
            MealReelApplication.mainScreen = (Parent) fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.mainScreen);
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}