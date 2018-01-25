package com.yl.base.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import com.yl.base.entity.node.Node;
import com.yl.base.exception.CaculateException;

/**
 * 数学相关工具类
 * @author YuanLi
 */
public class MathUtil {

	/**加*/
	public static final String OPERATOR_PLUS = "+";
	/**减*/
	public static final String OPERATOR_MINUS = "-";
	/**乘*/
	public static final String OPERATOR_MULTIPLY = "*";
	/**除*/
	public static final String OPERATOR_DIVIDE = "/";
	/**左圆括号*/
	public static final String OPERATOR_LEFT_PARENTHESES = "(";
	/**右圆括号*/
	public static final String OPERATOR_RIGHT_PARENTHESES = ")";

	/**
	 * <strong><ul>计算中缀表达式</strong>
	 * <li>1.将中缀表达式转后缀表达式{@link #transformToPostfix(ArrayList)}。
	 * <li>2.计算后缀表达式{@link #caculatePostfix(ArrayList)}。
	 * @param infix
	 */
	public static double caculateInfix(ArrayList<Object> infix) {
		return caculatePostfix(transformToPostfix(infix));
	}
	
	/**
	 * <strong><ul>中缀表达式转后缀表达式（辅助栈法）</strong>
	 * <li>1.初始化两个栈，一个表示运算符栈，一个表示后缀表达式栈
	 * <li>2.从左往右遍历中缀表达式。
	 * <li>3.若遇见数字，直接加入后缀表达式栈。
	 * <li>4.若遇见左括号，直接加入运算符栈。
	 * <li>5.若遇见右括号，弹出运算符栈中的运算符符直至遇到左括号。
	 * <li>6.若遇见加减运算符，则弹出运算符栈中的加减乘除运算符加入后缀表达式栈（实质是判断操作符栈的运算符的优先级是否小于当前运算符，
	 * <li>很显然，加减运算符的优先级不大于任何运算符，所以运算符栈直接弹出加入到后缀表达式栈）
	 * <li>7.若遇见乘除运算符，同6，弹出运算符栈顶为加减的运算符加入后缀表达式栈。
	 * @param infix 中缀表达式
	 */
	public static ArrayList<Object> transformToPostfix(ArrayList<Object> infix){
		ArrayList<Object> result = new ArrayList<Object>();
		Stack<Object> operatorStack = new Stack<Object>();
		
		for(int i = 0; i < infix.size(); i++){
			if(infix.get(i).equals(OPERATOR_PLUS) || infix.get(i).equals(OPERATOR_MINUS)){
				while(!operatorStack.isEmpty() 
						&& (OPERATOR_PLUS.equals(operatorStack.peek()) || OPERATOR_MINUS.equals(operatorStack.peek()) 
						|| OPERATOR_MULTIPLY.equals(operatorStack.peek()) || OPERATOR_DIVIDE.equals(operatorStack.peek()))){
					result.add((operatorStack.pop()));
				}
				operatorStack.push(infix.get(i));
			}
			else if(infix.get(i).equals(OPERATOR_MULTIPLY) || infix.get(i).equals(OPERATOR_DIVIDE)){
				while(!operatorStack.isEmpty() && (OPERATOR_MULTIPLY.equals(operatorStack.peek()) || OPERATOR_DIVIDE.equals(operatorStack.peek()))){
					result.add((operatorStack.pop()));
				}
				operatorStack.push(infix.get(i));
			}
			else if(infix.get(i).equals(OPERATOR_LEFT_PARENTHESES)){
				operatorStack.push(OPERATOR_LEFT_PARENTHESES);
			}
			else if(infix.get(i).equals(OPERATOR_RIGHT_PARENTHESES)){
				while( !OPERATOR_LEFT_PARENTHESES.equals(operatorStack.peek())){
					result.add((operatorStack.pop()));
				}
				operatorStack.pop();
			}
			else{
				result.add(infix.get(i));
			}
		}
		
		while(!operatorStack.isEmpty()){
			result.add(operatorStack.pop());
		}
		return result;
	}
	
	/**
	 * <strong><ul>计算后缀表达式（辅助栈）</strong>
	 * <li>1.创建一个数字栈。
	 * <li>2.从左到右遍历后缀表达式。
	 * <li>3.遇见数字直接入数字栈。
	 * <li>4.遇见运算符取数字栈的栈顶的两个数字进行该运算符的运算，运算结果如数字栈。
	 * @param postfix 后缀表达式
	 */
	public static double caculatePostfix(ArrayList<Object> postfix) {
		Stack<Double> numStack = new Stack<Double>();
		try {
			for(int i = 0; i < postfix.size(); i++){
				if(postfix.get(i).equals(OPERATOR_PLUS)){
					numStack.push(numStack.pop() + numStack.pop());
				}
				else if(postfix.get(i).equals(OPERATOR_MINUS)){
					numStack.push(- numStack.pop() + numStack.pop());
				}
				else if(postfix.get(i).equals(OPERATOR_MULTIPLY)){
					numStack.push(numStack.pop() * numStack.pop());
				}
				else if(postfix.get(i).equals(OPERATOR_DIVIDE)){
					numStack.push(1 / numStack.pop() * numStack.pop());
				}
				else{
					numStack.push((Double) postfix.get(i));
				}
			}
			return numStack.pop();
		}
		catch(Exception e) {
			throw new CaculateException("计算后缀表达式出错，原因可能是后缀表达式:\""+ postfix +"\"存在错误！", e);
		}
	}
	
	/**
	 * <strong><ul>给定列表的全排列（给定元素集合进行排列组合，考虑元素顺序）</strong>
	 * <li>1.参数为空或者长度小于2抛出异常。
	 * <li>2.其他则进行全排（广度优先遍历）。
	 * @param list 给定列表
	 */
	public static <T> ArrayList<ArrayList<T>> fullPermutations (ArrayList<T> list) {
		if(list == null || list.size() == 0 || list.size() == 1) {
			throw new IllegalArgumentException("非法参数，进行全排的列表长度应该大于1!");
		}
		Node<T> root = initRootNode(list);
		return fullPermutations(root, list, new LinkedList<Node<T>>(), new ArrayList<ArrayList<T>>(), list.size(), false);
	}
	
	/**
	 * <strong><ul>给定列表的全排列（给定元素集合进行排列组合，考虑元素顺序）</strong>
	 * <li>1.参数为空或者长度小于2抛出异常。
	 * <li>2.其他则进行全排（广度优先遍历）。
	 * @param list 给定列表
	 */
	public static <T> ArrayList<ArrayList<T>> fullPermutations (@SuppressWarnings("unchecked") T...arr) {
		ArrayList<T> list = new ArrayList<T>();
		if(arr == null || arr.length == 0 || arr.length == 1) {
			throw new IllegalArgumentException("非法参数，进行全排的列表长度应该大于1!");
		}
		for(T t : arr) {
			list.add(t);
		}
		return fullPermutations(list);
	}
	
	/**
	 * <strong><ul>给定列表的部分元素排列（给定元素集合进行排列组合，考虑元素顺序）</strong>
	 * <li>1.参数为空或者长度小于2抛出异常。
	 * <li>2.其他则进行全排（广度优先遍历）。
	 * @param list 给定列表
	 * @param selectNum 选择多少个元素（应该大于1且小于等于列表长度）
	 */
	public static <T> ArrayList<ArrayList<T>> partPermutations (ArrayList<T> list, int selectNum) {
		if(list == null || list.size() == 0 || list.size() == 1 || selectNum > list.size()) {
			throw new IllegalArgumentException("非法参数，进行部分排列的列表长度应该大于1,且选择元素个数应该小于列表长度!");
		}
		Node<T> root = initRootNode(list);
		return fullPermutations(root, list, new LinkedList<Node<T>>(), new ArrayList<ArrayList<T>>(), selectNum, false);
	}
	
	/**
	 * <strong><ul>给定列表的部分元素排列（给定元素集合进行排列组合，考虑元素顺序）</strong>
	 * <li>1.参数为空或者长度小于2抛出异常。
	 * <li>2.其他则进行全排（广度优先遍历）。
	 * @param list 给定列表
	 * @param selectNum 选择多少个元素（应该大于1且小于等于列表长度）
	 */
	public static <T> ArrayList<ArrayList<T>> partPermutations (int selectNum, @SuppressWarnings("unchecked") T...arr) {
		ArrayList<T> list = new ArrayList<T>();
		if(arr == null || arr.length == 0 || arr.length == 1) {
			throw new IllegalArgumentException("非法参数，进行全排的列表长度应该大于1!"); 
		}
		for(T t : arr) {
			list.add(t);
		}
		Node<T> root = initRootNode(list);
		return fullPermutations(root, list, new LinkedList<Node<T>>(), new ArrayList<ArrayList<T>>(), selectNum, false);
	}
	
	/**
	 * <strong><ul>给定列表的自定义排列（给定元素集合进行排列组合，考虑元素顺序）</strong>
	 * <li>1.参数为空或者长度小于2抛出异常。
	 * <li>2.其他则进行全排（广度优先遍历）。
	 * @param list 给定列表
	 * @param selectNum 选择多少个元素（应该大于1且小于等于列表长度）
	 * @param isRepeat 是否允许元素重复
	 */
	public static <T> ArrayList<ArrayList<T>> customPermutations (ArrayList<T> list, boolean isRepeat, int selectNum) {
		if(list == null || list.size() == 0 || list.size() == 1) {
			throw new IllegalArgumentException("非法参数，进行组合的列表长度应该大于1");
		}
		
		Node<T> root = initRootNode(list);
		return fullPermutations(root, list, new LinkedList<Node<T>>(), new ArrayList<ArrayList<T>>(), selectNum, isRepeat);
	}
	
	/**
	 * <strong><ul>给定列表的自定义排列（给定元素集合进行排列组合，考虑元素顺序）</strong>
	 * <li>1.参数为空或者长度小于2抛出异常。
	 * <li>2.其他则进行全排（广度优先遍历）。
	 * @param list 给定列表
	 * @param selectNum 选择多少个元素（应该大于1且小于等于列表长度）
	 * @param isRepeat 是否允许元素重复
	 */
	public static <T> ArrayList<ArrayList<T>> customPermutations (boolean isRepeat, int selectNum, @SuppressWarnings("unchecked") T...arr) {
		ArrayList<T> list = new ArrayList<T>();
		if(arr == null || arr.length == 0 || arr.length == 1) {
			throw new IllegalArgumentException("非法参数，进行全排的列表长度应该大于1!"); 
		}
		for(T t : arr) {
			list.add(t);
		}
		Node<T> root = initRootNode(list);
		return fullPermutations(root, list, new LinkedList<Node<T>>(), new ArrayList<ArrayList<T>>(), selectNum, isRepeat);
	}
	
	/**
	 * 全排
	 * @param node 当前节点
	 * @param list 被排列元素集合
	 * @param queue 节点队列
	 * @param result 结果集合
	 * @param select 排列元素个数
	 * @param isRepeat 排列中是否允许元素重复
	 */
	private static <T> ArrayList<ArrayList<T>> fullPermutations(Node<T> node, ArrayList<T> list, LinkedList<Node<T>> queue, ArrayList<ArrayList<T>> result, int select, boolean isRepeat) {
		//判断节点是否为空，为空则返回结果
		if(node == null) {
			return result;
		}
		//若节点直系亲属个数为select则将节点加入结果集
		if(node.getCache().size() == select) {
			result.add(transformIndexToObject(list, node.getCache()));
		}
		else {
			if(node.getChilds().size() == 0) {
				//创建孩子节点
				node = createChilds(node, list,isRepeat);
			}
			//将孩子节点加入队列
			offerAll(queue, node.getChilds());
		}
		//队列为空则返回结果
		if(queue.size() == 0) {
			return result;
		}
		return fullPermutations(queue.pop(), list, queue, result, select,isRepeat);
	}
	
	private static <T> LinkedList<Node<T>> offerAll(LinkedList<Node<T>> queue, ArrayList<Node<T>> adds) {
		for(Node<T> node : adds) {
			queue.offer(node);
		}
		return queue;
	}
	
	private static <T> ArrayList<T> transformIndexToObject(ArrayList<T> list, ArrayList<Object> cacheIndex) {
		ArrayList<T> result = new ArrayList<T>();
		for(Object index : cacheIndex) {
			result.add(list.get((int)index));
		}
		return result;
	}
	
	private static <T> Node<T> initRootNode(ArrayList<T> list) {
		Node<T> root = new Node<T>(null, true);
		root.setChilds(Node.createNodes(list, true));
		int i = 0;
		for(Node<T> child : root.getChilds()) {
			child.addCahce(i++);
		}
		return root;
	}
	
	private static <T> Node<T> createChilds(Node<T> node, ArrayList<T> list, boolean isRepeat) {
		for(int i = 0; i < list.size(); i++) {
			if(!isRepeat) {
				if(node.getCache().indexOf(i) < 0) {
					Node<T> child = new Node<T>(list.get(i), true);
					child.setParent(node);
					child.addCahce(i);
					node.addChild(child);
				}
			}
			else {
				Node<T> child = new Node<T>(list.get(i), true);
				child.setParent(node);
				child.addCahce(i);
				node.addChild(child);
			}
		}
		return node;
	}
	
}
