package com.culturall.selenium.util;


public class CultUtils {
	
	public static String turnLangDebugOn (String url) {
		
		if (url.indexOf("language_debug") >= 0) {
			return (url.replaceAll("(language_debug=)\\d", "language_debug=1"));
		} else {
			if (url.indexOf('?') == -1) {
				return (url + "?language_debug=1");
			} else {
				return (url + "&language_debug=1");
			}	
		}
	}
	
	public static String turnLangDebugOff (String url) {
		if (url.indexOf("language_debug") >= 0) {
			return (url.replaceAll("(language_debug=)\\d", "language_debug=0"));
		} else {
			if (url.indexOf('?') == -1) {
				return (url + "?language_debug=0");
			} else {
				return (url + "&language_debug=0");
			}	
		}
	}
}
