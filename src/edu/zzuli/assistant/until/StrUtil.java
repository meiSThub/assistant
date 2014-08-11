package edu.zzuli.assistant.until;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StrUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<20;i++)
		 getTimeStr();
	}
	
	/**
	 * 日期+随机数   16 位
	 * @return
	 */
	public static String  getTimeStr(){
	    int max=99;
	    int min=10;
	    Random random = new Random();
	    int randomInt = random.nextInt(max)%(max-min+1) + min;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
        String newFileName = df.format(new Date())  + randomInt;
		return newFileName;  
	} 

}
