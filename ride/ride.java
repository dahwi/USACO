/*
ID: ekgnlql1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride{
	public static void main(String[] args) throws IOException{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String s1 = f.readLine(); 
		int prd1 = 1;
		String s2 = f.readLine();
		int prd2 = 1;
		for(char c : s1.toCharArray()){
			prd1 *= (c-'A'+1)%47;
		}
		for(char c : s2.toCharArray()){
			prd2 *= (c-'A'+1)%47;
		}
		if(prd1%47 == prd2%47) out.println("GO");
		else out.println("STAY");
		out.close();
	}
}