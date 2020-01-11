package com.cj.myleetcode

//https://leetcode-cn.com/problems/add-two-numbers/
/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 *
 */
class AddTwoNumbers {

    inner class ListNode(val `val`: Int) {
        var next: ListNode? = null
    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)//伪头部
        var currentNode: ListNode = dummyHead
        var pointer1: ListNode? = l1
        var pointer2: ListNode? = l2
        var value = 0
        var toAddTen = false//进位标识
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == null) {
                value = pointer2!!.`val`
            } else if (pointer2 == null) {
                value = pointer1.`val`
            } else {
                value = pointer1.`val` + pointer2.`val`
                if (toAddTen) value += 1//判断上一位是否有进位
                toAddTen = value >= 10//更新进位表示
                if (toAddTen) value %= 10//取余
            }
            currentNode.next = ListNode(value)//当前节点赋值
            currentNode = currentNode.next!!//更新当前节点
            //移动指针
            pointer1 = pointer1?.next
            pointer2 = pointer2?.next
        }
        if (toAddTen) {
            currentNode.next = ListNode(1)//最后一位；判断是否要进位
        }
        return dummyHead.next
    }

}