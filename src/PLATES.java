import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node_Plates implements Comparable<Node_Plates>{
    int no,val;
    public Node_Plates(int no ,int val){
        this.no = no;
        this.val = val;
    }
    public int compareTo(Node_Plates i){
        return ((Integer)this.val).compareTo(((Integer)i.val));
    }
}

public class PLATES {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt(),k=in.nextInt();
        int[] plus = new int[n];
        int[] min = new int[n];
        Node_Plates[] cal = new Node_Plates[n];
        for(int i = 0;i<n;i++){
            plus[i] = in.nextInt();
            min[i] = in.nextInt();
            cal[i] = new Node_Plates(i,plus[i]-min[i]);
        }
        Arrays.sort(cal);
        int ans =0 ;
        for(int i = 0;i<n;i++){
        	if(i<k){
        		ans += plus[cal[i].no];
        	}
        	else{
        		ans-=min[cal[i].no];
        	}
        }
        if(ans<0){
        	System.out.println(0);
        }
        else{
        	System.out.println(ans);
        }
    }
}
