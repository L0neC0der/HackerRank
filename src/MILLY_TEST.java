import java.util.*;
import java.io.*;

public class MILLY_TEST {
	public static void main(String[] args){
		 Scanner in = new Scanner(System.in);
         int t =in.nextInt();
         in.nextLine();
         while(t-->0){
        	 String s = in.nextLine();
        	 char[] arr = s.toCharArray();
        	 ArrayList<Character> del = new ArrayList<Character>();
        	 for(int i =0 ;i <arr.length;i++){       		 
        			 if(arr[i]=='m'){
            			del.add('m');            			 
            			 continue;
            		 }         		 
        			 if(arr[i]=='i'){
            			 del.add('i');
            			 continue;
            		 }         		
        			 if(arr[i]=='l'){
            			 del.add('l');
            			 continue;
            		 }         	         		
        			 if(arr[i]=='y'){
            			 del.add('y');
            		 }         		  
        	 }
        	 char[] chec = new char[del.size()];
        	 
        	
        	 if(checkInt(del)){
        		 System.out.println("Milly is Intelligent");
        	 }
        	 else{
        		 System.out.println("Milly is not Intelligent");
        	 }
         }
	}
	static boolean checkInt(ArrayList<Character> del){
		for(int i =0 ;i<del.size();i++){
   		 if(del.get(i)=='m'){
   			 for(int j = i+1;j<del.size();j++){
   				 if(del.get(j)=='i'){
       				 for(int k = j+1;k<del.size();k++){
       					 if(del.get(k)=='l'){
       						 for(int o = k+1;o<del.size();o++){
       							 if(del.get(o)=='l'){
       								 for(int p = o+1;p<del.size();p++){
       									 if(del.get(p)=='y'){
       										 return true;
       									 }
       								 }
       							 }
       						 }
       					 }
       				 }
       			 }
   			 }
   			
   		 }
   	 }
		return false;
	}
}