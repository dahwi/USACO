/*
ID: ekgnlql1
LANG: JAVA
TASK: combo
*/

import java.util.*;
import java.io.*;

class combo{
	public int x,y,z;
	//public static List<combo> test = new ArrayList<>();
	public combo(int x, int y, int z){
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
		
		int N = Integer.parseInt(f.readLine());	//maximum number of a lock
		StringTokenizer st = new StringTokenizer(f.readLine());
		combo Johnkey = new combo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(f.readLine());
		combo masterkey =new combo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int[] Johnx = validPos(N, Johnkey.getX()), Johny = validPos(N, Johnkey.getY()), Johnz = validPos(N, Johnkey.getZ());
		int[] masterx = validPos(N, masterkey.getX()), mastery = validPos(N, masterkey.getY()), masterz = validPos(N, masterkey.getZ());
		
		
		ArrayList<combo> listJohn = new ArrayList<>(); int counter = 0;
		for(int i = 0; i < Johnx.length; i++){
			for(int j = 0; j < Johny.length; j++){
				for(int k = 0; k < Johnx.length; k++){
					listJohn.add(new combo(Johnx[i], Johny[j], Johnz[k]));
				}
			}
		}
		
		ArrayList<combo> listmaster = new ArrayList<>(); counter = 0;
		for(int i = 0; i < masterx.length; i++){
			for(int j = 0; j < mastery.length; j++){
				for(int k = 0; k < masterz.length; k++){
					listmaster.add(new combo(masterx[i], mastery[j], masterz[k]));
				}
			}
		}
		//System.out.println(intersection(listJohn, listmaster));
		
		//out.println(listJohn.size()+ " " + listJohn.toString());
		//out.println(listmaster.size()+ " " + listmaster.toString());
		//out.println(test.toString());
		out.println(listJohn.size() + listmaster.size() - intersection(listJohn, listmaster));
		out.close();
	}
	
	private static int[] validPos(int N, int m){
		int counter = 0;
		if(N >4){
			int result[] = new int[5];
			while(counter <5){
				result[counter++] = mod(m-2, N);
				m++;
			}
			return result;
		}
		else{
			int[] res = new int[N];
			int n = m-2;
			List<Integer> list = new ArrayList<>();
			while(counter < N){
				int k = mod(n,N);
				if(!list.contains(k) || list.isEmpty()){
					list.add(k); res[counter++] = k;
					n++;
				}
			}
			return res;
		}
	}
	
	private static int intersection(ArrayList<combo> a, ArrayList<combo> b){
		int res = 0;
		for(int i = 0; i < a.size(); i++){
			if(b.contains(a.get(i))) res++;
		}
		return res;
	}
	
	public static int mod(int a, int b){
		return (a%b < 0)? a%b+b : a%b;
	}
}