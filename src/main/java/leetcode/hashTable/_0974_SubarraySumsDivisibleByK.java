package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

public class _0974_SubarraySumsDivisibleByK {
    public int solution(int[] A, int K) {
        /*
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;
            if(map.containsKey(sum))
                count += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
        */
        int n = A.length, preSum = 0;
        int[] mod = new int[K];
        mod[0] = 1; //因为在开始迭代之前，前0个数的和为0，其对K的mod也是0，算一个。
        for(int a : A){
            preSum += a;
            mod[((preSum % K) + K) % K]++;
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            if (mod[i] > 1) {
                ans += (mod[i] * (mod[i] - 1)) / 2;
            }
        }
        return ans;
    }
}
