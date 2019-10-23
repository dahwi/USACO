import java.util.*;
import java.io.*;

class Interval implements Comparable<Interval>{
	//Instance Variables
	public int x; 
	public int y;
	
	//Constructors
	public Interval(int a, int b){
		this.x = a;
		this.y = b;
	}
	
	//methods 
	public int compareTo(Interval i){
		Integer a = this.x;
		Integer b = i.x;
		return a.compareTo(b);
	}
}