/*
ID: ekgnlql1
LANG: JAVA
TASK: subset
*/

import java.io.*;
import java.util.*;

class subset{
	public static void main(String[] args) throws IOException{
		Scanner fin = new Scanner(new File("subset.in"));
		fout = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		//fout2 = new PrintWriter(new BufferedWriter(new FileWriter("subset2.out")));
		
		N = fin.nextInt();
		//System.out.println(N);
		sum = N*(N+1)/4;
		counter = 0;
		arr1 = new int[N+1];
		arr2 = new int[N+1];
		
		//int[] arr3 = new int[]{1,2,3,3,3,4,5,0};
		//arr2 = arr3;
		//System.out.println(Arrays.toString(arr2));
		//arr2 = new int[]{1,2,2,2,2,2,2,2};
		//System.out.println(Arrays.toString(arr2));
		//System.out.println(Arrays.toString(arr3));
		
		if(N*(N+1)/2 % 2 != 0){ 
			fout.println(0);
			fout.close();
			return;
		}
		c = 0;
		solve(1,0);
		//System.out.println(c);
		//fout.println(counter/2);
		//fout.close();
		//fout2.close();
	}
	static PrintWriter fout;
	static int N, sum, counter, c;
	static int[] arr1, arr2;
	
	static void solve(int start, int partSum){
		//c++;
		int i, j, k;
		//System.out.println(partSum);
		if(partSum > sum) return;
		if(partSum == sum){
			counter++;
			System.out.println("arr2: "+ Arrays.toString(arr2));
			System.out.println("arr1: "+ Arrays.toString(arr1));
			System.out.println();
			for(k = 1; k <= N; k++){
				if(arr1[k]+arr2[k] != 1) break;
			}
			if(k == N+1){ 
				fout.println(counter-1); 
				//fout.println(c); 
				fout.close(); 
				System.exit(0);
			}
			arr2 = arr1;	//this line will change arr2 as we change arr1 since they are refering to the same array
			System.out.println("arr2: "+ Arrays.toString(arr2));
			System.out.println();
			
			
			return;
		}
		
		
		//fout.println("start: "+start);
		for(i = start; i <= N; i++){
			if(partSum + i > sum) return;
			if(arr1[i] != 1){
				arr1[i] = 1;
				System.out.println("before: "+Arrays.toString(arr1));
				//j = i+1; int c1 = partSum+i;
				//fout.println(Arrays.toString(arr1)+" solve("+j+","+c1+")");
				solve(i+1, partSum+i);
				arr1[i] = 0;
				System.out.println("after: "+Arrays.toString(arr1));
			}
			//fout.println("i: "+i);
		}
		//fout.println("end: "+start);
		
	}
}