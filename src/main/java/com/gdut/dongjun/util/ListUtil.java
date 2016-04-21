package com.gdut.dongjun.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	public static <T> boolean isEmpty(List<T> list) {

		if(list == null || list.size() == 0 || list.get(0) == null) {
			return true;
		}
		return false;
	}
	
	public static <T> List<T> createList(@SuppressWarnings("unchecked") T ... obj) {
		
		List<T> result = new ArrayList<>(obj.length + 1);
		for(T t : obj) {
			result.add(t);
		}
		return result;
	}
	
	@SafeVarargs
	public static <T> int removeList(List<T> list, T ... obj) {
		
		int count = 0;
		for(T t : obj) {
			if(list.remove(t)) {
				++count;
			}
		}
		return count;
	}
}
