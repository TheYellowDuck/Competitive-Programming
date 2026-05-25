#include <bits/stdc++.h>

using namespace std;

int main() {

	int T;
	scanf("%d", &T);

	while (T-- > 0) {

		int H, W, N, ans = 0, x = 0, y = 0;
		scanf("%d %d %d", &H, &W, &N);

		string grid[H + 1]{string(W, '*')};
		cin.ignore();
		for (int i = 1; i <= H; i++)
			getline(cin, grid[i]);

		while (N-- > 0) {

			char c;
			cin >> c;

			switch (c) {
			case 'L' :

				if (y > 0 && grid[x][y - 1] != 'S') {
					y--;
					if (grid[x][y] == 'T') {
						grid[x][y] = 'E';
						ans++;
					}

					while (x < H && grid[x + 1][y] == 'E')
						x++;

				}

				break;
			case 'R' :

				if (y + 1 < W && grid[x][y + 1] != 'S') {
					y++;
					if (grid[x][y] == 'T') {
						grid[x][y] = 'E';
						ans++;
					}

					while (x < H && grid[x + 1][y] == 'E')
						x++;

				}

				break;
			case 'D' :

				if (x < H && grid[x + 1][y] != 'S') {
					x++;
					if (grid[x][y] == 'T') {
						grid[x][y] = 'E';
						ans++;
					}

					while (x < H && grid[x + 1][y] == 'E')
						x++;

				}

				break;
			}
		}

		printf("%d\n", ans);

	}

	return 0;
}
