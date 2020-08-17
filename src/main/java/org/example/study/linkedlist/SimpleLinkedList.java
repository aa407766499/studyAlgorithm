package org.example.study.linkedlist;

/**
 * @author lsx
 * @date 2020/8/14 21:03
 */
public class SimpleLinkedList {

    private Node head = new Node();

    public void add(Node node) {
        head.setNext(node);
    }

    public Node get(String value) {
        Node next = head.getNext();
        while (next != null) {
            if (next.getData().equals(value)) {
                return next;
            }
            next = next.getNext();
        }
        return null;
    }

    public void insert(Node node, String value) {
        Node preNode = get(value);
        Node nextNode = preNode.getNext();
        if (nextNode != null) {
            node.setNext(nextNode);
        }
        preNode.setNext(node);
    }

    public void remove(String value) {
        Node pre = head;
        Node next = head.getNext();
        while (next != null) {
            if (next.getData().equals(value)) {
                pre.setNext(next.getNext());
                next.setNext(null);
            }
            pre = next;
            next = next.getNext();
        }
    }
}
