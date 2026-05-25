#include <bits/stdc++.h>
using namespace std;

class Bloon {
public :

	int H = -1, I = -1;

	Bloon(){}

	Bloon(int health) {
		this -> H = health;
	}

};

int main() {

	int T;
	cin >> T;

	while (T -- > 0) {

		int L, N;
		scanf("%d %d", &L, &N);
		int T[L] = {};

		while (N -- > 0) {

			int I, R, D;
			scanf("%d %d %d", &I, &R, &D);

			T[(I - R - 1 < 0 ? 0 : I - R - 1)] += D;
			if (I + R < L)
				T[I + R] -= D;

		}

		for (int i = 1; i < L; i ++)
			T[i] += T[i - 1];

		int M;
		cin >> M;
		Bloon B[M];

		for (int i = 0; i < M; i ++) {

			int H;
			cin >> H;
			B[i] = Bloon(H);

		}

		for (int i = 0; i < L; i ++) {
			for (int j = 0; j < M; j ++) {
				if (B[j].I != -1)
					continue;
				B[j].H -= T[i];
				if (B[j].H <= 0)
					B[j].I = i + 1;
			}
		}

		for (Bloon i : B) {
			if (i.I == -1)
				cout << "Bloon leakage\n";
			else
				cout << i.I << "\n";
		}

	}

	return 0;
}
