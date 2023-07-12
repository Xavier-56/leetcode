package everyday;

public class LeetCode2023_7_12_2544交替数字和 {
    public int alternateDigitSum(int n) {
        int sum = 0, sign = 1;
        while (n != 0) {
            sum += sign * (n % 10);
            sign *= -1;
            n = n / 10;
        }
        return -sign * sum;
    }
}
