/*
ID: ekgnlql1
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;
import java.math.*;

class hamming{
	public static void main(String[] args) throws IOException{
		Scanner fin = new Scanner(new File("hamming.in"));
		fout = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
	 
		N = fin.nextInt();
		B = fin.nextInt();
		D = fin.nextInt();
		list = new ArrayList<>();
		
		System.out.println( (1<< 2) & 4);
		System.out.println( (1<< 2) & 15);
		findAllwD(0,0);
		list.add(0,0);
		for(int i = 0; i < list.size(); i++){
			if(i == list.size()-1 || i % 10 == 9) fout.println(list.get(i));
			else fout.print(list.get(i)+" ");
		}
		fout.close();
	}
	static PrintWriter fout;
	static int N, B, D;
	static ArrayList<Integer> list;
	
	static void findAllwD(int k, int count){
		BigInteger num = new BigInteger(Integer.toBinaryString(k),2);
		int i;
		for(i = k+1; i < Math.pow(2,B); i++){
			if(count == N-1) return;
			BigInteger b = new BigInteger(Integer.toBinaryString(i),2);
			String s = num.xor(b).toString(2);
			//fout.println(s);
			int c = 0;
			for(int j = 0; j < s.length(); j++){
				if(s.charAt(j) == '1') c++;
				if(c >= D){
					//System.out.println(i+" "+list.size());
					
					int res = 0;
					for(int p = count; p > 0; p--){
						String s1 = (new BigInteger(Integer.toBinaryString(list.get(p-1)), 2).xor(b)).toString(2);
						int c1 = 0;
						for(int index = 0; index < s1.length(); index++){
							if(s1.charAt(index) == '1') c1++;
						}
						if(c1>= D) res++;
					}
					if(res == count){
						count++;
						list.add(i);
						break;
					}
				}
			}
			
			
		}
	}
}