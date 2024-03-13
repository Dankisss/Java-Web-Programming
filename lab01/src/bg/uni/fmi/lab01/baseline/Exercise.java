package bg.uni.fmi.lab01.baseline;

import java.sql.SQLOutput;
import java.util.*;

public class Exercise {
    public static int findElmnt(int[] arr, int ind) throws Exception {
        if (ind >= arr.length) {
            throw new Exception();
        }

        int counter = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] % 2 == 1) {
                counter++;
            }

            if (counter == ind) {
                return arr[i];
            }

            i++;
        }

        return -1;
    }

    public static void task3(List<String> list, String str) {
        if (str == null) {
            throw new NullPointerException();
        }

        list.addFirst(str);
    }

    public static String task4(List<String> list , int ind) {
        if (ind < 0 || ind >= list.size()) {
            throw new IllegalArgumentException();
        }

        return list.get(ind);
    }

    public static void task5(List<String> list) {
        list.remove(2);
    }

    public static String task6(List<String> list, String str) {
        return list.stream().filter(el -> el.equals(str)).findFirst().get();
    }

    public static <T extends Comparable<? super T>> void task7(List<T> list) {
        Collections.sort(list);
    }

    public static <T> void task8(List<T> list, T el) {
        list.remove(1);
        list.add(1,el);
    }

    public static <T, Z> int task9(Map<T, Z> map) {
        return map.entrySet().toArray().length;
    }

    public static void main(String[] args) {
        try {
            System.out.println(findElmnt(new int[]{5, 3, 8, 2, 9}, 4));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        task5(list);
        System.out.println(list);
        //System.out.println(task6(list, "e"));

        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog("dupe", 12));

        dogs.add(new Dog("laino", 10));
        task7(dogs);
        System.out.println(dogs);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
        System.out.println(task9(map));
    }
}
