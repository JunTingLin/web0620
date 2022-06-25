package com.gjun.functions;

public class StringUtility {
	// 傳遞字串與分隔符號 進行字串分割成字串陣列
	public static String[] split(String source, String sp) {
		// 字串切割
		return source.split(sp);
	}

	// 轉換大寫
	public static String caseUpper(String source) {
		return source.toUpperCase();
	}

	// 轉換小寫
	public static String caseLower(String source) {
		return source.toLowerCase();
	}
}
