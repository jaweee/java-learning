package com.jaweee.algorithmtest;

import com.jaweee.algorithm.mylinkedlists.Leetcode;
import com.jaweee.algorithm.mylinkedlists.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/12/6 10:36
 * @github: https://github.com/jaweee
 * @version: 1.0
 */

public class ListAlgorithm {

    @Test
    public void testReverseKGroup(){
        Leetcode leetcode = new Leetcode();
        ListNode head = new ListNode(1, null);
        ListNode ptr = head;
        int i = 2;
        while (i <= 5){
            ListNode temp = new ListNode(i, null);
            ptr.next = temp;
            ptr = temp;
            i++;
        }
        leetcode.printLinkList(head);

//        head = leetcode.reverseKGroup(head, 2);
//        System.out.println();
//        leetcode.printLinkList(head);

        head = leetcode.reverseBetween(head, 2, 4);
        System.out.println();
        leetcode.printLinkList(head);

        Set<ListNode> listNodeSet = new HashSet<>();
        listNodeSet.add(new ListNode());
    }
}
