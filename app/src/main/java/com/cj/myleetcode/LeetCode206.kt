package com.cj.myleetcode

//https://leetcode-cn.com/problems/reverse-linked-list/
class LeetCode206 {

    inner class ListNode {
        var value: Int? = null
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head
        while (curr != null) {
            val nextTemp : ListNode? = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
     }

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */

}