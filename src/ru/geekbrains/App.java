package ru.geekbrains;

import java.util.Iterator;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) {
        MyArrayList<String> ar = new MyArrayList<String>(10);
        ar.add("aaa");
        ar.add("aab");
        ar.add("aac");
        ar.insert(0,"aa0");
        ar.delete(1);
        for(String t : ar){
            System.out.println(t);
        }

        MyLinkedList<String> list=new MyLinkedList<String>();
        list.add("aaa");
        list.add("aab");
        list.add("aac");
        list.insert(0,"aa0");
        list.delete(1);
        for(String t : list){
            System.out.println(t);
        }
    }
}
