/*
ID: ekgnlql1
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.*;
class sort3{
	static int[] arr, loc, nums;
	static ArrayList<Integer> list;
	static int counter = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		
		int n = Integer.parseInt(fin.readLine());	//number of records to be sorted
		loc = new int[5]; nums = new int[4];
		arr = new int[n+1];
		
		
		//read in data
		for(int i = 1; i <= n; i++){
			int k = Integer.parseInt(fin.readLine()); 
			nums[k]++;	//number of occurrences of one's, two's, and three's
			arr[i] = k; 
		}
		
		loc[1] = (nums[1]>0)? 1 : 0;
		loc[2] = loc[1] + nums[1];
		loc[3] = loc[2] + nums[2];
		loc[4] = arr.length;
		//System.out.println(Arrays.toString(nums));
		//System.out.println(Arrays.toString(arr));
		//System.out.println(Arrays.toString(loc));
		
		for(int i = 1; i <= n; i++){
			solve(arr[i], i);
		}
		fout.println(counter);
		fout.close();
	}

	static void solve(int n, int index){
		boolean swapped = false;
		if(loc[n] <= index && index < loc[n+1]) return;
		for(int i = loc[n]; i < loc[n+1]; i++){
			int k = arr[i];
			if(loc[k] <= index && index < loc[k+1]){
				counter++;
				arr[i] = arr[index];
				arr[index] = k;
				//System.out.println(Arrays.toString(arr)+" i: "+i+" index: "+index);
				swapped = true;
				return;
			}
		}
		
		if(!swapped){
			for(int i = loc[n]; i < loc[n+1]; i++){
				if(arr[i] != n){
					counter++;
					//System.out.println("n"+Arrays.toString(arr)+" i: "+i+" index: "+index);
					int temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
					solve(temp, index);
					return;
				}
			}
		}
	}
}