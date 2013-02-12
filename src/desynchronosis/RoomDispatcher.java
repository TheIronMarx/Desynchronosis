package desynchronosis;

import java.util.ArrayList;

/**
 * @author Marx
 */
public class RoomDispatcher {

    static int currentRoomRef = 0;
    static ArrayList<Room> rooms = new ArrayList<Room>(0);

    public RoomDispatcher() {

        //(RefID, Name, Description)
        rooms.add(new Room(0, "Home",
                /*9am*/"This is home's description for 9am. Yeah, your home's okay, I guess.",
                /*noon*/ "This is home's description at noon. It looks the same, so what?",
                /*3pm*/ "If it's 3pm, then this is home's description. Who cares.",
                /*6pm*/ "It's evening, this is still home's description. Big deal.",
                /*9pm*/ "It's your home, sure, but it's at least dark now. Great.",
                /*midnight*/ "It's midnight at your home. Go to bed."
        ));

        rooms.add(new Room(1, "Outside", "This is outside. It looks kinda nice, I suppose."));
        rooms.add(new Room(2, "Under the tree", "Yep. It's a tree. An apple tree, to be specific."));
        rooms.add(new Room(3, "Path into town", "This dirt path heading north leads into the town."));
        rooms.add(new Room(4, "Wachter Road", "On the south side of town, Wachter Road leads from your home to the bakery, the electronics shop, and other places to visit."));
        rooms.add(new Room(5, "Bakery",
                        "The dark crimson bricks and tinted windows of this\n"
                        + " building eventually lead to a windowed door, which swings open with a jingle\n"
                        + " alerting the bakers inside. The smell of rising breads, cooling pies, and\n"
                        + " other confectioneries tempt the nostrils with their inviting aromas. Pristine\n"
                        + " cakes and donuts line the shelves of the counter, teasing and begging to be purchased."));

    }

    public void setCurrentRoom(int newRoomRef) {
        currentRoomRef = newRoomRef;
    }

    public void display(String time) {
        System.out.println("\n----" + rooms.get(currentRoomRef).getName() + "(#" + rooms.get(currentRoomRef).getReferenceNumber() + ")" + "------------------------------------------");
        System.out.println("    " + rooms.get(currentRoomRef).getDesc(time));
    }
}