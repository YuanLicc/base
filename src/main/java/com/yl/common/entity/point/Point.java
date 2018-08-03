package com.yl.common.entity.point;

import java.io.Serializable;

public class Point<T, E> implements Serializable{
	private static final long serialVersionUID = 1L;

	private T column;
	
	private E row;
	
	public T getColumn() {
		return column;
	}

	public void setColumn(T column) {
		this.column = column;
	}

	public E getRow() {
		return row;
	}

	public void setRow(E row) {
		this.row = row;
	}

	public Point(T column, E row) {
		this.column = column;
		this.row = row;
	}
	
	public int hashCode() {
		return this.column.hashCode() * 30 + this.row.hashCode();
	}
	
	public boolean equals (Object o) {
		if(o == this) return true;
		
		if(o instanceof Point) {
			@SuppressWarnings("rawtypes")
			Point point = (Point)o;
			if (point.getColumn() == this.column && point.getRow() == row) {
				return true;
			}
		}
		return false;
	}
	
	public String toString () {
		return "("+ row +", "+ column +")";
	}
	
}
