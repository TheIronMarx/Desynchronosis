package desynchronosis;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Marx
 */
public class InputHandler {

    DispatcherController controller;
    Time time;
    Scanner scan;

    Pattern timePattern;
    Pattern itemLookAtPattern_look;
    Pattern itemLookAtPattern_l;
    Pattern itemObtainPattern_take;
    Pattern itemObtainPattern_get;
    Pattern inventoryPattern;

    public InputHandler() {
        time = new Time();
        controller = new DispatcherController();
        scan = new Scanner(System.in);

        timePattern = Pattern.compile("Time [A-Z 0-9]+", Pattern.CASE_INSENSITIVE);
        itemLookAtPattern_look = Pattern.compile("L(o(o(k)?)?)? [A-Z 0-9]+", Pattern.CASE_INSENSITIVE);
        itemObtainPattern_take = Pattern.compile("T(a(k(e)?)?)? [A-Z 0-9]+", Pattern.CASE_INSENSITIVE);
        itemObtainPattern_get = Pattern.compile("G(e(t)?)? [A-Z 0-9]+", Pattern.CASE_INSENSITIVE);
        inventoryPattern = Pattern.compile("I(n(v(e(n(t(o(r(y)?)?)?)?)?)?)?)?", Pattern.CASE_INSENSITIVE);
    }

    public void nameConfirm(String input) {
    }

    public void displayHome() {
        controller.display();
    }

    //Returns false if input string doesn't match any known command; otherwise returns true
    public boolean listen(String input) {
        if(controller.isValidExit(input)) {
            controller.setCurrentRoom(input);
            controller.display();
            return true;
            
        } else if(controller.isValidItem(input)) {
            return true;
            
        } else if(input.equalsIgnoreCase("Time")) {
            System.out.println("----Time---------------");
            System.out.println("[9am]|[noon]|[3pm]");
            System.out.println("[6pm]|[9pm]|[midnight]");
            System.out.println("You check your watch. What time is it? >");
            time.setTime(scan.nextLine());
            controller.display();
            return true;

        } else if(timePattern.matcher(input).matches()) {
            input = input.substring(input.indexOf(" ")+1);
            time.setTime(input);
            controller.display();
            return true;
            
        } else if(itemLookAtPattern_look.matcher(input).matches()) {
            input = input.substring(input.indexOf(" ")+1);
            if(controller.isValidItem(input)) {
                controller.inspectItem(input);
                return true;
            }
            return false;
            
        } else if(itemObtainPattern_get.matcher(input).matches()) {
        	input = input.substring(input.indexOf(" ")+1);
            if(controller.isValidItem(input)) {
                if(controller.isItemObtainable(input)) {
                controller.obtainItem(input);
                return true;
            }
            System.out.println("Item is unobtainable!");
            return true;
            }
            return false;
            
        } else if(itemObtainPattern_take.matcher(input).matches()) {
        	input = input.substring(input.indexOf(" ")+1);
            if(controller.isValidItem(input)) {
                if(controller.isItemObtainable(input)) {
                    controller.obtainItem(input);
                    return true;
                }
                System.out.println("Item is unobtainable!");
                return true;
            }
            return false;
            
        } else if(input.equalsIgnoreCase("Look") || input.equalsIgnoreCase("L")) {
            controller.display();
            return true;
            
        } else if(input.equals("TERMINATE")) {
            System.exit(0);
            return true;
            
        } else if(inventoryPattern.matcher(input).matches()) {
            controller.displayInventory();
            System.out.println("DEBUG: Inventory accessed.");
            return true;
            
        } else {
            // Serialize unrecognized response to XML/JSON before beta testing
            return false;
        }
        //exitResponder()

        //case to check for item interaction
        //itemResponder()

        //case to check if NPC was interacted with
        //NPCResponder()
    }
}