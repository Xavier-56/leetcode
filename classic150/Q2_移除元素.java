package classic150;

public class Q2_移除元素 {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int num : nums) {
            if (num != val){
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }
}
