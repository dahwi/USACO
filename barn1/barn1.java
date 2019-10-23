/*
ID: ekgnlql1
LANG: JAVA
TASK: barn1
*/

import java.util.*;
import java.io.*;

class barn1{
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int M = Integer.parseInt(st.nextToken());	//maximum number of boards that can be purchased
		int S = Integer.parseInt(st.nextToken());	//total number of stalls
		int C = Integer.parseInt(st.nextToken());	//number of cows in the stalls
		
		int boardNum = 0, stallsBlocked = C;
		int arr[] = new int[C];
		for(int i = 0; i < C; i++){
			arr[i] = Integer.parseInt(f.readLine());
		}
		 
		Arrays.sort(arr);
		
		//store the index difference between occupied stalls
		ArrayList<Integer> diff = new ArrayList<>();	
		for(int i = 0; i < C-1; i++){
			int d = arr[i+1]-arr[i];
			if(d > 1) diff.add(d);
		}
		
		Collections.sort(diff);
		
		boardNum = diff.size()+1;
		
		
		while(boardNum > M){
			boardNum--;
			//get the smallest difference and cover the stalls with the block including the gap
			int d = diff.remove(0);
			//the reason for subtracting 1 from the difference is that we count all the occupied stalls in the beginning, so we just add the unoccupied ones.
			stallsBlocked += d-1;
		}
		
		
		fout.println(stallsBlocked);
		fout.close();
	}
}