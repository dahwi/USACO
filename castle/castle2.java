/*
ID: ekgnlql1
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

class castle1{
	static int[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("castle.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		
		//input M and N
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		//store all inputs into 2-dimensional array
		int[][] floor = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(fin.readLine());
			for(int j = 0; j < M; j++){
				floor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int counter = 0;
		int max = 0;
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				//System.out.println("visited: "+ visited[i][j]);
				if(visited[i][j] == 0) {
					counter++;
					int roomsize = sizeOfRooms(i,j,floor,0);
					max = (max < roomsize)? roomsize : max;
					//System.out.println("i: "+ i+"j: "+ j+ " " + sizeOfRooms(i,j,floor,0));
				}
			}
		}
		fout.println(counter);
		fout.println(max);
		fout.close();
	} 
	
	
	
	static int sizeOfRooms(int i , int j, int[][] arr, int val){
		//System.out.println("hi");
		int res = 0;
		
		
		
		//base case
		if(i < 0 || i > arr.length-1 || j < 0 || j > arr[0].length-1 || visited[i][j] == 1) return 0;
		//System.out.println("vis: "+visited[i][j]+" i,j: "+i+" " +j);
		visited[i][j] = 1;
		
		int num = arr[i][j];
		if(num == 15) return 1;
		else if(num + val == 15) return 1;
		
		res += sizeOfRooms(i+1, j, arr, 2);
		res += sizeOfRooms(i-1, j, arr, 8);
		res += sizeOfRooms(i, j+1, arr, 1);
		res += size OfRooms(i, j-1, arr, 4);
		
		return res+1;
		
	}
}