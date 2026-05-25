#include <stdio.h>
#include <iostream>
#include <unordered_set>
using namespace std;

int T, G;
int S[5];
unordered_set<int> played;

int possible_results(int i, int j) {
    if (i > 4 || j > 4) {
        for (int k = 1; k <= 4; k ++) {
            if (k == T) continue;
            if (S[k] >= S[T]) return 0;
        }
        return 1;
    }
    int x = i, y = j + 1;
    if (y > 4) {
        x ++;
        y = x + 1;
    }

    int C = 0;
    if (played.count(i * 10 + j)) C += possible_results(x, y);
    else {
        S[i] += 3;
        C += possible_results(x, y);
        S[i] -= 3;
        S[j] += 3;
        C += possible_results(x, y);
        S[j] -= 3;
        S[i] ++;
        S[j] ++;
        C += possible_results(x, y);
        S[i] --;
        S[j] --;
    }
    return C;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T >> G;
    for (int i = 0; i < G; i ++) {
        int A, B, a, b;
        cin >> A >> B >> a >> b;
        if (a > b) S[A] += 3;
        else if  (b > a) S[B] += 3;
        else {
            S[A] ++;
            S[B] ++;
        }
        played.emplace(A * 10 + B);
    }
    cout << possible_results(1, 2) << endl;

    return 0;
}