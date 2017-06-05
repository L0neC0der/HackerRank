import java.io.*;
import java.util.*;

public class ANTIPRIME {
	
	static HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();

	public static void main(String[] args){
		 InputReader in = new InputReader(System.in);
		 PrintWriter w = new PrintWriter(System.out); 
		int q=in.nextInt();
		memo.put(1, 1);
		while(q-->0){
			int a = in.nextInt();
			int maxDiv = 0;
            for(int i=1;i<=a;i++){
            	if(memo.containsKey(i)){
            		if(memo.get(i)>maxDiv){
            			maxDiv=memo.get(i);
            		}
            	}
            	else {
            		memo.put(i, numberOfDiv(i));
            		if(memo.get(i)>maxDiv){
            			maxDiv=memo.get(i);
            		}
            	}
            }
            while(memo.get(a)<maxDiv){
            	a++;
            	if(memo.containsKey(a)){
            		continue;
            	}
            	else {
            		memo.put(a, numberOfDiv(a));
            	}
            }
            w.println(a);
	    }
		w.flush();
	}
	static int numberOfDiv(int a) {
		ArrayList<Integer> divisor = new ArrayList<Integer>();
		int noDiv = 1;
		int i = 2;
		while (a > 1) {
			if (a % i == 0) {
				divisor.add(i);
				a = a / i;
			} else
				i++;
		}
		int check = divisor.get(0);
		int count = 0;
		for(int p : divisor){
			if(p == check){
				count++;
			}
			else{
				check = p;
				noDiv *=(count+1); 
				count = 0;
			}
		}
		return noDiv;
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
