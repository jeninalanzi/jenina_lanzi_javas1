import java.util.List;

public class FactoryIceCream {

    // Properties of Ice Cream if in a factory setting.
    private String brand;
    private String flavor;
    private double cost;
    private double retailPrice;
    private double totalWeight;
    private String servingSize;
    private int caloriesPerServing;
    private int totalNumberOfServings;
    private List<String> ingredientsList;
    private int fatGrams;
    private int carbGrams;
    private int proteinGrams;

    // Constructors
    public FactoryIceCream(String brand, String flavor, double totalWeight, String servingSize, int caloriesPerServing, int totalNumberOfServings, List<String> ingredientsList, int fatGrams, int carbGrams, int proteinGrams) {
        this.brand = brand;
        this.flavor = flavor;
        this.cost = cost;
        this.retailPrice = retailPrice;
        this.totalWeight = totalWeight;
        this.servingSize = servingSize;
        this.caloriesPerServing = caloriesPerServing;
        this.totalNumberOfServings = totalNumberOfServings;
        this.ingredientsList = ingredientsList;
        this.fatGrams = fatGrams;
        this.carbGrams = carbGrams;
        this.proteinGrams = proteinGrams;
    }

    public FactoryIceCream() {
    }

    // Setters/Getters
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

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public void setCaloriesPerServing(int caloriesPerServing) {
        this.caloriesPerServing = caloriesPerServing;
    }

    public int getTotalNumberOfServings() {
        return totalNumberOfServings;
    }

    public void setTotalNumberOfServings(int totalNumberOfServings) {
        this.totalNumberOfServings = totalNumberOfServings;
    }

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public int getFatGrams() {
        return fatGrams;
    }

    public void setFatGrams(int fatGrams) {
        this.fatGrams = fatGrams;
    }

    public int getCarbGrams() {
        return carbGrams;
    }

    public void setCarbGrams(int carbGrams) {
        this.carbGrams = carbGrams;
    }

    public int getProteinGrams() {
        return proteinGrams;
    }

    public void setProteinGrams(int proteinGrams) {
        this.proteinGrams = proteinGrams;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    // Methods pertaining to this mode of Ice Cream.

    public void printNutritionInfo() {
        System.out.println("Nutrition Data for: " + this.brand + " " + this.flavor + " Ice Cream");
        System.out.println("------------------------------------------------------------");
        System.out.println("Serving Size: " + this.servingSize);
        System.out.println("Calories per serving: " + this.caloriesPerServing);
        System.out.println(" ");
        System.out.println("Protein (g): " + this.proteinGrams);
        System.out.println("Carbohydrates (g): " + this.carbGrams);
        System.out.println("Fat (g): " + this.fatGrams);
    }

    public double calculateProfit() {
        double profit = retailPrice - cost;
        return profit;

    }

    public int totalCaloriesPerUnit() {
        int total = totalNumberOfServings * caloriesPerServing;
        return total;
    }

    public int calculateFatCalPerServing() {
        int calories = fatGrams * 9;
        return calories;
    }

    public int calculateCarbCalPerServing() {
        int calories = carbGrams * 4;
        return calories;
    }

    public int calculateProteinCalPerServing() {
        int calories = proteinGrams * 4;
        return calories;
    }

}
