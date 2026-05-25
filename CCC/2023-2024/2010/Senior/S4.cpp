#include <stdio.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <utility>
#include <algorithm>
using namespace std;

int M;
int cost = 0;

vector<pair<pair<int, int>, int>> E;
// vector<pair<int, int>> E2;

unordered_map<int, pair<int, int>> map;

int link[101];
int weight[101];
vector<int> C[101];

void update_link(int cur, int lowlink) {
    if (link[cur] == lowlink) return;
    link[cur] = lowlink;

    for (int i : C[cur]) {
        update_link(i, lowlink);
    }
}

int find_cost() {
    sort(E.begin(), E.end(), [](auto &a, auto &b) { return a.second < b.second; });

    // for (auto i: E) {
    //     int a = i.first.first, b = i.first.second, c = i.second;
    //     cout << "edge: " << a << " " << b << " " << c << endl;
    // }
    // cout << endl;

    for (int i = 1; i <= M; i ++) { link[i] = i; weight[i] = 1; }

    int out = -1;

    for (auto i : E) {
        int a = i.first.first, b = i.first.second, c = i.second;
        if (link[a] == link[b]) continue;
        // cout << "edge: " << a << " " << b << " " << c << endl;
        cost += c;
        if (a == 0 || b == 0) {
            if (out == -1) out = c;
            else out = 0;
        }
        if (weight[link[a]] < weight[link[b]]) {
            weight[link[b]] += weight[link[a]];
            update_link(a, link[b]);
        }
        else {
            weight[link[a]] += weight[link[b]];
            update_link(b, link[a]);
        }
        C[a].push_back(b);
        C[b].push_back(a);
    }

    cost -= out;

    return cost;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> M;
    for (int i = 1; i <= M; i ++) {
        int e;
        int P[8];
        cin >> e;
        for (int j = 0; j < e; j ++) 
            cin >> P[j];
        for (int j = 0; j < e; j ++) {
            int c = 0;
            cin >> c;
            int k = P[j] * 10000 + P[(j + 1) % e];
            if (P[j] > P[(j + 1) % e])
                k = P[(j + 1) % e] * 10000 + P[j];
            if (map.find(k) == map.end()) map[k] = pair(i, c);
            else {
                // C[i][map[k].first] = c;
                // C[map[k].first][i] = c;
                E.push_back(pair(pair(i, map[k].first), c));
                map.erase(k);
            }
        }
    }
    for (auto i : map) {
        // C[0][i.first] = i.second;
        // C[i.first][0] = i.second;
        E.push_back(pair(pair(0, i.second.first), i.second.second));
    }
    cout << find_cost() << endl;



    return 0;
}