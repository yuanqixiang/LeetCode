package leetcode.dynamicProgramming;

public class _0053_MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0)
                sum = num;
            else
                sum += num;
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public  int solution(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1;  i < A.length; ++i){
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
