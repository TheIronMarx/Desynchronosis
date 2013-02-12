package desynchronosis;

import java.util.ArrayList;

/**
 * @author Marx
 */
public class ExitDispatcher {

    int currentRoomRef;
    ArrayList<Exit> exits;

    public ExitDispatcher() {
        currentRoomRef = 0;
        exits = new ArrayList<Exit>(0);


        //(RefID, Name, Where it is, where it leads to)
        exits.add(new Exit(0, "Oak Door", 0, 1)); //exits.get(0).setMnemonic("Door", "OD", ...);
        exits.add(new Exit(1, "Inside", 1, 0));
        exits.add(new Exit(2, "Tree", 1, 2));
        exits.add(new Exit(3, "House", 2, 1));
        exits.add(new Exit(4, "Dirt Path", 1, 3));
        exits.add(new Exit(5, "Dirt Path", 3, 1));
        exits.add(new Exit(6, "Intersection", 3, 4));
        exits.add(new Exit(7, "Intersection", 4, 3));
        exits.add(new Exit(8, "Bakery", 4, 5));
        exits.add(new Exit(9, "Glass Door", 5, 4));
        //(RefID, Name, Where it is, where it leads to, list of times it will appear)
        exits.add(new Exit(1000, "Secret Oven Door", 5, 0, "Midnight"));
    }

    public int getDestination(String exitName, String time) {
        for(int i = 0; i < exits.size(); i++) {
            if(currentRoomRef == exits.get(i).getSource() && exitName.equalsIgnoreCase(exits.get(i).getName()) && exits.get(i).hasSpecial()) {
                if(exits.get(i).isShownAt()) {

                    for(int j = 0; j < exits.get(i).shownAtSize(); j++) {
                        if(time.equalsIgnoreCase(exits.get(i).getShownAtElement(j))) {
                            return exits.get(i).getDestination();
                        }
                    }
                }
            } else if(currentRoomRef == exits.get(i).getSource() && exitName.equalsIgnoreCase(exits.get(i).getName())) {
                return exits.get(i).getDestination();
            }
        }
        return -1;
    }

    public void setCurrentRoom(int newRoomRef) {
        currentRoomRef = newRoomRef;
    }

    public void display(String time) {
        System.out.print("Visible exits: ");
        for(int i = 0; i < exits.size(); i++) {
            if(currentRoomRef == exits.get(i).getSource() && exits.get(i).hasSpecial()) {
                if(exits.get(i).isShownAt()) {
                    for(int j = 0; j < exits.get(i).shownAtSize(); j++) {
                        if(time.equalsIgnoreCase(exits.get(i).getShownAtElement(j))) {
                            System.out.print("[" + exits.get(i).getName() + "] \n");
                        }
                    }

                }
            } else if(currentRoomRef == exits.get(i).getSource()) {
                System.out.print("[" + exits.get(i).getName() + "] \n");
            }
        }
    }
}
