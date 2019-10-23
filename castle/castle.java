/*
ID: ekgnlql1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

class castle{
	static int[][] floor, visited;
	static int[] rs;	//roomsize
	static int counter = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("castle.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		
		//input M and N
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		//store all inputs into 2-dimensional array
		floor = new int[N+1][M+1];
		visited = new int[N+2][M+2];
		rs = new int[N*M+1];
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(fin.readLine());
			for(int j = 1; j <= M; j++){
				floor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int roomno = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= M; j++){
				//System.out.println("visited: "+ visited[i][j]);
				if(visited[i][j] == 0) {
					sizeOfRooms(i,j,++roomno);
				}
			}
		}
		
		fout.println(roomno);
		
		for(int i = 1; i < rs.length; i++){
			max = (max > rs[i])? max : rs[i];
		}
		fout.println(max);
		
		max = 0;
		int X = 0; int Y = 0;
		char c = ' ';
		
		for(int i = N; i >= 1; i--){
			for(int j = 1; j <= N; j++){
				if(floor[i][j]/2 % 2 != 0 && visited[i][j] != visited[i-1][j]){
					if(rs[visited[i][j]]+rs[visited[i-1][j]] > max){
						max = rs[visited[i][j]]+rs[visited[i-1][j]];
						X = i; Y = j; c = 'N';
					}
				}
				
				if(floor[i][j]/4 % 2 != 0 && visited[i][j] != visited[i][j+1]){
					if(rs[visited[i][j]]+rs[visited[i][j+1]] > max){
						max = rs[visited[i][j]]+rs[visited[i][j+1]];
						X = i; Y = j; c = 'E';
					}
				}
			}
		}
		 
		fout.println(max);
		fout.println(X+" "+Y+" "+c);
		

		
		fout.close();
	} 
	
	
	
	static void sizeOfRooms(int i , int j, int roomno){
		//base case
		if(visited[i][j] != 0) return;
		
		int num = floor[i][j];
		visited[i][j] = roomno;
		rs[roomno]++;
		
		//System.out.println("num: "+num+" "+"i: "+i+" "+"j: "+j+" "+"visited: "+ roomno);
		
		//check neighbors: west, north, east, south
		if(num % 2 == 0) sizeOfRooms(i,j-1, roomno);
		if((num/2) %2 == 0) sizeOfRooms(i-1, j, roomno);
		if((num/4) %2 == 0) sizeOfRooms(i, j+1, roomno);
		if((num/8) %2 == 0) sizeOfRooms(i+1, j ,roomno);
		
		return;
		
	}
	
	static int checkNeighbors(int i, int j, int N, int M){
		int num = visited[i][j];
		int size = rs[num];
		int best = 0;
		int cap;
		
		//check all direction: W,E,N,S
		if(j-1 >= 0 && num != visited[i][j-1]){
			best = rs[visited[i][j-1]];
		}
		if(i-1 >= 0 && num != visited[i-1][j]){
			cap = rs[visited[i-1][j]];
			best = (best > cap)? best : cap;
		}
		if(i+1 < N && num != visited[i+1][j]){
			cap = rs[visited[i+1][j]];
			best = (best > cap)? best : cap;
		}
		if(j+1 < M && num != visited[i][j+1]){
			cap = rs[visited[i][j+1]];
			best = (best > cap)? best : cap;
		}
		return size + best;
	}
}