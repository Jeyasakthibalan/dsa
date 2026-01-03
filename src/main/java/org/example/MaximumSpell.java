import java.util.*;

class Solution {
    private static long findMaxPower(List<Integer> power, int index, int last, TreeMap<Integer, Integer> map, Map<String, Long> memo) {
        if (index >= power.size()) return 0;

        String key = index + "," + last;
        if (memo.containsKey(key)) return memo.get(key);

        // Option 1: skip current power
        long skip = findMaxPower(power, index + 1, last, map, memo);

        // Option 2: take current power (only if valid)
        long take = 0;
        if (power.get(index) - last > 2) { // <-- Correct distance condition
            take = (long) power.get(index) * map.get(power.get(index)) +
                    findMaxPower(power, index + 1, power.get(index), map, memo);
        }

        long res = Math.max(skip, take);
        memo.put(key, res);
        return res;
    }

    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Map<String, Long> memo = new HashMap<>();
        return findMaxPower(list, 0, -10, map, memo); // sentinel val
    }
}
