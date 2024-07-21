import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LoginAsRestaurantOwner {
    Scene scene;

    public LoginAsRestaurantOwner() {
        VBox mainRoot = new VBox(30);
        mainRoot.setAlignment(Pos.CENTER);

        scene = new Scene(mainRoot);
        scene.setFill(Color.ORANGE);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)) {
                    MealReelApplication.stage.setFullScreen(true);    
                } 
            }
            
        });

        Image image = new Image("Meal_Reel.png");
        ImageView view = new ImageView(image);
        view.setFitHeight(140);
        view.setPreserveRatio(true);

        TextField usernameOrEmail = new TextField("Enter your username or email");
        usernameOrEmail.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 70));
        usernameOrEmail.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        usernameOrEmail.setStyle("-fx-text-inner-color: white");
        usernameOrEmail.setAlignment(Pos.CENTER);
        usernameOrEmail.setMaxWidth(1000);

        usernameOrEmail.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(usernameOrEmail.getText().equals("Enter your username or email")){
                    usernameOrEmail.setText("");   
                }
            }
            
        });

        usernameOrEmail.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(usernameOrEmail.getText().equals("")) {
                    usernameOrEmail.setText("Enter your username or email"); 
                } 
            }
            
        });

        TextField password = new TextField("Enter your password");
        password.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 70));
        password.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        password.setStyle("-fx-text-inner-color: white");
        password.setAlignment(Pos.CENTER);
        password.setMaxWidth(1000);

        password.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(password.getText().equals("Enter your password")){
                    password.setText("");   
                }
            }
            
        });

        password.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(password.getText().equals("")) {
                    password.setText("Enter your password"); 
                } 
            }
            
        });

        Button button1 = new Button("Login");
        button1.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        button1.setTextFill(Color.WHITE);
        button1.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        button1.setMaxWidth(550);

        button1.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button1.setBackground(new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        button1.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button1.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        Button button2 = new Button("You haven't signed up yet?");
        button2.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        button2.setTextFill(Color.WHITE);
        button2.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        button2.setMaxWidth(550);
        
        button2.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button2.setBackground(new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        button2.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button2.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        Button button3 = new Button("Forgot your password?");
        button3.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        button3.setTextFill(Color.WHITE);
        button3.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        button3.setMaxWidth(550);

        button3.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button3.setBackground(new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        button3.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button3.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        Button button4 = new Button("Exit");
        button4.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        button4.setTextFill(Color.WHITE);
        button4.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        button4.setMinWidth(550);

        button4.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button4.setBackground(new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        button4.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button4.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MealReelApplication.stage.close();   
            }
            
        });

        Label empty1 = new Label();
        Label empty2 = new Label();

        Label title = new Label("Restaurant Owner Login", view);
        title.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 140));
        title.setTextFill(Color.WHITE);
        title.setGraphicTextGap(40);
        

        mainRoot.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(0), new Insets(0))));
        mainRoot.getChildren().addAll(title, empty1, empty2, usernameOrEmail, password, button1, button2, button3, button4);  
    }

    public void open() {
        MealReelApplication.stage.setScene(scene);
        MealReelApplication.stage.setFullScreen(true);
    }
}
