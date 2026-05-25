#include <stdio.h>
#include <iostream>
#include <map>
#include <list>
#include <queue>
#include <set>
using namespace std;

int N;
map<string, list<string>> M;

int connect(string a, string b)
{
    queue<string> Q;
    set<string> V;
    Q.emplace(a);
    V.emplace(a);
    while (!Q.empty())
    {
        string s = Q.front();
        Q.pop();
        list<string> C = M.at(s);
        for (auto i : C)
        {
            if (V.find(i) == V.end())
            {
                if (i.compare(b) == 0)
                    return 1;
                Q.emplace(i);
                V.emplace(i);
            }
        }
    }
    return 0;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    string L;
    getline(cin, L);
    for (int i = 0; i < N; i++)
    {
        list<string> C;
        getline(cin, L);
        while (1)
        {
            string line;
            getline(cin, line);
            if (line.compare("</HTML>") == 0)
                break;
            while (1)
            {
                int pos = line.find("<A HREF=\"") + 9;
                if (pos == 8)
                    break;
                line.erase(0, pos);
                string l = line.substr(0, line.find("\">"));
                cout << "Link from " << L << " to " << l << "\n";
                C.push_back(l);
            }
        }
        M.emplace(L, C);
    }

    while (1)
    {
        string a;
        getline(cin, a);
        if (a.compare("The End") == 0)
            break;
        string b;
        getline(cin, b);
        int connected = connect(a, b);
        // int connected = 1;
        if (connected == 0)
            cout << "Can't ";
        else
            cout << "Can ";
        cout << "surf from " << a << " to " << b << ".\n";
    }

    return 0;
}