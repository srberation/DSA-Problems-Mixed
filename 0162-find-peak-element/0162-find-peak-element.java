class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0; // Special case: There's only one element, which is a peak.
        }

        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
