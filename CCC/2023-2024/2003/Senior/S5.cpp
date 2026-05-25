#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>
using namespace std;

int C, R, D;
int L[10001];
pair<int, pair<int, int>> rds[100000];
int dest[10001];
vector<int> connected[10001];
int visited = 0;
int rnum = 0;
int maxW = 2e9;

struct compare {
    bool operator() (const pair<int, pair<int, int>> &a, const pair<int, pair<int, int>> &b) const {
        return get<0>(a) > get<0>(b);
    }
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> C >> R >> D;

    for (int i = 1; i <= C; i ++) {
        L[i] = i;
    }

    for (int i = 0; i < R; i ++) {
        int a, b, c;
        cin >> a >> b >> c;
        rds[i] = pair(c, pair(a, b));
    }
    sort(rds, rds + R, compare());
    for (int i = 0; i < D; i ++) {
        int c;
        cin >> c;
        dest[c] = 1;
    }

    while (visited < D && rnum < R) {
        pair<int, pair<int, int>> r = rds[rnum ++];
        int a = r.second.first, b = r.second.second, c = r.first;
        if (L[a] == L[b]) continue;
        maxW = c;
        // if ((dest[a] == 1 || dest[b] == 1) && ((L[a] == 1 && L[b] != 1) || (L[a] != 1 && L[b] == 1)))
        //     visited ++;
        queue<int> Q;
        int lowlink = 1;
        if (L[a] < L[b]) {
            lowlink = L[a];
            Q.emplace(b);
        }
        else if (L[a] > L[b]) {
            lowlink = L[b];
            Q.emplace(a);
        }
        while (!Q.empty()) {
            int cur = Q.front();
            Q.pop();
            if (lowlink == 1 && dest[cur] == 1)
                visited ++;
            L[cur] = lowlink;
            for (int nxt : connected[cur]) {
                if (L[nxt] != lowlink)
                    Q.emplace(nxt);
            }
        }
        connected[a].push_back(b);
        connected[b].push_back(a);
        // cout << a << " " << b << " " << c << " " << maxW << " " << visited << endl;
    }
    cout << maxW << "\n";
    // int check = 1;
    // for (int i = 1; i <= C; i ++) {
    //     if (dest[i] == 1 && L[i] != 1)
    //         check = 0;
    // }
    // cout << check << "\n";
    return 0;
}