package com.mkd.adtools.utils;

import java.util.*;

/**
 * 通用工具类
 */
public class AdUtil {
	/**
	 * 生成随机字符串 纯数字
	 * 
	 * @param num
	 * @return
	 */
	public static String getRandomIntString(Integer num) {
		if (num == null || num <= 0) {
			num = 6;
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < num; i++) {
			str.append((int) (Math.random() * 10));
		}
		return str.toString();
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String getRandomString(Integer num) {
		if (num == null || num <= 0) {
			num = 8;
		}
		char[] chr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < num; i++) {
			buffer.append(chr[random.nextInt(chr.length)]);
		}
		return buffer.toString();
	}

	/**
	 * 生成16位随机字符串
	 * 
	 * @return
	 */
	public static String getRandom() {
		String generate = UUID.randomUUID().toString().replaceAll("-", "");
		int index = (int) (Math.random() * 15);
		return generate.substring(index, index + 16);
	}

	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
