# 1.Remove Duplicates from Sorted Array

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.

    Example 1:
    
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    
    Example 2:
    
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).


Solution:-

### Steps:

1. **Initialize Two Pointers**:
    - `left = 0` → points to the last unique element.
    - `right = 0` → used to scan the array.


2. **Iterate While `right < nums.length`**:
    - If `nums[right] != nums[left]`:
        - Increment `left` by 1.
        - Assign `nums[left] = nums[right]`.


3. **Increment `right`** in every iteration.

4. After the loop ends, the subarray `nums[0...left]` contains all unique elements.

5. **Return `left + 1`** as the new length of the modified array.

**Code**
```
    class Solution {
        public int removeDuplicates(int[] nums) {
            int left,right;
            left=right=0;
            while(right<nums.length)
            {
                if(nums[right]!=nums[left]){
                nums[left+1]=nums[right];
                left++;
                }
                
                right++;
            }
            return left+1;
        }
    }
```



# 2. Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]

Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]

Output: ["h","a","n","n","a","H"]

```
    public void reverseString(char[] s) {
        int right=s.length-1;
        int left=0;
        while(left<right)
        {
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
```

# 3. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"

Output: true

Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"

Output: false

Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "

Output: true

Explanation: s is an empty string "" after removing non-alphanumeric characters.

Since an empty string reads the same forward and backward, it is a palindrome.

```

   public boolean isPalindrome(String s) {
           int left = 0, right = s.length() - 1;
   
           while (left < right) {
               while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                   left++;
               while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                   right--;
   
               if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                   return false;
               }
               left++;
               right--;
           }
           return true;
       }

```

# 4.Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9

Output: [1,2]

Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:

Input: numbers = [2,3,4], target = 6

Output: [1,3]

Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: numbers = [-1,0], target = -1

Output: [1,2]

Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


```
   
     public int[] twoSum(int[] numbers, int target) {
           int right=numbers.length-1;
           int left=0;
           while(left<right)
           {   int sum=numbers[right]+numbers[left];
               if(sum==target) return new int[]{left+1,right+1};
               else if(sum>target)right--;
               else left++;
           }
           return null;
       }

```

# 5. Move zeros
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]

Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]

Output: [0]
```
       public void moveZeroes(int[] nums) {
              int left=0;
              int right=0;
              while(right<nums.length)
              {
                  if(nums[right]!=0)
                  {   int temp=nums[left];
                      nums[left]=nums[right];
                      nums[right]=temp;
                      left++; 
      
                  }
      
                  right++;
              }
          }

```

# 6. Remove Element
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.


Example 1:

Input: nums = [3,2,2,3], val = 3

Output: 2, nums = [2,2,_,_]

Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2

Output: 5, nums = [0,1,4,0,3,_,_,_]

Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.

Note that the five elements can be returned in any order.

It does not matter what you leave beyond the returned k (hence they are underscores).

```
   
   public int removeElement(int[] nums, int val) {
           if(nums.length==0) return 0;
           int left=0;
           int right;
           while(left<nums.length&&nums[left]!=val){left++;}
   
           right=left+1;
           while(right<nums.length)
           {
               if(nums[right]!=val)
               {   int temp=nums[left];
                   nums[left]=nums[right];
                   nums[right]=temp;
                   while(left<nums.length&&nums[left]!=val){left++;}
               }
   
               right++;
           }
           return left;
       }

```