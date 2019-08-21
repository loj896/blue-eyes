package com.blue.eyes.util;

import java.security.MessageDigest;

public class MD5Util {

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5方法
     *
     * @param text 明文
     * @return 密文
     * @throws Exception
     */
    public static String md5Encrypt(String text, String... encodings) throws Exception {

        byte[] bytes;
        if (encodings != null && encodings.length > 0) {
            String encoding = null;
            for (String t : encodings) {
                encoding = t;
            }
            bytes = text.getBytes(encoding);

        } else {
            bytes = text.getBytes();
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        bytes = messageDigest.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5  密文
     * @return true/false
     * @throws Exception
     */
    public static boolean md5Verify(String text, String md5) throws Exception {
        String md5Text = md5Encrypt(text);
        if (md5Text.equalsIgnoreCase(md5)) {
            return true;
        } else {
            return false;
        }
    }

}
