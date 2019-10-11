
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
		
		int n   = Integer.parseInt(fin.readLine());	//number of input triples to follow
		StringTokenizer st;
		triples = new int[n][3];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(fin.readLine());
			triples[i][0] = Integer.parseInt(st.nextToken());
			triples[i][1] = Integer.parseInt(st.nextToken());
			triples[i][2] = Integer.parseInt(st.nextToken());
		}
		
		control = new int[10][10];
		
		for(int i = 0; i < n; i++){
			if(triples[i][2] > 50) control[triples[i][0]][triples[i][1]] = 1;
			else control[triples[i][0]][triples[i][1]] = triples[i][2];
		}
		for(int i = 0; i < 8; i++) System.out.println(Arrays.toString(control[i]));
		
		for(int i = 1; i < control.length; i++){
			for(int j = 1; j < control[0].length; j++){
				if(control[i][j] == 1){
					for(int k = 1; k < n+1; k++){
						if(control[j][k] == 1) control[i][k] =1;
					}
				}
			}
		}
		System.out.println();
		for(int i = 0; i < 8; i++) System.out.println(Arrays.toString(control[i]));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		
		for(int i = 1; i < control.length; i++){
			for(int j = 1; j < control[0].length; j++){
				if(control[i][j] == 1) fout.println(i+" "+j);
			}
		}
		
		fout.close();
	}
	
	static int[][] triples, control, visited;
	
	
}
