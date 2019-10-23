/*
ID: ekgnlql1
LANG: JAVA
TASK: ariprog
*/

import java.util.*;
import java.io.*;

class ariprog{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		

		int n = Integer.parseInt(in.readLine());	//the length of progressions 
		int m = Integer.parseInt(in.readLine());	//upper bound to limit the search
		
		int diff_max = 2*m*m/(n-1);
		//System.out.println(diff_max);
		ArrayList<Integer> list = new ArrayList<>(); list.add(0);
		int[] X = new int[2*m*m+1];
		
		
		//find all possible bisquares 
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <=i; j++){
				X[i*i + j*j] = 1;
			}
		}
		
		boolean none = true;
		
		//find the sequence that has the length of n
		for(int diff = 1; diff <= diff_max; diff++){
			for(int j = 0; j+diff*(n-1) <= 2*m*m; j++){
				boolean check = true;
				//increment the coefficient of difference
				for(int i = 0; i < n; i++){
					int k = j+ diff*i;
					if(k > 2*m*m || X[k] == 0){
						check = false;
						break;
					}
				}
				if(check){
					out.println(j +" " +diff);
					none = false;
				}
			}
		}
		
		if(none) out.println("NONE");
		out.close();
	}
	
}