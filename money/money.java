/*
ID: ekgnlql1
LANG: JAVA
PROG: money
*/

import java.util.*;
import java.io.*;

class money{
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("money.in"));
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int V = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		int[] coin = new int[V];
		String s; int index = 0;
		while( (s=fin.readLine()) != null){ 
			st = new StringTokenizer(s);
			while(st.hasMoreTokens()) coin[index++] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(coin));
		long [] arr = new long[N+1];
		arr[0] = 1;
		for(int i = 0; i < V; i++){
			for(int j = 1; j <= N; j++){
				if(j >= coin[i]) arr[j] += arr[j - coin[i]];
				else continue;
				//System.out.println(Arrays.toString(arr));
			}
			//System.out.println("final: "+Arrays.toString(arr));
		}
		fout.println(arr[N]);
		fout.close();
	}
}