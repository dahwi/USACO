/*
ID: ekgnlql1
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;
import java.math.*;

class hamming{
	public static void main(String[] args) throws IOException{
		Scanner fin = new Scanner(new File("hamming.in"));
		fout = new PrintWriter(new BufferedWriter(new FileWriter("hamming1.out")));
		
		N = fin.nextInt();
		B = fin.nextInt();
		D = fin.nextInt();
		maxval = 1 << B;
		nums = new int[65];
		dist = new int[maxval+1][maxval+1];
		
		for(int i = 0; i < maxval; i++){
			for(int j = 0; j < maxval; j++){
				dist[i][j] = 0;
				for(int k = 0; k < B; k++){
					if(((1 << k) & i) != ((1 << k) & j)) dist[i][j]++;
				}
			}
		}
		//for(int i = 1; i < maxval; i++)	fout.println(Arrays.toString(dist[i]));
		
		nums[0] = 0;
		findgroups(1,1);
		
		//fout.close();
	}
	
	static PrintWriter fout;
	static int N, B, D, maxval;
	static int[][] dist;
	static int[] nums;
	
	static void findgroups(int count, int index){
		int a, b;
		boolean	canuse;
		if(count == N){
			for(a = 0; a < count; a++){
				if(a % 10 == 9 || a == N-1) fout.println(nums[a]);
				else fout.print(nums[a]+" ");
			}
			fout.close();
		}
		
		for(a = index; a < maxval; a++){
			canuse = true;
			for(b = 0; b < count; b++){
				if(dist[nums[b]][a] < D){
					//System.out.println(a);
					canuse = false;
					break;
				}
			}
			if(canuse){
				//System.out.println(a);
				nums[count] = a;
				findgroups(count+1, a+1);
			}
		}
		
		
	}
}