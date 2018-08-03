package com.yl.common.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 二叉树结构
 * @param <T> 树数据类型
 * @author YuanLi
 */
public class TreeNode<T> {

    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    // --- 前序遍历 开始 ---
    /**
     * 前序遍历（While） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @param action 遍历时操作
     */
    public void preTravelWhile(Consumer<TreeNode<T>> action) {

        preTravelWhile(this, action);
    }

    /**
     * 前序遍历（While） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @param node 起始节点
     * @param action 遍历时操作
     */
    public void preTravelWhile(TreeNode<T> node, Consumer<TreeNode<T>> action) {
        Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> cNode = node;
        while (cNode != null || !stack.isEmpty()) {
            if(cNode != null) {
                action.accept(cNode);

                stack.push(cNode);
                cNode = cNode.left;
            }
            else {
                cNode = stack.pop().right;
            }
        }
    }

    /**
     * 前序遍历顺序列表（While）
     * @see #preTravelWhile(TreeNode, Consumer)
     * @return 前序遍历顺序列表
     */
    public List<T> preTravelListWhile() {
        ArrayList<T> list = new ArrayList<>();

        preTravelWhile(node -> {
            list.add(node.value);
        });

        return list;
    }

    /**
     * 前序遍历（递归） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @param action 遍历时操作
     */
    public void preTravelRecursion(Consumer<TreeNode<T>> action) {

        preTravelRecursion(this, action);
    }

    /**
     * 前序遍历（递归） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param node 起始节点
     * @param action 遍历时操作
     */
    public void preTravelRecursion(TreeNode<T> node, Consumer<TreeNode<T>> action) {
        if(node != null) {
            action.accept(node);

            preTravelRecursion(node.left, action);
            preTravelRecursion(node.right, action);
        }
    }

    /**
     * 前序遍历顺序列表（Recursion）
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @return 前序遍历顺序列表
     */
    public List<T> preTravelListRecursion() {
        ArrayList<T> list = new ArrayList<>();

        preTravelRecursion(node -> {
            list.add(node.value);
        });

        return list;
    }
    // --- 前序遍历 结束 ---

    /**
     * 中序遍历顺序列表（While）
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @return 中序遍历顺序列表
     */
    public List<T> inTravelListWhile() {
        ArrayList<T> list = new ArrayList<>();

        inTravelWhile(node -> {
            list.add(node.value);
        });

        return list;
    }

    /**
     * 中序遍历（While） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param action 遍历时操作
     */
    public void inTravelWhile(Consumer<TreeNode<T>> action) {
        inTravelWhile(this, action);
    }

    /**
     * 中序遍历（While） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param node 起始节点
     * @param action 遍历时操作
     */
    public void inTravelWhile(TreeNode<T> node, Consumer<TreeNode<T>> action) {
        Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> cNode = node;

        while (cNode != null || !stack.isEmpty()) {
            if(cNode != null) {
                stack.push(cNode);
                cNode = cNode.left;
            }
            else {
                TreeNode<T> popNode = stack.pop();
                action.accept(popNode);
                cNode = popNode.right;
            }
        }
    }

    /**
     * 中序遍历顺序列表（Recursion）
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @return 中序遍历顺序列表
     */
    public List<T> inTravelListRecursion() {
        List<T> list = new ArrayList<>();

        inTravelRecursion(node -> {
            list.add(node.value);
        });

        return list;
    }

    /**
     * 中序遍历（Recursion） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param action 遍历时操作
     */
    public void inTravelRecursion(Consumer<TreeNode<T>> action) {

        inTravelRecursion(this, action);
    }

    /**
     * 中序遍历（Recursion） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param node 起始节点
     * @param action 遍历时操作
     */
    public void inTravelRecursion(TreeNode<T> node, Consumer<TreeNode<T>> action) {
        if(node != null) {
            inTravelRecursion(node.left, action);
            action.accept(node);
            inTravelRecursion(node.right, action);
        }
    }

    /**
     * 后序遍历（Recursion） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param action 遍历时操作
     */
    public void postTravelRecursion(Consumer<TreeNode<T>> action) {

        postTravelRecursion(this, action);
    }

    /**
     * 后序遍历（Recursion） ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param node 起始节点
     * @param action 遍历时操作
     */
    public void postTravelRecursion(TreeNode<T> node, Consumer<TreeNode<T>> action) {
        if(node != null) {
            postTravelRecursion(node.left, action);
            postTravelRecursion(node.right, action);
            action.accept(node);
        }
    }

    /**
     * 后序遍历顺序列表（Recursion）
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @return 后序遍历顺序列表
     */
    public List<T> postTravelListRecursion() {
        List<T> list = new ArrayList<>();

        postTravelRecursion(node -> {
            list.add(node.value);
        });

        return list;
    }

    /**
     * 广度优先遍历顺序列表
     * @see #preTravelRecursion(TreeNode, Consumer)
     * @return 广度优先遍历顺序列表
     */
    public List<T> breadthFirstTravelList() {
        List<T> list = new ArrayList<>();

        breadthFirstTravel(node -> {
            list.add(node.value);
        });

        return list;
    }

    /**
     * 广度优先遍历 ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param action 遍历时操作
     */
    public void breadthFirstTravel(Consumer<TreeNode<T>> action) {
        breadthFirstTravel(this, action);
    }

    /**
     * 广度优先遍历 ---> 此方法作用与集合 {@link java.util.Collection#forEach(Consumer)} 方法相同
     * @param node 起始节点
     * @param action 遍历时操作
     */
    public void breadthFirstTravel(TreeNode<T> node, Consumer<TreeNode<T>> action) {
        if(node == null) return;

        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode<T> cNode = queue.poll();
            action.accept(cNode);

            if(cNode.left != null) {
                queue.offer(cNode.left);
            }
            if(cNode.right != null) {
                queue.offer(cNode.right);
            }
        }
    }

    public String toString() {

        return breadthFirstTravelList().stream().map(value -> {
            return value.toString();
        }).collect(Collectors.joining(","));
    }
}
