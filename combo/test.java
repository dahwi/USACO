import java.util.*;
import java.io.*;

class test{
	public static void main(String[] args){
		int N = 2, m = 1;
		int[] res = new int[N];
		if(N <= 4){
			int n = m-2,counter = 0;
			List<Integer> list = new ArrayList<>();
			while(counter < N){
				System.out.println(n%N);
				if(!list.contains(n%N) || list.isEmpty()){
					list.add(n%N); res[counter++] = n++%N;
					System.out.println(list.toString()+" "+Arrays.toString(res));
				}
			}
		}
		
	}
}