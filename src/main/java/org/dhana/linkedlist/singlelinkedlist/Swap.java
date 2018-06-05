package org.dhana.linkedlist.singlelinkedlist;

import java.util.Arrays;

public class Swap {
    public <T> GenericLinkedList<T> swapAlternateElements(GenericLinkedList<T> ll) {
        GenericLinkedList<T>.Node current = ll.getHead();

        while (current != null && current.next != null) {
            T temp = current.next.value;
            current.next.value = current.value;
            current.value = temp;

            current = current.next.next;
        }

        return ll;
    }

    public static void main(String[] args) {
        GenericLinkedList<String> ll = new GenericLinkedList<>();
        Arrays.asList("One", "Two", "Three", "four", "Five", "Six", "Seven", "Eight").forEach(ll::insertInTheEnd);

        Swap swap = new Swap();
        swap.swapAlternateElements(ll);
        ll.list();
    }

}
