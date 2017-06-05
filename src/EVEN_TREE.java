import java.io.*;
import java.util.*;

public class EVEN_TREE {
	static InputReader in = new InputReader(System.in);
	static PrintWriter w = new PrintWriter(System.out); 
	static HashMap<Integer,Nodes> mapping ;
	static HashSet<Nodes> visited= new HashSet<Nodes>();
	static int ans =0;
	//static ArrayList<Nodes> leafNodes = new ArrayList<Nodes>();
	public static void main(String[] args){
		mapping = new  HashMap<Integer,Nodes>();
		int N =in.nextInt();
		int M =in.nextInt();
		int tail;
		int head;
		int root = 0;
		for(int i=1; i<=N;i++){
			Nodes temp = new Nodes(i);
			mapping.put(i, temp);
		}
		for (int i =1;i<=M;i++){
			tail =in.nextInt();
			head = in.nextInt();
			Nodes tailEnd = mapping.get(tail);
			Nodes headEnd = mapping.get(head);
			tailEnd.setParent(headEnd);
			headEnd.addChild(tailEnd);
		}
		for(int i = 1; i<=N ;i++){
			if(mapping.get(i).getParent()==null){
				root =i;
				break;
			}
		}
		DFS(mapping.get(root));
		visited.clear();
        DFS1(mapping.get(root));
        w.println(ans);
	}
	static void DFS1(Nodes w){
		visited.add(w);
		ArrayList<Nodes> temp = w.getChildren();
		if(!temp.isEmpty()){
			for(Nodes all :temp){
				if(!visited.contains(all)){
					DFS1(all);
				}
			}
		}
		if(w.getParent()!=null){
			if(w.getNoOfChildren()%2!=0){
				Nodes paren = w.getParent();
				ans++;
				paren.setNoOfChildren(paren.getNoOfChildren()-w.getNoOfChildren()-1);
			}	
		}
	}
	static void DFS(Nodes n){
		visited.add(n);
		ArrayList<Nodes> temp = n.getChildren();
		if(!temp.isEmpty()){
			for(Nodes all :temp){
				if(!visited.contains(all)){
					DFS(all);
				}
			}
		}	
	   if(n.getParent()!=null){
			//System.out.println("in Node  "+n.getNo());
			Nodes pare = n.getParent();
			pare.setNoOfChildren(pare.getNoOfChildren()+n.getNoOfChildren()+1);
			//System.out.println("parent Node no of child set is "+pare.getNoOfChildren());
		}
	}
     static class Nodes{
		public Nodes parent;
		public ArrayList<Nodes> children;
		public int noOfChildren;
		public int no;
		public Nodes(int no){
			this.no=no;
			parent = null;
			children = new ArrayList<Nodes>();
			noOfChildren =0;
		}
		void setParent(Nodes pa){
			parent =pa;
		}
		Nodes getParent(){
			return parent;
		}
		int getNoOfChildren(){
			return noOfChildren;
		}
		void setNoOfChildren(int a){
			noOfChildren = a;
		}
		void addChild(Nodes e){
			children.add(e);
		}
		ArrayList<Nodes> getChildren(){
			return children;
		}
		int getNo(){
			return no;
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


