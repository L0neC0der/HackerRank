import java.util.*;
import java.io.*;

public class SORTED_ARRAY {
		public static void rev(int[] arr,int l ,int r){
			int a[] = new int[r-l+1];
			int tempL= l;
			for(int i = 0;i<=r-l;i++){
				a[i]=arr[tempL];
				tempL++;
			}
			for(int i = l ;i<=r;i++){
				arr[i]=a[r-i];
			}
		}
		public static void main(String[] args){
			Scanner in  = new Scanner (System.in);
			int n = in.nextInt();
			int[] arr = new int[n+2];
			arr[0]= -1;
			arr[n+1] = 100000001;
			for(int i = 1;i<n+1;i++){
				int no = in.nextInt();
				arr[i] = no;
			}
			int[] inversion = new int[n+2];
			for(int i= 1 ;i <n+1;i++){
				if(arr[i]<arr[i+1] && arr[i]<arr[i-1]){
					inversion[i]=-1;
				}
				if(arr[i]>arr[i+1] && arr[i]>arr[i-1]){
					inversion[i]=1;
				}
			}
			int countP=0,countN = 0,l1=-1,r1=-1,l2=-1,r2=-1;
			for(int i=1;i<n+1;i++){
				if(countN==3 || countP==3){
					break;
				}
				if(inversion[i]==1){
					if(l1==-1){
						l1=i;
						countP++;
					}else{
						l2=i;
						countP++;
					}
				}
				if(inversion[i]==-1){
					if(r1==-1){
						r1=i;
						countN++;
					}else{
						r2=i;
						countN++;
					}
				}
			}
			if(countN==3 || countP==3){
				System.out.println("no");
			}
			else{
				if(countN==0 && countP==0){
					System.out.println("yes");
				}
				else{
					if(countN==1 && countP==1){
						rev(arr,l1,r1);
						boolean ch = true;
						for(int i= 0 ;i <n+1;i++){
							if(arr[i]>arr[i+1] ){
								ch =false;
								System.out.println("no");
								break;
							}
						}
						if(ch){
							if(r1-l1<=2){
								System.out.println("yes");
								System.out.println("swap "+l1+" "+r1);
							}
							else{
								System.out.println("yes");
								System.out.println("reverse "+l1+" "+r1);
							}
						}
					}
					else{
						int faltu = arr[l1];
						arr[l1]=arr[r2];
						arr[r2]=faltu;
						boolean ch = true;
						for(int i= 0 ;i <n+1;i++){
							if(arr[i]>arr[i+1] ){
								ch =false;
								System.out.println("no");
								break;
							}
						}
						if(ch){
							System.out.println("yes");
							System.out.println("swap "+l1+" "+r2);
						}
						
					}
				}
			}
		}
}
