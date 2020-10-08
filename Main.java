package Generics.homework2;

import java.util.ArrayList;

public class Main {
    public static void main(String a[]) {
        // параметризируем класс типом String для ключа и значения
        Box<String, String> sample1 = new Box<>("имя", "Нетология");
        System.out.println(sample1);
        // параметризируем класс типом Integer для ключа и Boolean для значения
        Box<Integer, Boolean> sample2 = new Box<>(1, Boolean.TRUE);
        System.out.println(sample2);

        System.out.println("---------------------");
        // Ошибкой в данном случае является то, что происходит сторгая типизация для объектов,
        // хранящихся в ArrayList (String, Integer), однако далее идет попытка поместить два экземпляра с разными типами данных,
        // которые не соответсвтвуют указнным дженерикам.
        //ArrayList<Box<String, Integer>> list1 = new ArrayList<>();
        //list1.add(sample1);
        //list1.add(sample2);

        // Решением проблемы может стать:
        // 1) Использование сырых типов данных, то есть следующий код:
        //ArrayList<Box> arrayList = new ArrayList<>();
        //arrayList.add(sample1);
        //arrayList.add(sample2);
        // Однако, данный способ не явялется типобезопасным
        // 2) Реализация двух объектов ArrayList для двух экземпляров класса Box,
        // имеющих разные дженерики:
        ArrayList<Box<String, String>> list = new ArrayList<>();
        list.add(sample1);

        ArrayList<Box<Integer, Boolean>> list2 = new ArrayList<>();
        list2.add(sample2);

    }
}
