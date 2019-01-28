package RSAAES;

import sun.security.krb5.internal.crypto.Aes128;

public class TestEncrypt {
    public static void main(String[] args) throws Exception {
        String key = AESUtils.generateKey();
        String name = "wujj";
        String idCard = "444200002939402";
        String encryptName = AESUtils.encryptData(key, name);
        String encryptCard = AESUtils.encryptData(key, idCard);

        String encryptKey = RSAUtils.encryptByPublicKey(key);
        System.out.println("使用RSA加密后的AES密钥： " + encryptKey);
        System.out.println("使用AES加密后的Name " + encryptName + "  使用AES加密后的Card :" + encryptCard);

    }
}
