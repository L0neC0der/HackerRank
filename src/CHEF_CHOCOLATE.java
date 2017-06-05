import java.util.*;
import java.io.*;
import java.lang.*;

public class CHEF_CHOCOLATE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);

        	int n = in.nextInt(), m = in.nextInt();            
            int size =(n>m?n:m);
            int[][] mat = new int[size+1][size+1];
            for(int i = 1;i<=size;i++){
            	for(int j=1;j<=i;j++){
            		mat[i][j]=getWin(mat,i,j);
            		mat[j][i]= mat[i][j];
            	}
            }
     System.out.print("  ");   
     for(int i=1;i<=size;i++){
    	 if(i/10==0){
    		 System.out.print(" 0"+i);
    	 }
    	 else
    	  System.out.print(" "+i);
     }
     System.out.println();
     for(int i=1;i<=size;i++){
    	 System.out.print(i+" ");
    	 for(int j=1;j<=size;j++){
    		 System.out.print("  "+mat[i][j]);
    	 }
    	 System.out.println();
     }
        	
        
	}
  public static int getWin(int[][] mat,int n ,int m){
	  int winner = 2;
	  if(n==1 && m==1){
		  return 2;
	  }
	  for(int i=1;i<n;i++){
		  if(winner ==1 ){
			  break;
		  }
		  if(mat[i][m]==1 || mat[n-i][m]==1){
			  winner =2;
		  }
		  if(mat[i][m]==2 && mat[n-i][m] == 2){
			  winner = 1;
		  }
	  }
	  if(winner!=1){
		  for(int j = 1;j<m;j++){
			  if(winner ==1){
				  break;
			  }
			  if(mat[n][j]==1 || mat[n][m-j]==1){
				  winner =2;
			  }
			  if(mat[n][j]==2 && mat[n][m-j] == 2){
				  winner = 1;
			  }
		  }
	  }
	   return winner;
  }
}
