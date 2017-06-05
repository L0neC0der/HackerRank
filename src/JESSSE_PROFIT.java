import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class NodeProfit implements Comparable<NodeProfit>{
	int val,posn;
	public NodeProfit(int val,int posn){
		this.val = val;
		this.posn = posn;
	}
	public int compareTo(NodeProfit i){
		return ((Integer)this.val).compareTo((Integer)i.val);
	}
}
public class JESSSE_PROFIT {
	static InputReader in = new InputReader(System.in);
	static PrintWriter w = new PrintWriter(System.out); 
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      int n= in.nextInt(),t=in.nextInt();
      NodeProfit[] stock = new NodeProfit[n];
      int[] stockPrice = new int[n];
      for(int i = 0 ;i<n;i++){
    	  int p =in.nextInt();
    	  stock[i]=new NodeProfit(p,i);
    	  stockPrice[i] = p;
      }
      Arrays.sort(stock);
      Arrays.sort(stockPrice);
 
      while(t-->0){

    	  int profit = in.nextInt();
    	  int i = 0;
          int startD = 0,endD = 0,diff = Integer.MAX_VALUE;

			if (stock[n - 1].val - stock[0].val < profit) {
				w.println(-1);
			} 
			else {
				while (i < n ) {
					int j = Arrays.binarySearch(stockPrice, stock[i].val+profit);
					if(j>=0){
						int sIndex=j,eIndex=j; 
						while(stock[--j].val==stock[i].val+profit){
							sIndex=j;
						}
						try{
							while(stock[++j].val==stock[i].val+profit ){
								eIndex=j;
							}
						}
                        catch(Exception e){
                        	e.getMessage();
                        }
						for(int kk = sIndex;kk<=eIndex;kk++){
							if (stock[kk].posn > stock[i].posn) {
								if (diff >= stock[kk].posn - stock[i].posn) {
									if (diff == stock[kk].posn - stock[i].posn) {
										if (startD > stock[i].posn + 1) {
											startD = stock[i].posn + 1;
											endD = stock[kk].posn + 1;
										}
									} else {
										diff = stock[kk].posn - stock[i].posn;
										startD = stock[i].posn + 1;
										endD = stock[kk].posn + 1;
									}
	
								}
							}
						}
					}
					i++;
				}
                if(startD==0 && endD==0){
                    w.println(-1);
                }
                else{
                    w.println(startD + " " + endD);
                }
				
			}

		}
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
