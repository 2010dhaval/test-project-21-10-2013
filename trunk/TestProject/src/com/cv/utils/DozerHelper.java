package com.cv.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

public class DozerHelper {
	public static <T, U> ArrayList<U> map(Mapper mapper, final List<T> source,
			final Class<U> destType, String mapId) {

		final ArrayList<U> dest = new ArrayList<U>();

		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(mapper.map(element, destType, mapId));
		}

		// finally remove all null values if any
		List s1 = new ArrayList();
		s1.add(null);
		dest.removeAll(s1);

		return dest;
	}
}
