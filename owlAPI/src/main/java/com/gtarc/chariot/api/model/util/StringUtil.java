package com.gtarc.chariot.api.model.util;

/**
 * String helper class with useful methods.
 * 
 * @author ckuster
 *
 */
public final class StringUtil {
	
	private StringUtil() {
	}
	
	/**
	 * Returns a string that has spaces before capital letters.<br><br>
	 * {@code ThisIsAnExample = This Is An Example}
	 * 
	 * @param string String without spaces in mixed case style.
	 * @return
	 */
	public static String getStringWithSpaces(String string) {
		return string.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2").replace("And", "and");
	}
	
	/**
	 * Returns a string that has no spaces.<br><br>
	 * {@code This Is An Example = ThisIsAnExample}
	 * 
	 * @param string String with spaces.
	 * @return String without spaces
	 */
	public static String getStringWithoutSpaces(String string) {
		return string.replaceAll(" ","").replace("and", "And");
	}

}
