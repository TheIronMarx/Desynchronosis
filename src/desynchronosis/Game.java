package desynchronosis;

import java.util.Scanner;

/**
 * @author Marx
 */
public class Game {

    Scanner scan = new Scanner(System.in);
    Player player;
    InputHandler input;

    public Game() {
    }

    public void init() {
        System.out.print("Hello, friend. What is your name? >");
        player = new Player(scan.nextLine());
        input = new InputHandler();
        System.out.println(player.getName() + ", is it? That's a nice name.");
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println("DEBUG: Oops, bad things happened. Please let the developer know this has happened.");
            e.printStackTrace();
        }
        System.out.print("Well? Ready to play, " + player.getName() + "? >");
        input.nameConfirm(scan.nextLine());      //Does this really need a call to InputHandler?
        // Add response listener (answer == no) ? ("Really? What's wrong?) : etc)

    }

    public void play() {
        input.displayHome();
        while(true) {
            System.out.println("");
            if(input.listen(scan.nextLine())) {
                System.out.print("Done >");
            } else {
                System.out.println("Wuh?");
            }
        }
    }
}
