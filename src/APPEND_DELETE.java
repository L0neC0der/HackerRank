import java.util.*;
import java.io.*;

public class APPEND_DELETE {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String sS = in.nextLine();
		String tS = in.nextLine();
		int k = in.nextInt();
		char[] s = sS.toCharArray();
		char[] t = tS.toCharArray();
		int count = 0 ,index = -1;
		boolean bre = false;
		for(int i = 0 ;i < (int)Math.min(s.length, t.length);i++){
			if(s[i]!=t[i]){
				count+=(s.length-i)+(t.length-i);
				index = i;
				bre =true;
				break;
			}
		}
		if (bre == false) {
			count += Math.abs(s.length - t.length);
		}
		if (count < k) {
			if ( index == 0) {
				System.out.println("Yes");
			}
			else{
				if(index == -1){
					if(k>count+2*(Math.min(s.length, t.length))){
						System.out.println("Yes");
					}
					else{
						if((count%2==0 && (k)%2==0) ||(count%2!=0 && (k)%2!=0) ){
							System.out.println("Yes");
						}
						else{
							System.out.println("No");
						}
					}
				}
				else{
					if(k>count+2*(s.length-index+1)){
						System.out.println("Yes");
					}
					if((count%2==0 && (k)%2==0) ||(count%2!=0 && (k)%2!=0) ){
						System.out.println("Yes");
					}
					else{
						System.out.println("No");
					}
				}
				
			}
		}
		else{
			if(count==k){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
		}
	}
}
