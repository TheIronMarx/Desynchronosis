package desynchronosis;

/**
 * @author Marx
 */
public class Room {

    int referenceNumber;
    String name;
    String desc9am;
    String descNoon;
    String desc3pm;
    String desc6pm;
    String desc9pm;
    String descMidnight;

    public Room() {
        referenceNumber = -1;
        name = "default";
        desc9am = "default desc";
    }

    public Room(int roomReferenceNumber, String roomName, String roomDesc9am) {
        referenceNumber = roomReferenceNumber;
        name = roomName;
        desc9am = roomDesc9am;
    }

    public Room(int roomReferenceNumber, String roomName, String roomDesc9am, String roomDescNoon, String roomDesc3pm, String roomDesc6pm, String roomDesc9pm, String roomDescMidnight) {
        referenceNumber = roomReferenceNumber;
        name = roomName;
        desc9am = roomDesc9am;
        descNoon = roomDescNoon;
        desc3pm = roomDesc3pm;
        desc6pm = roomDesc6pm;
        desc9pm = roomDesc9pm;
        descMidnight = roomDescMidnight;
    }

    public String getName() {
        return name;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public String getDesc() {
        return desc9am;
    }

    public String getDesc(String time) {
        if(time.equals("noon"))
            return descNoon;
        else if(time.equals("3pm"))
            return desc3pm;
        else if(time.equals("6pm"))
            return desc6pm;
        else if(time.equals("9pm"))
            return desc9pm;
        else if(time.equals("midnight"))
            return descMidnight;
        else
            return desc9am;
    }
}
