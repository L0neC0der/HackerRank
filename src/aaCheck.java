import java.util.*;
import java.io.*;
import java.math.*;


class aaCheck {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int n = in.nextInt();
	            int[] a = new int[n];
	            int[] b = new int[n];
	            for(int a_i=0; a_i < n; a_i++){
	                a[a_i] = in.nextInt();
	                b[a_i] = a[a_i];
	            }
	            // Write Your Code Here
	            Arrays.sort(a);
	            boolean check = true;
	            for(int i=0;i<n-1;){
	                if(a[i]==b[i]){
	                    i++;
	                    continue;
	                }
	                else if(a[i]==b[i+1] && a[i+1]==b[i]){
	                    i+=2;
	                    continue;
	                }
	                else{
	                   check = false;
	                    break;
	                }
	            }
	            if(check =false){
	                System.out.println("No");
	            }
	            else{
	                System.out.println("Yes");
	            }
	        }
	    }
}