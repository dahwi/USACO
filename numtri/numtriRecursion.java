/*
ID: ekgnlql1
LANG: JAVA
TASK: numtri
*/

import static java.lang.System.*;
import java.io.*;
import java.util.*;

/**
It takes too long as the input get bigger since the recursive method has exponential time complexity
**/
class numtriRecursion{
	
	/**
	Solution for "non-static variable this cannot be referenced from a static context" error
	A non-static nested class in Java contains an implicit reference to an instance of the parent class.
	To instantiate an object of inner class, you need to have an instance of outer class.
	Code: Outerclass.Innerclass name = Outerobject.new Innerclass();
	ex) numtri.Node head = new numtri().new Node(0);
	
	Another way to fix this problem is to make inner class static!!!
	**/
	 
	static class Node{
		//instance variables
		int data;
		Node left, right;
		
		//constructor
		 Node(int value){
			data = value;
			left = right = null;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader fin = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		 
		int numLine = Integer.parseInt(fin.readLine());
		
		int first = Integer.parseInt(fin.readLine());
	
		Queue<Node> queue = new LinkedList<>();
		Node head = new Node(first); Node temp;
		queue.add(head);		
		
		for(int i = 2; i <= numLine; i++){ 
			int counter = 1;
			String s = fin.readLine();
			StringTokenizer st = new StringTokenizer(s);
			temp = queue.peek();
			while(counter <= i){
				int a = Integer.parseInt(st.nextToken());
				Node node = new Node(a);
				if(counter == 1){
					//out.println("left child of "+temp.data+" is " +a);
					temp.left = node;
				}
				else if(counter == i){
					//out.println("right child of "+temp.data+" is " +a);
					temp.right = node;
					queue.poll(); //queue.remove();
				}
				else{
					//out.println("right child of "+temp.data+" is " +a);
					temp.right = node;
					queue.remove(); //queue.poll();
					temp = queue.peek();
					//out.println("left child of "+temp.data+" is " +a);
					temp.left = node;
				}
				queue.add(node);
				counter++;
			}
		}
		
		int maxSum = solve(head);
		
		fout.println(maxSum);
		fout.close();
	}
	
	public static int solve(Node node){
		int sumL, sumR;
		sumL = sumR = 0;
		//base case
		if(node == null) return 0;

		int leftchild = solve(node.left);
		int rightchild = solve(node.right);
		sumL = leftchild + node.data;
		sumR = rightchild + node.data;
		
		return (sumL >= sumR)? sumL : sumR;
	}
	
	public static void traversal(Node node){
		if(node == null) return;
		
		traversal(node.left);
		out.print(node.data+" ");
		traversal(node.right);
		
	}
}
