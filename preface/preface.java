/*
ID: ekgnlql1
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

class preface{
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("preface.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		
		N = Integer.parseInt(fin.readLine());
		letter = new String[]{"I","V","X","L","C","D","M"};
		num = new int[]{1,5,10,50,100,500,1000};
		
		freq = new int[13];
		letters = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		nums = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
		
		
		/* I = 1;
		V = 5;
		X = 10;
		L = 50;
		C = 100;
		D = 500;
		M = 1000; */
		
		for(int i = 1; i <= N; i++){
			solve(i);
		}
		
		for(int i = 0; i < 13; i++){
			if(freq[i] > 0){
				fout.println(letters[i] +" "+freq[i]);
			}
		}	
		fout.close();
	}
	
	static int N;
	static int[] freq, num, nums;
	static String[] letter, letters;
	//static int I, V, X, L, C, D, M;
	
	 
	static void solve(int n){
		int i; 
		//System.out.print("n: "+ n+" ");
		for(i = nums.length-1; i >= 0; i--){
		if(n <= 0) return;//System.out.println(); //System.out.println(Arrays.toString(freq));}
			while(n >= nums[i]){
				n -= nums[i];
				//System.out.print(letters[i]); 
				if(i % 2 == 0) freq[i]++;
				else if(i % 4 == 3){
					freq[i+1]++;
					freq[i-3]++;
				}
				else{
					freq[i-1]++; freq[i+1]++;
				}
			}
		}
		//System.out.println();
		//System.out.println(Arrays.toString(freq));
	}
}