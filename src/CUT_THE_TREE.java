import java.io.*;
import java.util.*;

class PairNode{
	int u,v;
	public PairNode(int u,int v){
		this.u =u;
		this.v = v;
	}
}
class nodeTree{
	int val,no;
	HashMap<Integer,Integer> bag ;
	public nodeTree(int val,int no){
		this.val = val;
		this.no = no;
		bag = new HashMap<Integer,Integer>();
	}
}
class myNodeListTree extends LinkedList<nodeTree>{
	
}
class Cut_Tree{
	int v;
	myNodeListTree[] arr;
	HashSet<nodeTree> visited = new HashSet<nodeTree>();
	int ret;
	public Cut_Tree(int v){
		this.v = v;
		this.ret = 0;
		arr = new myNodeListTree[v+1];
		for(int i = 0;i<=v;i++){
			arr[i] = new myNodeListTree();
			nodeTree temp = new nodeTree(0,i);
			arr[i].add(temp);
		}		
	}
	void addEdge(int u,int v){
		arr[u].add(arr[v].getFirst());
		arr[v].add(arr[u].getFirst());
	}
	void addVal(int no,int val){
		arr[no].getFirst().val = val;
	}
	int DFS(int start){
		int i = 0,ret = 0;
		visited.add(arr[start].getFirst());
		for(nodeTree temp: arr[start]){
			int no = temp.no;
			if(i==0){
				i++;
				continue;						
			}
			if(!visited.contains(temp)){
				int neibVal = DFS(temp.no);
				ret+=neibVal;
				arr[start].getFirst().bag.put(temp.no, neibVal);
			}	
		}
		return ret+arr[start].getFirst().val;
	}
}
public class CUT_THE_TREE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),total = 0;
		ArrayList<PairNode> bag = new ArrayList<PairNode>();
		Cut_Tree t = new Cut_Tree(n);
		for(int i = 0 ;i<n;i++){
			int a = in.nextInt();
			total+=a;
			t.addVal(i+1, a);
		}
		for(int i = 0 ;i<n-1;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			bag.add(new PairNode(a,b));
			t.addEdge(a, b);
		}
		int gMin = Integer.MAX_VALUE;
		t.DFS(5);
		for(int i=0;i<bag.size();i++){
			PairNode temp = bag.get(i);
			int u = temp.u;
			int v = temp.v;
			int lMin = 0;
			if(t.arr[u].getFirst().bag.containsKey(v)){
				int valU = total-t.arr[u].getFirst().bag.get(v);
				lMin = Math.abs(valU-t.arr[u].getFirst().bag.get(v));
			}
			if(t.arr[v].getFirst().bag.containsKey(u)){
				int valV = total-t.arr[v].getFirst().bag.get(u);
				lMin = Math.abs(valV-t.arr[v].getFirst().bag.get(u));
			}
			if(lMin<gMin){
				gMin =lMin;
			}
		}
		System.out.println(gMin);
	}

}
