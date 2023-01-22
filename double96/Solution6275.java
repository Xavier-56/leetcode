package double96;

public class Solution6275 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if(k==0) return -1;
        int n = nums1.length;
        int sum1 = 0;
        int sum2 = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if ((nums1[i] - nums2[i])%k==0){
                a[i] = (nums1[i] - nums2[i]) / k;
                if (a[i] < 0) sum1 += a[i];
                else sum2 += a[i];
            }else {
                return -1;
            }
        }
        if (sum1+sum2==0){
            return Math.abs(sum1);
        }else {
            return -1;
        }
    }
}
