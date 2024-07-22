import java.util.ArrayList;

public class RestaurantOwner extends User {
    private static final double MAX_RATING = 5;

    //instance data members
    private String restaurantName;
    private Menu menu;
    private double rating;
    private ArrayList<Integer> givenRatings;
    private ArrayList<String> commentsOfRestaurant;

    //constructor
    public RestaurantOwner(String restaurantName, Menu menu, String password, String email, String username, Address address) {
        super(password, email, username, address);
        setRestaurantName(restaurantName);
        setMenu(menu);
        rating = 0;
        givenRatings = new ArrayList<Integer>();
        commentsOfRestaurant = new ArrayList<String>();
    }

    //getters
    public ArrayList<Integer> getGivenRatings() {
        return givenRatings;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Menu getMenu() {
        return menu;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getCommentsOfRestaurant() {
        return commentsOfRestaurant;
    }

    //setters
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    //add a comment to the restaurant given by the customer
    public void addCommentsToRestaurant (String comment) {
        commentsOfRestaurant.add(comment);
    }

    //calculate the rating of the restaurant by getting the average of the ratings given by the customers
    public void calculateRating() {
        double TotalOfRatings;
        double numbersOfRatingsGiven;

        TotalOfRatings = 0;
        numbersOfRatingsGiven = givenRatings.size();

        for(int n = 0; n < numbersOfRatingsGiven; n++) {
            TotalOfRatings += givenRatings.get(n);
        }

        this.rating = TotalOfRatings / numbersOfRatingsGiven; 
    }
    //calculate total amount of discounts of the menu items
    public double calculateTotalDiscounts() {
        double discountSum;
        
        discountSum = 0;

        for(int n = 0; n < menu.getMenuAsArrayList().size(); n++) {
            discountSum += menu.getMenuAsArrayList().get(n).getPriceWithoutDiscount() - menu.getMenuAsArrayList().get(n).getPriceWithDiscount(); 
        }

        return discountSum;
    }

    @Override
    public String toString() {
        return "Restaurant's Name: " + restaurantName + "\n" + super.toString() + "\nRating: " + rating + "/" + MAX_RATING + "\nMenu: " + menu;
    }
} 