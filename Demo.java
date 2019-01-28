package RSAAES;

public class Demo {
    public static void main(String[] args) throws Exception {
        String encryptKey = "W42a322SBoRZKTSLaczF74uUyAxGMFZSgvZWeWnEf+v7AlfTYo8Ie0JLUJpXMMfCjt3i+AlX+8M+Wd1FiEgwgkXwaObvqhqLdwYEybHdyYLE6XcUjn/vqSl/Z3jhKrYi5H+X6RZ70BVYDXki2q4vLPOfL8rECZywRPnl1+tAI7E=";
        String encryptName = "Y5zy9Pf6h8jx/xTETt/2BA==";
        String encryptCard = "7XVmAnoZsqq44aEOySVlsg==";
        //解密
        String key = RSAUtils.decryptByPrivateKey(encryptKey);
        String name = AESUtils.decryptData(key,encryptName);
        String idCard = AESUtils.decryptData(key,encryptCard);
        System.out.println("使用RSA解密后的AES密钥： " + encryptKey);
        System.out.println("使用AES解密后的Name " + name + "  使用AES解密后的Card :" + idCard);

    }
}
