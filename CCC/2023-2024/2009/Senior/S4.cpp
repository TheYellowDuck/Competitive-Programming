#include <stdio.h>
#include <iostream>
#include <vector>
#include <utility>
#include <queue>
using namespace std;

int N, T, K, D;
long long int C[5001];
vector<pair<int, int>> R[5001];
vector<pair<int, int>> P;
long long int m = (long long int) 9e18;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> T;
    for (int i = 0; i < T; i ++) {
        int a, b, c;
        cin >> a >> b >> c;
        R[a].push_back(make_pair(b, c));
        R[b].push_back(make_pair(a, c));
    }
    cin >> K;
    for (int i = 0; i < K; i ++) {
        int a, b;
        cin >> a >> b;
        P.push_back(make_pair(a, b));
    }
    cin >> D;

    queue<int> Q;
    Q.emplace(D);

    while (!Q.empty()) {
        int cur = Q.front();
        Q.pop();
        for (auto i : R[cur]) {
            if (i.first == D) continue;
            if (C[i.first] == 0 || C[cur] + i.second < C[i.first]) {
                C[i.first] = C[cur] + i.second;
                Q.emplace(i.first);
            }
        }
    }

    for (auto i : P) {
        m = min(m, i.second + C[i.first]);
    }    
    
    cout << m << endl;

    return 0;
}