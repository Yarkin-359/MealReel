import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class LoginChoice implements Navigatable {
    VBox root;

    public LoginChoice() {
        root = new VBox(30);
        root.setAlignment(Pos.CENTER);

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {

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

        Button button1 = new Button("Login as customer");
        button1.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 70));
        button1.setTextFill(Color.WHITE);
        button1.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        button1.setMinWidth(1000);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginAsCustomer loginAsCustomer = new LoginAsCustomer();
                loginAsCustomer.navigate();        
            }   
        });

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

        Button button2 = new Button("Login as restaurant owner");
        button2.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 70));
        button2.setTextFill(Color.WHITE);
        button2.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        button2.setMinWidth(1000);

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginAsRestaurantOwner loginAsRestaurantOwner = new LoginAsRestaurantOwner();
                loginAsRestaurantOwner.navigate();         
            }   
        });

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

        Button button3 = new Button("You haven't signed up yet?");
        button3.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        button3.setTextFill(Color.WHITE);
        button3.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        button3.setMinWidth(550);

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
        Label empty3 = new Label();

        Label title = new Label("Welcome to Meal Reel", view);
        title.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 140));
        title.setTextFill(Color.WHITE);
        title.setGraphicTextGap(40);
        

        root.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(0), new Insets(0))));
        root.getChildren().addAll(title, empty1, empty2, empty3, button1, button2, button3, button4);
    }

    public void navigate() {
        MealReelApplication.stage.getScene().setRoot(root);
    }
}
