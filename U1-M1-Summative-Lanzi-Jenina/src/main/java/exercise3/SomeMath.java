package exercise3;

public class SomeMath {

    // Calculates the total of 5 parameters as an int:
    public static int total5(int a, int b, int c, int d, int e) {
        int result = a+b+c+d+e;
        return result;
    }

    // Calculates the average of 5 parameters as a double:
    public static double average5(int a, int b, int c, int d, int e) {
        double sum = a+b+c+d+e;
        double result = sum/5;
        return result;
    }

    // Calculates the largest double
    public static double largest5(double a, double b, double c, double d, double e) {
        double sum = a+b+c+d+e;
        double result = sum/5;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(total5(1,2,3,4,5));
        System.out.println(average5(1,3,5,7,9));
        System.out.println(largest5(42.0,35.1,2.3,40.2,15.6));
    }
}
