#include <stdio.h>
#include <iostream>
#include <string.h>
#include <queue>
using namespace std;

int connections[26][26];
int visited[26];
int connected = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    char P1, P2;
    while (true) {
        cin >> P1 >> P2;
        if (P1 == '*' && P2 == '*') break;
        connections[P1 - 'A'][P2 - 'A'] = 1;
        connections[P2 - 'A'][P1 - 'A'] = 1;
    }

    queue<int> Q;
    Q.emplace(0);
    Q.emplace(1);
    visited[0] = 1;
    visited[1] = 2;
    while (!Q.empty() && connected == 0) {
        int cur = Q.front(); Q.pop();
        for (int i = 0; i < 26; i ++) {
            if (connections[cur][i] == 0) continue;
            if (visited[i] == visited[cur]) continue;
            if (visited[i] != 0) {
                connected = 1;
                break;
            }
            visited[i] = visited[cur];
            Q.emplace(i);
        }
    }

    int count = 0;

    if (connected == 1) {
        for (int i = 0; i < 26; i ++) {
            for (int j = i + 1; j < 26; j ++) {
                if (connections[i][j] == 0) continue;
                connections[i][j] = 0;
                connections[j][i] = 0;
                connected = 0;
                queue<int> q;
                q.emplace(0);
                q.emplace(1);
                memset(&visited, 0, sizeof(visited));
                visited[0] = 1;
                visited[1] = 2;
                while (!q.empty() && connected == 0) {
                    int cur = q.front(); q.pop();
                    for (int k = 0; k < 26; k ++) {
                        if (connections[cur][k] == 0) continue;
                        if (visited[k] == visited[cur]) continue;
                        if (visited[k] != 0) {
                            connected = 1;
                            break;
                        }
                        visited[k] = visited[cur];
                        q.emplace(k);
                    }
                    
                }
                if (connected == 0) {
                    count ++;
                    cout << (char)(i + 'A') << (char) (j + 'A') << '\n';
                }
                connections[i][j] = 1;
                connections[j][i] = 1;
            }
        }
    }
    cout << "There are "<< count << " disconnecting roads.\n";
    return 0;
}