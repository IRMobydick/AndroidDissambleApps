package com.crashlytics.android.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ay
{
  private static aB a = aB.a;
  private HttpURLConnection b = null;
  private URL c;
  private final String d;
  private aF e;
  private boolean f;
  private boolean g = true;
  private boolean h = false;
  private int i = 8192;

  private ay(CharSequence paramCharSequence, String paramString)
    throws aD
  {
    try
    {
      this.c = new URL(paramCharSequence.toString());
      this.d = paramString;
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new aD(localMalformedURLException);
    }
  }

  private ay a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return (ay)new az(this, paramInputStream, this.g, paramInputStream, paramOutputStream).call();
  }

  public static ay a(CharSequence paramCharSequence)
    throws aD
  {
    return new ay(paramCharSequence, "PUT");
  }

  public static ay a(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    return new ay(c(a(paramCharSequence, paramMap)), "GET");
  }

  private ay a(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"").append(paramString1);
    if (paramString2 != null)
      localStringBuilder.append("\"; filename=\"").append(paramString2);
    localStringBuilder.append('"');
    d("Content-Disposition", localStringBuilder.toString());
    if (paramString3 != null)
      d("Content-Type", paramString3);
    return d("\r\n");
  }

  private ay a(String paramString1, String paramString2, String paramString3, String paramString4)
    throws aD
  {
    try
    {
      j();
      a(paramString1, paramString2, null);
      this.e.a(paramString4);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new aD(localIOException);
    }
  }

  private static String a(CharSequence paramCharSequence, Map<?, ?> paramMap)
  {
    String str = paramCharSequence.toString();
    if ((paramMap == null) || (paramMap.isEmpty()))
      return str;
    StringBuilder localStringBuilder = new StringBuilder(str);
    if (2 + str.indexOf(':') == str.lastIndexOf('/'))
      localStringBuilder.append('/');
    int j = str.indexOf('?');
    int k = -1 + localStringBuilder.length();
    if (j == -1)
      localStringBuilder.append('?');
    while (true)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry1.getKey().toString());
      localStringBuilder.append('=');
      Object localObject1 = localEntry1.getValue();
      if (localObject1 != null)
        localStringBuilder.append(localObject1);
      while (localIterator.hasNext())
      {
        localStringBuilder.append('&');
        Map.Entry localEntry2 = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry2.getKey().toString());
        localStringBuilder.append('=');
        Object localObject2 = localEntry2.getValue();
        if (localObject2 != null)
          localStringBuilder.append(localObject2);
      }
      if ((j < k) && (str.charAt(k) != '&'))
        localStringBuilder.append('&');
    }
    return localStringBuilder.toString();
  }

  public static ay b(CharSequence paramCharSequence)
    throws aD
  {
    return new ay(paramCharSequence, "DELETE");
  }

  public static ay b(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    return new ay(c(a(paramCharSequence, paramMap)), "POST");
  }

  private ay b(String paramString1, String paramString2, String paramString3)
    throws aD
  {
    return a(paramString1, paramString2, null, paramString3);
  }

  // ERROR //
  private static String c(CharSequence paramCharSequence)
    throws aD
  {
    // Byte code:
    //   0: new 45	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokeinterface 51 1 0
    //   10: invokespecial 54	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 197	java/net/URL:getHost	()Ljava/lang/String;
    //   18: astore_2
    //   19: aload_1
    //   20: invokevirtual 200	java/net/URL:getPort	()I
    //   23: istore_3
    //   24: iload_3
    //   25: iconst_m1
    //   26: if_icmpeq +30 -> 56
    //   29: new 91	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   36: aload_2
    //   37: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: bipush 58
    //   42: invokevirtual 103	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   45: iload_3
    //   46: invokestatic 205	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   49: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_2
    //   56: new 207	java/net/URI
    //   59: dup
    //   60: aload_1
    //   61: invokevirtual 210	java/net/URL:getProtocol	()Ljava/lang/String;
    //   64: aload_2
    //   65: aload_1
    //   66: invokevirtual 213	java/net/URL:getPath	()Ljava/lang/String;
    //   69: aload_1
    //   70: invokevirtual 216	java/net/URL:getQuery	()Ljava/lang/String;
    //   73: aconst_null
    //   74: invokespecial 219	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: invokevirtual 222	java/net/URI:toASCIIString	()Ljava/lang/String;
    //   80: astore 7
    //   82: aload 7
    //   84: bipush 63
    //   86: invokevirtual 142	java/lang/String:indexOf	(I)I
    //   89: istore 8
    //   91: iload 8
    //   93: ifle +63 -> 156
    //   96: iload 8
    //   98: iconst_1
    //   99: iadd
    //   100: aload 7
    //   102: invokevirtual 223	java/lang/String:length	()I
    //   105: if_icmpge +51 -> 156
    //   108: new 91	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   115: aload 7
    //   117: iconst_0
    //   118: iload 8
    //   120: iconst_1
    //   121: iadd
    //   122: invokevirtual 227	java/lang/String:substring	(II)Ljava/lang/String;
    //   125: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 7
    //   130: iload 8
    //   132: iconst_1
    //   133: iadd
    //   134: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   137: ldc 231
    //   139: ldc 233
    //   141: invokevirtual 237	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore 9
    //   152: aload 9
    //   154: astore 7
    //   156: aload 7
    //   158: areturn
    //   159: astore 10
    //   161: new 31	com/crashlytics/android/internal/aD
    //   164: dup
    //   165: aload 10
    //   167: invokespecial 61	com/crashlytics/android/internal/aD:<init>	(Ljava/io/IOException;)V
    //   170: athrow
    //   171: astore 4
    //   173: new 65	java/io/IOException
    //   176: dup
    //   177: ldc 239
    //   179: invokespecial 240	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   182: astore 5
    //   184: aload 5
    //   186: aload 4
    //   188: invokevirtual 244	java/io/IOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   191: pop
    //   192: new 31	com/crashlytics/android/internal/aD
    //   195: dup
    //   196: aload 5
    //   198: invokespecial 61	com/crashlytics/android/internal/aD:<init>	(Ljava/io/IOException;)V
    //   201: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	159	java/io/IOException
    //   56	91	171	java/net/URISyntaxException
    //   96	152	171	java/net/URISyntaxException
  }

  private static String c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
      return paramString;
    return "UTF-8";
  }

  private static String c(String paramString1, String paramString2)
  {
    String str;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      str = null;
      return str;
    }
    int j = paramString1.length();
    int k = 1 + paramString1.indexOf(';');
    if ((k == 0) || (k == j))
      return null;
    int m = paramString1.indexOf(';', k);
    int n;
    int i1;
    if (m == -1)
    {
      n = k;
      i1 = j;
    }
    while (true)
    {
      if (n < i1)
      {
        int i2 = paramString1.indexOf('=', n);
        if ((i2 != -1) && (i2 < i1) && (paramString2.equals(paramString1.substring(n, i2).trim())))
        {
          str = paramString1.substring(i2 + 1, i1).trim();
          int i6 = str.length();
          if (i6 != 0)
          {
            if ((i6 <= 2) || ('"' != str.charAt(0)) || ('"' != str.charAt(i6 - 1)))
              break;
            return str.substring(1, i6 - 1);
          }
        }
        int i3 = i1 + 1;
        int i4 = paramString1.indexOf(';', i3);
        if (i4 == -1)
          i4 = j;
        int i5 = i4;
        n = i3;
        i1 = i5;
        continue;
      }
      return null;
      n = k;
      i1 = m;
    }
  }

  private ay d(CharSequence paramCharSequence)
    throws aD
  {
    try
    {
      i();
      this.e.a(paramCharSequence.toString());
      return this;
    }
    catch (IOException localIOException)
    {
      throw new aD(localIOException);
    }
  }

  private ay d(String paramString1, String paramString2)
    throws aD
  {
    return d(paramString1).d(": ").d(paramString2).d("\r\n");
  }

  private String d(String paramString)
    throws aD
  {
    h();
    int j = a().getHeaderFieldInt("Content-Length", -1);
    ByteArrayOutputStream localByteArrayOutputStream;
    if (j > 0)
      localByteArrayOutputStream = new ByteArrayOutputStream(j);
    try
    {
      while (true)
      {
        a(new BufferedInputStream(f(), this.i), localByteArrayOutputStream);
        String str = localByteArrayOutputStream.toString(c(paramString));
        return str;
        localByteArrayOutputStream = new ByteArrayOutputStream();
      }
    }
    catch (IOException localIOException)
    {
      throw new aD(localIOException);
    }
  }

  private HttpURLConnection e()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = a.a(this.c);
      localHttpURLConnection.setRequestMethod(this.d);
      return localHttpURLConnection;
    }
    catch (IOException localIOException)
    {
      throw new aD(localIOException);
    }
  }

  private InputStream f()
    throws aD
  {
    if (b() < 400);
    InputStream localInputStream1;
    do
    {
      try
      {
        InputStream localInputStream3 = a().getInputStream();
        localInputStream1 = localInputStream3;
        return localInputStream1;
      }
      catch (IOException localIOException2)
      {
        throw new aD(localIOException2);
      }
      localInputStream1 = a().getErrorStream();
    }
    while (localInputStream1 != null);
    try
    {
      InputStream localInputStream2 = a().getInputStream();
      return localInputStream2;
    }
    catch (IOException localIOException1)
    {
      throw new aD(localIOException1);
    }
  }

  private ay g()
    throws IOException
  {
    if (this.e == null)
      return this;
    if (this.f)
      this.e.a("\r\n--00content0boundary00--\r\n");
    if (this.g);
    try
    {
      this.e.close();
      while (true)
      {
        label41: this.e = null;
        return this;
        this.e.close();
      }
    }
    catch (IOException localIOException)
    {
      break label41;
    }
  }

  private ay h()
    throws aD
  {
    try
    {
      ay localay = g();
      return localay;
    }
    catch (IOException localIOException)
    {
      throw new aD(localIOException);
    }
  }

  private ay i()
    throws IOException
  {
    if (this.e != null)
      return this;
    a().setDoOutput(true);
    String str = c(a().getRequestProperty("Content-Type"), "charset");
    this.e = new aF(a().getOutputStream(), str, this.i);
    return this;
  }

  private ay j()
    throws IOException
  {
    if (!this.f)
    {
      this.f = true;
      a("Content-Type", "multipart/form-data; boundary=00content0boundary00").i();
      this.e.a("--00content0boundary00\r\n");
      return this;
    }
    this.e.a("\r\n--00content0boundary00\r\n");
    return this;
  }

  public final ay a(int paramInt)
  {
    a().setConnectTimeout(10000);
    return this;
  }

  public final ay a(String paramString, Number paramNumber)
    throws aD
  {
    if (paramNumber != null);
    for (String str = paramNumber.toString(); ; str = null)
      return b(paramString, null, str);
  }

  public final ay a(String paramString1, String paramString2)
  {
    a().setRequestProperty(paramString1, paramString2);
    return this;
  }

  // ERROR //
  public final ay a(String paramString1, String paramString2, String paramString3, java.io.File paramFile)
    throws aD
  {
    // Byte code:
    //   0: new 281	java/io/BufferedInputStream
    //   3: dup
    //   4: new 355	java/io/FileInputStream
    //   7: dup
    //   8: aload 4
    //   10: invokespecial 358	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: invokespecial 361	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   16: astore 5
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: aload_3
    //   22: aload 5
    //   24: invokevirtual 364	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)Lcom/crashlytics/android/internal/ay;
    //   27: astore 9
    //   29: aload 5
    //   31: invokevirtual 367	java/io/InputStream:close	()V
    //   34: aload 9
    //   36: areturn
    //   37: astore 6
    //   39: aconst_null
    //   40: astore 5
    //   42: new 31	com/crashlytics/android/internal/aD
    //   45: dup
    //   46: aload 6
    //   48: invokespecial 61	com/crashlytics/android/internal/aD:<init>	(Ljava/io/IOException;)V
    //   51: athrow
    //   52: astore 7
    //   54: aload 5
    //   56: ifnull +8 -> 64
    //   59: aload 5
    //   61: invokevirtual 367	java/io/InputStream:close	()V
    //   64: aload 7
    //   66: athrow
    //   67: astore 10
    //   69: aload 9
    //   71: areturn
    //   72: astore 8
    //   74: goto -10 -> 64
    //   77: astore 7
    //   79: aconst_null
    //   80: astore 5
    //   82: goto -28 -> 54
    //   85: astore 6
    //   87: goto -45 -> 42
    //
    // Exception table:
    //   from	to	target	type
    //   0	18	37	java/io/IOException
    //   18	29	52	finally
    //   42	52	52	finally
    //   29	34	67	java/io/IOException
    //   59	64	72	java/io/IOException
    //   0	18	77	finally
    //   18	29	85	java/io/IOException
  }

  public final ay a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
    throws aD
  {
    try
    {
      j();
      a(paramString1, paramString2, paramString3);
      a(paramInputStream, this.e);
      return this;
    }
    catch (IOException localIOException)
    {
      throw new aD(localIOException);
    }
  }

  public final ay a(Map.Entry<String, String> paramEntry)
  {
    return a((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }

  public final ay a(boolean paramBoolean)
  {
    a().setUseCaches(false);
    return this;
  }

  public final String a(String paramString)
    throws aD
  {
    h();
    return a().getHeaderField(paramString);
  }

  public final HttpURLConnection a()
  {
    if (this.b == null)
      this.b = e();
    return this.b;
  }

  public final int b()
    throws aD
  {
    try
    {
      g();
      int j = a().getResponseCode();
      return j;
    }
    catch (IOException localIOException)
    {
      throw new aD(localIOException);
    }
  }

  public final ay b(String paramString1, String paramString2)
  {
    return b(paramString1, null, paramString2);
  }

  public final String c()
    throws aD
  {
    return d(c(a("Content-Type"), "charset"));
  }

  public final String d()
  {
    return a().getRequestMethod();
  }

  public final String toString()
  {
    return a().getRequestMethod() + ' ' + a().getURL();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.ay
 * JD-Core Version:    0.6.2
 */