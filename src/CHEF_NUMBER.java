import java.util.*;
import java.io.*;

public class CHEF_NUMBER {
     public static void main(String[] args){
    	 Scanner in = new Scanner (System.in);
    	 int t= in.nextInt();
    	 in.nextLine();
    	 while(t-->0){
    		 
    		 String n=in.nextLine();
    		 char[] arr = n.toCharArray();
    		 int n1=0,n0=0;
    		 for(int i=0;i<arr.length;i++){
    			 if(arr[i]=='1'){
    				 n1++; 
    			 }
    			 if(arr[i]=='0'){
    				 n0++;
    			 }
    		 }
    		 if(n0==1 || n1==1){
    				 System.out.println("Yes");
    			
    		 }
    		 else{
    			 System.out.println("No");
    		 }
    	 }
     }
}
