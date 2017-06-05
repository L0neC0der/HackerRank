import java.util.*;
import java.io.*;

class BurgerNode implements Comparable<BurgerNode>{
	int orderNo;
	int totalTime;
	public BurgerNode(int i,int t,int d){
		orderNo = i;
		totalTime = t+d;
	}
	public int compareTo(BurgerNode i){
		return ((Integer)this.totalTime).compareTo((Integer)i.totalTime);
	}
}
public class JIM_BURGERS {
        public static void main(String[] args){
        	Scanner in= new Scanner(System.in);
        	int n = in.nextInt();
        	BurgerNode[] arr  = new  BurgerNode[n];
        	for(int i =0;i<n;i++){
        		int t = in.nextInt();
        		int d = in.nextInt();
        		arr[i] = new BurgerNode(i+1,t,d);
        	}
        	Arrays.sort(arr);
        	for(int i =0 ; i<n;i++){
        		System.out.println(arr[i].orderNo);
        	}
        }
}
