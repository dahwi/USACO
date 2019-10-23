/*
ID: ekgnlql1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1{
	public static void main(String[] args) throws IOException{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.txt")));
		int NP = (int) Integer.valueOf(f.readLine()); 
		Map<String, Integer> map = new HashMap<>();
		String[] order = new String[NP];
		for(int i = 0; i < NP; i++){
			String ss = f.readLine();
			order[i] = ss;
			map.put(ss, 0);
		}
		for(int i = 0; i < NP; i++){
			String name = f.readLine();
			//System.out.println(name);
			StringTokenizer st = new StringTokenizer(f.readLine());
			int money = Integer.parseInt(st.nextToken());
			int numOfPpl = Integer.parseInt(st.nextToken());
			int dividend = (numOfPpl == 0)? 0 : money/numOfPpl;
			int r = money;
			for(int j = 0; j < numOfPpl; j++){
				String person = f.readLine();
				int num = (int) map.get(person);
				map.put(person, num + dividend);
				r -= dividend;
			}
			//System.out.println(r-money);
			map.put(name, map.get(name)+r-money);
		}
//		for(Map.Entry entry :map.entrySet()){
//			System.out.println("name: "+entry.getKey()+" money: "+entry.getValue());
//		}
		for(String s : order){
			out.write(s + " " + map.get(s)+"\n");
		}
		out.close();
	}
}