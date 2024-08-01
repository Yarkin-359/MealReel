import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SearchPage implements Navigable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    RestaurantFilter restaurantFilter = new RestaurantFilter();
    public static int index;
    public static int pageNumber = 0;
    public boolean sortByAlphabeticalOrder = false;
    public boolean sortByPopularity = false;
    public boolean sortByRating = false;
    public boolean sortByTotalDiscountOfItems = false;
    public boolean lower = false;
    public boolean upper = false;
    public double lowerBounds = 0;
    public double upperBounds = Double.MAX_VALUE;


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
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private RadioButton radioButton3;
    @FXML
    private RadioButton radioButton4;

    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private TextField textField6;
    @FXML
    private TextField textField7;

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

    public void radioButton1(ActionEvent event)
    {
        sortByAlphabeticalOrder = true;
        sortByPopularity = false;
        sortByRating = false;
        sortByTotalDiscountOfItems = false;

        radioButton1.setSelected(sortByAlphabeticalOrder);
        radioButton2.setSelected(sortByPopularity);
        radioButton3.setSelected(sortByRating);
        radioButton4.setSelected(sortByTotalDiscountOfItems);

        restaurantFilter.sortByAlphabeticalOrderOfRestaurantName();
    }
    public void radioButton2(ActionEvent event)
    {
        sortByAlphabeticalOrder = false;
        sortByPopularity = true;
        sortByRating = false;
        sortByTotalDiscountOfItems = false;

        radioButton1.setSelected(sortByAlphabeticalOrder);
        radioButton2.setSelected(sortByPopularity);
        radioButton3.setSelected(sortByRating);
        radioButton4.setSelected(sortByTotalDiscountOfItems);

        restaurantFilter.sortByPopularity();
    }
    public void radioButton3(ActionEvent event)
    {
        sortByAlphabeticalOrder = false;
        sortByPopularity = false;
        sortByRating = true;
        sortByTotalDiscountOfItems = false;

        radioButton1.setSelected(sortByAlphabeticalOrder);
        radioButton2.setSelected(sortByPopularity);
        radioButton3.setSelected(sortByRating);
        radioButton4.setSelected(sortByTotalDiscountOfItems);

        restaurantFilter.sortByRating();
    }
    public void radioButton4(ActionEvent event)
    {
        sortByAlphabeticalOrder = false;
        sortByPopularity = false;
        sortByRating = false;
        sortByTotalDiscountOfItems = true;

        radioButton1.setSelected(sortByAlphabeticalOrder);
        radioButton2.setSelected(sortByPopularity);
        radioButton3.setSelected(sortByRating);
        radioButton4.setSelected(sortByTotalDiscountOfItems);

        restaurantFilter.sortByTotalDiscountOfItems();
    }

    public void textFile1(ActionEvent event)
    {
        restaurantFilter.includesGivenItem(textField1.getText());
    }
    public void textFile2(ActionEvent event)
    {
        restaurantFilter.includesGivenItem(textField2.getText());
    }
    public void textFile3(ActionEvent event)
    {
        restaurantFilter.includesGivenItem(textField3.getText());
    }
    public void textFile4(ActionEvent event)
    {
        restaurantFilter.includesGivenItem(textField4.getText());
    }
    public void textFile5(ActionEvent event)
    {
        restaurantFilter.includesGivenItem(textField5.getText());
    }
    public void textFile6(ActionEvent event)
    {

        lowerBounds = Double.parseDouble(textField1.getText());

        restaurantFilter.includesItemsBetweenSetPriceRange(lowerBounds, Double.parseDouble(textField1.getText()));
    }
    public void textFile7(ActionEvent event)
    {
        upperBounds = Double.parseDouble(textField7.getText());

        restaurantFilter.includesItemsBetweenSetPriceRange(Double.parseDouble(textField7.getText()), upperBounds);
    }



    @Override
    public void navigate() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchPage.fxml"));
        
        try {
            MealReelApplication.searchPage = (Parent) fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MealReelApplication.stage.getScene().setRoot(MealReelApplication.searchPage);
    }
}
