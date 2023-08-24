package LinkedList2_Phv;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LL {
	Node head;
	Node tail;
	int size;
	
	void init() {
		head = new Node(-1);
		tail = null;
		size = 0;
	}
	
	void add(int idx, int data) {
		if(size < idx || idx < 0) {
			System.out.println("add idx out of range!");
			return;
		}
		
		Node newNode = new Node(data);
		if(idx == 0) {
			if(head.next == null) {
				head.next = newNode;
				tail = newNode;
				++size;
				return;
			}
			
			Node head_next = head.next;
			head.next = newNode;
			newNode.next = head_next;
			++size;
			return;
		}
		
		else {
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
				++cnt;
				cur = cur.next;
			}
			if(newNode.next == null) tail = newNode;
			return;
		}
	}
	
	void del(int idx) {
		if(size < idx + 1 || idx < 0) {
			System.out.println("del idx out of range!");
			return;
		}
		
		if(idx == 0) {
			Node cur = head.next;
			head.next = cur.next;
			--size;
			if(head.next == null) tail = null;
			return;
		}
		
		else {
			Node cur = head.next;
			int cnt = 0;
			while(true) {
				if(cnt == idx - 1) {
					Node cur_next_next = cur.next.next;
					cur.next = cur_next_next;
					--size;
					break;
				}
				++cnt;
				cur = cur.next;
			}
			if(cur.next == null) tail = cur;
			return;
		}
	}
	
	void get(int idx) {
		if(size < idx + 1 || idx < 0) {
			System.out.println("get idx out of range!");
			return;
		}
		
		Node cur = head.next;
		int cnt = 0;
		while(true) {
			if(cnt == idx) {
				System.out.println(cur.data);
				return;
			}
			++cnt;
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
}

public class LinkedList2_Phv {
	public static void main(String[] args) {
		LL ll = new LL();
		ll.init();
		for(int i=1; i<10; i++) {
			ll.add(ll.size, i);
		}
		ll.print();
		ll.add(0, -10);
		ll.print();
		ll.add(0, 19);
		ll.print();
		System.out.println(ll.size);
		ll.add(11, 100);
		ll.print();
		ll.del(11);
		ll.print();
		System.out.println(ll.size);
		ll.get(ll.size-1);
		ll.init();
		ll.add(0,1);
		ll.print();
		ll.del(1);
		ll.print();
	}
}
