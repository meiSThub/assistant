package edu.zzuli.assistant.until;

/**
* 
* @Description 中文转成Unicode编码 为了跨平台 

* @author MR.Wang  

* @date 2014-7-8 下午8:07:19 

* @version V1.0
 */
public class UnicedeUtil {
	
    /**
     * @Description 中文转unicode
     * @param str
     * @return String
     */
    public static String toUnicodeString(String str){
    	
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 0 && c <= 255) {
		           sb.append(c);
		         }
		         else {
		          sb.append("\\u"+Integer.toHexString(c));
		     }
		}
		return sb.toString();
    }
}
