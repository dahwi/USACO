/*
ID: ekgnlql1
LANG: JAVA
TASK: wormhole
*/

import java.util.*;
import java.io.*;

class wormhole{
	static int N = 12, n;
	//one based array
	static int[] X = new int[N+1];
	static int[] Y = new int[N+1];
	static int[] partner = new int[N+1];
	static int[] next_on_right = new int[N+1];
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		n = Integer.parseInt(f.readLine());		//the number of wormholes
		
		StringTokenizer st;
		for(int i = 1; i <= n; i++){
			st = new StringTokenizer(f.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		} 
		
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				if(X[j] > X[i] && Y[i] == Y[j])
					if(next_on_right[i] == 0 || X[j]-X[i] < X[next_on_right[i]]-X[i]) next_on_right[i] = j;
			}
		}
		
		wormhole w = new wormhole();
		
		out.println(w.solve());
		out.close();
	}
	
	public int solve(){
		int i;
		int	total = 0;
		
		for(i = 1; i <= n; i++){
			if(partner[i] == 0) break;
		} 
		
		if(i > n){
			if(cycle_exist()) return 1;
			else return 0;
		}
		
		//pair with all possible other wormholes 
		for(int j = i+1; j <= n; j++){
			if(partner[j] == 0){
				partner[i] = j;
				partner[j] = i;
				//System.out.println(Arrays.toString(partner));
				total += solve();
				partner[i] = 0;
				partner[j] = 0;
			}
		}
		return total;
	} 
	
	private boolean cycle_exist(){
		for(int i = 1; i <= n; i++){
			//check whether there exists a cycle starting from i
			int pos = i;
			for(int c = 0; c < n; c++)
				pos = next_on_right[partner[pos]];
			if(pos != 0) return true; 
		}
		return false;
	}
}