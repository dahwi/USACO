/*
ID: ekgnlql1
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;

class sprime{
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		//PrintWriter fout2 = new PrintWriter(new BufferedWriter(new FileWriter("sprime2.out")));
		
		int digitsLen = Integer.parseInt(fin.readLine());
		String arr1[] = {"1","3","7","9"};	
		String arr2[] = {"23","29","31","37","57","59","71","73","79"};	
		
		
		
		/* long startTime = System.nanoTime();
		//List<String> list = new ArrayList<>();
		for(int j = 0; j <arr2.length; j++){
			String numStart = arr2[j];
			for(int i = 0; i < digitsLen-2; i++){ 
				numStart += arr1[0];
			}
			list.add(numStart);
		}
		
		int counter = 0;
		for(int j = 0; j < list.size(); j++){
			int head = Integer.parseInt(arr2[j])+1;
			for(int i = Integer.parseInt(list.get(j)); i < head*Math.pow(10,digitsLen-2); i+=2){
				String s = Integer.toString(i);
				if(s.indexOf('0') != -1 ||s.indexOf('2') > 0 ||s.indexOf('4') != -1 ||s.indexOf('6') != -1 ||s.indexOf('8') != -1 || s.indexOf('5') > 0) continue;
				if(isPrime(i)){ 
					int num = i/10;
					while(num != 0){
						if(!isPrime(num)) break; 
						num /= 10;
					}
					if(num == 0) fout.println(i);
				}
			}
		}
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime); */
		
		
		//startTime = System.nanoTime();
		for(int j = 0; j < arr2.length; j++){
			solve(arr2[j], arr1, digitsLen, fout);
		}
			
		
		//estimatedTime = System.nanoTime() - startTime;
		//System.out.println(estimatedTime);
		fout.close();
		//fout2.close();
	}
	
	public static boolean isPrime(int x){
		int n = 5;
		if(x == 2 || x == 3) return true;
		if(x%2 == 0 || x%3 == 0)  return false;
		while(n*n <= x){
			if(x%n == 0 || x%(n+2) == 0) return false;
			n += 6;
		}
		return true;
		
	}
	
	public static void solve(String s, String[] arr, int len, PrintWriter out){
		if(s.length() == len){
			int num = Integer.parseInt(s);
			while(num != 0){
				if(!isPrime(num)) break; 
				num /= 10;
			}
			if(num == 0) out.println(s); 
			return;
		}
		
		solve(s+arr[0], arr, len, out);
		solve(s+arr[1], arr, len, out);
		solve(s+arr[2], arr, len, out);
		solve(s+arr[3], arr, len, out);
	}
}