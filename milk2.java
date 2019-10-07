/*
ID : ekgnlql1
LANG: JAVA
TASK: milk2
*/ 

import java.util.*;
import java.io.*;


class milk2 implements Comparable<milk2>{
	//Instance Variables
	public int x; 
	public int y;
	
	//Constructor
	public milk2(int a, int b){
		this.x = a;
		this.y = b;
	}
	
	//methods 
	public int compareTo(milk2 i){
		Integer a = this.x;
		Integer b = i.x;
		return a.compareTo(b);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int n = Integer.parseInt(f.readLine());
		milk2[] arr = new milk2[n];
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			milk2 k = new milk2(start, end);
			arr[i] = k;
		}
		Arrays.sort(arr);
		int MT = 0, MNT = 0;
		
		for(int i = 0; i < n; i++){
			int sTime = arr[i].x;
			int eTime = arr[i].y;
			
			//check to see if i is not out of bound and at least one cow is being milked or
			//no cows are being milked
			while(i+1 < n && eTime >= arr[i+1].x){
				eTime = Math.max(eTime, arr[++i].y);
			}
			MT = Math.max(MT, eTime - sTime);
			if(i+1< n && eTime < arr[i+1].x) MNT = Math.max(MNT, arr[i+1].x - eTime);
		}
		
		out.println(MT + " " + MNT);
		out.close();
	}
}