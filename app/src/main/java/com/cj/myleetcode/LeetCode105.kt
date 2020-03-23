package com.cj.myleetcode

class LeetCode105 {

    class TreeNode(i: Int) {
        var value: Int = i
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var pre_idx = 0//从先序的第一个开始
    var preorder : IntArray? = null //先序
    var inorder : IntArray? = null//中序
    var index_map = HashMap<Int, Int>()//用以记录中序数组中数字的位置，数组中一个值的左边是他的左子树，右边是他的右子树,key为值，value为位置

    fun buildTree(preorder : IntArray, inorder : IntArray) : TreeNode? {
        this.preorder = preorder
        this.inorder = inorder
        var i = 0
        for (value in inorder) {
            index_map.put(value,i++)
        }
        return helper(0, inorder.size)
    }

    fun helper(idx_left : Int, idx_right : Int) : TreeNode?{//idx_left左边界 idx_right右边界
        if (idx_left == idx_right) return null//左右index相同,没有子树
        val root_val = preorder!![pre_idx]//根节点值
        val root = TreeNode(root_val)
        val index = index_map[root_val]!!//获取到这个值在中序中的位置，这个值的左边是他的左子树，右边是他的右子树

        pre_idx++
        root.left = helper(idx_left,index)
        root.right = helper(index + 1, idx_right)
        return root
    }

}