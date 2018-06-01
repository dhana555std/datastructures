package org.dhana.linkedlist.singlelinkedlist;

public class Loop {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public Node setNext(Node node) {
            this.next = node;
            return node;
        }
    }

    Node head;

    public Node getLoopNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;

            if (fast.next.next == slow) {
                return fast;
            }

            fast = fast.next.next;
        }

        return null;
    }

    public int getLoopLength(Node node) {
        Node loopRef = node.next;
        int i = 1;
        while (loopRef != node) {
            loopRef = loopRef.next;
            ++i;
        }
        return i;
    }

    public void removeLoop(Node node) {
        node.next = null;
    }

    public void list() {
        Node i = head;
        while (i != null) {
            System.out.println(i.value);
            i = i.next;
        }
    }

    public static void main(String... args) {
        Loop loop = new Loop();
        Node head = new Node(66);

        loop.head = head;
        Node refNode = new Node(12);

        loop.head.setNext(new Node(32))
                .setNext(new Node(4))
                .setNext(new Node(55)).setNext(refNode).setNext(refNode);

        Node loopNode = loop.getLoopNode();
        System.out.println("Length of the loop is " + loop.getLoopLength(loopNode));

        if (loopNode != null) {
            System.out.println("Loop node detected. The loop node is " + loopNode.value);
            loop.removeLoop(loopNode);
            System.out.println("Now the loop in the node is released.");
        }

        System.out.println("Printing all the elements of list \n");
        loop.list();
    }
}