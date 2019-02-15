package ru.java;
public class TesterCollection {

    public void testCollection(ICollection<String> list) {
        list.add("Sambuca");
        list.add("Abscent");
        list.add("Beer");
        list.add("Strawberry syrup");
        list.add("Croutons");

        System.out.printf("\nInto the list %d items\n", list.getSize());

        list.add("Soda Water");
        list.add("Crush ice");
        list.add("Lime");
        list.add("Rum");
        list.add("Mint");
        list.add("Sugar syrup");
        list.add("Vodka");
        if (list.contains("Mint")) {
            System.out.println("This string contains Mint");
        } else {
            System.out.println("Result not found");
            System.out.printf("\nInto the list %d items\n", list.getSize());
        }
    }
}