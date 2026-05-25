#include <bits/stdc++.h>
using namespace std;

int main() {

	int T;
	cin >> T;

	while (T -- > 0) {

		int N;
		cin >> N;
		int a[N];

		for (int i = 0; i < N; i ++) {

			int V;
			cin >> V;

			if (V == P)
				P --;
			else
				a[index ++] = V;

		}

		bool S = true;
		for (int i = 1; i < N; i ++) {
			if (a[i] != a[i - 1] - 1) {
				S = false;
				break;
			}
		}

		cout << (S ? "Y\n" : "N\n");

	}

	return 0;
}
