import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.text.*;

class Node_PF{
	int k;
	String x,y,z;
	public Node_PF(int k,String x,String y,String z){
		this.k = k;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class POINT_FILTERING {
    public static void main(String[] args){
    	HashMap<Double,Node_PF> zHash = new HashMap<Double,Node_PF>();
    	HashMap<Integer,Node_PF> kHash = new HashMap<Integer,Node_PF>();
    	HashSet<Integer> bSet = new HashSet<Integer>();
    	Scanner in = new Scanner(System.in);
    	
    	int n = in.nextInt();
    	int b = in.nextInt();
    	
    	Double[] arr = new Double[n];
    	for(int i =0;i<n;i++){
    		int k = in.nextInt();
    		String tt = in.nextLine();
    		String[] pa = tt.split(" ");
    		String x = pa[1];
    		String y = pa[2];
    		String z = pa[3];
    		Node_PF temp = new Node_PF(k,x,y,z);
    		arr[i] = Double.parseDouble(z);
    		zHash.put(Double.parseDouble(z), temp);
    		kHash.put(k, temp);
    	}
    	Arrays.sort(arr,Collections.reverseOrder());
    	int pointer = 0;
    	for(int i = 0; i<b;i++){
    		bSet.add(zHash.get(arr[i]).k);
    		pointer++;
    	}
    	
    	while(in.hasNextLine()){
    		String com = in.nextLine();
    		String [] parts = com.split(" ");
    		int id = Integer.parseInt(parts[1]);
    		com = parts[0].toLowerCase();
    		if(com.equals("f")){
    			if(bSet.contains(id)){
    				BigDecimal bdX = new BigDecimal(kHash.get(id).x);
    				BigDecimal bdY = new BigDecimal(kHash.get(id).y);
    				BigDecimal bdZ = new BigDecimal(kHash.get(id).z);
    			    bdX = bdX.setScale(3, BigDecimal.ROUND_HALF_UP);
    			    bdY = bdY.setScale(3, BigDecimal.ROUND_HALF_UP);
    			    bdZ = bdZ.setScale(3, BigDecimal.ROUND_HALF_UP);
    				System.out.println(id+
    						" = ("+bdX+","+bdY+","+bdZ+")");
    			}
    			else{
    				System.out.println("Point doesn't exist in the bucket.");
    			}
    		}
    		else{
    			if(!bSet.contains(id)){
					System.out.println("Point doesn't exist in the bucket.");
				}    			
    			else{
    				if(pointer == n){
        				System.out.println("No more points can be deleted.");
        			}    				
    				else{
    					bSet.remove(id);
    					bSet.add(zHash.get(arr[pointer]).k);
    					pointer++;
    					System.out.println("Point id "+id+" removed.");
    				}
    			}
    		}
    	}
    }
}
    
