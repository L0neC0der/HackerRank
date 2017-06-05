import java.util.*;
import java.io.*;

class NodePar implements Comparable<NodePar>{
	int n,cost;
	public NodePar(int n,int cost){
		this.n=n;
		this.cost=cost;
	}
	public int compareTo(NodePar o){
		return ((Integer)this.cost).compareTo((Integer)o.cost);
	}
}
public class ICE_CREAM_PARLOR {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			ArrayList<NodePar> pQ = new ArrayList<NodePar>();
			for (int i = 1; i <= n; i++) {
				int cost = in.nextInt();
				NodePar temp = new NodePar(i, cost);
				pQ.add(temp);
			}
			Collections.sort(pQ);
			int[] arr = new int[pQ.size()];
			for (int i = 0; i < pQ.size(); i++) {
				arr[i]= pQ.get(i).cost;
			}
			for (int i = 0; i < pQ.size(); i++) {
               int q = m-pQ.get(i).cost;
               int ret = bSearch(pQ,q);
               if(ret == -1){
            	   continue;
               }
               else{
            	   int a = pQ.get(i).n;
            	   if(a==ret){
            		   continue;
            	   }
            	   if(a<ret){
            		   System.out.println(a+" "+ret);  
            	   }
            	   else{
            		   System.out.println(ret+" "+a);
            	   }
            	   break;
               }
			}
		}
	}
	static int bSearch(ArrayList<NodePar> arr,int s){	
		int ret =-1;
		int start = 0, end = arr.size()-1,mid=(start+end)/2;		
		while(start<=end){
			mid = (start+end)/2;
			if(s==arr.get(mid).cost){
				return arr.get(mid).n;
			}
			else if(s<arr.get(mid).cost){
				end = mid-1;
			}
			else if(s>arr.get(mid).cost){
				start = mid+1;
			}
		}
		
		return ret;
	}
}
