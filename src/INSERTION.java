import java.util.*;
import java.io.*;

public class INSERTION {
	static int compareC , swapC ;
    static void insertionSort(int[] arr){
 	
    	for(int i = 1 ;i<arr.length;i++){
    		int j = i-1;
    		while(j>-1){
    			if(compare(arr[j],arr[j+1])>0){
    				swap(j,j+1,arr);
    				j = j-1;
    			}
    			else 
    				break;
    		}
    	}
    	
    }
    static void swap(int a, int b,int[] arr){
    	swapC++;
    	arr[a] = arr[a]^arr[b];
    	arr[b] = arr[a]^arr[b];
    	arr[a] = arr[a]^arr[b];	
    }
    static int compare(int a,int b){
    	compareC++;
    	if(a>b){
    		return 1;
    	}
    	else
    		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Scanner in = new Scanner(System.in);
           int t= in.nextInt();
           while(t-->0){
        	   int n = in.nextInt();
        	   int[] arr = new int[n];
        	   for(int i = 0;i<n;i++){
        		   arr[i] = in.nextInt();
        	   }
        	   compareC = 0;
        	   swapC = 0;
        	   insertionSort(arr);
        	   System.out.println(compareC-swapC);
           }
	}

}
