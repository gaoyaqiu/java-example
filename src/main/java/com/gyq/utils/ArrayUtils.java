package com.gyq.utils;

import java.util.List;

/**
 * 操作数组、集合工具类.
 *
 * @auther gaoyaqiu
 */
public class ArrayUtils {

	/**
	 * 验证list是否为空
	 *
	 * @param list
	 * @return true: 空, false: 非空
	 */
	public static Boolean isNullOrEmpty(List list) {

		if (list != null && list.size() != 0) {
			return false;
		} else {
			return true;
		}
	}

}
