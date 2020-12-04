package com.leetcode.model;

import java.io.Serializable;

/**
 * @className: ListNode
 * @author: wangyulong
 * @datetime: 2019-07-09 15:18
 * @description: 链表对象
 */
public class ListNode implements Serializable {
	private static final long serialVersionUID = 1L;

	int val;

    ListNode next;

    public ListNode(int val, ListNode next) {
        super();
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
