import java.util.*;
import java.io.*;

public class RICHIE_RICH {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int l=0,r=0;
		in.nextLine();
		String s = in.nextLine();
		char[] arr= s.toCharArray();
		ArrayList<Integer> bag = new ArrayList<Integer>();
        int tempK=0;
        int index = -1;
	    if(arr.length%2 == 0){
	    	 l =arr.length/2-1;
	    	 r = arr.length/2;
	    	while(l>-1 && r<arr.length ){
	    		if(arr[l] == arr[r]){
	    			l--;
	    			r++;
	    		}
	    		else{
	    			if(arr[l]>arr[r]){
	    				arr[r] = arr [l];
	    				bag.add(l);
	    				tempK++;
	    				l--;
	    				r++;
	    			}
	    			else{
	    				arr[l]=arr[r];
	    				bag.add(l);
	    				tempK++;
	    				l--;
	    				r++;
	    			}
	    		}
	    	}
	    	if(tempK>k){
	    		System.out.println(-1);
	    	}
	    	else{
	    		if(tempK == k){
	    			System.out.println(new String(arr));
	    		}
	    		else{
	    				Collections.sort(bag);	   
	    				
	    				 l=0;
	    				 r=arr.length-1;
	    				 if(!bag.isEmpty()){
			    			index = bag.get(0);
 			    			bag.remove(0);	
			    			}
	    				 
	    				  while(l<r && (k-tempK)>=1){
	    			    		if(index == l ){
	    			    			if(arr[l]=='9'){
		    			    			l++;
		    			    			r--;
		    			    			if(!bag.isEmpty()){
		    			    				index = bag.get(0);
			    			    			bag.remove(0);	
		    			    			}	    			    			
		    			    			continue;
		    			    		}
	    			    			arr[index]='9';
	    	    					arr[arr.length-1-index] = '9';
	    	    					tempK++;
	    	    					if(!bag.isEmpty()){
	    			    				index = bag.get(0);
		    			    			bag.remove(0);	
	    			    			}
	    			    		}
	    			    		else{
	    			    			if((k-tempK)>=2 ){
	    			    				if(arr[l]=='9'){
	    	    			    			l++;
	    	    			    			r--;
	    	    			    			continue;
	    	    			    		}
	    	    			    		arr[l]='9';
	    	    			    		arr[r]='9';
	    	    			    		l++;
	    	    			    		r--;
	    	    			    		tempK+=2;
	    			    			}
	    			    			else{
	    			    				l++;
	    			    				r--;
	    			    			}
	    			    		}
	    			    	}
	    				  System.out.println(new String(arr));	    			
	    		}
	    	}
	    }
	    else{
	    	 l =arr.length/2-1;
	    	 r = arr.length/2+1;
	    	while(l>-1 && r<arr.length ){
	    		if(arr[l] == arr[r]){
	    			l--;
	    			r++;
	    		}
	    		else{
	    			if(arr[l]>arr[r]){
	    				arr[r] = arr [l];
	    				bag.add(l);
	    				tempK++;
	    				l--;
	    				r++;
	    			}
	    			else{
	    				arr[l]=arr[r];
	    				bag.add(l);
	    				tempK++;
	    				l--;
	    				r++;
	    			}
	    		}
	    	}
	    	if(tempK>k){
	    		System.out.println(-1);
	    	}
	    	else{
	    		if(tempK == k){
	    			System.out.println(new String(arr));
	    		}
	    		else{
	    				Collections.sort(bag);
   
	    				
	    				 l=0;
	    				 r = arr.length-1;
	    				 if(!bag.isEmpty()){
			    			 index = bag.get(0);
 			    			bag.remove(0);	
			    			}
	    				  while(l<r && (k-tempK)>=1){
	    			    		if(index == l ){
	    			    			if(arr[l]=='9'){
		    			    			l++;
		    			    			r--;
		    			    			if(!bag.isEmpty()){
		    			    				index = bag.get(0);
			    			    			bag.remove(0);	
		    			    			}	    			    			
		    			    			continue;
		    			    		}
	    			    			arr[index]='9';
	    	    					arr[arr.length-1-index] = '9';
	    	    					tempK++;
	    	    					if(!bag.isEmpty()){
	    			    				index = bag.get(0);
		    			    			bag.remove(0);	
	    			    			}
	    			    		}
	    			    		else{
	    			    			if((k-tempK)>=2 ){
	    			    				if(arr[l]=='9'){
	    	    			    			l++;
	    	    			    			r--;
	    	    			    			continue;
	    	    			    		}
	    	    			    		arr[l]='9';
	    	    			    		arr[r]='9';
	    	    			    		l++;
	    	    			    		r--;
	    	    			    		tempK+=2;
	    			    			}
	    			    			else{
	    			    				l++;
	    			    				r--;
	    			    			}
	    			    		}
	    			    	}	    			
	    					if(k-tempK>=1){
	    						arr[arr.length/2]='9';
	    					}
	    					System.out.println(new String(arr));
	    				
	    		}
	    	}
	    }
	}
}
