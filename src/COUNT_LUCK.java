import java.util.*;
import java.io.*;

class Node_CL{
	int x,y;
	String val;
	public Node_CL(String val,int x,int y){
		this.x=x;
		this.y=y;
		this.val = val;
	}
}
public class COUNT_LUCK {
	static InputReader in = new InputReader(System.in);
	static HashSet<Node_CL> visited = new HashSet<Node_CL>();
	static ArrayList<Node_CL> path= new ArrayList<Node_CL>();
	static boolean add = true;
	static int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t= in.nextInt();
		while(t-->0){
			int n=in.nextInt(),m=in.nextInt();
			int sX=0,sY=0;
			Node_CL[][] g = new Node_CL[n][m];
			for(int i =0 ;i <n;i++){
				String val = in.readString();
				char[] ar = val.toCharArray();
				for(int j=0;j<ar.length;j++){
					if(ar[j]=='M'){
						sX = i;
						sY = j;
					}
					g[i][j] = new Node_CL(Character.toString(ar[j]),i,j);
				}
				
			}
			ans = 0;
			add = true;
			visited.clear();
			path.clear();
		    DFS(sX,sY,g);
		    visited.clear();
		    for(Node_CL cur:path){
		    	int i = cur.x,j=cur.y;
		    	visited.add(cur);
		    	int temp = 0;
		    	if(i-1>=0 && j>=0 && i-1<g.length && j<g[0].length && (g[i-1][j].val.equals(".")|| g[i-1][j].val.equals("*")) && !visited.contains(g[i-1][j])){
		    		temp++;
		    	}
		    	if(i>=0 && j-1>=0 && i<g.length && j-1<g[0].length && (g[i][j-1].val.equals(".")|| g[i][j-1].val.equals("*")) && !visited.contains(g[i][j-1])){
		    		temp++;
		    	}
		    	if(i+1>=0 && j>=0 && i+1<g.length && j<g[0].length && (g[i+1][j].val.equals(".")|| g[i+1][j].val.equals("*")) && !visited.contains(g[i+1][j])){
		    		temp++;
		    	}
		    	if(i>=0 && j+1>=0 && i<g.length && j+1<g[0].length && (g[i][j+1].val.equals(".")|| g[i][j+1].val.equals("*")) && !visited.contains(g[i][j+1])){
		    		temp++;
		    	}
		    	if(temp>1){
		    		ans++;
		    	}
		    }
		    int k = in.nextInt();		    
		    if(k== ans){
		    	System.out.println("Impressed");
		    }
		    else{
		    	System.out.println("Oops!");
		    	//System.out.println(ans);
		    }
		    	
		}
         
	}

	private static void DFS(int sX, int sY, Node_CL[][] g) {		
		int i = sX,j=sY;
		visited.add(g[i][j]);		
		if (g[i][j].val.equals("*")) {
			add = false;
			return;
		}
		path.add(g[i][j]);
		if (add && i - 1 >= 0 && j >= 0 && i - 1 < g.length && j < g[0].length
				&& (g[i - 1][j].val.equals(".") || g[i - 1][j].val.equals("*")) && !visited.contains(g[i - 1][j])) {
			DFS(i - 1, j, g);
		}
		if (add && i >= 0 && j - 1 >= 0 && i < g.length && j - 1 < g[0].length
				&& (g[i][j - 1].val.equals(".") || g[i][j - 1].val.equals("*")) && !visited.contains(g[i][j - 1])) {
			DFS(i, j - 1, g);
		}
		if (add && i + 1 >= 0 && j >= 0 && i + 1 < g.length && j < g[0].length
				&& (g[i + 1][j].val.equals(".") || g[i + 1][j].val.equals("*")) && !visited.contains(g[i + 1][j])) {
			DFS(i + 1, j, g);
		}
		if (add && i >= 0 && j + 1 >= 0 && i < g.length && j + 1 < g[0].length
				&& (g[i][j + 1].val.equals(".") || g[i][j + 1].val.equals("*")) && !visited.contains(g[i][j + 1])) {
			DFS(i, j + 1, g);
		}
		if(add){
			path.remove(g[i][j]);
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
