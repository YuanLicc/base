package com.yl.common.entity.array;

import java.io.Serializable;

import com.yl.common.entity.point.Point;

public class LocatableElement<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private T value;
	
	private Integer column;
	
	private Integer row;
	
	private boolean is2D;
	
	public LocatableElement(T value, Integer column, Integer row) {
		if(value == null || column == null || row == null) throw new NullPointerException("元素值、坐标不能为空！");
		
		this.column = column;
		this.row = row;
		this.value = value;
		this.is2D = true;
	}
	
	public LocatableElement(T value, Integer row) {
		if(value == null || row == null) throw new NullPointerException("元素值、位置不能为空！");
		
		this.column = -1;
		this.row = row;
		this.value = value;
		this.is2D = false;
	}
	
	public T getValue() {
		return value;
	}

	public Object getLocation() {
		if(this.is2D) return new Point<Integer, Integer>(column, row);
		
		else {
			return this.row;
		}
	}
	
	public boolean equals(Object o) {
		if(o == this) return true;
		
		if(o instanceof LocatableElement) {
			LocatableElement<?> element = (LocatableElement<?>)o;
			if(element.value.equals(this.value) && element.getLocation().equals(this.getLocation()))
				return true;
		}
		return false;
	}
	
	public String toString() {
		return "value:\""+ value +"\", location:\""+ getLocation() +"\", is2D:\""+ is2D +"\"";
	}
	
}
