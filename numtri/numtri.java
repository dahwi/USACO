/*
ID: ekgnlql1
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;


class numtri{
	static int[][] arr = new int[1000][1000]; 
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		 
		int numLine = Integer.parseInt(fin.readLine());
		StringTokenizer st;
		//store input data into 2D array
		for(int i = 0; i < numLine; i++){
			st = new StringTokenizer(fin.readLine());
			for(int j = 0; j <= i; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] res = new int[1000][1000];
		int maxSum = 0;
		int sum = 0;
		for(int i = numLine-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				maxSum  = (arr[i][j] > arr[i][j+1])? arr[i-1][j] + arr[i][j] : arr[i-1][j] + arr[i][j+1];
				arr[i-1][j] = maxSum;	
				//fout.println("i: "+ i + " j: "+ j+" sum: "+ maxSum);
			}
		}
	
		fout.println(arr[0][0]);
		fout.close();
	}
}