package com.cj.myleetcode.lru

import java.util.*

/**
 *  https://leetcode-cn.com/problems/lru-cache/
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 *
 *
LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
 *
 */
class LRUCache constructor(private val capacity: Int) {

    inner class DLinkedNode {
        var nodeKey: Int? = null
        var nodeValue: Int? = null
        var prevNode: DLinkedNode? = null
        var nextNode: DLinkedNode? = null

        override fun toString(): String {
            return "DLinkedNode[$nodeKey,$nodeValue]"
        }
    }

    private fun addNode(dLinkedNode: DLinkedNode) {
        /**
         * 新加入的节点,永远加在head的右边
         */
        dLinkedNode.prevNode = head
        dLinkedNode.nextNode = head.nextNode

        head.nextNode!!.prevNode = dLinkedNode//原来head的next节点的前一节点更新成新加入节点
        head.nextNode = dLinkedNode//head的next节点改为新加入节点
    }

    private fun removeNode(dLinkedNode: DLinkedNode) {
        val p = dLinkedNode.prevNode
        val n = dLinkedNode.nextNode
        p!!.nextNode = n
        n!!.prevNode = p
    }

    /*
*  将指定节点移到头部，最新使用
* */
    private fun moveToHead(dLinkedNode: DLinkedNode) {
        removeNode(dLinkedNode)
        addNode(dLinkedNode)
    }

    private fun popTail(): DLinkedNode {
        val res = tail.prevNode
        removeNode(res!!)
        return res
    }

    //head表示最近使用，head的next指向tail,左边是head,右边是tail
    private var head: DLinkedNode//伪头部和伪尾部，真正的数据在它们两个中间，最新的在head的右边，最旧的在tail左边
    private var tail: DLinkedNode
    private val cache: Hashtable<Int, DLinkedNode> = Hashtable<Int, DLinkedNode>()

    init {
        head = DLinkedNode()
        tail = DLinkedNode()
        head.nextNode = tail
        tail.prevNode = head
    }


    fun get(nodeKey: Int): Int {
        val dLinkedNode = cache[nodeKey] ?: return -1//如果再cache中没有找到，返回-1
        moveToHead(dLinkedNode)//在cache中找到了,最近被使用，将get到的移到head
        return dLinkedNode.nodeValue ?: -1//返回值
    }


    fun put(key: Int, value: Int) {
        val cached = cache[key]//先尝试从hashtable中取节点
        if (cached != null) {//如果cache中存在,更新value,移到最新使用head
            cached.nodeValue = value
            moveToHead(cached)
        } else {//如果cache中不存在,移到头部,判断是否超容量，超容量移除尾部
            val toPut = DLinkedNode()
            toPut.nodeKey = key
            toPut.nodeValue = value
            cache[key] = toPut
            addNode(toPut)//更新头部
            if (capacity <= cache.size - 1) {//放不下了，需要移除尾部
                val tail = popTail()
                cache.remove(tail.nodeKey)
            }
        }
    }


}