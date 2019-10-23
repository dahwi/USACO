/*
ID: ekgnlql1
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

class frac1 implements Comparable<frac1>{
	int x,y,z;
	static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19
	, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79};
	frac1(int denom, int num, int val){
		x = denom;
		y = num;
		z = val;
	}
	
	public int getDenom(frac1 f){
		return f.x;
	}
	
	public int getNum(frac1 f){
		return f.y;
	}
	
	public int compareTo(frac1 i){
		Integer a = i.z;
		Integer b = this.z;
		
		if(this.y*i.x > this.x*i.y) return 1;
		else if(this.y * i.x == this.x * i.y) return 0;
		else return -1;
		//return b.compareTo(a);
	}
	
	public String toString(){
		return Integer.toString(this.y)+"/"+Integer.toString(this.x);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		
		int n = Integer.parseInt(fin.readLine());
		//int[][] arr = new int[n+1][n+1];
		//arr[1][0] = 1; arr[1][1] = 1; //arr[2][1] = 80;
		fout.println("0/1");
		 
		ArrayList<frac1> list = new ArrayList<>();
		
		for(int denom = 2; denom <= n; denom++){
			for(int num = 1; num < denom; num++){
				if(num == 1 || relativelyPrime(denom, num)){
					//System.out.println(denom+" and "+num+ " are relatively prime");
					//arr[denom][num]  = 160*num/denom;
					list.add(new frac1(denom, num, 160*num/denom));
				}
				//else System.out.println(denom+" and "+num+ " are not relatively prime");
			}
		}
		
		Collections.sort(list);
		//System.out.println(list.toString());
		//for(int i = 0; i <= n; i++) System.out.println(Arrays.toString(arr[i]));
		for(frac1 f: list) fout.println(f.toString());
		fout.println("1/1");
		fout.close();
	}
	
	static boolean relativelyPrime(int i, int j){
		for(int k = 0; k < prime.length; k++){
			int d = prime[k];
			if(d > j) break;
			if(i % d == 0 && j % d == 0) return false;
		}
		return true;
	}
}