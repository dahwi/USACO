#include<iostream>
#include<fstream>
using namespace std;
int n, m;

int main(void){
	ifstream fin("ariprog.in");
	fin >> n >> m;
	//fin >> m;
	
	int X[2*m*m +1] = {};
	int length = sizeof(X)/sizeof(X[0]);
	//cout << X[80] << endl;
	
	//find all possible bisquares
	for(int i = 0; i <= m; i++){
		for(int j = 0; j <=i; j++){
			X[i*i + j*j] = 1;
		}
	}
	
	ofstream fout("ariprog.out");
	bool none = true;
	
	//find the sequence that has the length greater than n
	int diff_max = (2*m*m)/(n-1);
	for(int diff = 1; diff <= diff_max; diff++){
		for(int a = 0; a+diff*(n-1) <= 2*m*m; a++){
			bool b = true;
			for(int i = 0; i < n; i++){
				int index = a + diff*i;
				if(index >= length || X[index] == 0){
					b = false;
					i = n;
				}
			}
			if(b){
				fout << a << " " << diff << endl;
				none = false;
			}
		}
	} 
	
	 
	if(none) fout << "NONE" << "\n";
	

	fout.close();
	return 0;
}
	