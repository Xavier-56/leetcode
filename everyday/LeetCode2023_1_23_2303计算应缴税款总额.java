package everyday;

public class LeetCode2023_1_23_2303计算应缴税款总额 {
    public double calculateTax(int[][] brackets, int income) {
        int result = 0;
        int present = 0;
        for (int[] bracket : brackets) {
            if (income < bracket[0]) {
                result += (income - present) * bracket[1];
                break;
            }
            result += (Math.min(bracket[0], income) - present) * bracket[1];
            present = bracket[0];
        }
        return (double) result / 100.0;
    }
}
