package desynchronosis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marx
 */
public class Exit {
    int referenceNumber;
    String name;
    int sourceRef;
    int destinationRef;
    List<String> shownAt;
    boolean isShownAt;


    public Exit() {
        referenceNumber = -1;
        name = "default";
        sourceRef = -1;
        destinationRef = -1;
        shownAt = new ArrayList<String>(0);
        isShownAt = false;
    }

    public Exit(int exitNumber, String exitName, int exitSource, int exitDestination) {
        referenceNumber = exitNumber;
        name = exitName;
        sourceRef = exitSource;
        destinationRef = exitDestination;
        isShownAt = false;
    }

    public Exit(int exitNumber, String exitName, int exitSource, int exitDestination, String... exitShownAt) {
        referenceNumber = exitNumber;
        name = exitName;
        sourceRef = exitSource;
        destinationRef = exitDestination;
        shownAt = Arrays.asList(exitShownAt);
        isShownAt = true;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public String getName() {
        return name;
    }

    public int getSource() {
        return sourceRef;
    }

    public int getDestination() {
        return destinationRef;
    }

    public boolean hasSpecial() {
        return (isShownAt); //return (isShownAt && isTriggered && et. al)
    }

    public boolean isShownAt() {
        return isShownAt;
    }

    public int shownAtSize() {
        return shownAt.size();
    }

    public String getShownAtElement(int index) {
        return shownAt.get(index);
    }
}