 
/*
ID: ekgnlql1
LANG: JAVA
PROG: concom
*/

import java.util.*;
import java.io.*;

class concom{
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("concom.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		
		int n   = Integer.parseInt(fin.readLine());	//number of input triples to follow
		StringTokenizer st;
		triples = new int[n][3];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(fin.readLine());
			triples[i][0] = Integer.parseInt(st.nextToken());
			triples[i][1] = Integer.parseInt(st.nextToken());
			triples[i][2] = Integer.parseInt(st.nextToken());
		}
		
		control = new int[101][101];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
		for(int i = 0; i < n; i++){
			if(triples[i][2] > 50) control[triples[i][0]][triples[i][1]] = 101;
			else control[triples[i][0]][triples[i][1]] = triples[i][2];
		}
		for(int i = 1; i < 51; i++) fout.println(Arrays.toString(control[i]));
		
		PrintWriter debug = new PrintWriter(new BufferedWriter(new FileWriter("concom2.out")));
		
		for(int i = 1; i < control.length; i++){
			for(int j = 1; j < control[0].length; j++){
				if(i != j && control[i][j] == 101){
					for(int k = 1; k < control[0].length; k++){
						if(control[j][k] == 101) control[i][k] = 101;
						else if(control[i][k] != 101 && control[j][k] > 0) control[i][k] += control[j][k];
						debug.println("i: "+ i+" "+"j: "+j+" "+Arrays.toString(control[i]));
					}
				}
			}
		}
		
		fout.println();
		for(int i = 1; i < 51; i++) fout.println(Arrays.toString(control[i]));
		
		
		for(int i = 1; i < control.length; i++){
			for(int j = 1; j < control[0].length; j++){
				if(i != j && (control[i][j] == 101 || control[i][j] > 50)) fout.println(i+" "+j);
			}
		}
		
		fout.close();
	}
	
	static int[][] triples, control, visited;
	
	
}
