package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;

/**
 * @Author: crownp
 * @Description: 第三节的内容
 * @Date: 2020/03/09 9:48
 */
public class code3_01_Array_To_Stack_Queue {

    /**
     * 用数组实现一个固定长度的栈
     */
    public static class ArrayStack {
        private Integer[] arr;  // 实现的数组
        private Integer index;  // 指向栈顶元素

        public ArrayStack(int initSize) {  // 构造参数重载。初始化固定长度的数组
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = -1;
        }

        public Integer peek() {  // 获取当前栈顶元素，但不remove
            if (index == -1) {
                return null;
            }
            return arr[index];
        }

        public void push(int obj) {
            if (index == arr.length - 1) {  // 数组越界
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[++index] = obj;
        }

        public Integer pop() {
            if (index == -1) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[index--];
        }
    }


    /**
     * 数组实现固定长度的队列
     */
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer start;  // 指向队列头
        private Integer end;  // 指向队列尾,还没填入元素的空间
        private Integer size; // 当前数组中有元素的大小

        public ArrayQueue(int initSize) {  // 初始化数组大小
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            start = 0;
            end = 0;
            size = 0;
        }

        public void add(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The Queue is full ! ");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;  // 如果end等于length-1，说明到头了，然后把end指向0
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The Queue is empty ! ");
            }
            size--;
            int temp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[temp];
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
    }
}
