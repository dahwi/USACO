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
		
		
		
		//find all possible bisquares in ascending order
		for(int i = 1, j = 0; i <= m; i++, j = 0){
			while(j <= i){
				int a = i*i+j*j++;
				if(!list.contains(a)) list.add(a);
				//System.out.println(a);
			}
		}
		
		Collections.sort(list);
		int res = 0;
	
		//PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("ariprog1.out")));
		//out1.println(list.toString());
		
		//System.out.println(list.size());
		
		//find the sequence that has the length of n
		for(int diff = 1; diff <= diff_max; diff++){
			for(int j = 0; j < list.size(); j++){
				int num_start = list.get(j), num = num_start, counter = 1;
				while(list.contains(num+diff)){ 
					num += diff;
					counter++;
					if(counter >= n){
						out.println(list.get(j)+" "+ diff);
						res++;
						break;
					}
				}
			}
		}
		
		if(res == 0) out.println("NONE");
		//out1.close();
		out.close();
	}
	
}