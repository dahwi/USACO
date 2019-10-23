/*
ID: ekgnlql1
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;

class milk3{
	static int A,B,C;
	ArrayList<Integer> list = new ArrayList<Integer>();
	List<String> arr = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		
		//Capacity of buckets A,B,C(inclusive); between 1 and 20
		StringTokenizer st = new StringTokenizer(fin.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		milk3 milk = new milk3();
		
		
		if(C<=A && C<=B) fout.println(0+" "+C);
		else{
			milk.solve(A, 0, C-A);
			milk.solve(0, B, C-B);
			milk.show();
			milk.show2();
		}
		
		ArrayList<Integer> res = milk.getList();
		Collections.sort(res);
		
		for(int i = 0; i < res.size(); i++){
			if(i == res.size()-1) fout.println(res.get(i));
			else fout.print(res.get(i)+" ");
		}
		
		fout.close();
	}
	
	
	public void solve(int a, int b, int c){
		//check to see if moving milk is possible or already done
		if(a > A || b > B || c > C || a < 0 || b < 0 || c < 0) return;
		if(a+b+c != C) return;
		if(visited(a,b,c)) return;
		
		//we do this process before the conditional statements in order to prevent the infinite loop!!!!
		String s = a+" "+b+" "+c;
		arr.add(s);
		
		//two cases: 
		//1. A is empty 
		if(a==0){ 
			if(!list.contains(c)) list.add(c); 
			if(!list.contains(b) && canSwitch(b,c)) list.add(b);	//ex) (0,1,9) can be switched into (0,9,1) when the cap is (8,9,10)
			solve(A, b-A, c); solve(A, b, c-A);	//fill A COMPLETELY from B and C
			solve(b, B, c-B); //fill A from B and B from C
		}

		//2. A is not empty
		else{
			//if milk in A is greater than what B needs to be completely full, we only pour needed amount, B-b, from A.
			//Otherwise, we pour all milk from A to B
			//Same for vice versa
			int x = (B-b > a)? a : B-b;
			solve(a-x, b+x, c); 
			
			int y = (A-a > b)? b : A-a;
			solve(a+y, b-y, c);
			
			//then make A empty
			/**found out that this was redundant bc of line 71-72	
			solve(0, b+a, c);
			**/
			solve(0, b, c+a);
			solve(0, a, b+c);
			solve(0, b+c, a);			
		}
		return; 
	}
	
	
	//check to see if milk in B can be switched with milk in C
	public boolean canSwitch(int b, int c){ 
		if(c <= A && b <= C){
			if(c <= B) return true;
		}
		return false;
	}
	
	public boolean visited(int a, int b, int c){
		String s = a+" "+b+" "+c;
		return (arr.contains(s))? true : false;
	}
	public void show(){
		System.out.println(list.toString());
	}
	
	public void show2(){
		System.out.println(arr.toString());
	}
	
	public ArrayList<Integer> getList(){
		return list;
	}
}