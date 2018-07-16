package com.yl.location;

import java.io.Serializable;

public interface Location extends Serializable{
	
	public static final Location UNKNOWN = LocationImpl.UNKNOWN;
	
	int getColumn();
	
	int getRow();
	
	String getUri();
	
	String getDescription();
	
	boolean hasURI();
	
	boolean hasCoordinate();
	
}
