package com.fw.ejb.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	
	public static String hashSHA256(String s) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA256");
        md.update(s.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b1 : b){
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        }
        return sb.toString();
	}
}
