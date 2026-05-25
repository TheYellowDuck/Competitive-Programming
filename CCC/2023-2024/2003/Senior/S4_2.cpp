#include <stdio.h>
#include <iostream>
#include <string.h>
#include <unordered_set>
#include <queue>
// #include <unistd.h>
using namespace std;

int N;
string S;
string s;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0 ; i < N ; i++) {
	    cin >> S;
	    int total = 2;
        int len = S.length();

	    for (int j = 1; j < len; j ++) {
            for (int k = 0 ; k <= len - j ; k ++) {
                s = S.substr(k, j);
                // cout << s << endl;
                if (S.find(s) == k)
                    total ++;
            }
	    }
        cout << total << "\n";
    }

    return 0;
}