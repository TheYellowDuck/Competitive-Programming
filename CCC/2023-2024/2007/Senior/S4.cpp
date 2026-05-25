#include <stdio.h>
#include <iostream>
#include <unordered_set>
using namespace std;

int N;
int P[10000];
unordered_set<int> C[10000];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    while (1) {
        int a, b;
        cin >> a >> b;
        if (a == 0) break;
        C[a].emplace(b);
    }
    P[N] = 1;
    for (int i = N - 1; i >= 1; i --) {
        for (int j : C[i]) {
            P[i] += P[j];
        }
    }
    cout << P[1] << endl;
    return 0;
}