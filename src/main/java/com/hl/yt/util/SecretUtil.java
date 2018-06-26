package com.hl.yt.util;

public class SecretUtil {
	/**
	 * 加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encrypt(String str) {
		String first = MD5Util.getMD5(str);
		return MD5Util.getMD5(first.substring(16) + first.substring(0, 16));
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt("admin@dzy"));
	}

}