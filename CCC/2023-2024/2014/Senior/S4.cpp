#include <stdio.h>
#include <iostream>
#include <utility>
#include <tuple>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
using namespace std;

int N, T;
vector<tuple<int, int, int>> P;
vector<int> C, R;
unordered_set<int> C1, R1;
unordered_map<int, int> idx1, idx2;
int G[2000][2000];
long long int A = 0;
int M[2000][2000];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N >> T;
    for (int i = 0; i < N; i ++) {
        int x1, y1, x2, y2, t;
        cin >> x1 >> y1 >> x2 >> y2 >> t;
        P.push_back(make_tuple(x1, y1, t));
        P.push_back(make_tuple(x1, y2, -t));
        P.push_back(make_tuple(x2, y1, -t));
        P.push_back(make_tuple(x2, y2, t));
        if (C1.count(x1) == 0) {
            C1.emplace(x1);
            C.push_back(x1);
        }
        if (C1.count(x2) == 0) {
            C1.emplace(x2);
            C.push_back(x2);
        }
        if (R1.count(y1) == 0) {
            R1.emplace(y1);
            R.push_back(y1);
        }
        if (R1.count(y2) == 0) {
            R1.emplace(y2);
            R.push_back(y2);
        }
    }
    sort(C.begin(), C.end());
    sort(R.begin(), R.end());

    for (int i = 0; i < C.size(); i ++) 
        idx1.emplace(C[i], i);
    for (int i = 0; i < R.size(); i ++) 
        idx2.emplace(R[i], i);

    // sort(P.begin(), P.end(), [](auto &left, auto &right) {
    //     if (get<0>(left) == get<0>(right)) return get<1>(left) < get<1>(right);
    //     return get<0>(left) < get<0>(right);
    // });

    for (auto i : P) {
        G[idx1[get<0>(i)]][idx2[get<1>(i)]] += get<2>(i);
    }

    // cout << endl;
    // for (int j = 0; j < R.size(); j ++) {
    //     for (int i = 0; i < C.size(); i ++) {
    //         cout << G[i][j] << " ";
    //     }
    //     cout << endl;
    // }

    for (int i = 0; i < C.size(); i ++) {
        for (int j = 1; j < R.size(); j ++) {
            G[i][j] += G[i][j - 1];
        }
    }

    // cout << endl;
    // for (int j = 0; j < R.size(); j ++) {
    //     for (int i = 0; i < C.size(); i ++) {
    //         cout << G[i][j] << " ";
    //     }
    //     cout << endl;
    // }

    for (int i = 0; i < C.size(); i ++) {
        for (int j = 0; j < R.size(); j++) {
            // M[i][j] = G[i][j] + (i == 0 ? 0 : M[i - 1][j]) + (j == 0 ? 0 : M[i][j - 1])
            M[i][j] = (i == 0 ? 0 : M[i - 1][j]) + G[i][j];

            if (M[i][j] >= T) {
                A += (long long int) (C[i + 1] - C[i]) * (R[j + 1] - R[j]);
                // cout << i << " " << j << " " << (C[i + 1] - C[i]) << " " << (R[j + 1] - R[j]) << endl;
            }
        }
    }

    // cout << endl;
    // for (int j = 0; j < R.size(); j ++) {
    //     for (int i = 0; i < C.size(); i ++) {
    //         cout << M[i][j] << " ";
    //     }
    //     cout << endl;
    // }

    cout << A << endl;  

    return 0;
}