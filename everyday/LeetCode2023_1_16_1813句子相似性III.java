package everyday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 对于输入的两个句子，将其转换为双端队列，分别循环比较队头和队尾元素，若相同则出队，
 * 最后若其中一个句子为空 返回true
 */
public class LeetCode2023_1_16_1813句子相似性III {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] l1 = sentence1.split(" ");
        String[] l2 = sentence2.split(" ");
        Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(l1));
        Deque<String> deque2 = new ArrayDeque<>(Arrays.asList(l2));
        while (!deque1.isEmpty() && !deque2.isEmpty() && deque1.peekFirst().equals(deque2.peekFirst())) {
            deque1.pollFirst();
            deque2.pollFirst();
        }
        while (!deque1.isEmpty() && !deque2.isEmpty() && deque1.peekLast().equals(deque2.peekLast())) {
            deque1.pollLast();
            deque2.pollLast();
        }
        if (deque1.isEmpty() || deque2.isEmpty()) return true;
        else return false;
    }
}
