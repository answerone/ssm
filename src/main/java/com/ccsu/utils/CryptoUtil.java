package com.ccsu.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.apache.commons.codec.binary.Base64;

public class CryptoUtil {

	public static Key DEFAULT_KEY = null;

	public static final String DEFAULT_SECRET_KEY = "12dasfqwerzxcvadsfqwer1qaz2wsx3edc$RFV%TGB^YHN&UJM";

	public static final String DES = "DES";

	static {
		DEFAULT_KEY = obtainKey(DEFAULT_SECRET_KEY);
	}

	/**
	 * ���key
	 **/

	public static Key obtainKey(String key) {
		if (key == null) {
			return DEFAULT_KEY;
		}
		KeyGenerator generator = null;
		try {
			generator = KeyGenerator.getInstance(DES);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		generator.init(new SecureRandom(key.getBytes()));
		Key key1 = generator.generateKey();
		generator = null;
		return key1;
	}

	/** 
	 * ����<br>
	 * String��������,String�������
	 */

	public static String encode(String str) {
		return encode(null, str);
	}

	/**
	 * ����<br>
	 * String��������,String�������
	 */

	public static String encode(String key, String str) {

		return Base64.encodeBase64URLSafeString(obtainEncode(key, str.getBytes()));
	}

	/**
	 * ����<br>
	 * ��String��������,String�������
	 */

	public static String decode(String str) {
		return decode(null, str);
	}

	/**
	 * ����<br>
	 * ��String��������,String�������
	 */

	public static String decode(String key, String str) {
		return new String(obtainDecode(key, Base64.decodeBase64(str)));
	}

	/**
	 * ����<br>
	 * ��byte[]��������,byte[]�������
	 */

	private static byte[] obtainEncode(String key, byte[] str) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			Key key1 = obtainKey(key);
			cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.ENCRYPT_MODE, key1);
			byteFina = cipher.doFinal(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * ����<br>
	 * ��byte[]��������,��byte[]�������
	 */

	private static byte[] obtainDecode(String key, byte[] str) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			Key key1 = obtainKey(key);
			cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.DECRYPT_MODE, key1);
			byteFina = cipher.doFinal(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	public static void main(String[] args) {
		String a = "123456";
		System.out.println(a);
		String m = encode(a);
		System.out.println(m);
		String n = decode(m);
		System.out.println(n);
	}

}
