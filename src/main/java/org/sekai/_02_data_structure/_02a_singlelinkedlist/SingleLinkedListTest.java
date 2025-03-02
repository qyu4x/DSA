package org.sekai._02_data_structure._02a_singlelinkedlist;

public class SingleLinkedListTest {
    public static void main(String[] args) {

        SingleLinkedList<String> history = new SingleLinkedList<>();
        history.add("kaguya shinomiya");
        history.insertAt(0, "Kato Megumi");
        history.insertAt(1, "Chono Hina");
        history.addLast("Chinatsu");
        history.removeFirst();

        //history.removeAt(2);

        for (String data : history) {
            System.out.println(data);
        }

    }
}
