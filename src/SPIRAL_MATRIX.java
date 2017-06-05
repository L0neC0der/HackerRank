import java.util.*;
import java.io.*;
import java.math.*;
public class SPIRAL_MATRIX {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner  in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] ar = new char[n][m];
        boolean[][] ch = new boolean[n][m];
        ArrayList<Character> bag = new ArrayList<Character>();
        for(int i = 0;i<n;i++){
            String s = in.nextLine();
            ar[i] = s.toCharArray();
        }
        int rS = n-1,cS = 0;
        int rL = -1,cL = m;
        while(rL<rS && cS<cL){
           for(int i = rS;i>rL;i--){
        	   		if(ch[i][cS]==false){
        	   			bag.add(ar[i][cS]);
        	   			ch[i][cS]=true;
        	   		}                   
           }
           cS++;
            for(int i = cS;i<cL;i++){
                if(ch[rL+1][i]==false){
    	   			bag.add(ar[rL+1][i]);
    	   			ch[rL+1][i]=true;
    	   		} 
                
            }
            rL++;
            if(rS>rL){
                for(int i = rL+1;i<=rS;i++){
                    if(ch[i][cL-1]==false){
        	   			bag.add(ar[i][cL-1]);
        	   			ch[i][cL-1]=true;
        	   		} 
                }
                cL--;
            }
            if(cS<cL){
                for(int i = cL-1;i>=cS;i--){
                    if(ch[rS][i]==false){
        	   			bag.add(ar[rS][i]);
        	   			ch[rS][i]=true;
        	   		} 
                }
                rS--;
            }
        }
        boolean has = false;
        int ans =0 ;
        for(int i = 1 ;i<bag.size();i++){
            if(bag.get(i)=='#' && bag.get(i-1)!='#'){
                ans++;
                has = true;
            }
        }
        if(!has){
            ans++;
        }
        else{
            if(bag.get(bag.size()-1)!='#'){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
