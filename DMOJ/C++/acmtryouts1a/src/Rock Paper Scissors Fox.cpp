#include <bits/stdc++.h>
using namespace std;

int main() {

	int N;
	scanf("%d", &N);
	cin.ignore();
	while (N > 0) {
		string s;
		getline(cin, s);

		if (s == "Rock")
			printf("Paper\n");
		else if (s == "Paper")
			printf("Scissors\n");
		else if (s == "Scissors")
			printf("Rock\n");
		else if (s == "Fox")
			printf("Foxen\n");
		else
			return 0;
		N--;
	}

	return 0;
}
