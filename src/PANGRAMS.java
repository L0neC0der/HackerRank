import java.io.*;
import java.util.*;

public class PANGRAMS {
	
	static InputReader in = new InputReader(System.in);
	static PrintWriter w = new PrintWriter(System.out);
	
	public static void main(String[] args){
		
		HashMap<String,Integer> map = new HashMap<String,Integer>(); 
		int no = 0;
		for(char a = 'a';a<='z';a++){
			map.put(Character.toString(a), no);
			no++;
		}
		int[] test = new int[26];
		for(int i = 0;i<test.length;i++){
			test[i]=0;
		}
		
		String input = in.readString();
		input = input.toLowerCase();
		char[] check = input.toCharArray();
		
		for(int i = 0;i<check.length;i++){
			char tt = check[i];
			if(tt == ' ')
				continue;
            int index = map.get(Character.toString(tt));
            test[index]= 1;
		}
		boolean pan = true;
		for(int i = 0;i<test.length;i++){
			if(test[i]== 0){
				pan =false;
				break;
			}
		}
		if(pan){
			w.println("pangram");
		}
		else w.println("not pangram");
		
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
			return  c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	

}
