import java.util.ArrayList;
import java.util.List;

public class Filter implements Filterable{
    //instance data members
    private boolean isFilteredAtLeastOnce;
    private ArrayList<RestaurantOwner> restaurantOwners;
    private ArrayList<RestaurantOwner> filteredRestaurantOwners;

    //constructor
    public Filter() {
        isFilteredAtLeastOnce = false;
        this.restaurantOwners = new ArrayList<RestaurantOwner>();
        this.filteredRestaurantOwners = new ArrayList<RestaurantOwner>();
    }

    //getters
    public ArrayList<RestaurantOwner> getRestaurants() {
        return restaurantOwners;
    }

    public ArrayList<RestaurantOwner> getFilteredRestaurants() {
        return filteredRestaurantOwners;
    }

    public boolean getIsFilteredAtLeastOnce() {
        return isFilteredAtLeastOnce;
    }

    //setter
    public void setIsFilteredAtLeastOnce(boolean isFilteredAtLeastOnce) {
        this.isFilteredAtLeastOnce = isFilteredAtLeastOnce;
    }

    //add the created restaurant owner to this list so that it can be used for filtering processes
    public void addRestaurants(RestaurantOwner restaurantOwner) {
        restaurantOwners.add(restaurantOwner);
    }

    //reset filter
    public void resetFilter() {
        filteredRestaurantOwners.clear();
    }

    //filters the restaurants in a way that only the restaurants which include the given item type are shown
    @Override
    public void includesGivenItemType(String type) {
        int amountOfItemsInCurrentMenu;
        ArrayList<Item> currentMenuItems;
        boolean isFound;

        //if the filter is not used at least once, all of the currently registered restaurant owners are iterated through and the ones which include the given type in their menu, they are added to the filtered restaurants list
        if(!isFilteredAtLeastOnce) {
            //the first loop iterates through the list of restaurant owners
            for(int n = 0; n < restaurantOwners.size(); n++) {
                isFound = false;
                currentMenuItems = restaurantOwners.get(n).getMenu().getMenuAsArrayList();
                amountOfItemsInCurrentMenu = restaurantOwners.get(n).getMenu().getMenuAsArrayList().size();

                //the second loop checks the menu items of the restaurant owner found by the first loop
                for(int k = 0; k < amountOfItemsInCurrentMenu && !isFound; k++) {
                    if(currentMenuItems.get(k).getType().equalsIgnoreCase(type)) {
                        filteredRestaurantOwners.add(restaurantOwners.get(n));
                        isFound = true;
                    }
                }
            }
        }
        //if the filter is used at least once, the list of filtered restaurants is iterated through and the ones that does not include the given type in their menu are removed from this list.
        else {
            //the first loop iterates through the list of filtered restaurant owners
            for(int n = 0; n < filteredRestaurantOwners.size(); n++) {
                isFound = false;
                currentMenuItems = filteredRestaurantOwners.get(n).getMenu().getMenuAsArrayList();
                amountOfItemsInCurrentMenu = filteredRestaurantOwners.get(n).getMenu().getMenuAsArrayList().size();

                //the second loop checks the menu items of the restaurant owner found by the first loop
                for(int k = 0; k < amountOfItemsInCurrentMenu; k++) {
                    if(currentMenuItems.get(k).getType().equalsIgnoreCase(type)) {
                        isFound = true;
                    }
                }

                //if the given type is not found in anywhere of the menu, this restaurant is removed from the filtered restaurants list
                if(!isFound) {
                    filteredRestaurantOwners.remove(n);
                    n--;
                }
            }    
        }
    }

    //filters the restaurants in a way that only the restaurants which include the given item are shown
    @Override
    public void includesGivenItem(String name) {
        int amountOfItemsInCurrentMenu;
        ArrayList<Item> currentMenuItems;
        boolean isFound;

        //if the filter is not used at least once, all of the currently registered restaurant owners are iterated through and the ones which include the given item in their menu, they are added to the filtered restaurants list
        if(!isFilteredAtLeastOnce) {
            //the first loop iterates through the list of restaurant owners
            for(int n = 0; n < restaurantOwners.size(); n++) {
                isFound = false;
                currentMenuItems = restaurantOwners.get(n).getMenu().getMenuAsArrayList();
                amountOfItemsInCurrentMenu = restaurantOwners.get(n).getMenu().getMenuAsArrayList().size();

                //the second loop checks the menu items of the restaurant owner found by the first loop
                for(int k = 0; k < amountOfItemsInCurrentMenu && !isFound; k++) {
                    if(currentMenuItems.get(k).getName().equalsIgnoreCase(name)) {
                        filteredRestaurantOwners.add(restaurantOwners.get(n));
                        isFound = true;
                    }
                }
            }
        }
        //if the filter is used at least once, the list of filtered restaurants is iterated through and the ones that does not include the given item in their menu are removed from this list.
        else {
            //the first loop iterates through the list of filtered restaurant owners
            for(int n = 0; n < filteredRestaurantOwners.size(); n++) {
                isFound = false;
                currentMenuItems = filteredRestaurantOwners.get(n).getMenu().getMenuAsArrayList();
                amountOfItemsInCurrentMenu = filteredRestaurantOwners.get(n).getMenu().getMenuAsArrayList().size();

                //the second loop checks the menu items of the restaurant owner found by the first loop
                for(int k = 0; k < amountOfItemsInCurrentMenu; k++) {
                    if(currentMenuItems.get(k).getName().equalsIgnoreCase(name)) {
                        isFound = true;
                    }
                }

                //if the given item is not found in anywhere of the menu, this restaurant is removed from the filtered restaurants list
                if(!isFound) {
                    filteredRestaurantOwners.remove(n);
                    n--;
                }
            }    
        }    
    }

    //filters the restaurants in a way that only the restaurants which include the given price range for the items they have are shown
    @Override
    public void includesItemsBetweenSetPriceRange(double min, double max) {
        int amountOfItemsInCurrentMenu;
        ArrayList<Item> currentMenuItems;
        boolean isFound;

        //if the filter is not used at least once, all of the currently registered restaurant owners are iterated through and the ones which include the given price range for their items in their menu, they are added to the filtered restaurants list
        if(!isFilteredAtLeastOnce) {
            //the first loop iterates through the list of restaurant owners
            for(int n = 0; n < restaurantOwners.size(); n++) {
                isFound = false;
                currentMenuItems = restaurantOwners.get(n).getMenu().getMenuAsArrayList();
                amountOfItemsInCurrentMenu = restaurantOwners.get(n).getMenu().getMenuAsArrayList().size();

                //the second loop checks the menu items of the restaurant owner found by the first loop
                for(int k = 0; k < amountOfItemsInCurrentMenu && !isFound; k++) {
                    if(currentMenuItems.get(k).getPriceWithDiscount() <= max && currentMenuItems.get(k).getPriceWithDiscount() >= min) {
                        filteredRestaurantOwners.add(restaurantOwners.get(n));
                        isFound = true;
                    }
                }
            }
        }
        //if the filter is used at least once, the list of filtered restaurants is iterated through and the ones that does not include the given given price range for their items in their menu are removed from this list.
        else {
            //the first loop iterates through the list of filtered restaurant owners
            for(int n = 0; n < filteredRestaurantOwners.size(); n++) {
                isFound = false;
                currentMenuItems = filteredRestaurantOwners.get(n).getMenu().getMenuAsArrayList();
                amountOfItemsInCurrentMenu = filteredRestaurantOwners.get(n).getMenu().getMenuAsArrayList().size();

                //the second loop checks the menu items of the restaurant owner found by the first loop
                for(int k = 0; k < amountOfItemsInCurrentMenu; k++) {
                    if(currentMenuItems.get(k).getPriceWithDiscount() <= max && currentMenuItems.get(k).getPriceWithDiscount() >= min) {
                        isFound = true;
                    }
                }

                //if the given price range for their items is not found in anywhere of the menu, this restaurant is removed from the filtered restaurants list
                if(!isFound) {
                    filteredRestaurantOwners.remove(n);
                    n--;
                }
            }    
        }
    }

    //sorts the restaurants by the alphabetical order according to their name
    @Override
    public void sortByAlphabeticalOrderOfRestaurantName() {
        RestaurantOwner temporary;

        //if the restaurants are not filtered at least once, all of the restaurants are sorted according to the alphabetical order of their names
        if(!isFilteredAtLeastOnce) {
            filteredRestaurantOwners = new ArrayList<RestaurantOwner>(List.copyOf(restaurantOwners));

            //bubble sort algorithm that ends if there is nothing left to swap and sorts according to the alphabetical order of the names of the restaurants
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) {     
                    if(filteredRestaurantOwners.get(j + 1).getRestaurantName().compareTo(filteredRestaurantOwners.get(j).getRestaurantName()) < 0) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            }
        }
        //if the restaurants are filtered at least once, only the filtered restaurants are sorted according to the alphabetical order of their names
        else {
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) {
                    if(filteredRestaurantOwners.get(j + 1).getRestaurantName().compareTo(filteredRestaurantOwners.get(j).getRestaurantName()) < 0) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            } 
        }
    }

    //sorts the restaurants according to their ratings, the rating is done in a way that the restaurants with higher ratings are at the beginning of the list
    @Override
    public void sortByRating() {
        RestaurantOwner temporary;

        //if the restaurants are not filtered at least once, all of the restaurants are sorted according their ratings
        if(!isFilteredAtLeastOnce) {
            filteredRestaurantOwners = new ArrayList<RestaurantOwner>(List.copyOf(restaurantOwners));

            //bubble sort algorithm that ends if there is nothing left to swap and sorts according to the ratings of the restaurants
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) {
                    if(filteredRestaurantOwners.get(j + 1).getRating() > filteredRestaurantOwners.get(j).getRating()) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            }               
        }
        //if the restaurants are filtered at least once, only the filtered restaurants are sorted according to their ratings
        else {
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) {
                    if(filteredRestaurantOwners.get(j + 1).getRating() > filteredRestaurantOwners.get(j).getRating()) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            } 
        }
    }

    //sorts the restaurants according to the amount of ratings they have, he rating is done in a way that the restaurants with more amount of ratings are at the beginning of the list
    @Override
    public void sortByPopularity() {
        RestaurantOwner temporary;

        if(!isFilteredAtLeastOnce) {
            filteredRestaurantOwners = new ArrayList<RestaurantOwner>(List.copyOf(restaurantOwners));

            //bubble sort algorithm that ends if there is nothing left to swap and sorts according to the amount of ratings the restaurants have
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) {
                    if(filteredRestaurantOwners.get(j + 1).getGivenRatings().size() > filteredRestaurantOwners.get(j).getGivenRatings().size()) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            }   
        }
        //if the restaurants are filtered at least once, only the filtered restaurants are sorted according to the amount of ratings the restaurants have
        else {
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) {
                    if(filteredRestaurantOwners.get(j + 1).getGivenRatings().size() > filteredRestaurantOwners.get(j).getGivenRatings().size()) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            } 
        }    
    }

    //sorts the restaurants according the total discount they added for their items
    @Override
    public void sortByTotalDiscountOfItems() {
        RestaurantOwner temporary;

        if(!isFilteredAtLeastOnce) {
            filteredRestaurantOwners = new ArrayList<RestaurantOwner>(List.copyOf(restaurantOwners));

            //bubble sort algorithm that ends if there is nothing left to swap and sorts according to the total discounts their items have
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) {
                    if(filteredRestaurantOwners.get(j + 1).calculateTotalDiscounts() > filteredRestaurantOwners.get(j).calculateTotalDiscounts()) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            }   
        }
        //if the restaurants are filtered at least once, only the filtered restaurants are sorted according to the total discounts their items have
        else {
            for(int n = 0; n < filteredRestaurantOwners.size() - 1; n++) {
                for(int j = 0; j < filteredRestaurantOwners.size() - n - 1; j++) { 
                    if(filteredRestaurantOwners.get(j + 1).calculateTotalDiscounts() > filteredRestaurantOwners.get(j).calculateTotalDiscounts()) {
                        //swapping the found restaurants
                        temporary = filteredRestaurantOwners.get(j);
                        filteredRestaurantOwners.set(j, filteredRestaurantOwners.get(j + 1));
                        filteredRestaurantOwners.set(j + 1, temporary);
                    }
                }
            } 
        }      
    }

    //shows the restaurants that are found in the given city
    @Override
    public void isFoundInGivenCity(String city) {
        boolean isFound;

        //if the filter is not used at all, all of the restaurant owners are checked if they are found in the same city with the given city
        if(!isFilteredAtLeastOnce) {
            for(int n = 0; n < restaurantOwners.size(); n++) {
                if(restaurantOwners.get(n).getAddress().getCityName().equalsIgnoreCase(city)) {
                    filteredRestaurantOwners.add(restaurantOwners.get(n));  
                }
            }      
        }
        //if the filter is used at least once, the restaurants currently found in the filtered restaurants list are checked whether they are found in the same city with the given city 
        else {
            for(int n = 0; n < filteredRestaurantOwners.size(); n++) {
                isFound = false;

                if(filteredRestaurantOwners.get(n).getAddress().getCityName().equalsIgnoreCase(city)) {
                    isFound = true;
                }

                if(!isFound) {
                    filteredRestaurantOwners.remove(n);
                    n--;
                }
            }
        }
    }

    //shows the restaurants that are found in the given district
    @Override
    public void isFoundInGivenDistrict(String district) {
        boolean isFound;

        //if the filter is not used at all, all of the restaurant owners are checked if they are found in the same city with the given district
        if(!isFilteredAtLeastOnce) {
            for(int n = 0; n < restaurantOwners.size(); n++) {
                if(restaurantOwners.get(n).getAddress().getDistrictName().equalsIgnoreCase(district)) {
                    filteredRestaurantOwners.add(restaurantOwners.get(n));  
                }
            }      
        }
        //if the filter is used at least once, the restaurants currently found in the filtered restaurants list are checked whether they are found in the same district with the given district
        else {
            for(int n = 0; n < filteredRestaurantOwners.size(); n++) {
                isFound = false;

                if(filteredRestaurantOwners.get(n).getAddress().getDistrictName().equalsIgnoreCase(district)) {
                    isFound = true;
                }

                if(!isFound) {
                    filteredRestaurantOwners.remove(n);
                    n--;
                }
            }
        }    
    }

    //shows the restaurants that are found in the given street
    @Override
    public void isFoundInGivenStreet(String street) {
        boolean isFound;

        //if the filter is not used at all, all of the restaurant owners are checked if they are found in the same street with the given street
        if(!isFilteredAtLeastOnce) {
            for(int n = 0; n < restaurantOwners.size(); n++) {
                if(restaurantOwners.get(n).getAddress().getStreetName().equalsIgnoreCase(street)) {
                    filteredRestaurantOwners.add(restaurantOwners.get(n));  
                }
            }      
        }
        //if the filter is used at least once, the restaurants currently found in the filtered restaurants list are checked whether they are found in the same street with the given street
        else {
            for(int n = 0; n < filteredRestaurantOwners.size(); n++) {
                isFound = false;

                if(filteredRestaurantOwners.get(n).getAddress().getStreetName().equalsIgnoreCase(street)) {
                    isFound = true;
                }

                if(!isFound) {
                    filteredRestaurantOwners.remove(n);
                    n--;
                }
            }
        }   
    }
}