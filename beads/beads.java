/*
ID : ekgnlql1
LANG: JAVA
TASK: beads
*/

import java.util.*;
import java.io.*;

class beads{
	private static int length;
	private static int L,R;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int n = Integer.parseInt(f.readLine());
		String s = f.readLine();
		length = n;
		int result = 0;
		for(int i = 0; i < n; i++){
			//int length = findLongestLength(s,i, (i+1)%n);
			//System.out.println(length);
			result = Math.max(findLongestLength(s,i,(i+1)%n), result);
		}
		//System.out.println("result: " + result);
		out.println(result);
		out.close();
	}
	
	private static int findLongestLength(String s, int l, int r){
		L = l; R = r;
		int res = 0;
		char colorL = s.charAt(L), colorR = s.charAt(R);
		if(colorL == colorR &&  colorL!= 'w'){
			while(s.charAt(R) == colorL){
				R = (R+1 >= length)? R-length+1 : R+1;
				//System.out.println("L: " + L + " R: " + R);
				if(R == l) return length;
			}
		}
		while(s.charAt(L) == 'w' || s.charAt(L) == colorL){
			L = (L-1 < 0)? L+length-1 : L-1;
			if(colorL == 'w' && s.charAt(L) != 'w') colorL = s.charAt(L);
			if(L == r) return length;
		}
		while(s.charAt(R) == 'w' || s.charAt(R) == colorR){
			R = (R+1 >= length)? R-length+1 : R+1;
			if(colorR == 'w' && s.charAt(R) != 'w') colorR = s.charAt(R);
		}
		//System.out.println("L: " + L + " R: " + R);
		if(R-L-1 == -length) return length;
		else if(R-L-1 < 0) return R-L+length-1;
		else return R-L-1;
	}
}