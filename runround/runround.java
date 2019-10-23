/*
ID: ekgnlql1
LANG: JAVA
TASK: runround
*/

import java.io.*;
import java.util.*;

class runround{
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("runround.in"));
		fout = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		
		M = Integer.parseInt(fin.readLine());
		for(int i = M+1; i <= Integer.MAX_VALUE; i++){
			String s = Integer.toString(i);
			if(solve(s, s.length(), new int[10])) break;
		}
		
		
		fout.close();  
	}
	
	static PrintWriter fout;
	static int M;

	static boolean solve(String s, int len, int[] visited){
		//System.out.println(s);
		int i = 0;
		int start = s.charAt(0)-'0';//Character.getNumericValue(s.charAt(0));
		int num = start;
		int counter = len;
		while(counter-- > 0){
			//System.out.println(counter);
			if(visited[num] != 1) visited[num] = 1;
			else if(visited[num] == 1) return false;
			//System.out.println("n: "+ num);
			//System.out.println("num: "+s.charAt(i)+" shift: "+s.charAt((i+num)%len));
			if(s.charAt(i) == s.charAt((i+num)%len)){
				return false;
			}
			i = (i+num)%len;
			num = s.charAt(i)-'0';
			//System.out.println("i: "+i+" chg: "+ num);
			if(num == start) break;
			 
		}
		//System.out.println(counter);
		if(counter == 0){
			fout.println(s);
			return true;
		}
		return false;
	}
}
