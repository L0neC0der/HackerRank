
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.math.BigDecimal;
// Multiplying big numbers
public class REM_FACTORS {
    
	public static void main(String[] args) {
    	/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        PrintWriter w = new PrintWriter(System.out); 
        String str=in.nextLine();
        BigInteger n = new BigInteger(str);
        BigInteger n2 = n.pow(2);
        int count=0;
        for(int i=3;i<n.intValue();i++){   
            BigInteger div = new BigInteger(Integer.toString(i));
        if(n2.remainder(div)==BigInteger.ZERO && n.remainder(div)!=BigInteger.ZERO)
            count++;
        }
         w.println(count);
         w.flush();
    }	
}
