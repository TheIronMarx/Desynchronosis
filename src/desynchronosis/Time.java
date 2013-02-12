package desynchronosis;

/**
 * @author The Iron Marx
 */
public class Time {
    static String hour; // Can be "9am" "noon" "3pm" "6pm" "9pm" "midnight"    This should also allow for special cases of time for special events and places


    public Time() {
        hour = "9am";
    }

    public String getTime() {
        return hour;
    }

    public void setTime(String newHour) {
        if(newHour.equalsIgnoreCase("9am")) {
            hour = "9am";
        } else if(newHour.equalsIgnoreCase("noon")) {
            hour = "noon";
        } else if(newHour.equalsIgnoreCase("3pm")) {
            hour = "3pm";
        } else if(newHour.equalsIgnoreCase("6pm")) {
            hour = "6pm";
        } else if(newHour.equalsIgnoreCase("9pm")) {
            hour = "9pm";
        } else if(newHour.equalsIgnoreCase("midnight")) {
            hour = "midnight";
        } else {
            System.out.println("Something went wrong with changing time, time not changed.");
        }
    }

    public void display() {
        System.out.print("\nThe time is currently [" + hour + "]");
    }
}
