#include <stdio.h>
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int N;
vector<string> F;
unordered_map<string, string> M;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N;
    string name;
    for (int i = 0; i < N; i ++) {
        cin >> name;
        F.push_back(name);
    }

    int C = 1;
    for (int i = 0; i < N; i ++) {
        cin >> name;
        if ((M.count(name) && M[name] != F[i]) || (name == F[i])) {
            C = 0;
            break;
        }
        M.emplace(F[i], name);
    }
    cout << (C ? "good" : "bad") << endl;
    return 0;
}