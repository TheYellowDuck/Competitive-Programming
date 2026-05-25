#include <iostream>
using namespace std;

int main() {

	int T;
	scanf("%d", &T);
	while (T > 0) {
		int n;
		scanf("%d", &n);
		n -= 192;
		printf("%d\n", 192 + (n / 250 + (n % 250 > 0 ? 1 : 0)) * 250);
		T--;
	}

	return 0;
}
