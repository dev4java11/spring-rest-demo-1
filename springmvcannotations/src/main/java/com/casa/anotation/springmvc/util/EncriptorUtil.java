package com.casa.anotation.springmvc.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Component;

public class EncriptorUtil {
	
	
	public static String encode(String cadena){
		char[] code = Hex.encode(cadena.getBytes(Charset.forName("UTF-8")));
		String encode = String.copyValueOf(code);
		return encode;
	}
	
	public static String decode(String cadena){
		byte[] code = Hex.decode(cadena);
		return new String(code, Charset.forName("UTF-8"));
	}

}
