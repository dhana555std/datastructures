package org.dhana.linkedlist;

import java.util.Arrays;

public class SearchOnLinkedList<T> extends GenericLinkedList {
    public T findNthIndexFromEnd(GenericLinkedList<T> list, int index) {
        GenericLinkedList.Node head = list.getHead();
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return null;
        }

        GenericLinkedList<T>.Node slow = head;
        GenericLinkedList<T>.Node fast = head;

        int i = 0;
        while (fast != null && i < index) {
            fast = fast.next;
            i++;
        }

        if (i < index) {
            System.out.println("The list does not have " + index + " elements.");
            return null;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            i++;
        }

        return slow.value;
    }

    public Boolean isLoopExists(GenericLinkedList<String> ll) {
        Node head = ll.getHead();

        if (head == null) {
            System.out.println("There are no elements inside linked list.");
            return null;
        }

        Node slow = head;
        Node fast = head;

        int x = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.value == fast.value) {
                System.out.println("Loop exists at the " + x + " element.");
                return true;
            }

            x++;
        }

        return false;
    }

    public static void main(String[] args) {
        /*GenericLinkedList<Integer> ll = new GenericLinkedList<>();
        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(ll::insertInTheEnd);*/

       /* SearchOnLinkedList<Integer> searchList = new SearchOnLinkedList<>();
        int index = 7;
        Integer value = searchList.findNthIndexFromEnd(ll, index);
        Integer middle = ll.middleElement();

        System.out.println("The last " + index + " th index from end is " + value);
        System.out.println("The middle " + middle );*/

        GenericLinkedList<String> ll = new GenericLinkedList<>();
        Arrays.asList("One", "Two", "Three", "four", "Five", "Six").forEach(ll::insertInTheEnd);

        GenericLinkedList<String>.Node node = ll.getNodeAtIndex(4);
        System.out.println("Node is " + node.value);
    }
}
