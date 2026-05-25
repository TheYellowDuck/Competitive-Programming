#include <stdio.h>
#include <iostream>
#include <cstdint>
#include <unordered_set>
#include <queue>
// #include <string.h>
#include <bits/stdc++.h>
using namespace std;

typedef uint64_t intL;
typedef unsigned int uint;

int N;
intL C;
unordered_set<intL> V;
queue<pair<intL, int>> Q;
intL complete = 0b0000000100000010000001000000100000010000001000000100000010000000;
intL winCondition;
int ans = -1;

void binary(intL num, int vt){
    cout << bitset<64>(num).to_string().substr(64 - (vt ? 64 : N));
}

inline uint getIndex(intL v, int i) {
    return ((v >> (((N - 1) - i) * 8)) & 0b11111111);
}
inline intL generate(uint vs[8]) {
    intL v = 0;
    for (int i = 0; i < N; i ++) {
        v = (v << 8) + vs[i];
        // cout << "generating: ";
        // binary(v, 1);
    }
    return v;
}

void calculate(intL v) {

    Q.emplace(make_pair(v, 0));
    V.emplace(v);

    while(!Q.empty()) {
        intL cur = Q.front().first;
        int d = Q.front().second;
        Q.pop();
        // binary(cur, 1);
        // cout << " " << d << endl;

        if (cur == winCondition) {
            ans = d;
            Q = {};
            return;
        }
        uint vs[8];
        for (int i = 0; i < N; i ++) {
            vs[i] = getIndex(cur, i);
        }

        for (int i = 0; i < N - 1; i ++) {
            uint a = (vs[i] & -vs[i]);
            uint b = (vs[i + 1] & -vs[i + 1]);
            if (b != 0 && (a > b || a == 0)) {
                vs[i] ^= b;
                vs[i + 1] ^= b;
                intL nxt = generate(vs);
                if (V.find(nxt) == V.end()) {
                    // int r = 
                    Q.emplace(make_pair(nxt, d + 1));
                    V.emplace(nxt);
                    // cout << "\t\t";
                    // binary(nxt, 1);
                    // cout << endl;
                    // if (r != -1)
                    //     s = min((s == -1 ? (int) 2e9 : s), r);
                }
                vs[i] ^= b;
                vs[i + 1] ^= b;
            }
            else if (a != 0 && (b > a || b == 0)) {
                vs[i] ^= a;
                vs[i + 1] ^= a;
                intL nxt = generate(vs);
                if (V.find(nxt) == V.end()) {
                    // int r = 
                    Q.emplace(make_pair(nxt, d + 1));
                    V.emplace(nxt);
                    // cout << "\t\t";
                    // binary(nxt, 1);
                    // cout << endl;
                    // if (r != -1)
                    //     s = min((s == -1 ? (int) 2e9 : s), r);
                }
                vs[i] ^= a;
                vs[i + 1] ^= a;
            }
        }

    }

    // // cout << "Start: " << v << endl;
    // // binary(v, 1);
    // // cout << endl;
    // if (V.find(v) != V.end() && V[v] <= depth) return;
    // V[v] = depth;
    // if (v == winCondition) return;
    // uint vs[8];
    // // memset(vs, 0, sizeof(vs));
    // // int s = -1;
    // for (int i = 0; i < N; i ++) {
    //     vs[i] = getIndex(v, i);
    //     // binary(vs[i], 0);
    //     // cout << " ";
    //     // if (vs[i] == 0 || (i != 0 && vs[i] < vs[i - 1])) s = 0;
    // }
    // // cout << V[v] << endl;
    // // // cout << endl;
    // // if (s == 1) {
    // //     V[v] = 0;
    // //     for (int i = 0; i < N; i ++) {
    // //         binary(vs[i], 0);
    // //         cout << " ";
    // //     }
    // //     cout << 0 << endl;
    // //     return 0;
    // // }
    // // s = -1;
    // for (int i = 0; i < N - 1; i ++) {
    //     // cout << "s: " << v << endl;
    //     uint a = (vs[i] & -vs[i]);
    //     uint b = (vs[i + 1] & -vs[i + 1]);
    //     if (b != 0 && (a > b || a == 0)) {
    //         vs[i] ^= b;
    //         vs[i + 1] ^= b;
    //         // int r = 
    //         calculate(generate(vs), depth + 1);
    //         // if (r != -1)
    //         //     s = min((s == -1 ? (int) 2e9 : s), r);
    //         vs[i] ^= b;
    //         vs[i + 1] ^= b;
    //     }
    //     else if (a != 0 && (b > a || b == 0)) {
    //         vs[i] ^= a;
    //         vs[i + 1] ^= a;
    //         // int r = 
    //         calculate(generate(vs), depth + 1);
    //         // if (r != -1)
    //         //     s = min((s == -1 ? (int) 2e9 : s), r);
    //         vs[i] ^= a;
    //         vs[i + 1] ^= a;
    //     }
    // }
    // // V[v] = (s == -1 ? -1 : s + 1);
    // // binary(v, 1);
    // // for (int i = 0; i < N; i ++) {
    // //     binary(vs[i], 0);
    // //     cout << " ";
    // // }
    // // cout << V[v] << endl;
    return;
    // __builtin_ctz(vs[0]) + 1;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (1) {
        cin >> N;
        if (N == 0) break;
        C = 0;
        V.clear();
        ans = -1;
        // VP.clear();
        for (int i = 0; i < N; i ++) {
            intL v = 0;
            cin >> v;
            C = (C << 8) + (1 << (v - 1));
        }

        winCondition = (complete >> ((8 - N) * 8));
        // V[winCondition] = 2e9;

        calculate(C);
        if (ans == -1) cout << "IMPOSSIBLE" << endl;
        else cout << ans << endl;
    }
    return 0;
}