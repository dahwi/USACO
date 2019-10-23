/*
ID: ekgnlql1
LANG: JAVA
TASK: crypt1
*/

import java.util.*;
import java.io.*;
class crypt1{
	private static int[] arr = new int[10];
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		int n = Integer.parseInt(f.readLine()); //from 1 to 9
		StringTokenizer st = new StringTokenizer(f.readLine());
		List<Integer> list = new ArrayList<>();
		
		while(n-- > 0){
			int k = Integer.parseInt(st.nextToken());
			arr[k] = 1;
			list.add(k);
		}
		
		List<Integer> listOfT = new ArrayList<>(), listOfB = new ArrayList<>();
		
		
		for(int i = 0; i < list.size(); i++){
			int counter = 0;
			while(counter < list.size()){
				int k = 10*list.get(i)+list.get(counter++);
				listOfB.add(k);
			}
		}
		
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < listOfB.size(); j++){
				listOfT.add(100*list.get(i)+listOfB.get(j));
			}
		}
		
		int result = 0;
		for(int i = 0; i < listOfT.size(); i++){
			for(int j = 0; j < listOfB.size(); j++){
				if(check(listOfT.get(i),listOfB.get(j))) result++;
			}
		}
		
		out.println(result);
		out.close();
		
	}
	
	//check to see if the digits of n are in the set and the length is correct
	private static boolean isgood(int n, int d){
		if(n == 0) return false;
		while(n > 0){
			if(arr[n%10] == 0) return false;
			n = n/10;
			d--;
		}
		
		return (d == 0);
	}
	
	private static boolean check(int n, int m){
		if(!isgood(n , 3) || !isgood(m,2) || !isgood(m*n,4)) return false;
		
		while(m > 0){
			if(!isgood(n*(m%10), 3)) return false;
			m = m/10;
		}
		return true;
	}
}