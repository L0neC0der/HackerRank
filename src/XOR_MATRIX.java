import java.util.*;
import java.io.*;
import java.math.*;

class XOR_MATRIX {
	
	
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        long m = in.nextLong();
	        m=m-1;
	        int[][] val = new int[2][n];        
	        for(int i = 0 ; i<n;i++){
	            val[0][i] = in.nextInt();
	        }
	        if(m>0){
		        long number = m;
		        ArrayList<Long> binary = new ArrayList<Long>();
		        while(number > 0){
		            binary.add(number%2);
		            number = number/2;
		        }
		        ArrayList<Long> bag = new ArrayList<Long>();
		        ArrayList<Long> Obag = new ArrayList<Long>();
		        for(int i=binary.size()-1;i>-1;i--){
		        	if(bag.isEmpty()){
		        		bag.add(0L);
		        		bag.add((long)Math.pow(2,binary.size()-1));	    
		        		binary.remove(binary.size()-1);
		        	}
		        	else{
		        		int s = bag.size();
		        		if(binary.get(i)!=0){
		        			long pow = (long)Math.pow(2,i);
		        			for(int index = 0 ;index<s;index++){
		        				bag.add(bag.get(index)+pow);
		        			}
		        			binary.remove(i);
		        		}
		        		else{
		        			binary.remove(i);
		        		}
		        	}
		        }
		        HashSet<Long> cont = new HashSet<Long>();
		        for(long a:bag){
		        	a=a%n;
		        	if(!cont.contains(a)){
		        		cont.add(a);
		        		Obag.add(a);
		        	}
		        	else{
		        		cont.remove(a);
		        		Obag.remove(a);
		        	}
		        }
		        int hello = 0 ;
		        hello+=2;
		        for(int j=0;j<n;j++){
		        	{	
		        		int y =(int) (((long)j+Obag.get(0))%(long)n);
		        	    int xx =(int) (((long)j+Obag.get(1))%(long)n);
		        		val[1][j] = val[0][xx]^val[0][y];
		        		for(int ind = 2 ;ind <Obag.size();ind++){		        			
		        			long po = (long) Obag.get(ind);
		 	        	    int x =(int) (((long)j+po)%(long)n);
		                    val[1][j]=val[1][j]^val[0][x];
		        		}	                      
	                }  
	            } 
		           for(int i = 0 ; i<n;i++){
		            System.out.print(val[1][i]+" ");
		           }
	        }
      
	        else{
	            for(int i = 0 ; i<n;i++){
	            System.out.print(val[0][i]+" ");
	           }
	        }
	    }
}
