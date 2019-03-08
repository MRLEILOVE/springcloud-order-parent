package com.leigq.www.util;

import java.util.Random;
import java.util.UUID;

/**
 * 生成随机数工具类
 * <p>
 * 创建人：lgq <br>
 * 创建时间：2018年6月1日 下午2:47:46 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public class RandomUtils {

	/**
	 * 生成随机数字和字母
	 * <p>
	 * 创建人：lgq <br>
	 * 创建时间：2018年6月1日 下午2:48:15 <br>
	 * <p>
	 * 修改人： <br>
	 * 修改时间： <br>
	 * 修改备注： <br>
	 * </p> 
	 * @param length 随机数长度
	 * @return
	 */
	public static synchronized String getStringRandom(int length) {

        String val = "";  
        Random random = new Random();        
        //length为几位密码 
        for(int i = 0; i < length; i++) {          
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }
        }  
        return val;  
    }  
	
	/**
	 * 生成纳米级时间戳随机数
	 * <p>
	 * 创建人：LGQ <br>
	 * 创建时间：2018年6月9日 下午2:37:09 <br>
	 * <p>
	 * 修改人： <br>
	 * 修改时间： <br>
	 * 修改备注： <br>
	 * </p>
	 * @API {get} URL DESC
	 * @apiGroup operation LGQ
	 * @apiParam {int} length 随机数长度
	 */
	public static synchronized String getNanoTimeRandom(int length) {
		String nanoTime = System.nanoTime()+"";
		return nanoTime.substring(nanoTime.length() - length, nanoTime.length());
	}
	
	/**
	 * 获得从min到max的int型随数
	 * <p>
	 * 创建人：LGQ <br>
	 * 创建时间：2018年6月11日 上午10:23:20 <br>
	 * <p>
	 * 修改人： <br>
	 * 修改时间： <br>
	 * 修改备注： <br>
	 * </p>
	 * @API {get} URL DESC
	 * @apiGroup operation LGQ
	 * @apiParam {int} min 从min开始
	 * @apiParam {int} max 到max结束
	 */
	public static synchronized int getIntSectionRandom(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	/**
	 * 生成带前缀的随机码
	 * @param prefix 前缀
	 * @param length 长度[包含前缀，偶数]
	 * @return
	 */
	public static synchronized String getHasPrefixStrRandom(String prefix, Integer length) {
		length = length - prefix.length();
		StringBuilder random = new StringBuilder(prefix);
		String nanoTime = System.nanoTime() + "";
		nanoTime = nanoTime.substring(nanoTime.length() - length / 2);
		random.append(nanoTime);
		String uuid = UUID.randomUUID() + "";
		uuid = uuid.substring(uuid.length() - length / 2);
		random.append(uuid.toUpperCase());
		return random + "";
	}


	/**
	 * 生成8位随机数字
	 * @return 8位随机数字
	 */
	public static synchronized String getEightNumStr(){
		String uuid = UUID.randomUUID().toString().replaceAll("[^\\d]", "");
		//UUID截取数字之后可能位数不足8位
		if(uuid.length()<8) {
			uuid += "0000";
		}
		return uuid.substring(0,8);
	}
	
}
