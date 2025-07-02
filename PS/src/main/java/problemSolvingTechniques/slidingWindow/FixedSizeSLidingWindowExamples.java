package problemSolvingTechniques.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FixedSizeSLidingWindowExamples {

/*
643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
*/

    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg, windowAvg;

        maxAvg = windowAvg = 0;
        for (int i = 0; i < k; i++) {
            windowAvg += nums[i];
            if (i == k - 1) windowAvg /= k;
        }
        maxAvg = windowAvg;
        for (int i = k; i < nums.length; i++) {
            windowAvg *= k;
            windowAvg = windowAvg + nums[i] - nums[i - k];
            windowAvg /= k;
            maxAvg = Math.max(windowAvg, maxAvg);
        }
        return maxAvg;
    }

    // Practice Problems.md

    //question 1...
    /*

    1. Maximum Sum of Subarray of Size K (Fixed Size)
Problem:
Given an integer array nums and an integer k, return the maximum sum of any contiguous subarray of size k.

Input:

nums: List of integers
k: Integer (1 ≤ k ≤ nums.length)
Output:

Integer representing the maximum sum
Test Case 1: Input: nums = [2, 1, 5, 1, 3, 2], k = 3 Output: 9

Explanation:
Subarrays of size 3:

[2, 1, 5] → sum = 8
[1, 5, 1] → sum = 7
[5, 1, 3] → sum = 9 ✅
[1, 3, 2] → sum = 6
Maximum sum = 9
Test Case 2: Input: nums = [1, 9, -1, -2, 7, 3], k = 2 Output: 10

Explanation:
Subarrays of size 2:

[1, 9] → sum = 10 ✅
[9, -1] → sum = 8
[-1, -2] → sum = -3
[-2, 7] → sum = 5
[7, 3] → sum = 10 ✅
Maximum sum = 10

     */
    public static int maxSumInSubarrayOfSizeK(int[] nums, int k) {
        int maxSum, windowSum;
        maxSum = windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += (nums[i] - nums[i - k]);
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    /*
    2. Maximum in Each Sliding Window (Fixed Size)
Problem:
Given an array nums and an integer k, return an array of the maximum values in each sliding window of size k.

Input:

nums: List of integers
k: Integer
Output:

List of integers representing max of each window
Test Case 1: Input: nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3 Output: [3, 3, 5, 5, 6, 7]

Explanation:
Sliding windows:

[1, 3, -1] → max = 3
[3, -1, -3] → max = 3
[-1, -3, 5] → max = 5 ✅
[-3, 5, 3] → max = 5 ✅
[5, 3, 6] → max = 6 ✅
[3, 6, 7] → max = 7 ✅
Test Case 2: Input: nums = [4, 2, 12, 3, 8], k = 2 Output: [4, 12, 12, 8]

Explanation:
Sliding windows:

[4, 2] → max = 4
[2, 12] → max = 12 ✅
[12, 3] → max = 12 ✅
[3, 8] → max = 8 ✅

     */
    public static int calculateMaxInArray(int nums[], int start, int end) {
        int max = nums[start];
        for (int i = start; i < end; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    /*
    *Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2.
Window 2 of size k = 2 is 1 1. Number of distinct elements in this window is 1.
Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]
    * */

    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Build initial window
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freqMap.size());

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the element going out of the window
            int outElem = arr[i - k];
            freqMap.put(outElem, freqMap.get(outElem) - 1);
            if (freqMap.get(outElem) == 0) {
                freqMap.remove(outElem);
            }

            // Add the new element coming into the window
            int inElem = arr[i];
            freqMap.put(inElem, freqMap.getOrDefault(inElem, 0) + 1);

            // Add current distinct count
            result.add(freqMap.size());
        }

        return result;
    }


    public static int[] maxInWindow(int[] nums, int k) {
        int counter = k;
        int[] result = new int[nums.length - k + 1];
        int windowMax = calculateMaxInArray(nums, 0, k);
        for (int i = 0; i < nums.length - k + 1; i++) {
            int removeValue = nums[i];
            result[i] = windowMax;
            if (windowMax != removeValue) {
                windowMax = Math.max(windowMax, nums[counter]);
                if (counter < nums.length - 1) counter++;
            } else {
                windowMax = calculateMaxInArray(nums, i + 1, i + k + 1);
                if (counter < nums.length - 1) counter++;
            }

        }

        return result;
    }

    /*
    3. Longest Substring Without Repeating Characters (Variable Size)
    Problem:
    Given a string s, return the length of the longest substring without repeating characters.

            Input:

    s: String
    Output:

    Integer representing maximum length of substring with all unique characters
    Test Case 1: Input: s = "abcabcbb" Output: 3

    Explanation:
    Valid substrings without repeating characters:

            "abc" (length 3)
    Other substrings like "bca", "cab" also have length 3
    Maximum = 3
    Test Case 2: Input: s = "bbbbb" Output: 1

    Explanation:
    All characters are 'b', so only valid substrings are individual characters: "b"
    Maximum = 1
*/

    public static int maxUniqueSubstring(String str) {
        char[] array = str.toCharArray();
//        int left=0;
        int right = 0;
        int maxLength = 0;
        ArrayList<Character> list = new ArrayList<>();
        while (right < array.length) {
            boolean notUnique = list.contains(array[right]);
            list.add(array[right]);

            while (notUnique) {
                if (list.remove(0) == array[right]) {
                    notUnique = false;
                }
            }
            maxLength = Math.max(maxLength, list.size());

            right++;
        }
        return maxLength;
    }

    /*

    4. Minimum Size Subarray Sum (Variable Size)
Problem:
Given an array of positive integers nums and a target integer target, return the minimum length of a contiguous subarray whose sum is greater than or equal to target. If no such subarray exists, return 0.

Input:

nums: List of positive integers
target: Integer
Output:

Integer representing the minimum length
Test Case 1: Input: target = 7, nums = [2, 3, 1, 2, 4, 3] Output: 2

Explanation:
Subarrays with sum ≥ 7:

[4, 3] → sum = 7, length = 2 ✅
Other subarrays are longer or smaller in sum
Minimum length = 2
Test Case 2: Input: target = 15, nums = [1, 2, 3, 4, 5] Output: 5

Explanation:
Only subarray with sum ≥ 15 is entire array: [1, 2, 3, 4, 5]
Sum = 15, length = 5
Minimum length = 5

     */
    public static int minimumSubarraySum(int[] nums, int target) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowLength = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            sum += nums[right];
            windowLength++;

            while (sum >= target) {
                minLength = Math.min(windowLength, minLength);
                sum -= nums[left];
                left++;
                windowLength--;
            }

            right++;
        }
        return minLength;
    }

    public static int longestSubstring(String str, int k) {

        int right = 0;

        int maxLength = 0;
        int windowLength = 0;
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        while (right < arr.length) {
            if (map.containsKey(arr[right]))
                map.put(arr[right], map.get(arr[right]) + 1);
            else map.put(arr[right], 1);
            windowLength++;

            boolean check = true;
            for (Character ch : map.keySet()) {
                if (map.get(ch) < k) {
                    check = false;
                }
            }
            if (check) {
                maxLength = Math.max(maxLength, windowLength);
            }

            right++;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};

        //Find Max Avg Q .643
        System.out.println("max consecutive avg from array: " + Arrays.toString(nums));
        System.out.println(findMaxAverage(nums, 4)); //output- 12.7500


        //practice problem
        // Q.1
        int[] array1 = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(maxSumInSubarrayOfSizeK(array1, 3));

        //Q.2
        int[] array2 = new int[]{4, 2, 12, 3, 8};
        System.out.println(Arrays.toString(maxInWindow(array2, 2)));

        //Q3.
        String str = "bbbbbb";
        System.out.println(maxUniqueSubstring(str));

        //Q.4
        System.out.println("minimum size of sum: " + minimumSubarraySum(new int[]{1, 2, 3, 4, 5}, 15));
        System.out.println("minimum size of sum: " + minimumSubarraySum(new int[]{2, 3, 1, 2, 4, 3}, 7));

        System.out.println(longestSubstring("bbaaacbd", 3));



    }
}
