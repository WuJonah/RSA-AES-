package RSAAES;

import java.util.logging.Logger;

public class TestRSA {
    private static final String TAG = TestRSA.class.getSimpleName();

    public static void  main(String
                             [] args) throws Exception{
        String cipherText = RSAUtils.encryptByPublicKey("这是一个测试报文。");
       System.out.println("密文： " + cipherText);
       String text = RSAUtils.decryptByPrivateKey("UU1TNrm6bhv8+kG0RdTmM4DIYW+voyyqLqFdLFR+ONvO/GxERLSAj8cWiMkIFqI9QR/bVXMyzfKCZMUkGVFjfuH3xrkd3kgsIvzTSTTvE72jYaALZVvfXea9sxbTuJfWsWHz/CWbDIfD+e6JTR/Co+YckGltmV0TDGQ9nP50H38=");
       System.out.println("明文：" + text);
    }
}

