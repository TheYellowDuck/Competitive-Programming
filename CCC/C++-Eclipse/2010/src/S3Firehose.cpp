/*
 * S3Firehose.cpp
 *
 *  Created on: Sep. 19, 2022
 *      Author: gzhan
 */

#include <bits/stdc++.h>
#include "S3Firehose.h"
using namespace std;

vector<int> house;
int K;

bool checkHydrants(int len, int pos) {

}

bool placeHydrants(int len) {
	for (int i = 0; i < house.size(); i ++) {
		return checkHydrants(len, house[i]);
	}
	return false;
}

S3Firehose::S3Firehose() {
	// TODO Auto-generated constructor stub
	int H;
	cin >> H;
	house.resize(H);
	for (int i = 0; i < H; i ++) {
		int A;
		cin >> A;
		house.push_back(A);
	}
	sort(house.begin(), house.end());
	cin >> K;

	if (K >= H) {
		cout << "0\n";
		return;
	}

	int len = (1000000 - 1) / 2;
	while (true) {
		placeHydrants(len);
	}
}

S3Firehose::~S3Firehose() {
	// TODO Auto-generated destructor stub
}

