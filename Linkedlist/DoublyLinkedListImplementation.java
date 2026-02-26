package dsa.Linkedlist;

class dNode {

    int data;
    dNode next;
    dNode prev;

    dNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

class DoublyLinkedList {

    dNode head;
    dNode tail;
    int size = 0;

    public DoublyLinkedList() {
        head = tail = null;
    }

    void addAtFirst(int data) {
        dNode temp = new dNode(data);
        size++;
        if (head == null) {
            head = tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    void addAtLast(int data) {
        dNode temp = new dNode(data);

        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }

        size++;
    }

    void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addAtFirst(data);
            return;
        }

        if (index == size) {
            addAtLast(data);
            return;
        }

        dNode newNode = new dNode(data);
        dNode temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    void print() {
        dNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    

    int removeAtLast() {
        if (head == null) {
            throw new RuntimeException("Underflow - List is empty");
        }

        int val = tail.data;

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return val;
    }

    int removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeAtFirst();
        }

        if (index == size - 1) {
            return removeAtLast();
        }

        dNode temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        int val = temp.data;

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;
        return val;
    }

    int removeAtFirst() {
        if (head == null) {
            System.out.println("Underflow List");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    void reverseDoublyLinkedList(){
        dNode curr = head;
        dNode prev = null;
        dNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

}

public class DoublyLinkedListImplementation{
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addAtLast(1);
        dl.addAtLast(2);
        dl.addAtLast(3);
        dl.addAtLast(5);
        dl.addAtLast(6);
        dl.addAtFirst(0);
        dl.addAtIndex(4, 4);
        dl.removeAtIndex(6);
        dl.print();
        dl.reverseDoublyLinkedList();
        dl.print();
    }
}
