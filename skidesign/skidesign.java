/*
ID: ekgnlql1
LANG: JAVA
TASK: skidesign
*/

import java.util.*;
import java.io.*;

class skidesign{
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		n = Integer.parseInt(f.readLine());		//the number of hills
		
		
		int[] X = new int[n];
		for(int i = 0; i < n; i++){
			X[i] = Integer.parseInt(f.readLine());
		}
		
		
		Arrays.sort(X);
		int totalCost = Integer.MAX_VALUE;
		int count = 0;
		
		for(int i = 0; i + 17 <= X[n-1]; i++){

			int cost = 0, x;
			for(int j = 0; j < n; j++){
				if(X[j] < i) x = i - X[j];
				else if(i <= X[j] && X[j] <= i+17) x = 0;
				else x = X[j]-i-17;
				cost += x*x;
			}
			totalCost = Math.min(totalCost,cost);
		}
		out.println(totalCost);
		out.close();
	}
}