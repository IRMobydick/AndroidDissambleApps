package com.google.android.gms.internal;

import android.content.Context;

public final class hg extends gr
{
  private final String a;
  private final Context b;
  private final String c;

  public hg(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.a = paramString1;
    this.c = paramString2;
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: new 26	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   7: ldc 29
    //   9: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_0
    //   13: getfield 20	com/google/android/gms/internal/hg:c	Ljava/lang/String;
    //   16: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 43	com/google/android/gms/internal/hi:d	(Ljava/lang/String;)V
    //   25: new 45	java/net/URL
    //   28: dup
    //   29: aload_0
    //   30: getfield 20	com/google/android/gms/internal/hg:c	Ljava/lang/String;
    //   33: invokespecial 47	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 51	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   39: checkcast 53	java/net/HttpURLConnection
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 16	com/google/android/gms/internal/hg:b	Landroid/content/Context;
    //   47: aload_0
    //   48: getfield 18	com/google/android/gms/internal/hg:a	Ljava/lang/String;
    //   51: iconst_1
    //   52: aload_3
    //   53: invokestatic 58	com/google/android/gms/internal/gw:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   56: aload_3
    //   57: invokevirtual 62	java/net/HttpURLConnection:getResponseCode	()I
    //   60: istore 5
    //   62: iload 5
    //   64: sipush 200
    //   67: if_icmplt +11 -> 78
    //   70: iload 5
    //   72: sipush 300
    //   75: if_icmplt +38 -> 113
    //   78: new 26	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   85: ldc 64
    //   87: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload 5
    //   92: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc 69
    //   97: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_0
    //   101: getfield 20	com/google/android/gms/internal/hg:c	Ljava/lang/String;
    //   104: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 72	com/google/android/gms/internal/hi:e	(Ljava/lang/String;)V
    //   113: aload_3
    //   114: invokevirtual 75	java/net/HttpURLConnection:disconnect	()V
    //   117: goto +91 -> 208
    //   120: astore 4
    //   122: aload_3
    //   123: invokevirtual 75	java/net/HttpURLConnection:disconnect	()V
    //   126: aload 4
    //   128: athrow
    //   129: astore_2
    //   130: new 26	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   137: ldc 77
    //   139: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_0
    //   143: getfield 20	com/google/android/gms/internal/hg:c	Ljava/lang/String;
    //   146: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 79
    //   151: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_2
    //   155: invokevirtual 82	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 72	com/google/android/gms/internal/hi:e	(Ljava/lang/String;)V
    //   167: goto +41 -> 208
    //   170: astore_1
    //   171: new 26	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   178: ldc 84
    //   180: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: getfield 20	com/google/android/gms/internal/hg:c	Ljava/lang/String;
    //   187: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 79
    //   192: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 85	java/io/IOException:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 72	com/google/android/gms/internal/hi:e	(Ljava/lang/String;)V
    //   208: return
    //
    // Exception table:
    //   from	to	target	type
    //   43	113	120	finally
    //   0	43	129	java/lang/IndexOutOfBoundsException
    //   113	129	129	java/lang/IndexOutOfBoundsException
    //   0	43	170	java/io/IOException
    //   113	129	170	java/io/IOException
  }

  public void b()
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hg
 * JD-Core Version:    0.6.0
 */