package everyday;

public class LeetCode2023_7_5_2600K件物品的最大和 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) return k;
        else if (k <= numZeros + numOnes) {
            return numOnes;
        } else return numOnes - (k - numOnes - numZeros);
    }
}
