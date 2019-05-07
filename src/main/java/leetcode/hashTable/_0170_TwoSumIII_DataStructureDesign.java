package leetcode.hashTable;


import java.util.HashMap;
import java.util.Map;

/*
 * Design and implement a TwoSum class. It should support the following operations:add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * For example,
 *
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 *
 */
public class _0170_TwoSumIII_DataStructureDesign {
    private Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int target) {
        for (Integer i : map.keySet()) {
            int value = target - i;
            if (map.containsKey(target)) {
                if (i == value && map.get(value) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
