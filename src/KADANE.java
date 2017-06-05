import java.util.*;
import java.io.*;
public class KADANE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in= new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
        	int n = in.nextInt();
        	int[] arr = new int[n];
        	for(int i=0;i<n;i++){
        		int no=in.nextInt();
        		arr[i]=no;
        	}
        	int totalMax = 0,currMax =0;
        	for(int i = 0;i<n;i++){
        		currMax = Math.max(arr[i], currMax+arr[i]);
        		totalMax = Math.max(totalMax, currMax);
        	}
        	System.out.println(totalMax);
        }
	}

}
