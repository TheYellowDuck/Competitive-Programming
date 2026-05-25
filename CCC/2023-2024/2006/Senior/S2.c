#include <stdio.h>
#include <stdlib.h>

char used[27];
char map[27];
int count = 0;

int main()
{
    char plain[81];
    fgets(plain, 81, stdin);
    char cipher[81];
    fgets(cipher, 81, stdin);
    for (int i = 0; i < 81; i ++) {
        if (plain[i] < ' ') break;
        // printf("%c %c %d %d\n", plain[i], cipher[i], plain[i], cipher[i]);
        if (cipher[i] == ' ') map[26] = plain[i];
        else map[cipher[i] - 'A'] = plain[i];
        if (plain[i] == ' ' && used[26] == 0) {
            used[26] = 1;
            count ++;
        }
        else if (plain[i] != ' ' && used[plain[i] - 'A'] == 0) {
            used[plain[i] - 'A'] = 1;
            count ++;
        }
    }
    // printf("%d\n", count);
    if (count == 26) {
        for (int i = 0; i < 27; i ++) {
            if (map[i] == 0) {
                for (int j = 0; j < 27; j ++) {
                    if (used[j] == 0) {
                        map[i] = j == 26 ? ' ' : j + 'A';
                        break;
                    }
                }
                break;
            }
        }
    }
    fgets(cipher, 81, stdin);
    for (int i = 0; i < 81; i ++) {
        if (cipher[i] < ' ') break;
        int idx = 26;
        if (cipher[i] != ' ') idx = cipher[i] - 'A';
        printf("%c", map[idx] == 0 ? '.' : map[idx]);
    }
    printf("\n");
    return 0;
}