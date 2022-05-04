package ua.fan.hw15;


import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- TASK1 ----");
        MyList<String> list = new MyList<>();
        System.out.println("-- ADDING --");
        System.out.println("BEFORE: " + list);
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println("AFTER: " + list);

        System.out.println("-- SEARCHING --");
        System.out.print("'one': ");
        System.out.print(list.getFromLast("one") + " is on index " + list.getIndex() +"\n");
        System.out.print("'first': ");
        System.out.print(list.getFromLast("first")+ " is on index " + list.getIndex() +"\n");

        System.out.println("---- TASK2 ----");
        BoxComparator boxComparator = new BoxComparator();
        TreeSet<Box> treeSetOfBox = new TreeSet<>(boxComparator);
        treeSetOfBox.add(new Box(10));
        treeSetOfBox.add(new Box(15));
        treeSetOfBox.add(new Box(7));
        treeSetOfBox.add(new Box(3));
        treeSetOfBox.add(new Box(5));
        treeSetOfBox.add(new Box(0));

        for (Box b:  treeSetOfBox) {
            System.out.println(b.getVolume());
        }
    }
}