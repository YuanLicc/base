package com.yl.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * 集合工具
 * @author YuanLi
 */
public class CollectionUtil {

	public static <E> Collection<E> depthCopy(Collection<E> collection){
		
		try {
			@SuppressWarnings("unchecked")
			Collection<E> result = collection.getClass().newInstance();
			Iterator<E> iterator = collection.iterator();
			while (iterator.hasNext()) {
				result.add(iterator.next());
			}
			return result;
		} 
		catch (Exception e) {
			throw new IllegalArgumentException("深度克隆失败！", e);
		}
	}
	
}
