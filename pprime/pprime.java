/*
ID: ekgnlql1
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;

class pprime{
	
	pprime(){}
	
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		//PrintWriter fout2 = new PrintWriter(new BufferedWriter(new FileWriter("pprime2.out")));
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		long startTime = System.nanoTime();

		pprime obj = new pprime();
		
		/* //SLOWER version
		int index = (a % 2 == 0)? a+1 : a;
		for(int i = index; i <= b; i+=2){
			//System.out.println(i);
			if(obj.isPalindrome(i) && obj.isPrime(i)) fout.println(i);
		} */
		
		
		List<Integer> list = new ArrayList<>();
		//the one and only even palindrome that is prime
		if(5 >= a) list.add(5);
		if(7 >= a) list.add(7);
		if(11 >= a) list.add(11);
		
		
		for(int i = 1; i <= 999; i++){
			for(int j = 0; j <= 9; j++){
				int k = obj.reverse(i,j);
				//fout2.println("x: "+ i+" res: "+j+" k: "+k);
				if(obj.isPrime(k) && k >= a && k <= b) list.add(k);
			}
		}
		
		Collections.sort(list);
		for(int x: list) fout.println(x);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);
		
		//System.out.println(isPalindrome(111111111));
		fout.close();
	}
	
	/**
	Test if n is divisible by 2 and 3. Then, check through all the numbers
	of the form 6k plus minus 1 is less than or equal to sqrt of n
	**/
	public boolean isPrime(int x){
		
		if(x % 2 == 0 || x % 3 == 0) return false;
		
		/* SLOWER version
		int k = 1;
		int divisor1 = 6*k+1;
		int divisor2 = divisor1-2;	//6k-1
		while(divisor1 <= Math.sqrt(x) || divisor2 <= Math.sqrt(x)){
			if(x % divisor1 == 0 || x % divisor2 == 0) return false;
			divisor1 += 6; divisor2 += 6;
		}
		*/
	
		int k = 5;
		while(k*k <= x){
			if(x % k == 0 || x % (k+2) == 0) return false;
			k += 6;
		}
		return true;
		
	}
	
	public boolean isPalindrome(int x){
		/* SLOWER version
		String s = Integer.toString(x);
		int length = s.length()-1;
		for(int i = 0; i <= length/2; i++){
			if(s.charAt(i) != s.charAt(length-i)) return false;
		}
		return true;
		*/
		
		int num = 0;
		while(x > num){
			num = 10*num + x%10;
			x /= 10;
		}
		return (num == x || num/10 == x);
	}
	
	/* 
	since even palindromss are divisible by 11
	we only deal with odd palindromes
	*/
	public int reverse(int x, int middle){
		int res = 0, multiplier = 1, save = x;
		while(x != 0){
			res = 10*res + x%10;
			x /= 10;
			multiplier *= 10;
		}
		return res + multiplier*(10*save+middle);
	}
}