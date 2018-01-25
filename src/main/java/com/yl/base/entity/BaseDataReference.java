package com.yl.base.entity;

public class BaseDataReference<T> {

	private T value;

	public BaseDataReference(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
