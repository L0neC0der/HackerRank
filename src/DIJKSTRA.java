import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node implements Comparable<Node>{
	int val;
	int dist;
	public Node(int val){
		this.val = val;
		this.dist = Integer.MAX_VALUE;
	}
	public int compareTo(Node i){
		return ((Integer)this.dist).compareTo((Integer)i.dist);
	}
}
class myNodeList extends LinkedList<Node>{
	
}

class Graph{
	int N;
	myNodeList[] list;
	int [][] weight;
	int[] distance;
	PriorityQueue<Node> pq = new PriorityQueue<Node>();
	HashSet<Node> visited = new HashSet<Node>();
	public Graph(int N){
		this.N = N;
		list = new myNodeList[N+1];
		weight = new int[N+1][N+1];
		distance = new int[N+1];
		for(int i =0;i<=N;i++){
			Node temp = new Node(i);
			distance[i] = -1;
			list[i] = new myNodeList();
			list[i].add(temp);
		}
	}
	public void addEdge(int u,int v,int wt){
		list[u].add(list[v].getFirst());
		list[v].add(list[u].getFirst());
		if(wt<weight[u][v] || weight[u][v]==0){
		weight[u][v]=(wt);
		weight[v][u]=(wt);  
		}
	}
	
	public int[] dijkstra(int start){
		pq.clear();
		visited.clear();
		for(int i = 1;i<=N;i++){
			list[i].getFirst().dist = Integer.MAX_VALUE;
		}
		Node curr = list[start].getFirst();
		curr.dist = 0;
		pq.add(curr);
		distance[start] = 0;
		while(!pq.isEmpty()){
			curr = pq.poll();
			int dddd = curr.dist;
			if(!visited.contains(curr)){
				visited.add(curr);		
				for(Node temp:list[curr.val]){
					int d = distance[curr.val] + weight[curr.val][temp.val];
					if(distance[temp.val]==-1){
						distance[temp.val]=d;						
						temp.dist=d;
						pq.add(temp);
					}
					else if(distance[temp.val]>d){
						distance[temp.val]=d;				        
				        temp.dist=d;
				        pq.add(temp);
//					if(temp.dist>(curr.dist)+(weight[curr.val][temp.val])){
//						temp.dist=(curr.dist)+(weight[curr.val][temp.val]);
//						int neibDist = temp.dist;
//						pq.add(temp);
//					}
				}
			}
		}
   
		}
		 return distance;
	}
}
public class DIJKSTRA {
	static InputReader in = new InputReader(System.in);
	static PrintWriter w = new PrintWriter(System.out);
	
  public static void main(String[] args){

	  int T = in.nextInt();
	  while(T-->0){
		  int n = in.nextInt();
		  int e = in.nextInt();
		  Graph g = new Graph(n);
		  for(int i = 0 ;i<e;i++){
			  int u = in.nextInt();
			  int v = in.nextInt();
			  int wt = in.nextInt();
			  g.addEdge(u, v, wt);
		  }
		  int s= in.nextInt();
		  
		  
			int[] d=  g.dijkstra(s);
			  for(int i=1;i<=n;i++){
	              if(i==s){
	                  continue;
	                   }
	              System.out.print(d[i]+" ");
	          }
		  
		  System.out.println();
	  
  }
  }
  static class InputReader {
	  
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}
