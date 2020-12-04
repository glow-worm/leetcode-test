package com.leetcode.study.raise;

import com.leetcode.model.ListNode;

/**
 * @className: com.study.raise.AddTwoNumbers
 * @author: wangyulong
 * @datetime: 2019-07-09 14:07
 * @description: 两个链表相加
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        //ListNode result = addTwoNumbers(l2, l1);

        //ListNode result = addTwoNumbersTwo(new ListNode(5, null), new ListNode(5,null));
        //System.out.println(result);

        ListNode result = addTwoNumbersThree(l1, l2);
        System.out.println(result);

    }

    /**
     * @author: wangyulong
     * @datetime: \ 17:37
     * @param: [l1, l2]
     * @return:
     * @description: 方法一
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String emptyStr = "";
        String m = emptyStr;
        String n = emptyStr;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                m += l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                n += l2.getVal();
                l2 = l2.getNext();
            }
        }
        char[] arrm = m.toCharArray();
        char[] arrn = n.toCharArray();
        System.out.println(new StringBuilder(m).reverse().toString());
        System.out.println(new StringBuilder(n).reverse().toString());
        String temp = emptyStr;
        int index = arrm.length <= arrn.length ? arrm.length:arrn.length;
        int indexMax = arrm.length > arrn.length ? arrm.length:arrn.length;
        int flag = 0;
        for (int x = 0; x < index; x++) {
            for (int z = x; z < index ; z += index) {
                int singleSum = Integer.parseInt(emptyStr + arrm[x]) + Integer.parseInt(emptyStr + arrn[z]) + flag;
                flag = (singleSum >= 10) ? 1:0;
                temp = (singleSum % 10) + temp;
                if (x == (arrm.length - 1) && z == (arrn.length - 1) && flag == 1) {
                    temp = 1 + temp;
                }
            }
        }
        if (arrm.length > index || arrn.length > index) {
            for (int i = index; i < indexMax; i++) {
                int single = 0;
                if (arrm.length > index) {
                    single = Integer.parseInt(emptyStr + arrm[i]) + flag;
                }
                if (arrn.length > index) {
                    single = Integer.parseInt(emptyStr + arrn[i]) + flag;
                }
                flag = (single >= 10) ? 1:0;
                temp = (single % 10) + temp;
                if ((i == (arrm.length - 1) || i == (arrn.length - 1)) && flag == 1) {
                    temp = 1 + temp;
                }
            }
        }
        ListNode result = null;
        char[] arrRes = temp.toCharArray();
        System.out.println(arrRes);
        for (int k = 0; k < arrRes.length; k++) {
            if (result == null) {
                result = new ListNode(Integer.parseInt(emptyStr + arrRes[k]), null);
            }else {
                result = new ListNode(Integer.parseInt(emptyStr + arrRes[k]), result);
            }
        }
        return result;
    }

    /**
     * @author: wangyulong
     * @datetime: 2019-07-10 17:26
     * @param: [l1, l2]
     * @return:
     * @description: 方法二
     */
    public static ListNode addTwoNumbersTwo(ListNode l1, ListNode l2) {
        int flag = 0;
        boolean temp = true;
        String sumStr = "";
        ListNode result = null;
        while(temp) {
            int singleSum = 0;
            int sa = 0;
            int sb = 0;
            ListNode p = null;
            ListNode q = null;
            if (l1 != null) {
                sa = l1.getVal();
                p = l1;
                l1 = l1.getNext();
            }
            if (l2 != null) {
                sb = l2.getVal();
                q = l2;
                l2 = l2.getNext();
            }
            singleSum = sa + sb + flag;
            flag = (singleSum >= 10) ? 1:0;
            sumStr = (singleSum % 10) + sumStr;
            if (p == null && q == null) {
                temp = false;
            }
        }
        sumStr = sumStr.startsWith("0") ? sumStr.substring(1):sumStr;
        char[] arrRes = sumStr.toCharArray();
        System.out.println(arrRes);
        for (int k = 0; k < arrRes.length; k++) {
            if (result == null) {
                result = new ListNode(Integer.parseInt("" + arrRes[k]), null);
            }else {
                result = new ListNode(Integer.parseInt("" + arrRes[k]), result);
            }
        }
        return result;
    }

    /**
     * @author: wangyulong
     * @datetime: 2019-07-11 09:39
     * @param: [l1, l2]
     * @return:
     * @description: 方法三
     */
    public static ListNode addTwoNumbersThree(ListNode l1, ListNode l2) {
        int flag = 0;
        boolean temp = true;
        ListNode result = null;
        ListNode ln = null;
        while(temp) {
            int singleSum = 0;
            int sa = 0;
            int sb = 0;
            if (l1 == null && l2 == null) {
                temp = false;
            }
            if (l1 != null) {
                sa = l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                sb = l2.getVal();
                l2 = l2.getNext();
            }
            singleSum = sa + sb + flag;
            flag = (singleSum >= 10) ? 1:0;
            if (temp || (!temp && singleSum != 0)) {
                if (result == null) {
                    result = new ListNode(singleSum % 10, null);
                    ln = result;
                }else {
                    ln.setNext(new ListNode(singleSum % 10, null));
                    ln = ln.getNext();
                }
            }
        }
        return result;
    }

}


