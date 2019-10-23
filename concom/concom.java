 
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
		//debug = new PrintWriter(new BufferedWriter(new FileWriter("debug.out")));
		int n = Integer.parseInt(fin.readLine());	//number of input triples to follow
		//PrintWriter demo = new PrintWriter(new BufferedWriter(new FileWriter("concom2.out")));
		owner = new int[101][101];
		control = new int[101][101];
		
		for(int i = 1; i < 101; i++){
			control[i][i] = 1;
		}
		
		StringTokenizer st;
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(fin.readLine());
			own(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		
		/* for(int i = 1; i < 101; i++){
			demo.println(Arrays.toString(owner[i]));
		} */
		

	
		for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i!=j && control[i][j] == 1) {
                    fout.println(i + " " + j);
                }
            }
        }
		
		//debug.close();
		//demo.close();
		fout.close();
		
		
	}
	
	static int[][] owner, control;
	static PrintWriter debug;
	
	static void own(int i, int j, int p){
		//debug.println("addOwner: "+i+" "+j+" "+p);
		//add percent amount that j owns to everything that controls i
		for(int k = 1; k < 101; k++){
			if(control[k][i] ==1)	owner[k][j] += p;
		}
		
		for(int k = 1; k < 101; k++){
			if(owner[k][j] > 50) controller(k,j);
		}
		
	}
	
	static void controller(int i, int j){
		//debug.println("addController: "+i+" "+j+" "+ control[i][j]);
		if(control[i][j]==1) return;
		
		control[i][j] = 1;
		
		for(int k = 1; k < 101; k++){
			owner[i][k] += owner[j][k];
		}
		
		for(int k = 1; k < 101; k++)	
			if(k != i && control[k][i]==1) controller(k,j);
			
		for(int k = 1; k < 101; k++){
			if(k != j && owner[i][k] > 50) controller(i,k);
		}
	}
	
	
}
