//============================================================================
// Name        : vmss7wc15c2p3.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stack>
#include <unordered_map>
using namespace std;

int main() {
	stack<long long> S;
	unordered_map<long long,long long> M;
	long long HS;
	cin >> HS;
	long long C = 0;
	long long H;
	for (long long i = 0; i < HS; i ++) {
		cin >> H;
		while (!S.empty() && S.top() < H) {
			C += M[S.top()];
			S.pop();
		}
		if (!S.empty() && S.top() == H) {
			C += M[H];
			M[H] ++;
			if (S.size() > 1)
				C ++;
		}
		else {
			if (!S.empty()) C ++;
			M[H] = 1;
			S.push(H);
		}
	}
	cout << C;
	return 0;
}
