package DoublyLinkedList_Phv;

class Node {
	int data;
	Node prev;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class DLL {
	Node head;
	Node tail;
	int size;
	
	void init() { // make dummy head, tail and connect them.
		head = new Node(-1);
		tail = new Node(-1);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	void add(int idx, int data) {
		if(size < idx || idx < 0 ) {
			System.out.println("add idx out of range");
			return;
		}
		
	}
	
	void del(int idx, int data) {
		if(size < idx + 1 || idx < 0) {
			System.out.println("del idx out of range");
			return;
		}
	}
	
	void get(int idx) {
		
	}
	
	
	
}

public class DoublyLinkedList_Phv {
	
}
