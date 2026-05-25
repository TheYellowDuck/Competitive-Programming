#include <stdio.h>
#include <iostream>
using namespace std;

int N;
int C[5000001];

int find_cost(int n) {
    if (n == 1) return 0;
    if (C[n] != 0) return C[n];

    int m = 2e9;
    for (int i = i; i <= n / 2; i ++) {
        if ((n - i) % i != 0) continue;
        m = min(m, find_cost(n - (n - i) / i) + i);
        break;
    }
    C[n] = m;
    return m;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    cout << find_cost(N);

    return 0;
}