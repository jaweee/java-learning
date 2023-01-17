package com.jaweee.linkedlist;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 14:52
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class ReverseList {

    public ListNode reverseKGroup(ListNode head, int k) {
        //
        ListNode dummy = new ListNode(-1, head);
        ListNode ptr = dummy, pre = dummy;
        int count = 0;
        while(ptr != null){
            // 计数<k, 并且ptr=null，此时退出循环
            ListNode temp = pre.next, headof = pre.next;
            if(count == k){
                while(pre.next != ptr){
                    pre.next = temp.next;
                    temp.next = ptr.next;
                    ptr.next = temp;
                    temp = pre.next;
                }
                pre = headof;
                ptr = pre;
                count = 0;
            }
            ptr = ptr.next;
            count++;
        }
        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        for(int i=0; i<right; i++){
            if(i < left-1){
                slow = slow.next;
            }
            fast = fast.next;
        }
        ListNode tail = fast.next;
        ListNode temp = slow.next;
        while(slow.next != fast){
            slow.next = temp.next;
            temp.next = tail;
            fast.next = temp;
            tail = temp;
            temp = slow.next;
        }
        return dummy.next;
    }
}
