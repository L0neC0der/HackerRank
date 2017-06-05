import java.util.Scanner;


public class NON_DIVISIBLE_SUBSET {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        int k = in.nextInt();
        int[] remainder = new int[k];
        for(int i = 0 ;i <n;i++){
            remainder[in.nextInt()%k] +=1; 
        }
        if(k%2==0 && remainder[k/2]>0){
            remainder[k/2] = 1;
        }
        int ans = 0;
        for(int i= 1;i<=k/2;i++){
            ans+=(remainder[i]>remainder[k-i]?remainder[i]:remainder[k-i]);
        }
        if(remainder[0]>0){
            remainder[0] = 1;
        }
        ans+=remainder[0];
        System.out.println(ans);
    }
}
