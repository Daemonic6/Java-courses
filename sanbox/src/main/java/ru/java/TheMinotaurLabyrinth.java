import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TheMinotaurLabyrinth {
    static List descriptions = new ArrayList<String>();
    static Scanner scan = new Scanner(System.in);
    static int hp = 5;
    static int roomCounter;

    public static void main(String[] args) {
        descriptions.add("A gloomy dungeon, a bare brick wall, a collapsed ceiling, several doors leading in different directions");
        descriptions.add("Apparently this is the former armory. But everything has long been rusted and covered with dust.");
        descriptions.add("It looks like something was stored here, wooden shelves, bags");
        descriptions.add("Everything is cobweb, i'd rather get out into another room");
        descriptions.add("Bare stone walls, it seems there is nothing");
        descriptions.add("Remains of furniture prompted the idea that there once was a wedge");
        descriptions.add("The usual room is four meters by four");
        descriptions.add("This room is bigger than usual, but there’s nothing in it");
        descriptions.add("In addition to the skeleton on the floor nothing interesting");
        descriptions.add("A long corridor at the end of which doors can be seen");
        descriptions.add("Looks like a guard room, several beds and a broken cauldron in the corner.");
        descriptions.add("Regular room, bare walls and stone underfoot");

        String[] roomDescr = {"There is nothing in the room", "You have found a health potion", "You have met a monster"};
        int[] roomModificator = {0, 2, -2};

        boolean gameend = true;
        while (gameend) {
            System.out.println("In front of you are few doors: w / s / a / d / end");
            String input = scan.nextLine();
            if (input.equals("w")) {
                System.out.println("You heading north");
            } else if (input.equals("s")) {
                System.out.println("You heading south");
            } else if (input.equals("a")) {
                System.out.println("You heading west");
            } else if (input.equals("d")) {
                System.out.println("You heading east");
            } else if (input.equals("end")) {
                System.out.println("You decided to run away.GAME OVER");
                break;
            }
            roomCounter++;
            System.out.println(descriptions.get((int) (Math.random() * descriptions.size())));

            int r = (int) (Math.random() * 3);
            hp = hp + roomModificator[r];
            System.out.println(roomDescr[r]);
            System.out.println(roomModificator[r]);
            System.out.println("Passed rooms: " + roomCounter);
            System.out.println("Your health is : " + hp);

            gameend = (roomCounter < 10 && hp > 0);

            if (roomCounter == 10) {
                System.out.println("Congrats exile, you past you trial!");
            } else if (hp < 0) {
                System.out.println("Exile have fallen!");
            }
        }
    }
}