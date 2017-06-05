import java.util.*;
import java.io.*;

public class ABSOLUTE_PER {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t= in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];
			HashSet<Integer> bag = new HashSet<Integer>();
			for(int i = 1;i<n+1;i++){
				bag.add(i);
			}
			boolean ch = true;
			int i = -1;
			for(int pos = 1;pos<n+1;pos++){
				i = pos - k;
				if(bag.contains(i)){
					arr[pos-1] = i;
					bag.remove(i);
				}
				else{
					i = pos + k;
					if(bag.contains(i)){
						arr[pos-1] =i;
						bag.remove(i);
					}
					else{
						ch =false;
						System.out.println(-1);
						break;	
					}

				}				
			}
			if(ch){
				for(int j =0 ; j<n;j++){
					System.out.print(arr[j]+" ");
				}
                System.out.println();
			}		
		}
	}

}
