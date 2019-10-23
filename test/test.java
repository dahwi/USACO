/*
ID: ekgnlql1
LANG: JAVA
TASK: test
*/

import java.io.*;
import java.util.*;

class test{
	public static void main(String[] args) throws IOException{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		out.println(one + two);
		out.close();
	}
}