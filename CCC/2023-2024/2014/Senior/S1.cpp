#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

int K, M, R;
vector<int> F;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> K >> M;
    for (int i = 1; i <= K; i ++) 
        F.push_back(i);
    for (int i = 0; i < M; i ++) {
        cin >> R;
        for (int j = F.size() - F.size() % R - 1; j >= 0; j -= R) 
            F.erase(F.begin() + j);
    }
    for (int i : F) 
        cout << i << "\n";
    return 0;
}