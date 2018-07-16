package com.yl.location;

import java.io.Serializable;

public interface Locatable extends Serializable{
	
	public Location getLocation();
	
	public void setLocation(Location location);
	
}
