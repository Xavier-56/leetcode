package everyday;

public class LeetCode2023_1_28_1664生成平衡数组的方案数 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        odd[0] = 0;
        even[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                even[i] = even[i - 1] + nums[i];
                odd[i] = odd[i - 1];
            } else {
                odd[i] = odd[i - 1] + nums[i];
                even[i] = even[i - 1];
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int leftOdd = i - 1 >= 0 ? odd[i - 1] : 0;
            int leftEven = i - 1 >= 0 ? even[i - 1] : 0;
            int rightOdd = odd[n - 1] - odd[i];
            int rightEven = even[n - 1] - even[i];
            int temp = rightEven;
            rightEven = rightOdd;
            rightOdd = temp;
            if (leftEven + rightEven == rightOdd + leftOdd) {
                result++;
            }
        }
        return result;
    }
}
