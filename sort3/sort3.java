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
		loc = new int[4]; nums = new int[4];
		arr = new int[n+1];
		list = new ArrayList<>();
		
		
		//read in data
		for(int i = 1; i <= n; i++){
			int k = Integer.parseInt(fin.readLine()); 
			nums[k]++;
			arr[i] = k;
			//list.add(k);
			if(loc[k] == 0 || loc[k] >= i) loc[k] = i; 
		}
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(arr));
		//System.out.println(Arrays.toString(loc));
		
		/* for(int i = 1; i <= n ; i++){
			if(i != n && arr[i] > arr[i+1]){
				System.out.println(i+" " +Arrays.toString(arr));
				swap(loc[arr[i+1]+1], i+1);
			}
		} */
		
		/* for(int i = n; i >= 1; i--){
			
			int num = arr[i];
			for(int j = 1; j <= i; j++){
				if(arr[j] > num){ 
					swap(j,i);
					
					break;
				}
			} */
		
		//System.out.println(Arrays.toString(arr));
		fout.println(counter);
		fout.close();
		
	}
	
	static void swap(int i, int j){
		counter++;
		System.out.println("i: "+i+" j: "+j+" "+Arrays.toString(arr));
		int temp = arr[i];
		arr[i] = arr[j];
		list.remove(temp);
		//location of bigger vale us pushed back one 
		loc[temp] = list.indexOf(temp); 
		arr[j] = temp;
		
		//if(arr[i] < arr[i-1]) swap(loc[arr[i-1]], i);
		if(arr[j-1] > arr[j]) swap(loc[arr[j-1]], j);
		
	}
	
	
	static void swap2(int i, int j){
		counter++;
		int temp = arr[i];
		if(temp == 1) swap(loc[2], j);
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
}