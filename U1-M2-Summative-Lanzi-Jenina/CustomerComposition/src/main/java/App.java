public class App {
    public static void main(String[] args) {

        // Instance of Customer w/ 2 address instances
        Address bobShipping = new Address();
        bobShipping.setStreet1("PO BOX 231");
        bobShipping.setStreet2(" ");
        bobShipping.setCity("Los Angeles");
        bobShipping.setState("CA");
        bobShipping.setZipcode("90121");

        Address bobHome = new Address();
        bobHome.setStreet1("123 Van Halen Street");
        bobHome.setStreet2("Unit A");
        bobHome.setCity("Van Duys");
        bobHome.setState("CA");
        bobHome.setZipcode("90111");

        Customer bobJones = new Customer("Bob", "Jones", "bjones333@gmail.com", "555-123-3456", bobShipping, bobHome, false);

        // Print to console to see that above worked.
        System.out.println("Name: " + bobJones.getFirstName() + " " + bobJones.getLastName());
        System.out.println("Email address: " + bobJones.getEmail());
        System.out.println("Shipping Address: " + bobJones.getShippingAddress());
        System.out.println("Home Address: " + bobJones.getBillingAddress());
        System.out.println("Is " + bobJones.getFirstName() + " a Rewards Member? " + bobJones.isRewardsMember());

    }
}
