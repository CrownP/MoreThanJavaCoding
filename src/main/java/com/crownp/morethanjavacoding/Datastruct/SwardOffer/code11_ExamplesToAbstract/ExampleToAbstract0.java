package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code11_ExamplesToAbstract;

import java.util.Stack;

/**
 * @Author: crownp
 * @Description: 举例让抽象具体化
 * @Date: 2020/03/04 12:59
 */
public class ExampleToAbstract0 {
    /**
     * 【包含min函数的栈】 面试题30
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数。时间复杂度应为 O(1)
     * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
     *
     * 【思路总结】
     * 用一个辅助栈来存放最小的值，并保持与数据栈一样的长度。当前值node小于辅助栈的值时，辅助栈push当前值，否则push本身的值。
     * 也可以使用两个ArrayList来实现，但需要一个指针int head指向头部位置0，每次pop值的时候修改该head的值。
     */

    //定义数据栈
    Stack<Integer> dataStack = new Stack();
    //定义辅助栈
    Stack<Integer> minStack = new Stack();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
        } else {
            //如果要push进来的值比当前最小值要小，把node push进minStack
            if (node < minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
