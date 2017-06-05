import java.util.*;
import java.io.*;


class Node_BFS{
	int no;
	int dist;
	public Node_BFS(int no ,int dist){
		this.no = no;
		this.dist= dist;
	}
}
class myNodeListBFS extends LinkedList<Node_BFS>{
	
}

class Graph_BFS{
	myNodeListBFS[] Nodes;
	int V;
	public Graph_BFS(int V){
		this.V=V;
		Nodes =new myNodeListBFS[V+1];
		for(int i=0;i<V+1;i++){
			Nodes[i] =new myNodeListBFS();
		}
		for(int i=1;i<V+1;i++){
			Node_BFS temp = new Node_BFS(i,Integer.MIN_VALUE);
			Nodes[i].add(temp);
		}
	}
	void addEdge(int u,int v){
		Nodes[u].add(Nodes[v].getFirst());
		Nodes[v].add(Nodes[u].getFirst());
	}
	int[] bfs(int start){
		int[] ret = new int[V+1];
		Arrays.fill(ret, -1);		
		ArrayList<Node_BFS> q = new ArrayList<Node_BFS>();
		Nodes[start].getFirst().dist=0;
		q.add(Nodes[start].getFirst());
		while(!q.isEmpty()){
			Node_BFS curr = q.get(0);
			q.remove(0);
			int i =0;
			for(Node_BFS nei :Nodes[curr.no]){
						
				if(i==0){
					i++;
					continue;	
				}	
                if(ret[nei.no]!=-1){
				continue;	
				}
				q.add(nei);
				if(ret[nei.no]==-1){
					nei.dist = curr.dist+6;
					ret[nei.no]=nei.dist;
				}
				i++;
			}
		}
		return ret;
	}
}

public class BFS_SHORT_PATH {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              Scanner in = new Scanner(System.in);
              int  q= in.nextInt();
              
              while(q-->0){            	 
	            int n = in.nextInt();
	            int e = in.nextInt();
	            Graph_BFS g = new Graph_BFS(n);
	            for(int i = 0 ;i <e;i++){
	            	g.addEdge(in.nextInt(), in.nextInt());
	            }
	            
	            int start=	in.nextInt();
	            int[] print = g.bfs(start); 
           	    for(int i = 1; i<print.length;i++){
           		 if(i==start)
           			 continue;
           		 System.out.print(print[i]+" ");
           	   }
           	 System.out.println();
	       
              }

	    }

}
