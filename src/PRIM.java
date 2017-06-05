import java.io.*;
import java.util.*;


class NodePrim{
	int val ;
	int dist ;
	
	public NodePrim(int val){
		this.val = val;
		this.dist = Integer.MAX_VALUE;
	}
}


class MyNodeListP extends LinkedList<NodePrim> {
}
 
class MyWtListP extends LinkedList<Integer> {
}

class GraphPrim{
	MyNodeListP[] list;
	MyWtListP[] weight;
	int V;
	
	public GraphPrim(int V){
	   list = new MyNodeListP[V];
	   weight = new MyWtListP[V];
	   this.V =V;
	   
		for(int i=0;i<V;i++) {
			list[i] = new MyNodeListP();
			weight[i] = new MyWtListP();
		}
	   for(int i=0;i<V;i++){
		   NodePrim temp = new NodePrim(i);
		   list[i].add(temp);
	   }
	}
	public void addEdge(int u,int v,int wt){
		list[u].add(list[v].getFirst());
		list[v].add(list[u].getFirst());
		weight[u].add(wt);
		weight[v].add(wt);		
	}
	
	public int primAlgo(int s){
		int ans = 0;
		MinHeap mh = new MinHeap(V);
		
		list[s].getFirst().dist = 0;
		 for(int i = 0; i<V;i++){
			 mh.arr[i] = list[i].getFirst();
			 mh.pos[i] = i;
		 }
		 mh.swap(0,s);
		 int counter =0;
		 while(mh.size>0){
			 counter++;
		  NodePrim u= mh.extractMin();
		  ans+=u.dist;	  
		  int i=0;
			for(NodePrim v : list[u.val]) {
				 int neb = v.val;
				if(i == 0) {
					i++;
					continue;
				}
             
				if(mh.isInMinHeap(v) && weight[u.val].get(i-1) < v.dist) {
					v.dist = weight[u.val].get(i-1);
					mh.decreaseDist(v,v.dist);
				}
				i++;
			}
		 }
		return ans;
	}
}
class MinHeap{
	int size;
	int capacity;
	NodePrim[] arr;
	int[] pos;  // Determines the position of the nodes ex- the node number 1 is at 7th place etc
	public MinHeap(int V){
		size = V;
		capacity =V;
		arr = new NodePrim[V];
		pos = new int[V];
	}
	public void swap(int i ,int j){
		NodePrim temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		int posn = pos[arr[i].val];
		pos[arr[i].val] = pos[arr[j].val];
		pos[arr[j].val] = posn;
	}
	private int left(int i){
		return 2*i+1;
	}
	private int right(int i){
		return 2*i+2;
	}
	private int parent(int i){
		return ((i-1)/2);
	}
	public NodePrim extractMin(){
		if(size<=0){
			return null;
		}
		if(size==1){
			size--;
			return arr[0];
		}
		NodePrim ret = arr[0];
		swap(0 , size-1);
		size--;
		minHeapify(0);
		return ret;
	}
	private void minHeapify(int i){
		int l = left(i);
		int r = right(i);
		int small = i;
		if(l<size && arr[l].dist<arr[small].dist)
			small = l;
		if(r<size && arr[r].dist<arr[small].dist)
			small = r;
		if(small != i) {
			swap(i,small);
			minHeapify(small);
		}
	}
	public void decreaseDist(NodePrim v , int newDist){
		int index = pos[v.val];
		if(arr[index].dist < newDist){
			return;
		}
 
		arr[index].dist = newDist;
		fixUpwards(index); 
	}
	private void fixUpwards(int i){
		
		while(arr[i].dist<arr[parent(i)].dist){
			int parentInd = parent(i);
			swap(i,parent(i));
			i=parent(i);
		}
	}
	public boolean isInMinHeap(NodePrim node) {
		if(pos[node.val] < size)
			return true;
		return false;
	}
	
}

public class PRIM {
	static InputReader in = new InputReader(System.in);
	static PrintWriter w = new PrintWriter(System.out);

	public static void main(String[] args){
       int N = in.nextInt();
       int E = in.nextInt();
       GraphPrim g = new GraphPrim(N);
       for(int i = 0;i<E;i++){
    	   int u = in.nextInt();
    	   int v = in.nextInt();
    	   int wt = in.nextInt();
    	   g.addEdge(u-1,v-1,wt);
       }
	 int s = in.nextInt();
	 int ans = g.primAlgo(s-1);
	 w.println(ans);
	 w.flush();
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
