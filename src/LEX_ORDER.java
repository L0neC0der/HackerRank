import java.util.*;
import java.io.*;

public class LEX_ORDER {
     public static void main(String[] args){
    	 Scanner in= new Scanner(System.in);
    	 int n=in.nextInt();
    	 in.nextLine();
    	 while(n-->0){
    		 String str = in.nextLine();
    		 for(int i =0;i<str.length();i++){
    			 for(int j=i+1;j<=str.length();j++){
    				 String substr = str.substring(i,j);
    				 System.out.println(sortS(substr));
    			 }
    		 }
    	 }
     }
     static String sortS(String s){
    	 char[] ch = s.toCharArray();
    	 Arrays.sort(ch);
    	 return new String(ch);
     }
}
