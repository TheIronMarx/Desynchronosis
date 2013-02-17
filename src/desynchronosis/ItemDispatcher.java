package desynchronosis;

import java.util.ArrayList;

/**
 * @author The Iron Marx
 */
public class ItemDispatcher {
    int currentRoomRef;
    ArrayList<Item> items;
    //ArrayList<Item> inventory;

    public ItemDispatcher() {
        currentRoomRef = 0;
        items = new ArrayList<Item>(0);
        //inventory = new ArrayList<Item>(0);

        //(RefID, where it is, name, desc, is movable)
        items.add(new Item(0, 5, "Cake", "This is cake's description. Clearly, this must be a string changed based on time.", true));
        items.add(new Item(1, 0, "Grandfather clock", "This is grandfather clock's description. This string must change based on time", false));
        items.add(new Item(1, 2, "A SPACESHIP HAHA", "SPICESHAP FOIR MARSCUS!!", false));

    }

    public void setCurrentRoom(int newRoomRef) {
        currentRoomRef = newRoomRef;
    }

    // Returns the reference number ONLY if the item is in the room currently occupied by the player, so really this method identifier
    public int getRefID(String input) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equalsIgnoreCase(input) && items.get(i).getSource() == currentRoomRef)
                return items.get(i).getRefID();
        }
        return -1;
    }

    public void inspectItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(itemName.equalsIgnoreCase(items.get(i).getName())) {
                System.out.println(items.get(i).getDesc());
            }
        }
    }

    public boolean isObtainable(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(itemName.equalsIgnoreCase(items.get(i).getName())) {
                return items.get(i).isObtainable();
            }
        }
        return false;
    }

    public void obtainItem(String itemName) {
        for(int i = 0; i < items.size(); i++) {
            if(itemName.equalsIgnoreCase(items.get(i).getName())) {
                items.get(i).obtain();
            }
        }
    }

    public void display(String time) {
        System.out.print("Visible items: ");
        for(int i = 0; i < items.size(); i++) {
            if(currentRoomRef == items.get(i).getSource() && items.get(i).getSource() != -1) {
                System.out.print("{" + items.get(i).getName() + "}\n");
            }
        }
    }

    public void displayInventory() {
        for(int i = 0; i <items.size(); i++) {
            if(items.get(i).getSource() == -1)
System.out.println("(" + items.get(i).getName() + ")");
}
        }
        }
