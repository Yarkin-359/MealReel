public class test {
    public static void main(String[] args) {
        Filter filter = new Filter();

        Item i1 = new Item("a", "abc", 1);
        Item i9 = new Item("b", "abc", 2);
        Item i2 = new Item("c", "abc", 3);
        Item i4 = new Item("d", "abd", 4);
        Item i7 = new Item("e", "abd", 5);
        Item i6 = new Item("f", "abd", 6);
        Item i5 = new Item("g", "abf", 7);
        Item i3 = new Item("h", "abf", 8);
        Item i8 = new Item("a", "abc", 9);
        Item i10 = new Item("b", "abc", 9);
        Item i11 = new Item("c", "abc", 9);
        Item i12 = new Item("g", "abf", 9);
        Item i13 = new Item("h", "abf", 9);
        Item i14 = new Item("p", "abp", 9);
        Item i15 = new Item("z", "abz", 9);
        Item i16 = new Item("r", "abz", 9);
        
        Menu menu = new Menu();
        menu.addItemToMenu(i1);
        menu.addItemToMenu(i9);
        menu.addItemToMenu(i2);

        Menu menu1 = new Menu();
        menu1.addItemToMenu(i4);
        menu1.addItemToMenu(i7);
        menu1.addItemToMenu(i6);

        Menu menu2 = new Menu();
        menu2.addItemToMenu(i5);
        menu2.addItemToMenu(i3);
        menu2.addItemToMenu(i8);

        Menu menu3 = new Menu();
        menu3.addItemToMenu(i10);
        menu3.addItemToMenu(i11);
        menu3.addItemToMenu(i12);

        Menu menu4 = new Menu();
        menu4.addItemToMenu(i13);
        menu4.addItemToMenu(i14);
        menu4.addItemToMenu(i15);

        Menu menu5 = new Menu();
        menu5.addItemToMenu(i16);
        menu5.addItemToMenu(i3);
        menu5.addItemToMenu(i8);

        Menu menu6 = new Menu();
        menu6.addItemToMenu(i1);
        menu6.addItemToMenu(i4);
        menu6.addItemToMenu(i12);


        

        //menu.sortItemsByType();

        //System.out.println(menu);

        Address a = new Address("Çukurambar", "Çankaya", "Ankara");
        Address a1 = new Address("Oran", "Çankaya", "Ankara");
        Address a2 = new Address("Birlik", "Esenler", "Istanbul");
        Address a3 = new Address("Akatlar", "Beşiktaş", "İstanbul");
        Address a4 = new Address("Topaklı", "Gölbaşı", "Ankara");
        Address a5 = new Address("Çayyolu", "Çankaya", "Ankara");
        RestaurantOwner r = new RestaurantOwner("name", menu, null, "email", null, a);
        RestaurantOwner r1 = new RestaurantOwner("name1", menu1, null, "email", null, a1);
        RestaurantOwner r2 = new RestaurantOwner("name2", menu2, null, "email", null, a2);
        RestaurantOwner r3 = new RestaurantOwner("name3", menu4, null, "email", null, a3);
        RestaurantOwner r4 = new RestaurantOwner("name4", menu5, null, "email", null, a4);
        RestaurantOwner r5 = new RestaurantOwner("name5", menu6, null, "email", null, a5);

        r.setRating(1);
        r1.setRating(4);
        r2.setRating(5);
        r3.setRating(3);
        r4.setRating(2);
        r5.setRating(1.5);

        filter.addRestaurants(r);
        filter.addRestaurants(r4);
        filter.addRestaurants(r3);
        filter.addRestaurants(r2);
        filter.addRestaurants(r5);
        filter.addRestaurants(r1);

        filter.sortByRating();
        filter.setIsFilteredAtLeastOnce(true);
        filter.includesItemsBetweenSetPriceRange(2,5);
        filter.isFoundInGivenStreet("Çukurambar");

        
        System.out.println(filter.getRestaurants());
        System.out.println();
        System.out.println(filter.getFilteredRestaurants());

        //filter.includesGivenItemType("abd");
        //System.out.println(filter.getFilteredRestaurants());
        //System.out.println(r);

        //filter.resetFilter();

        //System.out.println();
        /*filter.includesGivenItemType("abc");
        System.out.println(filter.getFilteredRestaurants());
        System.out.println();

        filter.setIsFilteredAtLeastOnce(true);

        filter.includesGivenItemType("abc");
        System.out.println(filter.getFilteredRestaurants());

        Customer c = new Customer("name", "surname", null, "email", null, a);*/
        //System.out.println(c);

        
    }
    
}
