package com.realgnu.mySpring.common.mybatis;

import org.apache.commons.collections.map.ListOrderedMap;

public class CustomCamelMap extends ListOrderedMap{
	private static final long serialVersionUID = 6723434363565852261L;
	@Override
	public Object put(Object key, Object value) {
		return super.put(CamelUtil.convert2CamelCase((String) key), value);
	}
}
