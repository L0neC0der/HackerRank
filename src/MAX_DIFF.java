import java.util.*;
import java.io.*;

public class MAX_DIFF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            Scanner in = new Scanner(System.in);
            int t =in.nextInt();
            while(t-->0){
            	int n = in.nextInt();
            	int[] arr = new int[n];
            	for(int i =0 ;i <n;i++){
            		arr[i] = in.nextInt();
            	}
            	Arrays.sort(arr);
            	System.out.println(arr[arr.length-1]-arr[0]);
            }
	}

}
