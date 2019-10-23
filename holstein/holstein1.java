/*
ID: ekgnlql1
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;
class holstein{
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		
		N = Integer.parseInt(fin.readLine());	//number of types of vitamins
		
		req = new int[N];		//minimum req for each type of vitamin
		StringTokenizer st = new StringTokenizer(fin.readLine());
		for(int i = 0; i < N; i++){
			req[i] = Integer.parseInt(st.nextToken());
		}
		
		G = Integer.parseInt(fin.readLine());	//types of feeds available
		table = new int[G][N];	//amount of each vitamin that one scoop of each feed contains
		
		for(int i = 0; i < G; i++){
			st = new StringTokenizer(fin.readLine());
			for(int j = 0; j < N; j++){
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bestC = G+1;
		bestF = new int[G]; 
		curF = new int[G];
		
		solve(0,0);

		
		//System.out.println(Arrays.toString(visited));
		fout.print(bestC);
		for(int i = 0; i < bestC; i++){
			int k = bestF[i]+1;
			fout.print(" "+k);
		}
		fout.println();
		
		fout.close();
	
	}
	
	static int[] req, bestF, curF;
	static int[][] table;
	static int N, G, bestC;
	
	
	/**
	n is the number of feeds in the current mixture
	count is the identifier of the first feed to try adding
	**/
	static void solve(int n, int count){
		System.out.print("n: "+n+" count: "+ count+" ");
		System.out.println(Arrays.toString(req));
		int i;
		for(i = 0; i < N; i++)
			//check if the requirement has been met
			if(req[i] > 0) break;
		if(i == N){
			//System.out.println(Arrays.toString(vis));
			//System.out.println("valid: "+ Arrays.toString(vit));
			bestC = count;
			for(i = 0; i < bestC; i++)
				bestF[i] = curF[i];
			return;
		}
		
		//Add each feed to the mixture
		//count+1<bestC ensures that we stop if there is no hope in finding a better solution
		while(n < G && count+1 < bestC){
			//add the vitamins from this feed
			for(i = 0; i < N; i++)
				req[i] -= table[n][i];
			curF[count] = n;	//indicate that we used this feed
			System.out.println(Arrays.toString(curF));
			solve(n+1, count+1);
			//undo 
			for(i = 0; i < N; i++)
				req[i] += table[n][i];
			n++;
		}
		System.out.println("n: "+n+" count: "+ count+" over");
		System.out.println("end: "+Arrays.toString(req));
	
	}
}