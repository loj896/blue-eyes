package com.blue.eyes.util;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @Author: ChenJie
 * @Description: String 工具类
 * @Date: 2018年09月03日 17:23
 * @Modify:
 */
public class StringUtil {
    /**
     * 判断分帐序号是否为11为数字
     */
    public static Pattern NUMBERMORE_PATTERN = Pattern.compile("^\\d{11}$");

    /**
     * 生成32位小写格式的uuid
     * @return
     */
    public static String lowerUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    /**
     * 去空格判 断字符串是否为空
     * @param string
     * @return
     */
    public static boolean trimToEmpty(String string){
        return string == null || string.trim().length() == 0 || string.trim().equals("null");
    }


    public static String listToString(List<String> mList) {
        String convertedListStr = "";
        if (null != mList && mList.size() > 0) {
            String[] mListArray = mList.toArray(new String[mList.size()]);
            for (int i = 0; i < mListArray.length; i++) {
                if (i < mListArray.length - 1) {
                    convertedListStr += mListArray[i] + ",";
                } else {
                    convertedListStr += mListArray[i];
                }
            }
            return convertedListStr;
        } else return "List is null!!!";
    }
}
