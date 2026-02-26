package dsa.Linkedlist;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node head;
	Node tail;
	int size = 0;

	LinkedList() {
		head = tail = null;
	}

	// Insert at end
	void insert(int element) {
		Node temp = new Node(element);
		size++;
		if (head == null) {
			head = tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
	}

	// Insert at first
	void insertAtFirst(int element) {
		Node temp = new Node(element);
		size++;
		temp.next = head;
		head = temp;

		if (tail == null) {
			tail = temp;
		}
	}

	// Delete element
	void deleteElement(int element) {
		Node temp = head;
		Node prev = null;

		while (temp != null) {
			if (temp.data == element) {
				if (prev == null) { // delete head
					head = temp.next;
					size--;
					if (temp == tail) {
						tail = null;
					}
				} else {
					prev.next = temp.next;
					size--;
					if (temp == tail) {
						tail = prev;
					}
				}
				return;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	// Print list
	void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Search element
	boolean search(int element) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == element) {
				System.out.println(element + " has founded");
				return true;
			}
			temp = temp.next;
		}
		System.out.println(element + " has not founded");
		return false;
	}

	// Insert at position
	void insertAtPosition(int position, int element) {

		if (position < 0 || position > size) {
			System.out.println("Position out of bounds.");
			return;
		}

		if (position == 0) {
			insertAtFirst(element);						
			return;
		}
		
		if (position == size) {
	        insert(element);
	        return;
	    }
		
		Node temp = new Node(element);
		Node current = head;
		
		for (int i = 0; i < position - 1; i++) {
	        current = current.next;
	    }

		temp.next = current.next;
		current.next = temp;

		if (temp.next == null) {
			tail = temp;
		}

		size++;
	}
	
	void reverse() {
		Node prev = null;
		Node curr = tail = head;
		Node next;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	
	Node findMid(Node head) {
	    Node slow = head;
	    Node fast = head;

	    while (fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }

	    return slow;
	}
	
	boolean checkPalidrome() {
		if(size == 0 || head.next == null) {
			return true;
		}
		Node midNode = findMid(head);
		Node prev = null;
		Node curr = midNode.next;
		Node next;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev;
		Node left = head;
		while(right!=null) {
			if(left.data!=right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}

	boolean isCycle(){
		Node slow = head ;
		Node fast = head ;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	void removeCycle(){
		Node slow = head ;
		Node fast = head ;
		boolean cycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				cycle = true;
				break;
			}
		}
		if(cycle == false){
			return;
		}

		slow = head;

		if (slow == fast) { // cycle starts at head
    		while (fast.next != slow) {
        		fast = fast.next;
    		}
    		fast.next = null;
    		return;
		}

		Node prev = null;
		while (slow != fast) {
    		prev = fast;
    		slow = slow.next;
    		fast = fast.next;
		}
		prev.next = null;
	}

	int size () {
		return size;
	}
}



public class LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList  l= new LinkedList();

		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.print();
		System.out.println("List of size "+l.size());

		l.insertAtFirst(0);
		l.print();
		System.out.println("List of size "+l.size());
		l.deleteElement(2);
		l.print();
		System.out.println("List of size "+l.size());
		l.search(4);

		l.insertAtPosition(1, 4);
		l.print();
		System.out.println("List of size "+l.size());
		l.reverse();
		l.print();
		
		LinkedList  ll = new LinkedList();
		ll.insert(1);
		ll.insert(2);
		ll.insert(2);
		ll.insert(1);
		
		System.out.print("Palindrome list is : ");
		
		ll.print();
		
		if(ll.checkPalidrome()) {
			System.out.println("It is Palindrome ");
		}else {
			System.out.println("It is not Palindrome ");
		}

		LinkedList  l2 = new LinkedList();
		l2.head = new Node(1);
		Node temp = new Node(2);
		l2.head.next = temp;
		l2.head.next.next = new Node(3);
		l2.head.next.next.next = temp;
		System.out.println(l2.isCycle());
		l2.removeCycle();
		System.out.println(l2.isCycle());
    }
}
