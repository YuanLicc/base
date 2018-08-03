package com.yl.common.tree;

/**
 * 二叉树构造器
 * @author YuanLi
 */
public class TreeBuilder {

    /**
     * 构造二叉树
     * @param pre 前序遍历
     * @param in 中序遍历
     * @param <T> 元素类型
     * @return 构造树的根节点
     */
    public static <T> TreeNode<T> build(T[] pre, T[] in) {
        return  build(pre, 0, pre.length - 1
                , in, 0, in.length - 1);
    }

    /**
     * 构造二叉树
     * @param pre 前序遍历
     * @param subtreeRootStart 前序遍历中起始位置（一般指定为 0）
     * @param subtreeRootEnd 前序遍历中结束位置 （一般指定为前序遍历数组最后一个元素的下标）
     * @param in 中序遍历
     * @param subTreeStart 中序遍历中起始位置（一般指定为 0）
     * @param subTreeEnd 中序遍历中结束位置（一般指定为中序遍历数组最后一个元素的下标）
     * @param <T> 元素类型
     * @return 构造树的根节点
     */
    public static <T> TreeNode<T> build(T[] pre, int subtreeRootStart, int subtreeRootEnd
            , T[] in, int subTreeStart, int subTreeEnd) {

        if(subtreeRootStart > subtreeRootEnd) {
            return null;
        }
        T subtreeRootValue = pre[subtreeRootStart];
        TreeNode subtreeRoot = new TreeNode(subtreeRootValue);

        int count = 0;
        for(int i = subTreeStart; i <= subTreeEnd; i++) {
            count++;
            if(subtreeRootValue.equals(in[i])) {
                subtreeRoot.left = build(pre, subtreeRootStart + 1
                        , subtreeRootStart + count - 1, in, subTreeStart, i - 1);

                subtreeRoot.right = build(pre, subtreeRootStart + count
                        , subtreeRootEnd, in, i + 1, subTreeEnd);
                break;
            }
        }
        return subtreeRoot;
    }

}
