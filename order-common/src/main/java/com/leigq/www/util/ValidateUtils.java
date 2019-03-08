package com.leigq.www.util;

import java.util.regex.Pattern;

/**
 * 验证工具类
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018年6月16日 下午4:04:43 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public class ValidateUtils {
	/**
	 * 通用验证方法
	 * <br>创建人： leigq
	 * <br>创建时间： 2018-11-21 14:22
	 * <br>
	 *
	 * @param regex 正则表达式,使用此类中的枚举
	 * @param input 需要验证的字符串
	 * @return 验证成功 true, 失败 false
	 */
	public static boolean validate(RegexEnum regex, String input) {
		return Pattern.matches(regex.toString(), input);
	}
}
