/*
 * S2HuffmanEncoding.cpp
 *
 *  Created on: Sep. 19, 2022
 *      Author: gzhan
 */

#include <iostream>
#include "S2HuffmanEncoding.h"
using namespace std;

S2HuffmanEncoding::S2HuffmanEncoding() {
	// TODO Auto-generated constructor stub
	int N;
	cin >> N;
	char L[N];
	string A[58];
	for (int i = 0; i < N; i ++) {
		char C;
		string code;
		cin >> C >> code;
		L[i] = C;
		A[C - 'A'] = code;
	}
	string sequence;
	cin >> sequence;
	string decode = "";
	while (sequence != "") {
		for (char i : L) {
			string code = A[i - 'A'];
			if (sequence.substr(0, code.length()) == code) {
				decode += i;
				sequence = sequence.substr(code.length());
				break;
			}
		}
	}
	cout << decode;
}

S2HuffmanEncoding::~S2HuffmanEncoding() {
	// TODO Auto-generated destructor stub
}

