#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <iomanip>
using namespace std;

int N;
pair<double, double> S[1000];
int P[1000];

bool compare(const pair<double, double> &p1, const pair<double, double> &p2)
{
    if (p1.second < p2.second)
        return p1.second < p2.second;
    if (p1.second == p2.second)
        return p1.first < p2.first;
    return p1.second < p2.second;
}

double dist(double x, double y, double a, double b)
{
    return sqrt((a - x) * (a - x) + (b - y) * (b - y));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cout << std::fixed << std::setprecision(2);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> S[i].first >> S[i].second;
        S[i].first *= 100;
        S[i].second *= 100;
    }

    sort(S, S + N, compare);

    // for (int i = 0; i < N; i ++) {
    //     cout << S[i].first << " " << S[i].second << "\n";
    // }

    for (int i = 0; i < N; i++)
    {
        vector<int> close;
        double min = 2e9;

        for (int j = i; j >= 0; j--)
        {
            double d = dist(S[j].first, S[j].second, S[i].first, 0);
            if (d < min)
            {
                close.clear();
                close.push_back(j);
                min = d;
            }
            else if (d == min)
                close.push_back(j);
        }

        cout << S[i].first << " " << S[i].second << "\n";
        for (auto j : close)
        {
            cout << S[j].first << " " << S[j].second << "\n";
            if (P[j] == 0)
            {
                cout << "The sheep at (" << (round(S[j].first) / 100.0) << ", " << (round(S[j].second) / 100.0) << ") might be eaten.\n";
                P[j] = 1;
            }
        }
        cout << "\n";
    }

    return 0;
}

// if (R[j].second > R[i].second) {
//                 if (x < R[j].first) {
//                     R[j].first = -1;
//                     R[j].second = -1;
//                 }
//                 if (x > R[i].second) {
//                     R[i].first = -1;
//                     R[i].second = -1;
//                 }
                
//             }
//             else if (R[i].second <= R[j].second) {
//                 if (x > R[i].first) {
//                     R[i].first = x;
//                     R[j].second = x;
//                 }
//                 else {
//                     R[j].second = R[i].first;
//                 }
//             }
//             else if (R[j].first >= R[i].first) {
//                 if (x < R[j].second) {
//                     R[i].first = x;
//                     R[j].second = x;
//                 }
//                 else {
//                     R[i].first = R[j].second;
//                 }
//             }
//             else {
//                 R[i].first = x;
//                 R[j].second = x;
//             }