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
		
		bestC = Integer.MAX_VALUE;
		visited = new int[G]; 
		
		solve(0,0,new int[N],new int[G]);
		//System.out.println(Arrays.toString(visited));
		fout.print(bestC);
		for(int i = 0; i < visited.length; i++){
			if(visited[i] == 1){ 
				int k = i+1; fout.print(" "+ k);
			}
		}
		fout.println();
		//System.out.println(index);
		//System.out.println(Arrays.toString(req));
		//for(int i = 0; i <= G;i++)	System.out.println(Arrays.toString(table[i]));
		fout.close();
	
	}
	
	static int[] req, visited;
	static int[][] table;
	static int N, G, bestC;
	
	
	static void solve(int n, int count, int[] vit, int[] vis){
		//System.out.print("n: "+n+" count: "+ count+" ");
		//System.out.println(Arrays.toString(vit));
		if(n == vis.length){
			if(!enough(req, vit)) return;
			if(better(count, vis)){
				//System.out.println(Arrays.toString(vis));
				//System.out.println("valid: "+ Arrays.toString(vit));
				bestC = count;
				visited = vis.clone();
			}				
			return;
		}
		
		
		solve(n+1, count, vit, vis);
		for(int i = 0; i < N; i++){
			vit[i] += table[n][i];
		}
		vis[n] = 1;
		solve(n+1, count+1, vit, vis);
		for(int i = 0; i < N; i++){
			vit[i] -= table[n][i];
		}
		vis[n] = 0;
		//System.out.println("n: "+n+" count: "+ count+" over");
		//System.out.println("end: "+Arrays.toString(vis));
	}
	
	static boolean better(int counter, int[] vis){
		if(counter != 0 && counter < bestC) return true;
		if(counter > bestC) return false;
		
		for(int i = 0; i < G; i++){
			if(vis[i] == 1 && visited[i] == 0) return true;
			if(vis[i] == 0 && visited[i] == 1) return false;
		}
		return false;
	}
	
	static boolean enough(int[] req, int[] b){
		//int counter = 0;
		for(int i = 1; i < req.length; i++){
			if(req[i] > b[i]) return false;
		}
		return true;
	}
}