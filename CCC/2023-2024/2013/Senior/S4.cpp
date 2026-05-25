#include <stdio.h>
#include <iostream>
#include <unordered_set>
#include <queue>
using namespace std;

int N, M;
unordered_set<int> S[100001];
queue<int> Q1, Q2;
unordered_set<int> V;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < M; i ++) {
        int x, y;
        cin >> x >> y;
        S[x].emplace(y);
    }

    int p, q;
    cin >> p >> q;

    int ans = 0;
    Q1.emplace(p);
    V.emplace(p);
    Q2.emplace(q);
    V.emplace(q);
    while (!Q1.empty() || !Q2.empty()) {
        if (!Q1.empty()) {
            int cur = Q1.front();
            Q1.pop();
            for (auto i : S[cur]) {
                if (i == q) {
                    ans = 1;
                    goto end;
                }
                if (V.count(i) == 0) {
                    Q1.emplace(i);
                    V.emplace(i);
                }
            }
        }
        if (!Q2.empty()) {
            int cur = Q2.front();
            Q2.pop();
            for (auto i : S[cur]) {
                if (i == p) {
                    ans = 2;
                    goto end;
                }
                if (V.count(i) == 0) {
                    Q2.emplace(i);
                    V.emplace(i);
                }
            }
        }
    }
    end:;
    cout << (ans != 0 ? (ans == 1 ? "yes\n" : "no\n") : "unknown\n");

    return 0;
}