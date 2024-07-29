import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SearchPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    public static int index;
    public static int pageNumber = 0;

    @FXML
    private FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("RestaurantPage.fxml"));

    @FXML 
    private Text text1;
    @FXML 
    private Text text2;
    @FXML 
    private Text text3;
    @FXML 
    private Text text4;

   
    @FXML
    private VBox filter;
    private boolean filterCheck = false;


    @FXML
    void initialize() 
    {      

        System.out.println(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().size());

        if(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().size() > 0)
        {
            text1.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(0 + (4*pageNumber)).getRestaurantName());
            text2.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(1 + (4*pageNumber)).getRestaurantName());
            text3.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(2 + (4*pageNumber)).getRestaurantName());
            text4.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(3 + (4*pageNumber)).getRestaurantName());
        }
    }
        
    public void openPage1(ActionEvent event)
    {
        index = 0;
        try 
        {
            MealReelApplication.restaurantPage = (Parent) fxmlLoader2.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.restaurantPage);
    }
    public void openPage2(ActionEvent event)
    {
        
        index = 1;
        try 
        {
            MealReelApplication.restaurantPage = (Parent) fxmlLoader2.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.restaurantPage);
    }
    public void openPage3(ActionEvent event)
    {
        index = 2;
        try 
        {
            MealReelApplication.restaurantPage = (Parent) fxmlLoader2.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.restaurantPage);
    }
    public void openPage4(ActionEvent event)
    {
        index = 3;
        
        try 
        {
            MealReelApplication.restaurantPage = (Parent) fxmlLoader2.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.restaurantPage);
       
    }

    public void page1(ActionEvent event)
    {
        pageNumber = 0;
        text1.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(0 + (4*pageNumber)).getRestaurantName());
        text2.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(1 + (4*pageNumber)).getRestaurantName());
        text3.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(2 + (4*pageNumber)).getRestaurantName());
        text4.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(3 + (4*pageNumber)).getRestaurantName());
    }
    public void page2(ActionEvent event)
    {
        pageNumber = 1;
        text1.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(0 + (4*pageNumber)).getRestaurantName());
        text2.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(1 + (4*pageNumber)).getRestaurantName());
        text3.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(2 + (4*pageNumber)).getRestaurantName());
        text4.setText(MealReelApplication.listOfUsers.getRestaurantOwnersFromListOfUsers().get(3 + (4*pageNumber)).getRestaurantName());
    }
    public void page3(ActionEvent event)
    {
        pageNumber = 2;
    }
    public void page4(ActionEvent event)
    {
        pageNumber = 3;
    }
    public void page5(ActionEvent event)
    {
        pageNumber = 4;
    }

    public void filter(ActionEvent event)
    {
        filterCheck = !filterCheck;
        filter.setVisible(filterCheck);
    }
}
