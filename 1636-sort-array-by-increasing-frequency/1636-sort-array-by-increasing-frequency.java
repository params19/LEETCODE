import java.util.*;

class Solution {
    public static int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) 
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a custom comparator for sorting
        Comparator<Integer> comparator = (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) 
            {
                return Integer.compare(freqA, freqB);
            } 
            else 
            {
                return Integer.compare(b, a); // For equal frequency, sort by value in decreasing order
            }
        };

        // Step 3: Convert array to list for sorting
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        // Step 4: Sort the list using the custom comparator
        numList.sort(comparator);

        // Step 5: Convert list back to array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numList.get(i);
        }

        return nums;
    }

}
