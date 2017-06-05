import java.util.*;
import java.io.*;
import java.math.*;
 class NodeKruskal{
    int rank;
    NodeKruskal parent;
    int val;
    public NodeKruskal(int r,int v){
        rank = r;
        val = v;
        parent = this;
    }
}
 class EdgeKruskal implements Comparable<EdgeKruskal>{
	 int start,end,weight;
	 public EdgeKruskal(int start,int end,int weight){
		 this.start = start;
		 this.end = end;
		 this.weight = weight;
	 }
	 public int compareTo(EdgeKruskal i){
		 return ((Integer)this.weight).compareTo((Integer)i.weight);
	 }
 }
 class DisjointUnionKruskal{
    HashMap<Integer,NodeKruskal> map ;
    public DisjointUnionKruskal(){
        map = new HashMap<Integer,NodeKruskal>();
    }
    public void addSet(int i){
    	map.put(i,new NodeKruskal(0,i));
    }
    public NodeKruskal getParent(NodeKruskal curr){   	   	
    	if(curr.parent == curr){
    		return curr;
    	}
    	else{
    		curr.parent = getParent(curr.parent);
    	}
    	return curr.parent;
    }
   public void union(NodeKruskal p1,NodeKruskal p2){
	   if(p1.rank>=p2.rank){
		   p1.rank=(p1.rank==p2.rank?p1.rank+1:p1.rank);
		   p2.parent = p1;
	   }
	   else{
		   p1.parent = p2;
		   p2.rank = p2.rank+1;
	   }
   }
    
}
public class KRUSKAL {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		DisjointUnionKruskal dj = new DisjointUnionKruskal();
		for(int i = 1;i<=n;i++){
			dj.addSet(i);
		}
		EdgeKruskal[] arr = new EdgeKruskal[m];
		for(int i = 0 ; i<m;i++){
			int s = in.nextInt();
			int e = in.nextInt();
			int w = in.nextInt();
			EdgeKruskal ed = new EdgeKruskal(s,e,w);
			arr[i] = ed;
		}
		Arrays.sort(arr);
		int start = in.nextInt();
		long ans = 0;
		for(int i = 0 ; i<m ;i++){
			int s = arr[i].start;
			int e = arr[i].end;
			NodeKruskal p1 = dj.getParent(dj.map.get(s)) ,p2 = dj.getParent(dj.map.get(e));
			if(p1.equals(p2)){
				continue;
			}
			else{
				ans+=arr[i].weight;
				dj.union(p1, p2);
			}
		}
		System.out.println(ans);
	}
}
