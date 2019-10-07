/* 
ID: ekgnlql1
LANG: JAVA
TASK: transform
*/

import java.util.*;
import java.io.*;

class transform{
	public static int N;
	public static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		N = Integer.parseInt(f.readLine());
		char[][] square1 = new char[N][N];
		char[][] square2 = new char[N][N];
		
		//store all values of the original square into the array
		for(int i = 0; i < N; i++){
			String s = f.readLine();
			for(int j = 0; j < N; j++){
				square1[i][j] = s.charAt(j);
			}
		}
		
		//store all values of the transformed square into the array
		for(int i = 0; i < N; i++){
			String s = f.readLine();
			for(int j = 0; j < N; j++){
				square2[i][j] = s.charAt(j);
			}
		}
		char[][] temp = square1; int k = N;
		
		temp = rotate(temp);
		if(equals(temp, square2)){
			out.println(1);
			out.close();
			return;
		}
		temp = rotate(temp);
		if(equals(temp, square2)){
			out.println(2);
			out.close();
			return;
		}
		temp = rotate(temp);
		if(equals(temp, square2)){
			out.println(3);
			out.close();
			return;
		}
		
		temp = mirror(square1);
		if(equals(temp, square2)){
			out.println(4);
			out.close();
			return;
		}

		while(k-- > 0){
			temp = rotate(temp);
			if(equals(temp, square2)){
				out.println(5);
				out.close();
				return;
			}
		}
		if(equals(square1, square2)){
			out.println(6);
			out.close(); 
			return;
		}
		out.println(7);
		out.close();
	}
	
	public static boolean equals(char[][] c1, char[][] c2){
		for(int i = 0; i < N; i++){
			if(Arrays.equals(c1[i],c2[i])) continue;
			else return false;
		}
		
		return true;
	}
	
	public static char[][] rotate(char[][] c1){
		char[][] res = new char[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				res[j][N-i-1] = c1[i][j];
			}
		}
		return res;
	}
	
	public static char[][] mirror(char[][] c1){
		char[][] res = new char[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				res[i][j] = c1[i][N-j-1];
			}
		}
		return res;
	}
}