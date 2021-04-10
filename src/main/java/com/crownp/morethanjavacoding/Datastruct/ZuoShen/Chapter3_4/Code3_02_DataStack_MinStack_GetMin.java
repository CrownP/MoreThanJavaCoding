package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;

import java.util.Stack;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/09 11:34
 */
public class Code3_02_DataStack_MinStack_GetMin {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Code3_02_DataStack_MinStack_GetMin(Stack<Integer> dataStack, Stack<Integer> minStack) {
        this.dataStack = dataStack;
        this.minStack = minStack;
    }

    public void push(int obj) {
        dataStack.push(obj);
        if (minStack.empty()) {
            minStack.push(obj);
        } else {
            minStack.push(obj < minStack.peek() ? obj : minStack.peek());
        }
    }

    public int pop() {
        if (dataStack.empty()) {
            throw new RuntimeException("Stack is empty ! ");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin() {
        if (dataStack.empty()) {
            throw new RuntimeException("Stack is empty ! ");
        }
        return minStack.peek();
    }

}
