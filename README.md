# RSA-AES-
用RSA和AES加密技术完成一个加密项目
 客户端加密过程主要分为以下三个步骤：1.客户端随机产生AES的密钥；2.对身份证信息（重要信息）进行AES加密；3.通过使用RSA对AES密钥进行公钥加密。
 服务端解密过程主要分为以下两个步骤：1.对加密后的AES密钥进行RSA私钥解密，拿到密钥原文；2.对加密后的重要信息进行AES解密，拿到原始内容。
warning ： 目前代码只能说是思路，距离项目中运用还有一段距离，需要根据需求完善，大家看看可以，不要直接拿去用。
