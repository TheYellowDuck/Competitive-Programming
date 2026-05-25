#include <stdio.h>
#include <iostream>
using namespace std;

int N;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N;
    while (1) {
        N ++;
        int C[10] = {};
        int t = N;
        while (t > 0) {
            if (C[t % 10] == 1) break;
            C[t % 10] = 1;
            t /= 10;
        }
        if (t == 0) break;
    }
    cout << N << endl;
    return 0;
}