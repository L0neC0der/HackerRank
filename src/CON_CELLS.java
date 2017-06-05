import java.util.*;
import java.io.*;

class Node_mat{
	int x;
	int y;
	int val;
	public Node_mat(int val,int x,int y){
		this.val= val;
		this.x=x;
		this.y=y;
	}
}
public class CON_CELLS {
    static HashSet<Node_mat> visited = new HashSet<Node_mat>();
    static Node_mat[][] arr;
    static int ans = 0, tempAns = 0,n,m;
    static void  dfs(int i,int j){
    	arr[i][j].val = -1;
		if (i - 1 >= 0 && j - 1 >= 0 && i - 1 < n && j - 1 < m) {
          if(arr[i - 1][j - 1].val == 1)
        	  dfs(i-1,j-1);    	  
		}
		if (i - 1 >= 0 && j + 1 >= 0 && i - 1 < n && j + 1 < m) {
			if(arr[i - 1][j + 1].val == 1)
	        	  dfs(i-1,j+1);
		}
		if (i - 1 >=0 && j  >= 0 && i - 1 < n && j  < m) {
			if(arr[i - 1][j ].val == 1)
	        	  dfs(i-1,j);
		}
		if (i  >=0 && j - 1 >=0 && i  < n && j - 1 < m) {
			if(arr[i ][j - 1].val == 1)
	        	  dfs(i,j-1);
		}
		if (i  >=0 && j + 1 >= 0 && i  < n && j + 1 < m) {
			if(arr[i ][j + 1].val == 1)
	        	  dfs(i,j+1);
		}
		if (i + 1 >= 0 && j - 1 >= 0 && i + 1 < n && j - 1 < m) {
			if(arr[i + 1][j - 1].val == 1)
	        	  dfs(i+1,j-1);
		}
		if (i + 1 >= 0 && j  >= 0 && i+ 1 < n && j  < m) {
			if(arr[i + 1][j ].val == 1)
	        	  dfs(i+1,j);
		}
		if (i + 1 >= 0 && j + 1 >= 0 && i + 1 < n && j + 1 < m) {
			if(arr[i + 1][j + 1].val == 1)
	        	  dfs(i+1,j+1);
		}
      tempAns++;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
         n=in.nextInt();
         m=in.nextInt();
        arr= new Node_mat[n][m];
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		int no = in.nextInt();
        		Node_mat temp = new Node_mat(no,i,j);
        		arr[i][j] = temp;
        	}
        }
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
             if(arr[i][j].val==1){
            	 tempAns=0;
            	 dfs(i,j);
            	 if(tempAns>ans){
            		 ans=tempAns;
            	 }
             }
            	
        	}
        }
        System.out.println(ans);
	}
}
