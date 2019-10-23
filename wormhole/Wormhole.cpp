/*
ID: ekgnlql1
LANG: C++
TASK: wormhole
*/

#include <iostream>
#include <fstream>
using namespace std;
#define MAX_N 12

int N, X[MAX_N+1], Y[MAX_N+1];
int partner[MAX_N+1];
int next_on_right[MAX_N+1];

bool cycle_exist(void)
{
	for(int i = 1; i <= N; i++){
		int pos = i;
		for(int c = 0; c < N; c++)
			pos = next_on_right[partner[pos]];
		if(pos != 0) return true;
	}
	return false;
}

//count all solutions
int solve(void)
{
	//find the first unparied wormholeint i;
	int i, total = 0;
	for(i = 1; i <=N ;i++)
		if(partner[i] == 0) break;
	
	if(i > N){
		if(cycle_exist()) return 1;
		else return 0;
	}
	
	//try partnering i with all possible other wormholes j
	for(int j = i+1; j <= N; j++){
		if(partner[j] == 0){
			partner[i] = j; partner[j] = i;
			total += solve();
			partner[i] = partner[j] = 0;
		}
	}
	return total;
}

int main(void)
{
	//input file stream
	ifstream fin("wormhole.in");
	fin >> N;
	for(int i=1; i <= N; i++) fin >> X[i] >> Y[i];
	fin.close();
	
	for(int i = 1; i <= N; i++)
		for(int j = 1; j <= N; j++)
			if(X[j] > X[i] && Y[i] == Y[j])
				if(next_on_right[i] == 0 || X[j]-X[i] < X[next_on_right[i]]-X[i])
					next_on_right[i] = j;
	
	//output file stream
	ofstream fout("wormhole.out");
	fout << solve() << "\n";
	fout.close();
	return 0;
}