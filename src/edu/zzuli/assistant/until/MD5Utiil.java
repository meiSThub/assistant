package edu.zzuli.assistant.until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**   
 * @Description: to md5 encrypt
 * @author MR.Wang  
 * @date 2014-7-22 下午9:21:02 
 * @version V1.0   
*/ 
public class MD5Utiil {

    private MD5Utiil() {
    	
    }

	/**
	 * @Description 32位标准 MD5 加密 
	 * @param plainText 明文
	 * @return String密文
	 * 返回 Null 值则出现异常
	 */
    public static String encrypt32(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();// 32位的加密

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


	/**
	 * @Description 16位标准 MD5 加密 
	 * @param plainText 明文
	 * @return String密文
	 * 返回 Null 值则出现异常
	 */
    public static String encrypt16(String plainText) {
    	
        String result = encrypt32(plainText);
        if (result == null)
            return null;
        return result.toString().substring(8, 24);// 16位的加密
    }

    
    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
		System.out.println(MD5Utiil.encrypt32("解不出来啊"));
		long endTime = System.currentTimeMillis();
		System.out.println("共耗时"+(endTime-startTime));
	}
}