class Solution {
    public int trap(int[] height) {
         int left = 0;
        int right = height.length-1;
        int total = 0;
        int Lmax = height[0];
        int Rmax = height[right];
        while (left<right){
            if (height[left] < height[right]){
                Lmax = Math.max(Lmax,height[left]);
                if (Lmax-height[left] > 0){
                    total = total + Lmax-height[left];
                }
                left++;
            }else {
                Rmax = Math.max(Rmax, height[right]);
                if (Rmax-height[right] > 0){
                    total = total + Rmax-height[right];
                }
                right--;
            }
        }
        return total;
        
    }
}
