package ru.java;
public class ArrayListTest {
        public static void main(String[] args) {
            TesterCollection tc = new TesterCollection();
            tc.testCollection(new ArrList<>());
            ICollection arr = new ArrList();
            tc.testCollection(arr);
        }
    }