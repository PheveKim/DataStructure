package PriorityQueue_Phv;

import java.util.PriorityQueue;
import java.util.HashSet;

class Node implements Comparable<Node> {
	int r;
	int c;
	int dist;
	
	public Node(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node n2) {
		if(this.dist > n2.dist) return 1;
		else if(this.dist < n2.dist) return -1;
		else {
			if(this.r > n2.r) return 1;
			else if(this.r < n2.r) return -1;
			else {
				if(this.c > n2.c) return 1;
				else return -1;
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + dist;
		result = prime * result + r;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (c != other.c)
			return false;
		if (dist != other.dist)
			return false;
		if (r != other.r)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [r=" + r + ", c=" + c + ", dist=" + dist + "]";
	}
}


public class PriorityQueue_Phv {
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static PriorityQueue<Node> pq;
	static int[][] arr;
	static boolean[][] visited;
	static HashSet<Node> set_Node;
	static HashSet<Integer> set_Integer;
	static int n = 200;
	
	public static void main(String[] args) {
		
		arr = new int[n][n];
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
//		// method 1) using array : 27sec, 44sec
//		for(int cnt=0; cnt<20000; cnt++) {
//			pq = new PriorityQueue();
//			visited = new boolean[n][n];
//			
//			Node startNode = new Node(arr.length/2, arr.length/2, 0);
//			pq.add(startNode);
//			visited[startNode.r][startNode.c] = true;
//			arr[startNode.r][startNode.c] = 1;
//			
//			while(!pq.isEmpty()) {
//				Node popped = pq.poll();
//				arr[popped.r][popped.c] = 1;
//				
//				for(int i=0; i<4; i++) {
//					int nr = popped.r + dr[i];
//					int nc = popped.c + dc[i];
//					
//					if(bc(nr, nc) == true && !visited[nr][nc]) {
//						int dist = Math.abs(nr-startNode.r) + Math.abs(nc-startNode.c);
//						pq.add(new Node(nr, nc, dist));
//						visited[nr][nc] = true;
//					}
//				}
//			}
//		}
		
//		// method 2) using set_Node : 47sec
//		for(int cnt=0; cnt<100000; cnt++) {
//			pq = new PriorityQueue();
//			set_Node = new HashSet<>();
//			
//			Node startNode = new Node(arr.length/2, arr.length/2, 0);
//			pq.add(startNode);
//			arr[startNode.r][startNode.c] = 1;
//			set_Node.add(startNode);
//			
//			while(!pq.isEmpty()) {
//				Node popped = pq.poll();
//				arr[popped.r][popped.c] = 1;
//				
//				for(int i=0; i<4; i++) {
//					int nr = popped.r + dr[i];
//					int nc = popped.c + dc[i];
//					int dist = Math.abs(nr-startNode.r) + Math.abs(nc-startNode.c);
//					Node toNode = new Node(nr, nc, dist);
//					
//					if(bc(nr, nc) == true && !set_Node.contains(toNode)) {
//						pq.add(toNode);
//						set_Node.add(toNode);
//					}
//				}
//			}
//		}
		
		// method 3) using set_Integer : 32sec, 63sec->59sec(initial capacity)
		for(int cnt=0; cnt<20000; cnt++) {
			pq = new PriorityQueue();
			set_Integer = new HashSet<>(40000);
			
			Node startNode = new Node(arr.length/2, arr.length/2, 0);
			pq.add(startNode);
			arr[startNode.r][startNode.c] = 1;
			set_Integer.add(startNode.r * arr.length + startNode.c);
			
			while(!pq.isEmpty()) {
				Node popped = pq.poll();
				arr[popped.r][popped.c] = 1;
				
				for(int i=0; i<4; i++) {
					int nr = popped.r + dr[i];
					int nc = popped.c + dc[i];
					int uniqueId = nr * arr.length + nc;
					
					if(bc(nr, nc) == true && !set_Integer.contains(uniqueId)) {
						int dist = Math.abs(nr-startNode.r) + Math.abs(nc-startNode.c);
						pq.add(new Node(nr, nc, dist));
						set_Integer.add(uniqueId);
					}
				}
			}
		}
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}
	
	static boolean bc(int row, int col) {
		if(row<0 || row>=arr.length || col<0 || col>=arr.length) return false;
		return true;
	}
	
	static void printarr(int[][] arr) {
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				System.out.print(arr[r][c] + " " );
			}
			System.out.println();
		}
		System.out.println();
	} 
}


