#include <stdio.h>
#include <iostream>
#include <string.h>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int T;
int R, C;
char F[25][25];
int A[25 * 25];
int N = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T >> R >> C;
    for (int i = 0; i < R; i ++) {
        for (int j = 0; j < C; j ++) {
            cin >> F[i][j];
        }
    }
    for (int i = 0; i < R; i ++) {
        for (int j = 0; j < C; j ++) {
            if (F[i][j] != '.') continue;
            queue<pair<int, int>> Q;
            Q.emplace(pair(i, j));
            while (!Q.empty()) {
                pair<int, int> crds = Q.front();
                Q.pop();
                int x = crds.first, y = crds.second;
                if (x < 0 || y < 0 || x >= R || y >= C || F[x][y] != '.') continue;
                F[x][y] = '*';
                A[N] ++;
                Q.emplace(pair(x, y - 1));
                Q.emplace(pair(x, y + 1));
                Q.emplace(pair(x - 1, y));
                Q.emplace(pair(x + 1, y));
            }
            N ++;
        }
    }
    sort(A, A + N);
    int rooms = 0;
    for (int i = N - 1; i >= 0; i --) {
        if (T - A[i] < 0) break;
        T -= A[i];
        rooms ++;
    }
    cout << rooms << (rooms == 1 ? " room, " : " rooms, ") << T << " square metre(s) left over\n";
    return 0;
}