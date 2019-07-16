import java.util.List;

public class ShopIceCream {

    // Properties of ice cream as it would be modeled in the
    // point-of-sale system in an ice cream shop.
    private String brand;
    private String flavor;
    private double price;;
    private int caloriesPerCup;
    private int caloriesPerBowl;
    private List<String> allergens;
    private int productId;


    // Constructors!
    public ShopIceCream(String brand, String flavor, double price, int caloriesPerCup, int caloriesPerBowl, List<String> allergens, int productId) {
        this.brand = brand;
        this.flavor = flavor;
        this.price = price;
        this.caloriesPerCup = caloriesPerCup;
        this.caloriesPerBowl = caloriesPerBowl;
        this.allergens = allergens;
        this.productId = productId;
    }

    public ShopIceCream() {
    }


    // Getters/Setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCaloriesPerCup() {
        return caloriesPerCup;
    }

    public void setCaloriesPerCup(int caloriesPerCup) {
        this.caloriesPerCup = caloriesPerCup;
    }

    public int getCaloriesPerBowl() {
        return caloriesPerBowl;
    }

    public void setCaloriesPerBowl(int caloriesPerBowl) {
        this.caloriesPerBowl = caloriesPerBowl;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    // Methods pertaining to Ice Cream as a shop item in a POS system.

    public String purchase(double cashTendered) {
        String clerkMessage;

        if (this.getPrice() > cashTendered) {
            return clerkMessage = "Sorry, you don't have enough money to purchase this!";
        } else {
            this.giveChange(cashTendered);
            return clerkMessage = "Thanks for buying! Come again.";
        }
    }

    public double giveChange(double cashTendered) {
        double result = cashTendered - this.getPrice();
        String clerkMessage;

        if (result == 0) {
            System.out.println("You gave exact change! Thank you.");
            result = 0;
        }

        return result;
    }

    public void listStatsPerItem() {
        System.out.println("Product ID: " + this.getProductId());
        System.out.println("Brand: " + this.getBrand());
        System.out.println("Flavor: " + this.getFlavor());
        System.out.println("Price: $" + this.getPrice());
        System.out.println("Allergens, if any: " + this.getAllergens());;
    }

    public void CupOrBowl() {
        // Display calories for Cup and Bowl to give user options:
        System.out.println("Calories per Cup (4oz): " + this.getCaloriesPerCup());
        System.out.println("Calories per Bowl (8oz): " + this.getCaloriesPerBowl());
    }
}
