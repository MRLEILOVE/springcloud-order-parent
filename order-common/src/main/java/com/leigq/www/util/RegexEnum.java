package com.leigq.www.util;

/**
 * 各种正则表达式
 * 这里使用的枚举来保存,目的是为了整个项目统一使用(强制)这里正则表达式,
 * 这样可以达到表达式的复用和统一,如果发现缺少可以在这里添加.
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-11-24 15:06 <br>
 * <p>
 * 枚举使用参考:
 * <ul>
 *     <li>
 *         <a href='https://www.cnblogs.com/hyl8218/p/5088287.html'>深入理解Java枚举类型(enum)</a>
 *     </li>
 *     <li>
 *         <a href='https://www.cnblogs.com/hyl8218/p/5088287.html'>java enum(枚举)使用详解 + 总结</a>
 *     </li>
 * </ul>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public enum RegexEnum {

    /**
     * 验证手机
     */
    PHONE("^1(3|4|5|7|8)\\d{9}$"),
    /**
     * 验证邮箱
     */
    EMAIL("^\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}$"),
    /**
     * 判断字符串是否为纯数字
     */
    ALL_NUMBER("^[0-9]*$"),
    /**
     * 6-20个字母、数字、下划线或减号，以字母开头（适用于用户名、密码）
     */
    SIX_TO_TWENTY("^[a-zA-Z][a-zA-Z0-9_-]{5,19}$"),
    /**
     * 身份证号码(15位),很少会使用到
     */
    @Deprecated
    FIFTEEN_IDCARD("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$"),
    /**
     * 身份证号码(18位)
     */
    EIGHTEEN_IDCARD("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");

    private String s;

    RegexEnum(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
