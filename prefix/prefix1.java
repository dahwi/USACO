/*
ID: ekgnlql1
LANG: JAVA
TASK: prefix
 */
import java.io.*;
import java.util.*;

public class prefix1 {

	public int solve(String s, String[] primitives) {
		int len = s.length();
		boolean[] dp = new boolean[len + 1];

		for (String p : primitives) {
			int l = p.length();
			if (l >= len) continue;
			if (s.substring(0, l).equals(p)) {
				dp[l] = true;
			}
		}

		for (int k = 0; k <= len; k++) {
			if (dp[k]) {
				for (String p : primitives) {
					int l = p.length();
					if (k + l  > len) continue;
					if (s.substring(k , k + l ).equals(p)) {
						dp[k + l] = true;
					}
				}
			}
		}
		int res = 0;
		for (int k = 0; k <= len; k++) {
			if (dp[k]) {
				res = k;
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "prefix";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		ArrayList<String> primitives = new ArrayList<String>();
		long start = System.currentTimeMillis();
		String line = f.readLine();
		while (!line.equals(".")) {
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				primitives.add(st.nextToken());
			}
			line = f.readLine();
		}
		index = primitives.size();
		
		StringBuilder sb = new StringBuilder();
		line = f.readLine();
		while (line != null) {
			sb.append(line);
			line = f.readLine();
		}

		//int res = (new prefix1()).solve(sb.toString(), primitives.toArray(new String[0]));
		dpSolve(sb.toString(), primitives.toArray(new String[0]));
	System.out.println(System.currentTimeMillis() - start);
		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(maxLen);
		out.close(); // close the output file
		System.out.println(System.currentTimeMillis() - start);
		System.exit(0); // don't omit this!
	}
	
	static int index, maxLen;
	
	static void dpSolve(String s, String[] arr){
		int len = s.length();
		boolean[] pos = new boolean[len+1];
		pos[0] = true;
		for(int i = 0; i < len; i++){
			if(pos[i]){
				//System.out.println(i);
				for(int j = 0; j < index; j++){
					int k = arr[j].length();
					if(i+k <= len && s.substring(i,i+k).equals(arr[j])){
						//System.out.println(s.substring(0,i+arr[j].length()));
						maxLen = (maxLen < i+k)? i+arr[j].length() : maxLen;
						pos[i+k] = true;
					} 
				}
			}
		}
	}

}