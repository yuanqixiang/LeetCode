#include <iostream>
#include <vector>
using namespace std;

int find_sec_max(vector<int> &arr)
{
	int maxNum = arr[0];
	int secMax = INT_MIN;
	for (size_t i = 0; i < arr.size(); ++i)
	{
		if (arr[i] > maxNum)
		{
			secMax = maxNum;
			maxNum = arr[i];
		}
		else
		{
			if (arr[i] > secMax)
				secMax = arr[i];
		}
	}
	return secMax;
}

int main(void)
{
	vector<int> arr = { 0,1,2,3,4,5,6,7,8,9,10,13 };
	cout << find_sec_max(arr) << endl;
	return 0;
}
