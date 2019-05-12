package com.primeholding.marko.parking.util;

import java.util.List;

/**
 * Utility class for performing various validations on a generic list.
 * 
 * @author Marko Vuckovic
 */
public class ListUtils {

	/**
	 * Constructor that prevents making new instances of this class.
	 */
	private ListUtils() {
		super();
	}

	/**
	 * Checks if the index of a {@linkplain List} is valid.
	 * 
	 * @param index index that needs to be checked.
	 * 
	 * @return {@code true} if the index is valid and {@code false} if the index is
	 *         not valid.
	 */
	public static boolean checkIfIndexIsValid(List<?> list, int index) {
		if (list == null)
			return false;
		if (list.isEmpty())
			return false;
		return index >= 0 && index < list.size();
	}
}
