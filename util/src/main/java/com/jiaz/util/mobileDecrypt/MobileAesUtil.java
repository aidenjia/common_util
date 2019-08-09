package com.jiaz.util.mobileDecrypt;


import org.apache.commons.lang.StringUtils;

public class MobileAesUtil {

    public final static String AESKEY = "ZnMmIU50NSF0Rm0mdlFUYUg=";
    /**
     * 加密
     * */
    public static String encrypt(String content) throws Exception {
        try {
            if (StringUtils.isNotBlank(content)) {
                String result = TransferAesEncrypt.aesEncrypt(content, AESKEY, "utf-8");
                return result;
            }
            return content;
        } catch (Exception e) {
            throw new Exception("AES加密失败：Aescontent = " + content + "; charset = " + "utf-8", e);
        }
    }

    /**
     * 解密
     * */
    public static String descrypt(String content) throws Exception {
        try {
            if (StringUtils.isNotBlank(content)) {
                String result = TransferAesEncrypt.aesDecrypt(content, AESKEY, "utf-8");
                return result;
            }
            return content;
        } catch (Exception e) {
            throw new Exception("AES解密失败：Aescontent = " + content + "; charset = " + "utf-8", e);
        }
    }

    public static void main(String[] args) throws Exception{
       // System.out.println(descrypt("0JpRK62xuaxhY0AOzk1mA=="));
        //System.out.println(descrypt("q2Ymt0+fJ4716YU+QYPyiQ=="));
        System.out.println(encrypt("13862010842"));
    }

}
