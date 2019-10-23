/*
ID: ekgnlql1
LANG: JAVA
TASK: nocows
*/

import java.util.*;
import java.io.*;

class nocows{
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("nocows.in"));
		String input = fin.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());	//3 <= N <= 200
		K = Integer.parseInt(st.nextToken());	//1 < K < 100
		
		//output 
		fout = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		
		tree = new long[N+1][K+1];
		for(int i = 0; i < tree.length; i++){
			Arrays.fill(tree[i], -1);
		}
		
		//tree[1][1] = 1;

		fout.println(solve(N,K));
	
		fout.close();
		
		/* for(int i = 0; i < tree.length; i++){
			System.out.println(Arrays.toString(tree[i]));
		} */
		
	}
	
	static int N,K;
	static long[][] tree;
	static PrintWriter fout;
	
	static long solve(int N, int K){
		if(tree[N][K] != -1){
			//System.out.println("1n: " + N+" k: "+ K+ " "+ tree[N][K]);
			return tree[N][K];
		}
		
		if(N %2 == 0|| N < 1 || K < 1 || 2*K -1 > N){
			//System.out.println("2n: " + N+" k: "+ K+ " "+ tree[N][K]);
			return tree[N][K] = 0;
		}
		
		if(N == 1){
            if(K == 1) return tree[N][K] = 1;
            return tree[N][K] = 0;
        }
		
		tree[N][K] = 0;
		
		for(int i = 1; i < N-1; i +=2){
			int temp = N-i-1;
			for(int j = 1; j < K-1; j++){
				tree[N][K] += solve(i, K-1)*solve(temp, j);  
				tree[N][K] += solve(i, j)*solve(temp, K-1);
			}
			tree[N][K] += solve(i,K-1)*solve(temp, K-1);
		}
		
		//System.out.println("3n: " + N+" k: "+ K+ " "+ tree[N][K]);
		return tree[N][K] = tree[N][K]%9901;
		
	}	
}