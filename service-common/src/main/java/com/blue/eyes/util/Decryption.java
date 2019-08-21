package com.blue.eyes.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-08-13 14:51
 *           '::::::::::::'           @description 加密解密工具类（拷贝于老小智）
 *             .:::::::::: 
 *        '::::::::::::::.. 
 *             ..::::::::::::. 
 *           ``:::::::::::::::: 
 *            ::::``:::::::::'        .:::. 
 *           ::::'   ':::::'       .::::::::. 
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
public class Decryption {
    /**
     * 加密类
     * @param authenticator
     * @return
     */
    public byte[] enCriptSHA1(String authenticator){
        //
        final String Algorithm = "SHA-1";
        //
        MessageDigest md=null;
        byte[] encode=null;
        //
        byte[] bt=authenticator.getBytes();
        try {
            //SHA-1
            md=MessageDigest.getInstance(Algorithm);
            md.update(bt);
            //
            encode=md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encode;
    }



    /**
     * 3DES
     * @param reqStr
     * @param enkey
     * @return
     */
    public byte[] enCrpt(byte[] reqStr ,byte[] enkey){
        //
        final String Algorithm = "DESede";
        //
        byte[] encoded = null;
        //
        Cipher cipher = null;
        //
        SecretKey secretKey = null;
        try {
            //
            secretKey = getSecretKey(enkey,Algorithm);
            //
            cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //
            encoded = cipher.doFinal(reqStr);
        } catch (Exception e) {

        }
        return encoded;
    }


    /**
     * Base64
     * @param en3DESReqStr
     * @return
     */
    public String enBase64(byte[] en3DESReqStr){
        //BASE64Encoder
        BASE64Encoder enc=new BASE64Encoder();
        //3DES BASE64
        String bdnParm = filter(enc.encodeBuffer(en3DESReqStr));
        return bdnParm;
    }


    /**
     * base64 3-DES
     * @param str
     * @return
     */
    private String filter(String str){
        String output = null;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++)
        {
            int asc = str.charAt(i);
            if(asc != 10 && asc != 13){
                sb.append(str.subSequence(i, i + 1));
            }
        }
        output = new String(sb);
        return output;
    }

    public byte[] deBase64(String de3DESReqStr){
        //BASE64Decoder
        BASE64Decoder dec=new BASE64Decoder();
        //Base64
        byte[] bdnParm = null;
        try {
            //��Base64
            bdnParm = dec.decodeBuffer(de3DESReqStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bdnParm;
    }
    public byte[] deCrpt(byte[] reqStr ,byte[] deKey){
        //
        final String Algorithm = "DESede";
        //3DES
        byte[] decoded = null;
        //
        SecretKey secretKey =null;
        //
        Cipher cipher = null;
        try{
            //
            secretKey = getSecretKey(deKey,Algorithm);
            //
            cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            //
            decoded =  cipher.doFinal(reqStr);
        }catch(Exception e5){
            e5.printStackTrace();
        }
        return decoded;
    }
    public SecretKey getSecretKey(byte[] reqKey,String Algorithm){
        //
        SecretKey secretKey = new SecretKeySpec(reqKey, Algorithm);
        return secretKey;
    }
    //
    public String encryption(String str)throws Exception{
        try {
            String KEY = "A314BA5A3C85E86KK887WSWS";
            String date = "201206";
            byte[] enCriptSHA1String = enCriptSHA1(str);
            String base64String = enBase64(enCriptSHA1String);
            byte[] enCrptString = enCrpt((str + "_" + base64String).getBytes(), KEY.getBytes());
            String base64StringRe = enBase64(enCrptString);
            str= URLEncoder.encode(base64StringRe);
        } catch (Exception e) {
            throw e;
        }
        return str;
    }

    // type=0 URL type=1 URL
    public String decryption(String str,int type) throws Exception{
        String key = "A314BA5A3C85E86KK887WSWS";
        try {
            if(type==0){
                str=java.net.URLDecoder.decode(str,"UTF-8");
            }
            byte[] base64Str = deBase64(str);// Base64
            byte[] byt3de = deCrpt(base64Str, key.getBytes());// 3des
            str = new String(byt3de,"UTF-8");
        } catch (Exception e) {
            throw e;
        }
        return str.trim();
    }

    public static Long TimeDiff(String pBeginTime, String pEndTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd hh:mm");
        Long beginL = format.parse(pBeginTime).getTime();
        Long endL = format.parse(pEndTime).getTime();
        Long day = (endL - beginL)/86400000;
        Long hour = ((endL - beginL)%86400000)/3600000;
        Long min = ((endL - beginL)%86400000%3600000)/60000;
//	   return ("" + day + "" + hour + "" + min);
        return hour;
    }

    public static void main(String[] args) throws Exception {
        Decryption dec = new Decryption();
        //
        //http://10.4.13.103:8080/customerAccountGroup/home.html?workNo=
        String key = dec.encryption("CHENYANYAN");
        System.out.println("CHENYANYAN:"+key);
        key = dec.encryption("SHENPENG");
        System.out.println("SHENPENG:"+key);
        key = dec.encryption("fzs");
        System.out.println("fzs:"+key);
        key = dec.encryption("ls");
        System.out.println("ls:"+key);
        key = dec.encryption("cyy");
        System.out.println("cyy:"+key);
        key = dec.encryption("cj");
        System.out.println("cj:"+key);
        key = dec.encryption("mty");
        System.out.println("mty:"+key);

        //
        //String value = "SgNrmEn5nKLstPp8N0MCa6OjKCbb4j01xSQg6syZQos3V4TBFe%2F3ZaO4TcS6NXxU";
        String value = "KOLg9IAze%2BYa1et4J0TwBHEWWElzPBWxfYjU6UZWnmijuE3EujV8VA%3D%3D";
        System.out.println(dec.decryption(value, 0).substring(0, dec.decryption(value, 0).lastIndexOf("_")));
        String origAccountNo = dec.decryption(key,0).substring(0, 11);
        System.out.println("Orig:" + origAccountNo);
        Date ss=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd hh:mm");
        String sss=format.format(ss);
        long time = Decryption.TimeDiff(sss.toString().trim(), "2014 01 17 17:05:00");
        System.out.println("time:" + time);


    }
}
