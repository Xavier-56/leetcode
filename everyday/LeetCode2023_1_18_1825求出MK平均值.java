package everyday;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 我们使用三个集合s1，s2，s3保存最小的k个元素、中间的m-2k个元素、最后k个元素，sum2保存s2中所有元素只和，用队列q保存最后m个元素
 * 将新加的元素放入队列q中，对q的数目进行判断
 * 1.若q元素小于等于m
 * 将num插入有序集合s2中，并更新sum2=sum2+num。如果q元素数目为m，只需要将s2最小的k个元素和最大的k个元素移动到s1 s2并更新sum2
 * 2.若q元素数目等于m+1
 * 如果num小于s1的最大元素，将num插入s1中，并更新sum2，如果num大于s3的最小元素，将num插入s3中，并将s3中最小元素移动到s2，更新sum2
 * 3.从队列中取出首元素x，对于带删除元素x
 * 如果x在s2中，直接删除，如果在s1中，删除后将s2中最小元素移动到s1，如果在s3中，删除后将s2中最大元素移动到s3
 * <p>
 * 最后如果队列中的元素数目小于q，直接返回-1，否则返回sum2/(m-2*k)
 */
public class LeetCode2023_1_18_1825求出MK平均值 {
    private int m, k;
    private Queue<Integer> q;
    private TreeMap<Integer, Integer> s1;
    private TreeMap<Integer, Integer> s2;
    private TreeMap<Integer, Integer> s3;
    private int size1, size2, size3;
    private long sum2;

    public LeetCode2023_1_18_1825求出MK平均值(int m, int k) {
        this.m = m;
        this.k = k;
        this.q = new ArrayDeque<Integer>();
        this.s1 = new TreeMap<Integer, Integer>();
        this.s2 = new TreeMap<Integer, Integer>();
        this.s3 = new TreeMap<Integer, Integer>();
        this.size1 = 0;
        this.size2 = 0;
        this.size3 = 0;
        this.sum2 = 0;
    }

    public void addElement(int num) {
        q.offer(num);
        if (q.size() <= m) {
            s2.put(num, s2.getOrDefault(num, 0) + 1);
            size2++;
            sum2 += num;
            if (q.size() == m) {
                while (size1 < k) {
                    int firstNum = s2.firstKey();
                    s1.put(firstNum, s1.getOrDefault(firstNum, 0) + 1);
                    size1++;
                    sum2 -= firstNum;
                    s2.put(firstNum, s2.get(firstNum) - 1);
                    if (s2.get(firstNum) == 0) {
                        s2.remove(firstNum);
                    }
                    size2--;
                }
                while (size3 < k) {
                    int lastNum = s2.lastKey();
                    s3.put(lastNum, s3.getOrDefault(lastNum, 0) + 1);
                    size3++;
                    sum2 -= lastNum;
                    s2.put(lastNum, s2.get(lastNum) - 1);
                    if (s2.get(lastNum) == 0) {
                        s2.remove(lastNum);
                    }
                    size2--;
                }
            }
            return;
        }

        if (num < s1.lastKey()) {
            s1.put(num, s1.getOrDefault(num, 0) + 1);
            int lastNum = s1.lastKey();
            s2.put(lastNum, s2.getOrDefault(lastNum, 0) + 1);
            size2++;
            sum2 += lastNum;
            s1.put(lastNum, s1.get(lastNum) - 1);
            if (s1.get(lastNum) == 0) {
                s1.remove(lastNum);
            }
        } else if (num > s3.firstKey()) {
            s3.put(num, s3.getOrDefault(num, 0) + 1);
            int firstNum = s3.firstKey();
            s2.put(firstNum, s2.getOrDefault(firstNum, 0) + 1);
            size2++;
            sum2 += firstNum;
            s3.put(firstNum, s3.get(firstNum) - 1);
            if (s3.get(firstNum) == 0) {
                s3.remove(firstNum);
            }
        } else {
            s2.put(num, s2.getOrDefault(num, 0) + 1);
            size2++;
            sum2 += num;
        }

        int x = q.poll();
        if (s1.containsKey(x)) {
            s1.put(x, s1.get(x) - 1);
            if (s1.get(x) == 0) {
                s1.remove(x);
            }
            int firstNum = s2.firstKey();
            s1.put(firstNum, s1.getOrDefault(firstNum, 0) + 1);
            sum2 -= firstNum;
            s2.put(firstNum, s2.get(firstNum) - 1);
            if (s2.get(firstNum) == 0) {
                s2.remove(firstNum);
            }
            size2--;
        } else if (s3.containsKey(x)) {
            s3.put(x, s3.get(x) - 1);
            if (s3.get(x) == 0) {
                s3.remove(x);
            }
            int lastNum = s2.lastKey();
            s3.put(lastNum, s3.getOrDefault(lastNum, 0) + 1);
            sum2 -= lastNum;
            s2.put(lastNum, s2.get(lastNum) - 1);
            if (s2.get(lastNum) == 0) {
                s2.remove(lastNum);
            }
            size2--;
        } else {
            s2.put(x, s2.get(x) - 1);
            if (s2.get(x) == 0) {
                s2.remove(x);
            }
            size2--;
            sum2 -= x;
        }
    }

    public int calculateMKAverage() {
        if (q.size() < m) {
            return -1;
        }
        return (int) (sum2 / (m - 2 * k));
    }
}
