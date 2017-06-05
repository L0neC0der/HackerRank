import java.util.*;
import java.io.*;

public class SHER_ARRAY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for(int i=0;i<n;i++){
				int no=in.nextInt();
				arr[i]=no;
				sum+=no;
			}
			int l=0,r=sum;
			boolean print = false;
			for(int i= 0;i<n;i++){
				r-=arr[i];
				if(l==r){
					print = true;
					break;
				}
				l+=arr[i];
				
			}
			if(print)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}

	}

}
