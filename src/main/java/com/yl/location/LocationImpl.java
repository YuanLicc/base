package com.yl.location;

import com.yl.util.ObjectUtil;
import com.yl.string.StringUtil;

public class LocationImpl implements Location{
	private static final long serialVersionUID = 1L;

	private int column;
	
	private int row;
	
	private String description;
	
	private String uri;
	
	static final LocationImpl UNKNOWN = UKNOWNLocation();
	
	public LocationImpl(int column, int row, String description, String uri) {
		this.column = column < 0 ? -1 : column;
		this.row = row < 0 ? -1 : row;
		this.uri = uri;
		
		this.description = StringUtil.trimToNull(description);
	}
	
	public int getColumn() {
		return this.column;
	}

	public int getRow() {
		return this.row;
	}

	public String getUri() {
		return this.uri;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean hasURI() {
		return this.uri != null;
	}

	public boolean hasCoordinate() {
		if(this.column >= 0 || this.row >= 0) {
			return true;
		}
		return false;
	}

	private static LocationImpl UKNOWNLocation() {
		return new LocationImpl(-1, -1, null, null);
	}
	
	public boolean equals(Object o){
		if(o == this) return true;
		
		if(o instanceof Location) {
			Location loc = (Location)o;
			return this.column == loc.getColumn() && this.row == loc.getRow() 
				&& ObjectUtil.equals(this.description, loc.getDescription()) && ObjectUtil.equals(this.uri, loc.getUri());
		}
		
		return false;
	}
	
	public String toString() {
		return "location:{\n"
				+ "    column:\""+ column +"\",\n"
				+ "    row:\""+ row +"\",\n"
				+ "    description:\""+ ObjectUtil.nullToString(description) +"\",\n"
				+ "    URI:\""+ ObjectUtil.nullToString(uri) +"\"\n"
				+ "}";
	}

}
