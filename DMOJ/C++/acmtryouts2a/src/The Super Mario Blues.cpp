#include <bits/stdc++.h>
using namespace std;

int main() {

	int T;
	cin >> T;

	while(T -- > 0) {

		int W, L;
		scanf("%d-%d", &W, &L);
		W = (W - 1) * 4 + L;

		if (W <= 2)
			cout << 9 - W << "\n";
		else if (W <= 12)
			cout << 19 - W << "\n";
		else
			cout << 33 - W << "\n";

	}

	return 0;
}
