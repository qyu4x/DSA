package org.sekai._02_data_structure._02a_singlelinkedlist;

public class DoubleLinkedLIstTest {
    public static void main(String[] args) {

        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add("Kato Megumi");
        doubleLinkedList.add("Hayasaka Ai");
        doubleLinkedList.add("Chono Hina");
        doubleLinkedList.insertFirst("Shiina Mahiru");
        doubleLinkedList.insertBefore("Chono Hina", "Kaguya Shinomiya");
        doubleLinkedList.insertBefore("Shiina Mahiru", "Charlotte");
        doubleLinkedList.insertAfter("Shiina Mahiru", "Miaww");
        doubleLinkedList.insertAfter("Chono Hina", "Miaww");
        doubleLinkedList.insertAfter("Charlotte", "Miaww");

        doubleLinkedList.insertAt(2, "Megumin");
        doubleLinkedList.insertAt(8, "Kurumi");
        doubleLinkedList.insertAt(10, "Kurumi");


        for (String waifu : doubleLinkedList) {
            System.out.println(waifu);
        }

        System.out.println(doubleLinkedList.size());

    }
}
