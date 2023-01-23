package com.jaweee.linkedlist;

import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/23 11:15
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class MergeTwoLists {

    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, list1);
        ListNode p1 = list1, p2 = list2, pre = dummy;
        while(p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pre.next = p1;
                p1 = p1.next;
            }
            else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        if (p1 != null){
            pre.next = p1;
        }
        else if (p2 != null){
            pre.next = p2;
        }
        return dummy.next;
    }
}
