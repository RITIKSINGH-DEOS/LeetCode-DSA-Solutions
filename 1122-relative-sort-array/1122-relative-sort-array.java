import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int index = 0;

        for (int num : arr2) {
            int count = map.get(num);

            while (count > 0) {
                arr1[index++] = num;
                count--;
            }

            map.remove(num);
        }

        List<Integer> remaining = new ArrayList<>();

        for (int num : map.keySet()) {
            for (int i = 0; i < map.get(num); i++) {
                remaining.add(num);
            }
        }

        Collections.sort(remaining);

        for (int num : remaining) {
            arr1[index++] = num;
        }

        return arr1;
    }
}