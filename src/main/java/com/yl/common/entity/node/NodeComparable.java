package com.yl.common.entity.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import com.yl.common.util.ObjectUtil;
import com.yl.common.string.StringUtil;

public class NodeComparable<T extends Comparable<T>> implements Serializable, Comparable<NodeComparable<T>>{
	
	private static final long serialVersionUID = 1L;

	private NodeComparable<T> parent;
	
	private ArrayList<NodeComparable<T>> childs;
	
	private T value;
	
	private ArrayList<Object> cache;
	
	private final boolean isCache;

	public NodeComparable(T value, boolean isCache) {
		this.value = value;
		childs = new ArrayList<NodeComparable<T>>();
		if(isCache)
			cache = new ArrayList<Object>();
		this.isCache = isCache;
	}
	
	public NodeComparable<T> getParent() {
		return parent;
	}

	public void setParent(NodeComparable<T> parent) {
		this.parent = parent;
		if(isCache) {
			if(parent != null) this.cache.addAll(parent.getCache());
		}
	}

	public ArrayList<NodeComparable<T>> getChilds() {
		return childs;
	}

	public void setChilds(ArrayList<NodeComparable<T>> childs) {
		if(childs != null)
			this.childs.addAll(childs);
		for(NodeComparable<T> child : this.childs) {
			child.setParent(this);
		}
	}
	
	public void addChild(NodeComparable<T> child) {
		if(child != null) {
			this.childs.add(child);
		}
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public ArrayList<Object> getCache() {
		return cache;
	}

	public void setCache(ArrayList<Object> cache) {
		this.cache.addAll(cache);
	}
	
	public void addCahce(Object cache) {
		this.cache.add(cache);
	}

	/**
	 * 遍历节点的直系父级节点直到根节点结束，返回节点value的栈
	 * @return 直系栈
	 */
	public Stack<T> traverseNodeParents() {
		Stack<T> stack = new Stack<T>();
		stack.push(value);
		NodeComparable<T> copy = parent;
		
		while(copy != null) {
			stack.push(copy.getValue());
			copy = copy.getParent();
		}
		return stack;
	}
	
	/**
	 * 从根节点开始打印value值，直到该节点位置
	 */
	public void printNodeParents_ps () {
		/**获取该节点到父节点的value栈*/
		Stack<T> stack = traverseNodeParents();
		
		while(stack.size() != 0) {
			System.out.println(stack.pop().toString());
		}
	}
	
	public static <T extends Comparable<T>> ArrayList<NodeComparable<T>> createNodes(ArrayList<T> list,boolean isCache) {
		ArrayList<NodeComparable<T>> result = new ArrayList<NodeComparable<T>>();
		if(list == null || list.size() == 0) return result;
		
		for(T t : list) {
			NodeComparable<T> node = new NodeComparable<T>(t, isCache);
			result.add(node);
		}
		return result;
	}
	
	public String toString() {
		return "Node:{\n"
				+ "value:\""+ ObjectUtil.nullToString(value) +"\",\n"
				+ "parent" + StringUtil.addStrPerline(ObjectUtil.nullToString(parent), "    ") +",\n"
				+ "childs:\""+ ObjectUtil.nullToString(childs) +"\"\n"
				+ "}";
	}

	@Override
	public int compareTo(NodeComparable<T> o) {
		return o.getValue().compareTo(this.getValue());
	}

	
}
