package LinkedList_Phv;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LL {
	Node head = new Node(-1);
	Node tail;
	int size;
	
	void addToHead(int data) {
		if(head.next != null) return;
		Node newNode = new Node(data);
		head.next = newNode;
		tail = newNode;
	}
	
	void addLast(int data) {
		if(head.next == null && tail == null) {
			addToHead(data);
		}
		else {
			Node newNode = new Node(data);
			Node cur = tail;
			cur.next = newNode;
			tail = newNode;
		}
		++size;
	}
	
	void addFirst(int data) {
		if(head.next == null && tail == null) {
			addToHead(data);
		
		}
		else {
			Node newNode = new Node(data);
			Node head_next = head.next;
			head.next = newNode;
			newNode.next = head_next;
		}
		++size;
	}
	
	void add(int idx, int data) {
		if(size < idx || idx < 0) {
			System.out.println("add idx out of range");
			return;
		}
		if(idx == 0) {
			addFirst(data);
			return;
		}
		if(idx == size) {
			addLast(data);
			return;
		}
		Node newNode = new Node(data);
		Node cur = head.next;
		int cnt = 0;
		while(true) {
			if(cnt == idx - 1) {
				Node cur_next = cur.next;
				cur.next = newNode;
				newNode.next = cur_next;
				++size;
				break;
			}
			cnt++;
			cur = cur.next;
		}
	}
	
	void add(int data) {
		addLast(data);
	}
	
	void delLast() {
		if(head.next == null) return;
		if(head.next == tail) {
			head.next = null;
			tail = null;
			--size;
			return;
		}
		Node cur = head.next;
		while(true) {
			if(cur.next == tail) {
				cur.next = null;
				tail = cur; // 주의. cur = tail 이 아니고. tail = cur 가 맞다.
				--size;
				break;
			}
			cur = cur.next;
		}
	}
	
	void delFirst() {
		if(head.next == null) return;
		if(head.next == tail) {
			head.next = null;
			tail = null;
			--size;
			return;
		}
		Node head_next_next = head.next.next;
		head.next = head_next_next;
		--size;
	}
	
	void del(int idx) {
		if(size < idx + 1 || idx < 0) {
			System.out.println("del idx out of range");
			return;
		}
		if(idx == 0) {
			delFirst();
			return;
		}
		if(idx + 1 == size) {
			delLast();
			return;
		}
		
		Node cur = head.next;
		int cnt = 0;
		while(true) {
			if(cnt == idx - 1) {
				Node cur_next_next = cur.next.next;
				cur.next = cur_next_next;
				--size;
				break;
			}
			cnt++;
			cur = cur.next;
		}
	}
	
	void print() {
		Node cur = head.next;
		while(true) {
			if(cur == null) break;
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	void get(int idx) {
		if(size < idx + 1 || idx < 0) {
			System.out.println("get idx out of range");
			return;
		}
		Node cur = head.next;
		int cnt = 0;
		while(true) {
			if(cnt == idx) {
				System.out.println(cur.data);
				break;
			}
			cnt++;
			cur = cur.next;
		}
	}
}

public class LinkedList_Phv {
	public static void main(String[] args) {
		LL ll = new LL();
		ll.print();
		for(int i=0; i<10; i++) {
			ll.addLast(i);
		}
		ll.print();
		ll.addFirst(100);
		ll.print();
		ll.delFirst();
		ll.print();
		ll.delLast();
		ll.print();
		ll.addLast(1000);
		ll.print();
		ll.delLast();
		ll.print();
		ll.addFirst(1000);
		ll.print();
		ll.get(9);
		ll.add(0, 10);
		ll.print();
		ll.add(0, 11);
		ll.print();
		ll.add(-1, 12);
		ll.add(11, 12);
		ll.print();
		ll.del(12);
		ll.print();
		System.out.println(ll.size);
	}
}
