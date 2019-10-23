/*
ID: ekgnlql1
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.*;

class lamps{
	public static void main(String[] args) throws IOException{
		Scanner fin = new Scanner(new File("lamps.in"));
		fout = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		
		N = fin.nextInt();
		C = fin.nextInt();
		result = new int[7];
		check = new int[8];
		Arrays.fill(result, -1);
		On = new int[N+1];
		Off = new int[N+1];
		
		//finds out the final config of lamps that are ON from the input
		int temp = fin.nextInt();
		int loc;
		while(temp != -1){
			//On[temp%6] = 1;
			loc = (temp%6 == 0)? 6 : temp%6;
			if(result[loc] == -1) result[loc] += 2;
			temp = fin.nextInt();
		}
		//finds out the final config of lamps that are OFF from the input
		temp = fin.nextInt();
		while(temp != -1){
			//Off[temp%6] = 1;
			loc = (temp%6 == 0)? 6 : temp%6;
			if(result[loc] == -1) result[loc] += 1;
			temp = fin.nextInt();
		}
		
		for(int r = 0; r < 8; r++){
			int i;
			for(i = 1; i <= result.length-1; i++){
				//System.out.println("r:"+ r +" " +C+" "+arr[r][0]);
				if(C < arr[r][0] || (result[i] != -1 && result[i] != arr[r][i])) break;
			}
			if(i == result.length){
				//System.out.println(r);
				check[r] = 1;
			}
		}
		
		//System.out.println(Arrays.toString(On));
		//System.out.println(Arrays.toString(Off));
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(check));
		
		int counter = 0;
		for(int j = 0; j < 8; j++){
			System.out.println(counter);
			if(check[j] == 1){
				int index = 1;
				int indexmod = index;
				while(index <= N){
					if(indexmod == 7) indexmod = 1;
					//System.out.println(index+ " " + indexmod);
					fout.print(arr[j][indexmod]);
					index++; indexmod++;
				}
				fout.println();
			}
			else counter++;
		}
		System.out.println(counter);
		if(counter == 8) fout.println("IMPOSSIBLE");
		
		fout.close();
		
	}
	
	static PrintWriter fout;
	static int N,C;
	static int[] On, Off, result, check;
	static int[][] arr = {{1,0,0,0,0,0,0},
						  {2,0,0,1,1,1,0},	
						  {1,0,1,0,1,0,1},
						  {1,0,1,1,0,1,1},
						  {2,1,0,0,1,0,0},	
						  {1,1,0,1,0,1,0},
						  {2,1,1,0,0,0,1},
						  {0,1,1,1,1,1,1}};
}