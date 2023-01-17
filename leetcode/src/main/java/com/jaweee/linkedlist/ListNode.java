package com.jaweee.linkedlist;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/12/6 10:28
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
