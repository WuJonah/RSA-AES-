package RSAAES;

public class TestAES {
    private static final String TAG  = TestAES.class.getSimpleName();
    public static  void main(String[] args){
        String key = AESUtils.generateKey();
        String cont = "今天是2019年一月份。";
        String cipherText = AESUtils.encryptData(key,cont);
        System.out.println("key : " + key + "/n");
    }
}
