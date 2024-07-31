import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class FilterScreen {
    VBox root;

    public FilterScreen() {
        //Restaurant Filter object
        RestaurantFilter restaurantFilter = new RestaurantFilter();

        //the layout of the stage is created
        root = new VBox(30);
        root.setAlignment(Pos.CENTER);

        //Toggle group object
        ToggleGroup toggleGroup = new ToggleGroup();

        //Radio button objects
        RadioButton sortByAlphabeticalOrder = createSortButton("Sort by alphabetical order");
        RadioButton sortByRating = createSortButton("Sort rating");
        RadioButton sortByPopularity = createSortButton("Sort popularity");
        RadioButton sortByTotalDiscountOfItems = createSortButton("Sort by total discounts of items");

        //the created radio buttons are sorted into a toggle group so that only one of them can be selected
        sortByAlphabeticalOrder.setToggleGroup(toggleGroup);
        sortByRating.setToggleGroup(toggleGroup);
        sortByPopularity.setToggleGroup(toggleGroup);
        sortByTotalDiscountOfItems.setToggleGroup(toggleGroup);

        //Text Field objects
        TextField nameOfItem = createTextField("Enter the name of the item to be searched");
        TextField typeOfItem = createTextField("Enter the type of the item to be searched");
        TextField lowerPriceRange = createTextField("Enter the lower boundary of the price range for the items");
        TextField upperPriceRange = createTextField("Enter the upper boundary of the price range for the items");
        TextField city = createTextField("Enter a city to show the restaurants that can be found in the entered city");
        TextField district = createTextField("Enter a district to show the restaurants that can be found in the entered district");
        TextField street = createTextField("Enter a street to show the restaurants that can be found in the entered street");

        //Button object
        Button applyButton = new Button("Apply");
        applyButton.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        applyButton.setTextFill(Color.WHITE);
        applyButton.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));

        //the apply button manipulates the created Restaurant Filter object according to the selected radio buttons and given information; if the text field is unchanged, the information on that text field is disregarded
        applyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(sortByAlphabeticalOrder.isSelected()) {
                    restaurantFilter.sortByAlphabeticalOrderOfRestaurantName();
                }

                if(sortByPopularity.isSelected()) {
                    restaurantFilter.sortByPopularity();
                }

                if(sortByRating.isSelected()) {
                    restaurantFilter.sortByRating();
                }

                if(sortByTotalDiscountOfItems.isSelected()) {
                    restaurantFilter.sortByTotalDiscountOfItems();
                }

                if(!nameOfItem.getText().equals("Enter the name of the item to be searched")) {
                    restaurantFilter.includesGivenItem(nameOfItem.getText());
                }

                if(!typeOfItem.getText().equals("Enter the type of the item to be searched")) {
                    restaurantFilter.includesGivenItem(typeOfItem.getText());
                }

                if(!city.getText().equals("Enter a city to show the restaurants that can be found in the entered city")) {
                    restaurantFilter.includesGivenItem(city.getText());
                }

                if(!district.getText().equals("Enter a district to show the restaurants that can be found in the entered district")) {
                    restaurantFilter.includesGivenItem(district.getText());
                }

                if(!street.getText().equals("Enter a street to show the restaurants that can be found in the entered street")) {
                    restaurantFilter.includesGivenItem(street.getText());
                }

                if(!lowerPriceRange.getText().equals("Enter the lower boundary of the price range for the items") && !upperPriceRange.getText().equals("Enter the upper boundary of the price range for the items")) {
                    restaurantFilter.includesItemsBetweenSetPriceRange(Double.parseDouble(lowerPriceRange.getText()), Double.parseDouble(upperPriceRange.getText()));
                }

                if(lowerPriceRange.getText().equals("Enter the lower boundary of the price range for the items") && !upperPriceRange.getText().equals("Enter the upper boundary of the price range for the items")) {
                    restaurantFilter.includesItemsBetweenSetPriceRange(0, Double.parseDouble(upperPriceRange.getText()));
                }

                if(!lowerPriceRange.getText().equals("Enter the lower boundary of the price range for the items") && upperPriceRange.getText().equals("Enter the upper boundary of the price range for the items")) {
                    restaurantFilter.includesItemsBetweenSetPriceRange(Double.parseDouble(lowerPriceRange.getText()), Double.MAX_VALUE);
                }

                SearchPage searchPage = new SearchPage();
                searchPage.navigate();
                     
            }   
        });

        //the color of the button's background is changed if the mouse enters the area that this button can be found at
        applyButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                applyButton.setBackground(new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        //the color of the button's background is changed back to its previous color if the mouse exits the area that this button can be found at
        applyButton.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                applyButton.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));   
            }
            
        });

        //Label object
        Label title = new Label("Filter");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 80));
        title.setTextFill(Color.WHITE);
        title.setGraphicTextGap(40);
        
        //Adding the nodes to the root
        root.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(0), new Insets(0))));
        root.getChildren().addAll(title, sortByAlphabeticalOrder, sortByPopularity, sortByRating, sortByTotalDiscountOfItems, nameOfItem, typeOfItem, lowerPriceRange, upperPriceRange, city, district, street ,applyButton);
    }

    //this method creates a textField that includes functionality regarding the movements of the mouse
    public TextField createTextField(String text) {
        //creating the Text Field object with the desired traits
        TextField textField = new TextField(text);
        textField.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        textField.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        textField.setStyle("-fx-text-inner-color: white");
        textField.setAlignment(Pos.CENTER);
        textField.setMaxWidth(1200);

        //if the mouse enters the area, the text field is emptied
        textField.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(textField.getText().equals(text)){
                    textField.setText("");   
                }
            }
            
        });

        //if the mouse exits the area and nothing new is written inside this area, the text field is changed back to the given text
        textField.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(textField.getText().equals("")) {
                    textField.setText(text); 
                } 
            }
            
        });

        return textField;
    }

    //this method creates a radio button that includes the default functionality
    public RadioButton createSortButton(String text) {
        //creating the Radio Button object with the desired traits
        RadioButton sortButton = new RadioButton(text);
        sortButton.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        sortButton.setTextFill(Color.WHITE);
        sortButton.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(30), new Insets(0))));
        sortButton.setMinWidth(650);

        return sortButton;
    }

    //this method is to set the root of the stage to the root created within this particular class
    public void navigate() {
        MealReelApplication.stage.getScene().setRoot(root);
    }
}
