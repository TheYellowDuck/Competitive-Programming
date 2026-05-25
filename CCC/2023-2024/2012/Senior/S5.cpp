#include <stdio.h>
#include <iostream>
using namespace std;

int Cg[26][26];
int R, C;
int K;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> R >> C;
    cin >> K;
    for (int i = 0; i < K; i ++) {
        int r, c;
        cin >> r >> c;
        Cg[r][c] = -1;
    }
    Cg[1][1] = 1;
    for (int i = 1; i <= R; i ++) {
        for (int j = 1; j <= C; j ++) {
            if (Cg[i][j] == -1) continue;
            Cg[i][j] += (Cg[i - 1][j] == -1 ? 0 : Cg[i - 1][j]) + (Cg[i][j - 1] == -1 ? 0 : Cg[i][j - 1]);
        }
    }
    cout << Cg[R][C];
    return 0;
}