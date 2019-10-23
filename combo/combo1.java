/*
ID: ekgnlql1
LANG: JAVA
TASK: combo
*/

import java.util.*;
import java.io.*;

class combo1{
	public int x,y,z;
	private static int N;
	//public static List<combo> test = new ArrayList<>();
	public combo1(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getZ(){
		return this.z;
	}
	
	public String toString(){
		return Integer.toString(this.x)+Integer.toString(this.y)+Integer.toString(this.z);
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this) return true;
		//use eiter one to check for checking if the argument has the correct type
		if((o == null) || (o.getClass() != combo.class)) return false; 
		//if(!(o instanceof combo)) return false;
		
		combo c = (combo) o;
		return x == c.x && y == c.y && z == c.z;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(x, y, z);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		
		N = Integer.parseInt(f.readLine());	//maximum number of a lock
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		combo Johnkey = new combo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(f.readLine());
		combo masterkey =new combo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int result = 0;
		System.out.println(Johnkey.x+" "+Johnkey.y+" "+Johnkey.z);
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= N; j++){
				for(int k = 1; k <= N; k++){
					if(unlock(i,j,k, Johnkey.x, Johnkey.y, Johnkey.z) || unlock(i,j,k, masterkey.x, masterkey.y, masterkey.z)) result++;
				}
			}
		}
		
		out.println(result);
		out.close();
	}
	
	private static boolean isValid(int a, int b){
		return Math.abs(a-b) <= 2 || Math.abs(a-b) >= N-2;
	}
	
	private static boolean unlock(int a, int b, int c, int a1, int b1,int c1){
		return isValid(a,a1) && isValid(b,b1) && isValid(c,c1);
	}
	
	public static int mod(int a, int b){
		return (a%b < 0)? a%b+b : a%b;
	}
}