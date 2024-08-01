import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MealReelApplication extends Application {

    public static MongoClient mongoClient;
    public static String uri = "mongodb+srv://aegoksal:886yKSzMTARwXE92@mealreel.jv59fhy.mongodb.net/";// Connection string
    public static Stage stage;
    public static Parent searchPage; //root that holds search page
    public static Parent restaurantPage; //root that holds restaurant page
    public static ListOfUsers listOfUsers  = new ListOfUsers(); //list of users which should be accesible for all pages

    @Override
    public void start(Stage stage) throws Exception {
        VBox defaultRoot = new VBox();
        Scene defaultScene = new Scene(defaultRoot);

        MealReelApplication.stage = stage;
        stage.getIcons().add(new Image("Meal Reel Logo.png"));
        stage.setTitle("Meal Reel");
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.setScene(defaultScene);

        
        LoginChoice loginChoice = new LoginChoice();
        loginChoice.navigate();

        stage.show();
    }
    
    public static void main(String[] args) {
        // Create a new MongoClient
        mongoClient = MongoClients.create(uri);

        // Gets the database
        MongoDatabase  database = mongoClient.getDatabase("user");

        // Gets the collection
        MongoCollection<Document> collection = database.getCollection("restaurantOwners");

        // Creates a new document
        Document doc = new Document("name:", "bilkent").append("Menu", "menu");

        // Inserts the document into the collection
        collection.insertOne(doc);

        launch();
    }     
}
