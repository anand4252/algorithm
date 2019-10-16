package com.simple;

import java.util.Arrays; 


public class Anagram{

	public static void main(String[] args) {
		if(isAnagram(args[0], args[1])){
			System.out.println("Yesss");
		} else{
			System.out.println("Nooooo");
		}
		
	}

	private static boolean isAnagram(String str1, String str2){
		if(str1.length()!=str2.length())
			return false;
		char[] arrStr1 = str1.toCharArray();
		char[] arrStr2 = str2.toCharArray();
		
		Arrays.sort(arrStr1);
		Arrays.sort(arrStr2);
		for(int i=0;i<arrStr2.length;i++){
			if(arrStr1[i]!=arrStr2[i])
				return false;
		}
		return true;
	}
}