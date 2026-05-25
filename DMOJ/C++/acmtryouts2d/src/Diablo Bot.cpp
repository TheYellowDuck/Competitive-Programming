#include <bits/stdc++.h>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

vector<string> split(string s, char delim) {
	vector<string> a;
    istringstream iss(s);
    string item;
    while (getline(iss, item, delim))
         a.push_back(item);
    return a;
}

char asciiToLower(char c) {
	if (c <= 'Z' && c >= 'A')
		return c - ('Z' - 'z');
	return c;
}

string toLower(string s) {
	transform(s.begin(), s.end(), s.begin(), asciiToLower);
	return s;
}

int main() {

	int T;
	cin >> T;

	cin.ignore();
	while (T -- > 0) {

		string s;
		getline(cin, s);

		vector<string> items = split(s, ' ');

		if (items[0].length() >= 2 && items[0].substr(items[0].length() - 2) == "'s")
			cout << "Set\n";
		else if (toLower(items[0]) == "damaged")
			cout << "Normal\n";
		else if (items.size() > 2 && items.size() <= 4 && toLower(items[items.size() - 2]) == "of")
			cout << "Magic\n";
		else if (items.size() == 2)
			cout << "Not sure, take anyways\n";
		else
			cout << "Normal\n";

	}

	return 0;
}
