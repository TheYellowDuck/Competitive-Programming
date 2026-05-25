#include <iostream>
using namespace std;

int main () {

	printf("%s\n", "Ready");
//	fflush(stdout);

	char l, r;

	scanf("%c%c", &l, &r);

	while (l != ' ' && r != ' ') {
		if (((int) l + (int) r == 198 && (l == 'b' || r == 'b')) ||
				((int) l + (int) r == 225 && (l == 'p' || r == 'p')))
			printf("%s\n", "Mirrored pair");
		else
			printf("%s\n", "Ordinary pair");
		cin.ignore();
		scanf("%c%c", &l, &r);
	}

	return 0;
}
