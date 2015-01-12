package com.braintreegateway.encryption;

import com.braintree.org.bouncycastle.util.encoders.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class Rsa
{
  private static final String ALGORITHM = "RSA";
  private static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";

  public static String encrypt(byte[] paramArrayOfByte, String paramString)
    throws BraintreeEncryptionException
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, publicKey(paramString));
      String str = new String(Base64.encode(localCipher.doFinal(Base64.encode(paramArrayOfByte))));
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new BraintreeEncryptionException("No Such Algorithm: " + localNoSuchAlgorithmException.getMessage());
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      throw new BraintreeEncryptionException("No Such Padding: " + localNoSuchPaddingException.getMessage());
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      throw new BraintreeEncryptionException("Invalid Key: " + localInvalidKeyException.getMessage());
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      throw new BraintreeEncryptionException("Illegal Block Size: " + localIllegalBlockSizeException.getMessage());
    }
    catch (BadPaddingException localBadPaddingException)
    {
      throw new BraintreeEncryptionException("Bad Padding: " + localBadPaddingException.getMessage());
    }
  }

  // ERROR //
  private static java.security.PublicKey publicKey(String paramString)
    throws BraintreeEncryptionException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 94	com/braintree/org/bouncycastle/asn1/ASN1InputStream
    //   5: dup
    //   6: aload_0
    //   7: invokestatic 98	com/braintree/org/bouncycastle/util/encoders/Base64:decode	(Ljava/lang/String;)[B
    //   10: invokespecial 99	com/braintree/org/bouncycastle/asn1/ASN1InputStream:<init>	([B)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 103	com/braintree/org/bouncycastle/asn1/ASN1InputStream:readObject	()Lcom/braintree/org/bouncycastle/asn1/DERObject;
    //   18: invokestatic 108	com/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure:getInstance	(Ljava/lang/Object;)Lcom/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure;
    //   21: astore 8
    //   23: new 110	java/security/spec/RSAPublicKeySpec
    //   26: dup
    //   27: aload 8
    //   29: invokevirtual 114	com/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure:getModulus	()Ljava/math/BigInteger;
    //   32: aload 8
    //   34: invokevirtual 117	com/braintree/org/bouncycastle/asn1/x509/RSAPublicKeyStructure:getPublicExponent	()Ljava/math/BigInteger;
    //   37: invokespecial 120	java/security/spec/RSAPublicKeySpec:<init>	(Ljava/math/BigInteger;Ljava/math/BigInteger;)V
    //   40: astore 9
    //   42: ldc 8
    //   44: invokestatic 125	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   47: aload 9
    //   49: invokevirtual 129	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   52: astore 10
    //   54: aload_2
    //   55: invokevirtual 132	com/braintree/org/bouncycastle/asn1/ASN1InputStream:close	()V
    //   58: aload 10
    //   60: areturn
    //   61: astore 11
    //   63: new 19	com/braintreegateway/encryption/BraintreeEncryptionException
    //   66: dup
    //   67: new 59	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   74: ldc 134
    //   76: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 11
    //   81: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 76	com/braintreegateway/encryption/BraintreeEncryptionException:<init>	(Ljava/lang/String;)V
    //   93: athrow
    //   94: astore_3
    //   95: new 19	com/braintreegateway/encryption/BraintreeEncryptionException
    //   98: dup
    //   99: new 59	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   106: ldc 62
    //   108: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_3
    //   112: invokevirtual 70	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 76	com/braintreegateway/encryption/BraintreeEncryptionException:<init>	(Ljava/lang/String;)V
    //   124: athrow
    //   125: astore 4
    //   127: aload_1
    //   128: invokevirtual 132	com/braintree/org/bouncycastle/asn1/ASN1InputStream:close	()V
    //   131: aload 4
    //   133: athrow
    //   134: astore 6
    //   136: new 19	com/braintreegateway/encryption/BraintreeEncryptionException
    //   139: dup
    //   140: new 59	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   147: ldc 137
    //   149: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 6
    //   154: invokevirtual 138	java/security/spec/InvalidKeySpecException:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 76	com/braintreegateway/encryption/BraintreeEncryptionException:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: new 19	com/braintreegateway/encryption/BraintreeEncryptionException
    //   170: dup
    //   171: new 59	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   178: ldc 134
    //   180: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 7
    //   185: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokespecial 76	com/braintreegateway/encryption/BraintreeEncryptionException:<init>	(Ljava/lang/String;)V
    //   197: athrow
    //   198: astore 5
    //   200: new 19	com/braintreegateway/encryption/BraintreeEncryptionException
    //   203: dup
    //   204: new 59	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   211: ldc 134
    //   213: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 5
    //   218: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokespecial 76	com/braintreegateway/encryption/BraintreeEncryptionException:<init>	(Ljava/lang/String;)V
    //   230: athrow
    //   231: astore 4
    //   233: aload_2
    //   234: astore_1
    //   235: goto -108 -> 127
    //   238: astore 7
    //   240: aload_2
    //   241: astore_1
    //   242: goto -75 -> 167
    //   245: astore 6
    //   247: aload_2
    //   248: astore_1
    //   249: goto -113 -> 136
    //   252: astore_3
    //   253: aload_2
    //   254: astore_1
    //   255: goto -160 -> 95
    //   258: astore 7
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -95 -> 167
    //
    // Exception table:
    //   from	to	target	type
    //   54	58	61	java/io/IOException
    //   2	14	94	java/security/NoSuchAlgorithmException
    //   2	14	125	finally
    //   95	125	125	finally
    //   136	167	125	finally
    //   167	198	125	finally
    //   2	14	134	java/security/spec/InvalidKeySpecException
    //   127	131	198	java/io/IOException
    //   14	54	231	finally
    //   14	54	238	java/io/IOException
    //   14	54	245	java/security/spec/InvalidKeySpecException
    //   14	54	252	java/security/NoSuchAlgorithmException
    //   2	14	258	java/io/IOException
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintreegateway.encryption.Rsa
 * JD-Core Version:    0.6.2
 */