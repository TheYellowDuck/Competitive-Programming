/*
 * S1ComputerPurchase.cpp
 *
 *  Created on: Sep. 19, 2022
 *      Author: gzhan
 */

#include <iostream>
#include "S1ComputerPurchase.h"
using namespace std;

S1ComputerPurchase::S1ComputerPurchase() {
	// TODO Auto-generated constructor stub
	int N;
	cin >> N;
	string name1 = "", name2 = "";
	int value1 = -1, value2 = -1;
	for (int i = 0; i < N; i ++) {
		string name;
		int R, S, D;
		cin >> name >> R >> S >> D;
		int value = 2 * R + 3 * S + D;
		if (value > value1) {
			name2 = name1;
			value2 = value1;
			name1 = name;
			value1 = value;
		}
		else if (value == value1) {
			if (name < name1) {
				name2 = name1;
				value2 = value1;
				name1 = name;
			}
			else {
				if (value > value2) {
					name2 = name;
					value2 = value;
				}
				else if (value == value2 && name < name2)
					name2 = name;
			}
		}
		else {
			if (value > value2) {
				name2 = name;
				value2 = value;
			}
			else if (value == value2 && name < name2)
				name2 = name;
		}
	}
	cout << name1 << "\n" << name2 << endl;
}

S1ComputerPurchase::~S1ComputerPurchase() {
	// TODO Auto-generated destructor stub
}

