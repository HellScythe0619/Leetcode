/*
 * @lc app=leetcode id=381 lang=java
 *
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Use ArrayList and HashMap<Integer, HashSet<Integer>>
 * ArrayList 紀錄所有 val
 * HashMap 紀錄 val 對應所有的 index
 * 重點為 remove 時，須將要 delete val 的 index 與 最末尾數字 index 對調
 * 
 * runtime: 96.62% (29 ms)
 * memory: 66.21% (91.6 MB)
 */
class RandomizedCollection {

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        list.add(val);
        if (!map.containsKey(val)) {
            Set<Integer> set = new HashSet<>();
            set.add(list.size() - 1);
            map.put(val, set);
            return true;
        } else {
            Set<Integer> set = map.get(val);
            set.add(list.size() - 1);
            return false;
        }
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int deleteIndex = map.get(val).iterator().next();
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);

            // 使用 swap 調換要刪除的數字至 list 最尾
            list.set(lastIndex, val);
            list.set(deleteIndex, lastVal);

            // 刪除最後尾數字 (即為要刪除的 val)
            list.remove(lastIndex);
            // 刪除對應的index
            map.get(val).remove(deleteIndex);

            // 刪除空的set，減少memory
            if (map.get(val).size() == 0) {
                map.remove(val);
            }

            if (map.containsKey(lastVal)) {
                // 刪除原先最末尾數字的index
                map.get(lastVal).remove(lastIndex);
                // 因為swap過，其deleteIndex為最新的index
                map.get(lastVal).add(deleteIndex);
            }

            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

