package com.tyrone.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	public static List<Integer> decodeIntList(String str) {
		
		List<Integer> list = new ArrayList<>();
		String vetor[] = str.split(",");
		
		for (String s : vetor) {
			list.add(Integer.parseInt(s));
		}
		
		return list;
	}
	
	public static String decodeParam(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
