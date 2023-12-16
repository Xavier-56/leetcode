package classic150;


public class Q3_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
