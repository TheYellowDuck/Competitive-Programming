#include <stdio.h>
#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int T;
int R, C;
char M[22][22];
int ans;
int step, count, track;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T;
    for (int t = 0; t < T; t ++) {
        cin >> R >> C;
        for (int i = 1; i <= R; i ++) {
            for (int j = 1; j <= C; j ++) {
                cin >> M[i][j];
            }
            cin.ignore();
        }
        if (M[R][C] == '*') {
            cout << -1 << endl;
            continue;
        }
        // for (int i = 1; i <= R; i ++) {
        //     for (int j = 1; j <= C; j ++) {
        //         cout << M[i][j];
        //     }
        //     cout << "\n";
        // }
        ans = -1;
        queue<pair<int, int>> Q;
        Q.push(make_pair(1, 1));
        step = 1;
        count = 1;
        track = 0;
        while (!Q.empty()) {
            int x = Q.front().first, y = Q.front().second;
            Q.pop();
            count --;
            // cout << x << " " << y << " " << step << "\n";
            if (x == R && y == C) {
                ans = step;
                break;
            }
            if (M[x][y] == '|' || M[x][y] == '+') {
                if (M[x - 1][y] != 0) {
                    Q.push(make_pair(x - 1, y));
                    track ++;
                }
                if (M[x + 1][y] != 0) {
                    Q.push(make_pair(x + 1, y));
                    track ++;
                }
            }
            if (M[x][y] == '-' || M[x][y] == '+') {
                if (M[x][y - 1] != 0) {
                    Q.push(make_pair(x, y - 1));
                    track ++;
                }
                if (M[x][y + 1] != 0) {
                    Q.push(make_pair(x, y + 1));
                    track ++;
                }
            }
            M[x][y] = 0;
            if (count == 0) {
                step ++;
                count = track;
                track = 0;
            }
        }
        cout << ans << endl;
    }
    return 0;
}