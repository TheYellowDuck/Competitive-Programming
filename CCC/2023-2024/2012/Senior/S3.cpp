#include <stdio.h>
#include <iostream>
using namespace std;

int N;
int R[1001];
int A, B = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i ++) {
        int v;
        cin >> v;
        R[v] ++;
    }
    for (int i = 1; i <= 1000; i ++) {
        if (R[i] > R[A]) A = i;
    }
    for (int i = 1; i <= 1000; i ++) {
        if (R[i] > R[B] && i != A) B = i;
        if (R[i] == R[B] && i != A && abs(A - i) > abs(A - B)) B = i;
    }
    // cout << A << " " << B << "\n";
    cout << abs(A - B) << endl;
    return 0;
}