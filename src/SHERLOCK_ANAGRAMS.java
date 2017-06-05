import java.util.*;
import java.io.*;
import java.math.*;

public class SHERLOCK_ANAGRAMS {
    static boolean compare( ArrayList<Character> fi, ArrayList<Character> se){
        Collections.sort(fi);
        Collections.sort(se);
        for(int i = 0 ;i<fi.size();i++){
            if(fi.get(i)!=se.get(i)){
             return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        in.nextLine();
        while(t-->0){
            String s = in.nextLine();
            char[] ar = s.toCharArray();
            int ans = 0;
            ArrayList<Character> fi = new ArrayList<Character>();
            ArrayList<Character> se = new ArrayList<Character>();
            for(int len = 1;len<ar.length;len++){
                for(int i = 0;i<ar.length-len;i++){
                    fi.clear();
                    for(int index1 = i;index1<i+len;index1++){
                        fi.add(ar[index1]);
                    }
                    for(int j = i+1;j<=ar.length-len;j++){
                        se.clear();
                        for(int index2 = j;index2<j+len;index2++){
                        se.add(ar[index2]);
                        }
                        if(compare(fi,se)){
                           ans++; 
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
