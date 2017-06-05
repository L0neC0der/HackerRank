import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FAIR_RATIONS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        int countOdd=0,i=0,countBread=0;
        int index[]= new int[N]; 
        for(int B_i=0; B_i < N; B_i++){
        if(B[B_i]%2!=0){ 
           countOdd++;
           index[i]=B_i;
           i++;
    		}
        }
        if (countOdd%2!=0) System.out.println("NO");
        else{
         for(int B_i=0; B_i < N; B_i++){
    	 if(B[B_i]%2!=0){
    		B[B_i+1]+=1;
    		countBread+=2;
    	  }
    	}
         System.out.println(countBread);
          }
    }
}


