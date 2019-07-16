public class ConverterIf implements Converter {

    // First method.
    public String convertMonth(int monthNumber) {
        String conversion = "";

        // If/else if conditional output:
        if (monthNumber == 1) {
            return conversion = "January";
        } else if (monthNumber == 2) {
            return conversion = "February";
        } else if (monthNumber == 3) {
            return conversion = "March";
        } else if (monthNumber == 4) {
            return conversion = "April";
        } else if (monthNumber == 5) {
            return conversion = "May";
        } else if (monthNumber == 6) {
            return conversion = "June";
        } else if (monthNumber == 7) {
            return conversion = "July";
        } else if (monthNumber == 8) {
            return conversion = "August";
        } else if (monthNumber == 9) {
            return conversion = "September";
        } else if (monthNumber == 10) {
            return conversion = "October";
        } else if (monthNumber == 11) {
            return conversion = "November";
        } else if (monthNumber == 12) {
            return conversion = "December";
        } else {
            return conversion = "You have entered an invalid number. \n" +
                    "You must enter a number between 1 and 12. Goodbye.";
        }
    }

    // Second method.
    public String convertDay(int dayNumber) {
        String conversion;

        // Switch conditional output
        switch (dayNumber) {
            case 1:
                conversion = "Sunday";
                break;
            case 2:
                conversion = "Monday";
                break;
            case 3:
                conversion = "Tuesday";
                break;
            case 4:
                conversion = "Wednesday";
                break;
            case 5:
                conversion = "Thursday";
                break;
            case 6:
                conversion = "Friday";
                break;
            case 7:
                conversion = "Saturday";
                break;
            default:
                conversion = "You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.";
        }

        return conversion;
    }
}
