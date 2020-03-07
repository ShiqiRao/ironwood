package tech.dzion.rapier.p059;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MaxQueue
 * @Author Rao Shiqi
 * @Date 2020/3/7 20:35
 * @Description TODO
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> deque;


    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (deque.peekLast() != null&&deque.peekLast()<value){
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int ret = queue.poll();
        if (deque.peekFirst() == ret){
            deque.pollFirst();
        }
        return ret;
    }
}
