package leetcode.twoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * the same as 3Sum.
 */
public class _0018_4Sum {
    public List<List<Integer>> solution(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int n;
        if((n = nums.length) < 4) return res;
        if(nums[0] + nums[1] + nums[2] + nums[3] > target) return res;
        if(nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[n - 4] < target) return res;

        for(int i = 0; i < n - 3; ++i){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; ++j){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = n - 1;
                while(left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if(sum < target) left++;
                    else if(sum > target) right--;
                    else
                    {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        do{
                            left++;
                        } while(nums[left] == nums[left - 1] && left < right);
                        do{
                            right--;
                        } while(nums[right] == nums[right + 1] && left < right);
                    }
                }
            }
        }
        return res;
    }
}
