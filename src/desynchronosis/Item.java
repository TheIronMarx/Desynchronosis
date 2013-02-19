package desynchronosis;

/**
 * @author The Iron Marx
 */
public class Item {
    int referenceNumber;
    int roomLocation;
    String name;
    String moment;

    String desc9am;
    String descNoon;
    String desc3pm;
    String desc6pm;
    String desc9pm;
    String descMidnight;

    boolean isObtainable;

    public Item(int itemReferenceNumber, int itemRoomLocation, String itemName, String itemDesc9am, boolean itemIsMoveable) {
        referenceNumber = itemReferenceNumber;
        roomLocation = itemRoomLocation;
        name = itemName;
        desc9am = itemDesc9am;
        isObtainable = itemIsMoveable;
    }

    public Item(int itemReferenceNumber, int itemRoomLocation, String itemName, String itemDesc9am, String itemDescNoon, String itemDesc3pm, String itemDesc6pm, String itemDesc9pm, String itemDescMidnight) {
        referenceNumber = itemReferenceNumber;
        roomLocation = itemRoomLocation;
        name = itemName;
        desc9am = itemDesc9am;
        descNoon = itemDescNoon;
        desc3pm = itemDesc3pm;
        desc6pm = itemDesc6pm;
        desc9pm = itemDesc9pm;
        descMidnight = itemDescMidnight;
    }
    
    public Item(int itemReferenceNumber, int itemRoomLocation, String, itemMoment, String itemName, String itemDesc9am, String itemDescNoon, String itemDesc3pm, String itemDesc6pm, String itemDesc9pm, String itemDescMidnight) {
        referenceNumber = itemReferenceNumber;
        roomLocation = itemRoomLocation;
        moment = itemMoment;
        name = itemName;
        desc9am = itemDesc9am;
        descNoon = itemDescNoon;
        desc3pm = itemDesc3pm;
        desc6pm = itemDesc6pm;
        desc9pm = itemDesc9pm;
        descMidnight = itemDescMidnight;
    }

    public int getSource() {
        return roomLocation;
    }
    
    public String getMoment() {
        return moment;
    }
    
    public String getName() {
        return name;
    }

    public int getRefID() {
        return referenceNumber;
    }

    public String getDesc() {
        return desc9am;
    }

    public boolean isObtainable() {
        return isObtainable;
    }

    public void obtain() {
        roomLocation = -1;
    }
}
