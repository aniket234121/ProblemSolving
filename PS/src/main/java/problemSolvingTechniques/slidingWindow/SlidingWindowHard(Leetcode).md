# 1. Subarrays with K Different Integers

Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.



**Example 1:**

Input: nums = [1,2,1,2,3], k = 2

Output: 7

Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

**Example 2:**

Input: nums = [1,2,1,3,4], k = 3

Output: 3

Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

Solution:-

"Count subarrays with exactly k distinct integers"

You use this trick:

    exactlyK = atMost(k) - atMost(k - 1);

Because:

**atMost ( k )** includes all subarrays with ≤ k distinct elements

**atMost (k - 1)** includes all subarrays with ≤ (k - 1) distinct elements

So the difference gives you subarrays with exactly k distinct elements

```
class Solution {
    public int atMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0, distinctCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (map.getOrDefault(nums[right], 0) == 0) {
                distinctCount++;
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (distinctCount > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                    distinctCount--;
                }
                left++;
            }

            // all subarrays ending at `right` and starting from `left` to `right` are valid
            count += right - left + 1;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}
```