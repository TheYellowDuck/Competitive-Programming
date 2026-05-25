#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <iomanip>
using namespace std;

int N;
pair<double, double> S[1000];
pair<double, double> R[1000];

bool compare(const pair<double, double> &p1, const pair<double, double> &p2)
{
    if (p1.first < p2.first)
        return p1.first < p2.first;
    if (p1.first == p2.first)
        return p1.second < p2.second;
    return p1.first < p2.first;
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

    R[0].first = 0;
    R[0].second = 1e5;
    for (int i = 0; i < N; i++)
    {
        for (int j = i - 1; j >= 0; j--)
        {
            if (R[j].second < R[i].first)
                continue;
            if (S[i].first == S[j].first)
            {
                if (S[i].second < S[j].second)
                {
                    R[j].first = -1;
                    R[j].second = -1;
                }
                else if (S[i].second > S[j].second)
                {
                    R[i].first = -1;
                    R[i].second = -1;
                    j = -1;
                }
                continue;
            }
            double x = (S[i].first * S[i].first - S[j].first * S[j].first + S[i].second * S[i].second - S[j].second * S[j].second) / (2 * (S[i].first - S[j].first));
            if (x < R[j].first)
            {
                R[j].first = -1;
                R[j].second = -1;
                if (x < 0)
                    x = 0;
                R[i].first = x;
                R[i].second = 1e5;
            }
            else if (x <= R[j].second)
            {
                R[i].first = x;
                R[i].second = 1e5;
                R[j].second = x;
            }
            else
            {
                if (x > 1e5)
                {
                    R[i].first = -1;
                    R[i].second = -1;
                    j = -1;
                }
                else
                {
                    R[i].first = R[j].second;
                    R[i].second = 1e5;
                }
            }
        }
        // for (int i = 0; i < N; i ++) {
        //     if (R[i].first != -1) {
        //         cout << S[i].first << " " << S[i].second << "\n";
        //         cout << R[i].first << " " << R[i].second << "\n\n";
        //     }
        // }
    }

    for (int i = 0; i < N; i++)
    {
        if (R[i].first != -1)
        {
            // cout << R[i].first << " " << R[i].second << "\n";
            if ((int) (S[i].first * 10) % 10 == 5) S[i].first += (((int) (S[i].first) % 10 + 1) % 2) / 10.0;
            if ((int) (S[i].second * 10) % 10 == 5) S[i].second += (((int) (S[i].second) % 10 + 1) % 2) / 10.0;
            cout << "The sheep at (" << (round(S[i].first) / 100.0) << ", " << (round(S[i].second) / 100.0) << ") might be eaten.\n";
        }
    }

    return 0;
}