package RSAAES;

import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES算法封装，工具类.
 * IOS可设置任意长度的加密密码，JAVA只支持16位/24位/32位。这里取16位。
 */
public class AESUtils {

    /**偏移量,必须是长为16位的字符串*/
    private static final String IV_STRING = "16-Bytes--String";
    /**
     *或者这样  16位
     * private static final String IV_String = "0123456789qwerdf";
     */
    /**
     * 默认的密钥
     */
    public static final String DEFAULT_KEY = "1bd83b249a414036";

    /**
     * 产生随机密钥(这里产生密钥是16位)
     */
    public static String generateKey() {
        String key = UUID.randomUUID().toString().
                replace("-", "").substring(0, 16);// 替换掉-号
        return key;
    }

    public static String encryptData(String key, String content) {
        byte[] encryptedBytes = new byte[0];
        try {
            byte[] byteContent = content.getBytes("UTF-8");
            //缺省为ISO-8859-1
            byte[] b = content.getBytes();
            // 注意，为了能与 iOS 统一
            // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            StringBuffer stringBuffer = new StringBuffer(16);
            stringBuffer.append(key);
            stringBuffer.setLength(10);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            encryptedBytes = cipher.doFinal(byteContent);
            // 同样对加密后数据进行 base64 编码
            return Base64Utils.encode(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptData(String key, String content) {
        try {
            // base64 解码
            byte[] encryptedBytes = Base64Utils.decode(content);
            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);
            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String plainText = AESUtils.decryptData("F431E6FF9051DA07", "q8jHYk6LSbwC2K4zmr/wRZo8mlH0VdMzPEcAzQadTCpSrPQ/ZnTmuIvQxiLOnUXu");
        System.out.println("aes解密后: " + plainText);
    }

}
