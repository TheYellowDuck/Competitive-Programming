#include <iostream>
#include <set>

using namespace std;

int main() {
	int G;
	cin >> G;
	set<int> D;
	for (int i = 1; i <= G; i ++)
		D.insert(i);
	int NP, C = 0;
	cin >> NP;
	for (int i = 0; i < NP; i ++) {
		int P;
		cin >> P;
		set<int> ::iterator itr = D.upper_bound(P);
		if (itr != D.begin()) {
			itr --;
			D.erase(*itr);
			C ++;
		}
		else
			break;
	}
	cout << C;
	return 0;
}
