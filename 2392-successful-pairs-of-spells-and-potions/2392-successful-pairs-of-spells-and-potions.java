import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
   
        int n = potions.length - 1;
        Arrays.sort(potions);
        int maxPotion = potions[n];

        for (int i = 0; i < spells.length; i++) {
            long key = (long) Math.ceil((double) success / spells[i]);

            if (key > maxPotion) {
                pairs[i] = 0;
                continue;
            }

            int index = lower_bound(potions, key);

            int count = n - index + 1;

            pairs[i] = count;
        }

        return pairs;
    }

    public int lower_bound(int[] potions, long key) {
        int left = 0;
        int right = potions.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (potions[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
