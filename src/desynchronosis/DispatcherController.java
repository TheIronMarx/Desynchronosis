package desynchronosis;

public class DispatcherController {

    Time time;

    ExitDispatcher exits;
    RoomDispatcher rooms;
    ItemDispatcher items;

    public DispatcherController() {
        time = new Time();
        exits = new ExitDispatcher();
        rooms = new RoomDispatcher();
        items = new ItemDispatcher();
    }

    public boolean isValidExit(String input) {
        if(exits.getDestination(input, time.getTime()) != -1)
            return true;
        else
            return false;
    }

    public boolean isValidItem(String input) {
        if(items.getRefID(input) != -1) {
            System.out.println("DEBUG: This is a valid item.");
            return true;
        } else {
            return false;
        }
    }

    public void inspectItem(String itemName) {
        items.inspectItem(itemName);
    }

    public boolean isItemObtainable(String itemName) {
        return items.isObtainable(itemName);
    }

    public void obtainItem(String itemName) {
        items.obtainItem(itemName);
    }

    public void setCurrentRoom(String input) {
        //I encountered a problem where the order here was rooms, exits, THEN items.
        //I imagine the problem was a side effect from the (change to) ExitDispatcher, then subsequent calls to it
        //caused the side effect. For now it's a fix, but this must be made more elegant
        //@todo Fix side effects from the exitDispatcher call
        rooms.setCurrentRoom(exits.getDestination(input, time.getTime()));
        items.setCurrentRoom(exits.getDestination(input, time.getTime()));
        exits.setCurrentRoom(exits.getDestination(input, time.getTime()));
    }

    // This needs to be beautified (the output, not the code)
    public void display() {
        time.display();
        rooms.display(time.getTime());
        exits.display(time.getTime());
        items.display(time.getTime());
    }

    public void displayInventory() {
        items.displayInventory();
    }
}