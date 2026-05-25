#include <bits/stdc++.h>
using namespace std;

int main() {

	int T;
	scanf("%d", &T);

	while (T > 0) {
		int N;
		scanf("%d", &N);
		char a[N], b[N];
		scanf("%s\n%s", a, b);

		N--;
		while (N >= 0) {
			printf("%c%c", b[N], a[N]);
			N--;
		}
		printf("\n");
		T--;
	}

	return 0;
}
