package desynchronosis;

/**
 * @author Marx
 * @todo Clean up exits and items display
 * @todo Time dependent items
 * @todo NPC Prototype
 * @todo Item dependent exits (Keys to doors)
 * @todo Events
 * @todo Event dependent items/exits/rooms/NPCs/events
 * @todo Exit/room/item/etc. mnemonics
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Desynchronosis v.0.2.2.0");
        System.out.println("Release notes\n--------------------------------------------");
        System.out.println("v.0.0.1 - Please be gentle with me; I'm new.");
        System.out.println("v.0.0.2 - Added to the map, including the bakery!");
        System.out.println("v.0.0.3 - Implemented rudimentary items. Cake is in the bakery!");
        System.out.println("v.0.1.4.0.alpha - Added new revisioning standard, making the change between this update and the previous update ambiguous. (Or is it?)");
        System.out.println("v.0.2.0.0.alpha - 11/24/2011 - Time has been partially implemented. Hooray! I'll finish time, then work on cleaning up the cosmetic aspects of the game a bit");
        System.out.println("v.0.2.1.0.alpha - 12/8/2011 - Items can now be interacted with, though none do anything yet.");
        System.out.println("v.0.2.2.0.alpha - 1/30/2012 - New kind of exit which will only exist at a certain time. (Time dependency)");
        System.out.println("--------------------------------------------\n");

        game.init();
        game.play();
    }
}


/*
* The last time I programmed...
*
* @8/22/2011 - Still deciding on how to implement time relative to the actors. An idea I had is to have all actors which will be affected
* by time, have a superclass which itself could contain, or grab from time. This might imply that room inherits time? Room is a time? Maybe.
* Good night genius smart guy.
*
* @8/24/2011 - Created ItemDispatcher class, I still need to shell that out and then add it to the DispatcherController's duties, like display().
* I think I've decided to simply create Time as a class and have it work through a hub like the InputHandler or the DispatcherController. Either
* way, I've definitely spent too much time pondering over it. Time for action! Boo-ya!
*
* @8/25/2011 - Still working on ItemDispatcher and its display(). I noticed the display() for exits is in the ExitDispatcher, but the display()
* for rooms is in the Room. That needs to be normalized, probably to the Room or Exit class itself. I also must still implement time to affect
* the rooms, items, eventually player, eventually more.
*
* @8/25/2011 - I did more work on ItemDispatcher, not sure if constructor(s) is(are) finished, but at least it's something.
*
* @8/26/2011 - Worked on implementing item, ItemDispatcher's display() still needs a bit of work, no testing has been done.
*
* @8/26/2011 - I encountered a problem where the order of the setCurrentRoom() calls in the Dispatcher controller was in an order.
* Having anything after the exits.setCurrentRoom() was experiencing side effects. It's fixed for now, but it could be cleaned up.
*
* @11/8/2011 - I finally created Time, but I still have to change the Rooms, Items, and possibly Exits to have different descriptions and
* other characteristics depending on the Time. I need to decide if DispatcherController or each Room, Item, or possibly Exit handle time
* independently. I also need to make an NPC prototype. I must also decide how I want them to interact.
*
* @11/23/2011 - Work on the implementing time has been going well and generally few hurdles. There's one more aspect I need to finalize (for rooms),
* and that's simply to have the descriptions properly show up when a room is entered at a corresponding time. I must also implement time for exits
* and items, I must also have some sort of "look" command.
*
* @11/24/2011 - Time partially implemented, released another version for safety. In the previous LTIP, I mentioned an aspect about finalizing rooms.
* As it turned out, that was a very simple fix that only required one word changed, and one word added. As of now, time is working the way I had hoped,
* however the more difficult work is still ahead.
*
* @1/29/2012 - New kind of exit which will only appear at a certain time. "Appear" isn't quite as accurate as "exist," as exits which don't
* appear can not be used given the heuristic knowledge of where they are. A brilliant idea was given to me by Stink Britches; player
* occupation or other responsibilities.
*
* @1/29/2012 - More functionality was added to the ExitDispatcher. Upon completion, it should be very simple to have
* exits appear only at a given time, e.g. secret oven door is only available at midnight. However, I'm running into some god-awful
* bugs, and I haven't a clue how to debug on this new IDE. Even without debugging, I was unable to figure out why an Exit
* instance is behaving so poorly by having its shownAt ArrayList empty, which it should contain the element "Midnight."
* I suspect side-effects, though I have been making it a point to create none, and have found none so far. Frustrated.
*
* @1/30/2012 - The problem with ExitDispatcher was a matter of ArrayLists being passed by address, as a result subsequent changes
* to the ArrayList resulted in changes to each Exit's shownAt array changing. Fixed by dropping ArrayList and using variable
* arguments. Ah YEAH.
*
* @1/30/2012 - Special exits which are can only be taken at a certain time now only show at a certain time, items can now be
* "look"ed at. Item inspecting still needs some work, the Grandfather Clock at home can't be inspected because it's two words
* in length, this can be fixed with a little bit of tweaking from the split() method called from the exitDispatcher. Bada bing.
*
* @2/3/2012 - I dislike passing item looking and obtain by name. I'd rather do it by refID. That way multiple items of the same
* name can exist, although I don't really like that aesthetically, either. DFWIB. Also, I feel that item validation should only
* occur in the itemDispatcher, rather than a call from inputHandler. It would make InputHandler look a lot cleaner, and
* help encapsulate item functions to item classes. Very nice.
*
*/