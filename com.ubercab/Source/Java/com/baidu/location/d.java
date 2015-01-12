package com.baidu.location;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class d extends s
{
  private static d c1 = null;
  Handler c2 = null;
  String c3 = null;
  String c4 = null;
  String c5 = null;

  private boolean U()
  {
    if (this.c3 == null);
    while (new File(c.jdMethod_goto() + File.separator + this.c3).exists())
      return true;
    return jdMethod_for("http://" + this.c5 + "/" + this.c3, this.c3);
  }

  private void V()
  {
    if (this.c4 == null);
    File localFile1;
    do
    {
      return;
      localFile1 = new File(c.jdMethod_goto() + File.separator + this.c4);
    }
    while ((localFile1.exists()) || (!jdMethod_for("http://" + this.c5 + "/" + this.c4, this.c4)));
    File localFile2 = new File(c.jdMethod_goto() + File.separator + f.replaceFileName);
    if (localFile2.exists())
      localFile2.delete();
    try
    {
      jdMethod_if(localFile1, localFile2);
      return;
    }
    catch (Exception localException)
    {
      localFile2.delete();
    }
  }

  private Handler W()
  {
    return this.c2;
  }

  public static d X()
  {
    if (c1 == null)
      c1 = new d();
    return c1;
  }

  private void Y()
  {
    if (this.c5 == null);
    while (!ar.bU())
      return;
    new d.3(this).start();
  }

  private static boolean jdMethod_for(String paramString1, String paramString2)
  {
    File localFile = new File(c.jdMethod_goto() + File.separator + "tmp");
    if (localFile.exists())
      localFile.delete();
    FileOutputStream localFileOutputStream;
    HttpURLConnection localHttpURLConnection;
    try
    {
      localFileOutputStream = new FileOutputStream(localFile);
      byte[] arrayOfByte = new byte[4096];
      localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localHttpURLConnection.getInputStream());
      while (true)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i <= 0)
          break;
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      localFile.delete();
      return false;
    }
    localHttpURLConnection.disconnect();
    localFileOutputStream.close();
    if (localFile.length() < 10240L)
    {
      localFile.delete();
      return false;
    }
    localFile.renameTo(new File(c.jdMethod_goto() + File.separator + paramString2));
    return true;
  }

  // ERROR //
  public static void jdMethod_if(File paramFile1, File paramFile2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 125	java/io/BufferedInputStream
    //   3: dup
    //   4: new 162	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 132	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: new 165	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 111	java/io/FileOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: invokespecial 168	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_3
    //   32: sipush 5120
    //   35: newarray byte
    //   37: astore 6
    //   39: aload_2
    //   40: aload 6
    //   42: invokevirtual 136	java/io/BufferedInputStream:read	([B)I
    //   45: istore 7
    //   47: iload 7
    //   49: iconst_m1
    //   50: if_icmpeq +41 -> 91
    //   53: aload_3
    //   54: aload 6
    //   56: iconst_0
    //   57: iload 7
    //   59: invokevirtual 169	java/io/BufferedOutputStream:write	([BII)V
    //   62: goto -23 -> 39
    //   65: astore 4
    //   67: aload_2
    //   68: astore 5
    //   70: aload 5
    //   72: ifnull +8 -> 80
    //   75: aload 5
    //   77: invokevirtual 170	java/io/BufferedInputStream:close	()V
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   88: aload 4
    //   90: athrow
    //   91: aload_3
    //   92: invokevirtual 174	java/io/BufferedOutputStream:flush	()V
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 170	java/io/BufferedInputStream:close	()V
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   111: return
    //   112: astore 4
    //   114: aconst_null
    //   115: astore_3
    //   116: aconst_null
    //   117: astore 5
    //   119: goto -49 -> 70
    //   122: astore 4
    //   124: aload_2
    //   125: astore 5
    //   127: aconst_null
    //   128: astore_3
    //   129: goto -59 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   32	39	65	finally
    //   39	47	65	finally
    //   53	62	65	finally
    //   91	95	65	finally
    //   0	16	112	finally
    //   16	32	122	finally
  }

  void T()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(4.2F);
    localStringBuffer.append("&fw=");
    localStringBuffer.append(f.getFrameVersion());
    localStringBuffer.append("&suit=");
    localStringBuffer.append(2);
    if (az.cn().iP == null)
    {
      localStringBuffer.append("&im=");
      localStringBuffer.append(az.cn().iL);
    }
    while (true)
    {
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&sv=");
      String str = Build.VERSION.RELEASE;
      if ((str != null) && (str.length() > 10))
        str = str.substring(0, 10);
      localStringBuffer.append(str);
      localStringBuffer.append("&pack=");
      localStringBuffer.append(az.iH);
      this.cR = (c.jdMethod_int() + "?&it=" + Jni.l(localStringBuffer.toString()));
      return;
      localStringBuffer.append("&cu=");
      localStringBuffer.append(az.cn().iP);
    }
  }

  public void Z()
  {
    long l = e.jdMethod_do().jdMethod_if();
    if (System.currentTimeMillis() - l > 172800000L)
      W().postDelayed(new d.1(this), 10000L);
  }

  void jdMethod_do(boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.cS, "utf-8"));
      if ("up".equals(localJSONObject.getString("res")))
      {
        this.c5 = localJSONObject.getString("upath");
        if (localJSONObject.has("u1"))
          this.c4 = localJSONObject.getString("u1");
        if (localJSONObject.has("u2"))
          this.c3 = localJSONObject.getString("u2");
        W().post(new d.2(this));
      }
      label107: e.jdMethod_do().a(System.currentTimeMillis());
      return;
    }
    catch (Exception localException)
    {
      break label107;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.d
 * JD-Core Version:    0.6.2
 */