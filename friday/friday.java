/*
ID: ekgnlql1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday{
	public static void main(String[] args) throws IOException{
		//Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int n = (int) Integer.valueOf(f.readLine());
		int[] month = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int[] freq = new int[7];
		int counter = 0; // counter for a week: mon for 0, ..., sun for 6
		//year
		for(int i = 1900; i < 1900+n; i++){
			//check for a leap year
			if(i % 100 == 0 && i % 400 == 0) month[1] = 29;
			else if(i % 4 == 0 && i % 100 != 0)	month[1] = 29;
			else month[1] = 28;
			//month
			for(int j = 0; j < 12; j++){
				int days = 1;
				while(days <= month[j]){
					if(days == 13){	
						freq[counter]++; 
					}
					days++;
					counter = (counter+1)%7;
				}
			}
		}
		for(int i = 0; i < freq.length; i++){
			if(i == freq.length-1){ 
				out.print(freq[(i+5)%7]+"\n"); break;
				}
			out.print(freq[(i+5)%7]+" ");
		}
		out.close();
	}
}