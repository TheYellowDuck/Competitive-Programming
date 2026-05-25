#include <stdio.h>
#include <iostream>
#include <math.h>
using namespace std;

int T;
int M, X, Y;
int F;
int P[5][5] = {{0, 2, 2, 2, 0},
               {0, 1, 2, 1, 0},
               {0, 0, 1, 0, 0},
               {0, 0, 0, 0, 0},
               {0, 0, 0, 0, 0}};

int recurse(int m, int f, int a, int b) {
    if (m > M) return 0;
    int x = ((X - a) / f) % 5, y = ((Y - b) / f) % 5;
    int v = P[y][x];
    if (v == 2) return 1;
    if (v == 1) return recurse(m + 1, f / 5, x * F, y * F);
    return 0;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T;
    for (int i = 0; i < T; i ++) {
        cin >> M >> X >> Y;
        int F = pow(5, M - 1);
        int v = recurse(1, F, 0, 0);
        if (v) cout << "crystal\n";
        else cout << "empty\n";
    }

    return 0;
}