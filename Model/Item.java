public class Item {
    //instance data members
    private String name;
    private String type;
    private double priceWithoutDiscount;
    private double priceWithDiscount;
    private double discountRate;

    //constructor
    public Item(String name, String type, double priceWithoutDiscount) {
        discountRate = 0;
        setName(name);
        setType(type);
        setPriceWithoutDiscount(priceWithoutDiscount);
        setPriceWithDiscount();
    }

    //getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPriceWithoutDiscount() {
        return priceWithoutDiscount;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPriceWithoutDiscount(double priceWithoutDiscount) {
        this.priceWithoutDiscount = priceWithoutDiscount;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void setPriceWithDiscount() {
        this.priceWithDiscount = this.priceWithoutDiscount - this.priceWithoutDiscount * discountRate;
    }

    @Override
    public String toString() {
        return name + "  TL" + priceWithDiscount;
    }
}
