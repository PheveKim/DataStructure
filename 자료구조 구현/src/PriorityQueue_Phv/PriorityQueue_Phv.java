package PriorityQueue_Phv;
import java.util.PriorityQueue;

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
	public String toString() {
		return "Node [r=" + r + ", c=" + c + ", dist=" + dist + "]";
	}
}


public class PriorityQueue_Phv {
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		PriorityQueue<Node> pq = new PriorityQueue();
		
		arr = new int[5][5];
		visited = new boolean[5][5];
		
		Node startNode = new Node(arr.length/2, arr.length/2, 0);
		pq.add(startNode);
		visited[startNode.r][startNode.c] = true;
		arr[startNode.r][startNode.c] = 1;
		
		while(!pq.isEmpty()) {
			Node popped = pq.poll();
			arr[popped.r][popped.c] = 1;
			
			System.out.println(popped.dist);
			System.out.println(pq.toString());
			printarr(arr);
			
			for(int i=0; i<4; i++) {
				int nr = popped.r + dr[i];
				int nc = popped.c + dc[i];
				
				if(bc(nr, nc) == true && visited[nr][nc] == false) {
					int dist = Math.abs(nr-startNode.r) + Math.abs(nc-startNode.c);
					pq.add(new Node(nr, nc, dist));
					visited[nr][nc] = true;
				}
			}
		}
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


