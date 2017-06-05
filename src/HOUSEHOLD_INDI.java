import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class HOUSEHOLD_INDI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner in = new Scanner(System.in);
         int n= in.nextInt();
         double[] arr = new double[n];
         for(int i=0;i<n;i++){
        	 arr[i] = in.nextDouble();
        	}
         double ans = 0;
         DecimalFormat df = new DecimalFormat("#.00"); 
         for(int i=0;i<n;i++){
        	if(i%2==0){
        		ans =  arr[i/2];
        		System.out.print(df.format(ans)+" ");
        	}
        	else{
        		ans = (arr[i/2]+arr[(i/2)+1])/2;
        		System.out.print(df.format(ans)+" ");
        	}
         }
	}

}
