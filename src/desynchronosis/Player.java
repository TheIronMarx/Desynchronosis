package desynchronosis;

/**
 * @author Marx
 */
public class Player {

    String name;

    public Player() {
        name = "nameless";
    }

    public Player(String nameyName) {
        name = nameyName;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }
}
