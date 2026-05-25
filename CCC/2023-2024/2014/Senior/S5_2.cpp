#include <stdio.h>
#include <iostream>
#include <utility>
#include <algorithm>
using namespace std;

int N;
pair<int, int> P[2000];
pair<int, int> D[2000][2000];
int A[2001][2000];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    for (int i = 0; i < N; i ++) {
        int x, y;
        cin >> x >> y;
        P[i] = make_pair(x, y);
        for (int j = i - 1; j >= 0; j --) {
            D[i][j] = make_pair(j, abs((P[i].first - P[j].first) * (P[i].first - P[j].first) + (P[i].second - P[j].second) * (P[i].second - P[j].second)));
            D[j][i] = make_pair(i, D[i][j].second);
        }
    }

    for (int i = 0; i < N; i ++) {
        A[1][i] = abs(P[i].first * P[i].first + P[i].second * P[i].second);
        sort(begin(D[i]), end(D[i]), [](auto &left, auto &right) {
            return left.second > right.second;
        });
    }

    for (int i = 2; 1; i ++) {
        int c = 0;
        for (int j = 0; j < N; j ++) {
            int m = 0;
            for (int k = 0; k < N; k ++) {
                if (D[j][k].second < A[i - 1][D[j][k].first]) {
                    m = D[j][k].second;
                    break;
                }
            }
            if (m != 0) {
                A[i][j] = m;
                c = 1;
            }
            // cout << A[i][j] << " ";
        }
        // cout << endl;
        if (!c) {
            cout << (i - 1) << endl;
            break;
        }
    }

    return 0;
}