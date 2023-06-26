package everyday;

public class LeetCode2023_6_26_2485找出中枢整数 {
    public int pivotInteger(int n) {
        for (int i=1;i<=n;i++){
            if (sum(1,i)==sum(i,n)){
                return i;
            }
        }
        return -1;
    }
    public int sum(int a, int b){
        int sum = 0;
        for (int i=a;i<=b;i++){
            sum+=i;
        }
        return sum;
    }
}
