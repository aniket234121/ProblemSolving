package problemSolvingTechniques.slidingWindow;

import java.util.Arrays;

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
    public static int maxSumInSubarray(int[] nums,int k)
    {
        int maxSum,windowSum;
        maxSum=windowSum=0;
        for(int i=0;i<k;i++)
        {
            windowSum+=nums[i];
        }
        maxSum=windowSum;

        for(int i=k;i<nums.length;i++)
        {
            windowSum+=(nums[i]-nums[i-k]);
            maxSum=Math.max(maxSum,windowSum);
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
    public static int calculateMaxInArray(int nums[],int start,int end)
    {
        int max=0;
        for(int i=start;i<end;i++)
        {
            max=Math.max(nums[i],max);
        }
        return max;
    }

    public static int[] maxInWindow(int[]nums,int k)
    {
        int counter=k;
        int [] result=new int[nums.length-k+1];
        int windowMax=calculateMaxInArray(nums,0,k);
        for(int i=0;i<nums.length-k+1;i++)
        {
            int removeValue=nums[i];
            result[i]=windowMax;
            if(windowMax!=removeValue)
            {
                windowMax=Math.max(windowMax,nums[counter]);
                if(counter<nums.length-1)counter++;
            }
            else {
                windowMax=calculateMaxInArray(nums,i+1,i+k+1);
                if(counter<nums.length-1)counter++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,12,-5,-6,50,3};

        //Find Max Avg Q .643
        System.out.println("max consecutive avg from array: "+ Arrays.toString(nums));
        System.out.println(findMaxAverage(nums,4)); //output- 12.7500


        //practice problem
        // Q.1
        int [] array1=new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(maxSumInSubarray(array1,3));

        //Q.2
        int[]array2=new int[]{4, 2, 12, 3, 8};
        System.out.println(Arrays.toString(maxInWindow(array2,2)));


    }
}
