/*
ID: ekgnlql1
LANG: C++
TASK: skidesign
*/

#include<iostream>
#include<fstream>
using namespace std;
#define MAX_N 1000

int N, X[MAX_N];

int main(void){
	//input file stream
	ifstream fin("skidesign.in");
	fin >> N;
	
	for(int i = 0; i < N; i++)
		fin >> X[i];	//height of a hill
	fin.close();
	
	int totalCost = 1000000000;
	
	for(int i = 0; i <= 83; i++){
		int cost = 0, x;
		for(int j = 0; j < N; j++){
			if(X[j] < i) x = i-X[j];
			else if(X[j] > i +17) x = X[j]-i-17;
			else x = 0;
			cost += x*x;
		}
		totalCost = min(totalCost, cost);
	}
	
	ofstream fout("skidesign.out");
	fout << totalCost << "\n";
	fout.close();
	return 0;
}

