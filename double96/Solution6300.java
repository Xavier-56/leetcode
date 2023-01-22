package double96;

import java.util.*;

public class Solution6300 {
    public int getCommon(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int k : nums1) {
            for (int j:nums2){
                if (k==j) return k;
            }
        }
        return -1;
    }
}
