class Solution {
    public void sortColors(int[] nums) {
        // Create a TreeMap to store counts of each color (0, 1, 2)
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Count the occurrences of each color and store in the TreeMap
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Fill the original array based on the counts in ascending order
        int index = 0;
        for (int color : map.keySet()) {
            int count = map.get(color);
            for (int i = 0; i < count; i++) {
                nums[index++] = color;
            }
        }
    }
}
