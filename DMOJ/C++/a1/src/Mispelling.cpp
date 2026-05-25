#include <iostream>
using namespace std;

int main () {

	int T;
	cin >> T;
	for (int i = 1; i <= T; i++) {
		int j;
		string str;
		cin >> j;
		getline(cin >> ws, str);

		j--;
		str.erase(str.begin() + j);

		cout << i << " " << str << "\n";
	}

	return 0;
}
