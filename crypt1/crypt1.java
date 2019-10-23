/*
ID: ekgnlql1
LANG: JAVA
TASK: crypt1
*/

import java.util.*;
import java.io.*;
class crypt1{
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		//PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		int n = Integer.parseInt(f.readLine()); //from 1 to 9
		StringTokenizer st = new StringTokenizer(f.readLine());
		List<Integer> list = new ArrayList<>();
		while(n-- > 0){
			int k = Integer.parseInt(st.nextToken());
			list.add(k);
		}
		
		Collections.sort(list);
		
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
				int a = listOfT.get(i);
				int b = listOfB.get(j);
				int product1 = a*(b%10), product2 = a*(b/10);
				int product = a*b;
				
				if(product > 10000) break;
				else{
					if(check(product1, list) && check(product2, list) && check(product, list) && product1 < 1000 && product2 < 1000) result++;
					//fout.println(a+" "+b+" "+product + " " +product1+" "+check(product1,list) + " " +product2 +" "+ check(product2,list));
				}
			}
		}
		
		//fout.close();
		out.println(result);
		out.close();
		
	}
	
	//check to see the final product is four digits number and all the digits are from the input set.
	private static boolean check(int n, List<Integer> list){
		return (list.containsAll(numToDigits(n)));
	}
	
	//convert the number to a set of digits consisting of that number
	public static ArrayList<Integer> numToDigits(int n){
		ArrayList<Integer> result = new ArrayList<>();
		while(n > 0){
			int k = n%10;
			if(!result.contains(k)) result.add(k);
			n = n/10;
		}
		return result;
	}
}
