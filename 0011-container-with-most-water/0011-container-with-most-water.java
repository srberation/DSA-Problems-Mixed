class Solution {
    public int maxArea(int[] h) {
        int left = 0;
        int right = h.length-1;
        int max_Area = 0;

        while(left < right){
            int area = (right-left) * (Math.min(h[left],h[right]));
            max_Area = Math.max(area,max_Area);
            if(h[left] > h[right]) right--;
            else left++;
        }

        return max_Area;
    }
}