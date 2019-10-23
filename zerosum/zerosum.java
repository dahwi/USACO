/*
ID: ekgnlql1
LANG: JAVA
TASK: zerosum
*/

import java.util.*;
import java.io.*;

class zerosum{
	private static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("zerosum.in"));
		fout = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		N = Integer.parseInt(fin.readLine());
		dfs(1,0,1,1,"1");
		fout.close();
	}
	
	private static PrintWriter fout;
	
	static void dfs(int n, int sum, int num, int sign, String s){
		//System.out.println("n: "+n+" sum: "+sum+" num: "+num+ " string: "+ s);
		if(n == N){
			if(sum + sign*num == 0) fout.println(s);
			return;
		}
		
			n++;
			dfs(n, sum, num*10+n, sign, s+" "+n);
			dfs(n, sum+sign*num, n, 1, s+"+"+n);
			dfs(n, sum+sign*num, n, -1, s+"-"+n);
	}	
}