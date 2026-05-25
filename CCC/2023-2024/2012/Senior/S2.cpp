#include <stdio.h>
#include <iostream>
using namespace std;

char s[21];
int t = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> s;
    int p = 0;
    for (int i = 9; i >= 0; i --) {
        if (s[i * 2] == '\0') continue;
        int b = 0;
        if (s[i * 2 + 1] == 'I') b = 1;
        if (s[i * 2 + 1] == 'V') b = 5;
        if (s[i * 2 + 1] == 'X') b = 10;
        if (s[i * 2 + 1] == 'L') b = 50;
        if (s[i * 2 + 1] == 'C') b = 100;
        if (s[i * 2 + 1] == 'D') b = 500;
        if (s[i * 2 + 1] == 'M') b = 1000;
        int cur = (s[i * 2] - '0') * b;
        // cout << cur << " " << s[i * 2] << " " << b << endl;
        t += (p <= b ? cur : -cur);
        p = b;
    }
    cout << t << endl;
    return 0;
}