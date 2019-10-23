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
		arr = new long[sum+1][40];
		
		for(int i = 0; i < arr.length; i++){
			Arrays.fill(arr[i], -1);
		}
		
		if(N*(N+1)/2 % 2 != 0){ 
			fout.println(0);
			fout.close();
			return;
		}
		
		System.out.println(solve(0,0));
		fout.println(solve(sum, N)/2);
		
		fout.close();
		
	}
	static PrintWriter fout;
	static int N, sum;
	static long[][] arr;
	
	static long solve(int n, int k){
		if(n < 0 || k < 0) return 0;
		if(arr[n][k] != -1) return arr[n][k];
		if(n == k && k == 0) return arr[n][k] = 1;
		return arr[n][k] = solve(n, k-1) + solve(n-k, k-1);
		
	}
}