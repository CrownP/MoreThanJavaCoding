package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/09 13:01
 */
public class Code3_03_QueueAndStack {

    /**
     * 一、【如何仅用队列结构实现栈结构】
     */
    public static class twoQueueToStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public twoQueueToStack(Queue<Integer> data, Queue<Integer> help) {
            this.data = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        public void push(int obj) {
            data.add(obj);
        }

        public int pop() {
            // 空判断
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty ! ");
            }
            while (data.size() > 1) {  // 只要data长度大于1，就把data队列前面的数都poll出来到helo队列里去
                help.add(data.poll());
            }
            int temp = data.poll();  //缓存一下最终答案，此时data队列为null
            swap(data, help);  // 更换指针引用
            return temp;
        }

        public int peek() {
            // 空判断
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty ! ");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int temp = data.poll();
            help.add(temp);
            swap(data, help);
            return temp;
        }


        /* 更换队列指针引用的方法 */
        public void swap(Queue<Integer> data, Queue<Integer> help) {
            Queue<Integer> tem = data;  // 更换data与help的指针引用
            data = help;
            help = tem;
        }

    }

    /**
     * 二、【如何仅用栈结构实现队列结构】
     */
    public static class TowStackToQueue {
        private Stack<Integer> pushStack = new Stack<>();
        private Stack<Integer> popStack = new Stack<>();

        public void push(int num) {
            pushStack.push(num);
        }

        public int pop() {
            //非空判断
            if (pushStack.empty() && popStack.empty()) {
                throw new RuntimeException(" This Queue is emtpy ! ");
            }
            if (popStack.empty()) {   // 如果pop栈为空，就把所有push栈的元素 pop 进到pop栈
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        public int peek() {
            //非空判断
            if (pushStack.empty() && popStack.empty()) {
                throw new RuntimeException(" This Queue is emtpy ! ");
            }
            if (popStack.empty()) {   // 如果pop栈为空，就把所有push栈的元素 pop 进到pop栈
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }
    }

}
