package org.dhana.linkedlist.singlelinkedlist;

import java.util.Arrays;

public class LinkedList {
    private Node head;

    class Node {
        private Node next;
        private int value;

        Node(final int value) {
            this.value = value;
        }
    }

    public void insertInTheFront(final int x) {
        if (head == null) {
            head = new Node(x);
            return;
        }

        Node node = new Node(x);
        node.next = head;

        head = node;
        System.out.println("Node with value " + x + " is added to Linked list.");
    }

    public void insertInTheEnd(final int x) {
        if (head == null) {
            head = new Node(x);
            return;
        }

        Node i = head;
        while (i.next != null) {
            i = i.next;
        }

        i.next = new Node(x);
    }

    public void insertNodeAfterElement(final int element, final int newElement) {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return;
        }

        Node i = head;

        while (i != null) {
            if (i.value == element) {
                Node newNode = new Node(newElement);

                Node temp = i.next;
                newNode.next = temp;
                i.next = newNode;

                return;
            }
            i = i.next;
        }

        System.out.println("The linked list doesn't contain element " + element);
    }

    public boolean deleteKey(final int key) {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return false;
        }

        Node previous = null;
        Node current = head;

        while (current != null) {
            if (current.value == key) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }

                current.next = null;
                return true;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("There is no element " + key + " in the linked list.");
        return false;
    }

    public Integer deleteAtIndex(final int index) {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return null;
        }

        if (index == 0) {
            int value = head.value;
            head = head.next;
            return value;
        }

        Node previous = null;
        Node current = head;
        int pointer = 0;

        while (current != null) {
            if (pointer == index) {
                previous.next = current.next;
                current.next = null;
                return current.value;
            }

            pointer ++;
            previous = current;
            current = current.next;
        }

        System.out.printf("There is no index %d in the linked list.", index);
        return null;
    }

    public void update(final int x, final int y) {

    }

    public void list() {
        System.out.println("Displaying all the elements of the linked list:-");
        if (head == null) {
            System.out.println("There are no elements in the selected linked list.");
        } else {
            Node i = head;
            while (i != null) {
                System.out.println(i.value);
                i = i.next;
            }
        }
    }

    public void removeAll() {
       head = null;
    }

    public int size() {
        int i = 0;
        for (; head != null; head = head.next, i++);
        return i;
    }

    public Integer middleElement() {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        System.out.println("Insert from the front:-");

        /*Arrays.asList(1, 2, 3, 4, 5, 6).forEach(ll::insertInTheEnd);
        ll.list();

        System.out.println("Insert at the end:-");
        ll = new LinkedList();
        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(ll::insertInTheFront);
        ll.list();

        System.out.println("Insert after 3");
        ll.insertNodeAfterElement(3, 17);
        ll.list();

        System.out.println("Insert after 99");
        ll.insertNodeAfterElement(17, 101);
        ll.list();*/

        Arrays.asList(1, 2, 3, 4, 5, 6).forEach(ll::insertInTheEnd);
        ll.deleteAtIndex(0);
        ll.deleteAtIndex(2);
        ll.deleteAtIndex(21);
        ll.insertInTheFront(32);
        ll.list();

        ll.removeAll();
        ll.insertInTheFront(32);
        ll.insertInTheFront(30);
        ll.insertInTheFront(2);
        ll.insertInTheFront(4);
        ll.insertInTheFront(42);
        ll.insertInTheFront(43);
        ll.insertInTheFront(41);
        ll.insertInTheFront(40);
        ll.list();

        System.out.format("Middle of linked list is %s \n" , ll.middleElement());
    }
}
