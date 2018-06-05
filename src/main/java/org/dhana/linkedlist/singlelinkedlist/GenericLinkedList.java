package org.dhana.linkedlist.singlelinkedlist;

import java.util.Arrays;

public class GenericLinkedList<T> {
    private Node head;

    protected class Node {
        Node next;
        T value;

        Node(final T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    protected Node getHead() {
        return head;
    }

    protected void setHead(Node head) {
        this.head = head;
    }

    public void insertInTheFront(final T x) {
        if (head == null) {
            head = new Node(x);
            return;
        }

        Node node = new Node(x);
        node.next = head;

        head = node;
        System.out.println("Node with value " + x + " is added to Linked list.");
    }

    public void insertInTheEnd(final T x) {
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

    public void insertNodeAfterElement(final T element, final T newElement) {
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

    public boolean deleteKey(final T key) {
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

    public T deleteAtIndex(final int index) {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return null;
        }

        if (index == 0) {
            T value = head.value;
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

            pointer++;
            previous = current;
            current = current.next;
        }

        System.out.printf("There is no index %d in the linked list.", index);
        return null;
    }

    public boolean update(final T x, final T y) {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return false;
        }

        Node i = head;

        while (i != null) {
            if (i.value == x) {
                i.value = y;
                return true;
            }

            i = i.next;
        }

        System.out.println("There is no element " + x);
        return false;

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
        for (; head != null; head = head.next, i++) ;
        return i;
    }

    public T middleElement() {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Important remember
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }

    public Node getNodeAtIndex(int index) {
        if (head == null) {
            return null;
        }

        int x = 0;
        Node i = head;

        while (i != null) {
            x++;
            i = i.next;

            if (x == index) {
                return i;
            }
        }

        System.out.println("No index " + index);

        return null;
    }

    public void reverse() {
        if (head == null) {
            System.out.println("There are no elements in the linked list.");
            return;
        }

        Node newHead = null;

        while (head != null) {
            Node temp = head.next;
            head.next = null;

            if (newHead == null) {
                newHead = head;
            } else {
                head.next = newHead;
                newHead = head;
            }

            head = temp;
        }

        head = newHead;
    }

    public static void main(String[] args) {
        GenericLinkedList<String> ll = new GenericLinkedList<>();
        Arrays.asList("One", "Two", "Three", "Four", "Five", "Six").forEach(ll::insertInTheEnd);

        ll.reverse();
        ll.list();
    }

}