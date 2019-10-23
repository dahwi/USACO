import java.io.*;

class test{
public static void main(String[] args) throws IOException{
	BufferedReader fin = new BufferedReader(new FileReader("frac1.out"));
	BufferedReader fin2 = new BufferedReader(new FileReader("frac2.in"));
	
	int counter = 1;
	while(fin.readLine().equals(fin2.readLine())){
		System.out.println(counter);
		counter++;
	}
}

}
