/*
ID: ekgnlql1
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

class prefix{
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
		Scanner fin1 = new Scanner(new BufferedInputStream(new FileInputStream("prefix.in")));
		Scanner fin = new Scanner(new File("prefix.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
			
		int i = 0;
		index = 0;
		arr = new String[200];
		//Question: why does fin.hasNext(".") return true??? if I do not do fin.next()
		/* System.out.println(fin.delimiter());
		System.out.println(fin.next());
		System.out.println(fin.hasNext("BA"));
		System.out.println(fin.hasNext("."));
		System.out.println(fin.hasNext("AB"));
		System.out.println(fin.hasNext("BBC"));
		System.out.println(fin.next());
		System.out.println(fin.hasNext(".")); */
		
		//read in the input data
		//Scanner
		long start = System.currentTimeMillis();
		String s = "";
		while((s = fin.nextLine())!= null){
			//System.out.println(s);
			if(s.equals(".")) break;
			StringTokenizer st = new StringTokenizer(s);
			while(st.hasMoreTokens()){
				arr[index++] = st.nextToken();
			}
		} 
		seq = "";
		while(fin.hasNext()){
			seq += fin.next();
		}
		
		//BufferedReader
		/* String s = f.readLine();
		while(!s.equals(".")){
			StringTokenizer st = new StringTokenizer(s);
			while(st.hasMoreTokens()){
				arr[index++] = st.nextToken();
			}
			s = f.readLine();
		}
		StringBuilder sb = new StringBuilder();
		s = f.readLine();
		while(s != null){
			sb.append(s);
			s = f.readLine();
		} */
		
		System.out.print("Time for Input reading: ");
		System.out.println(System.currentTimeMillis() - start);
		/* for(int j = index -1; j >= 0; j--){
			solve(arr[j]);
		} */
		
		//dpSolve(sb.toString(), arr);
		dpSolve(seq, arr);
		
		System.out.print("Time for solving: ");
		System.out.println(System.currentTimeMillis() - start);
		fout.println(maxLen);
		fout.close();
		
	}
	
	static String[] arr;
	static String seq;
	static int index, maxLen;
	
	static void solve(String s){
		//System.out.println("before: "+s);
		if(seq.indexOf(s) != 0) return;
		else{
			//System.out.println("after: "+s);
			maxLen = (maxLen < s.length())? s.length() : maxLen;
			for(int i = index-1; i >= 0 ; i--){
				solve(s+arr[i]);
			}
		}
	}
	
	static void dpSolve(String s, String[] arr){
		int len = s.length();
		boolean[] pos = new boolean[len];
		pos[0] = true;
		for(int i = 0; i < len; i++){
			if(pos[i]){
				//System.out.println(i);
				for(int j = 0; j < index; j++){
					int k = arr[j].length();
					if(i+k <= len && s.substring(i,i+k).equals(arr[j])){
						//System.out.println(s.substring(0,i+arr[j].length()));
						maxLen = (maxLen < i+k)? i+arr[j].length() : maxLen;
						pos[i+k] = true;
					} 
				}
			}
		}
	}
}