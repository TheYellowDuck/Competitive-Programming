#include <bits/stdc++.h>
using namespace std;

int main() {

	int T;
	scanf("%d", &T);

	while (T > 0) {
		int N, maxF = 1;
		scanf("%d", &N);

		while (N > 0) {
			int F;
			scanf("%d", &F);

			if (F > maxF)
				maxF = F;

			N--;
		}
		printf("%d\n", maxF);
		T--;
	}

	return 0;
}
