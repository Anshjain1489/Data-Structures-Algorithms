package dsa.Linkedlist;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class CircularLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteFirst() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }

    public void deleteLast() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public int search(int key) {
        if (head == null) return -1;

        Node temp = head;
        int index = 0;

        do {
            if (temp.data == key)
                return index;

            temp = temp.next;
            index++;
        } while (temp != head);

        return -1;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public int size() {
        return size;
    }
}

public class CircularLinkedListImplementation{
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addFirst(0);
        cll.addLast(1);
        cll.addLast(2);
        cll.addLast(3);
        cll.addLast(4);
        cll.addAtIndex(5, 5);
        cll.display();
    }
}
