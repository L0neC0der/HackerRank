import java.util.*;
import java.io.*;
import java.lang.*;

public class TWO_ARRAYS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashSet<Integer> done = new HashSet<Integer>();
		Scanner in= new Scanner(System.in);
		int T=in.nextInt();
		while(T-->0){
			done.clear();
			int n=in.nextInt();
			int k=in.nextInt();
			Integer[] arrA=new Integer[n];
			int[] arrB=new int[n];
			for(int i=0;i<n;i++){
				int a=in.nextInt();
				arrA[i]=a;
			}
			for(int i=0;i<n;i++){
				int b=in.nextInt();
				arrB[i]=b;
			}
            int c=0;
			Arrays.sort(arrA,Collections.reverseOrder());
			Arrays.sort(arrB);
			for(int i=0;i<n;i++){
              if(arrA[i]+arrB[i]<k){
            	  System.out.println("NO");
            	  c =1;
            	  break;
              }
			}
			if(c == 0){
				System.out.println("YES");
			}

		}
	}

}
