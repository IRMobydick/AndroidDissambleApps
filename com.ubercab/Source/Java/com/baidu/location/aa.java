package com.baidu.location;

import android.os.Environment;
import android.os.Process;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

public class aa
  implements Thread.UncaughtExceptionHandler, ax, n
{
  private static aa gu = null;

  public static aa bg()
  {
    if (gu == null)
      gu = new aa();
    return gu;
  }

  private String jdMethod_if(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.close();
    return localStringWriter.toString();
  }

  public void bh()
  {
    while (true)
    {
      try
      {
        String str1 = Environment.getExternalStorageDirectory().getPath() + "/traces";
        File localFile = new File(str1 + "/error_fs.dat");
        if (localFile.exists())
        {
          RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
          localRandomAccessFile.seek(280L);
          if (1326 == localRandomAccessFile.readInt())
          {
            localRandomAccessFile.seek(308L);
            int i = localRandomAccessFile.readInt();
            if ((i <= 0) || (i >= 2048))
              break label249;
            byte[] arrayOfByte2 = new byte[i];
            localRandomAccessFile.read(arrayOfByte2, 0, i);
            str2 = new String(arrayOfByte2, 0, i);
            localRandomAccessFile.seek(600L);
            int j = localRandomAccessFile.readInt();
            String str3 = null;
            if (j > 0)
            {
              str3 = null;
              if (j < 2048)
              {
                byte[] arrayOfByte1 = new byte[j];
                localRandomAccessFile.read(arrayOfByte1, 0, j);
                str3 = new String(arrayOfByte1, 0, j);
              }
            }
            if (jdMethod_new(str2, str3))
            {
              localRandomAccessFile.seek(280L);
              localRandomAccessFile.writeInt(12346);
            }
          }
          localRandomAccessFile.close();
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label249: String str2 = null;
    }
  }

  public void jdMethod_if(File paramFile, String paramString1, String paramString2)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      localRandomAccessFile.seek(280L);
      localRandomAccessFile.writeInt(12346);
      localRandomAccessFile.seek(300L);
      localRandomAccessFile.writeLong(System.currentTimeMillis());
      byte[] arrayOfByte1 = paramString1.getBytes();
      localRandomAccessFile.writeInt(arrayOfByte1.length);
      localRandomAccessFile.write(arrayOfByte1, 0, arrayOfByte1.length);
      localRandomAccessFile.seek(600L);
      byte[] arrayOfByte2 = paramString2.getBytes();
      localRandomAccessFile.writeInt(arrayOfByte2.length);
      localRandomAccessFile.write(arrayOfByte2, 0, arrayOfByte2.length);
      if (!jdMethod_new(paramString1, paramString2))
      {
        localRandomAccessFile.seek(280L);
        localRandomAccessFile.writeInt(1326);
      }
      localRandomAccessFile.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  boolean jdMethod_new(String paramString1, String paramString2)
  {
    if (!ar.bU());
    while (true)
    {
      return false;
      try
      {
        HttpPost localHttpPost = new HttpPost(c.Y);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("e0", paramString1));
        localArrayList.add(new BasicNameValuePair("e1", paramString2));
        localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "utf-8"));
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        localDefaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(12000));
        localDefaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(12000));
        int i = localDefaultHttpClient.execute(localHttpPost).getStatusLine().getStatusCode();
        if (i == 200)
          return true;
      }
      catch (Exception localException)
      {
      }
    }
    return false;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((System.currentTimeMillis() - ab.bi() < 10000L) && (4.2F > f.getFrameVersion()))
    {
      long l2 = e.jdMethod_do().a();
      if (System.currentTimeMillis() - l2 >= 40000L)
        break label108;
      File localFile4 = new File(c.jdMethod_goto() + File.separator + f.getJarFileName());
      if (localFile4.exists())
        localFile4.delete();
    }
    while (!y.f0)
    {
      Process.killProcess(Process.myPid());
      return;
      label108: e.jdMethod_do().jdMethod_if(System.currentTimeMillis());
    }
    try
    {
      String str3 = jdMethod_if(paramThrowable);
      localObject2 = str3;
    }
    catch (Exception localException1)
    {
      try
      {
        String str4 = az.cn().jdMethod_char(false);
        String str5 = str4 + k.p().o();
        if (str5 != null)
        {
          String str6 = Jni.i(str5);
          str7 = str6;
          String str1 = str7;
          try
          {
            String str2 = Environment.getExternalStorageDirectory().getPath() + "/traces";
            localFile1 = new File(str2 + "/error_fs.dat");
            if (!localFile1.exists())
            {
              File localFile2 = new File(str2);
              if (!localFile2.exists())
                localFile2.mkdirs();
              boolean bool = localFile1.createNewFile();
              localFile3 = null;
              if (!bool)
                jdMethod_if(localFile3, str1, (String)localObject2);
            }
            else
            {
              while (true)
              {
                label299: Process.killProcess(Process.myPid());
                return;
                localException1 = localException1;
                localObject1 = null;
                localObject2 = localObject1;
                str1 = null;
                break;
                RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile1, "rw");
                localRandomAccessFile.seek(300L);
                long l1 = localRandomAccessFile.readLong();
                if (System.currentTimeMillis() - l1 > 604800000L)
                  jdMethod_if(localFile1, str1, (String)localObject2);
                localRandomAccessFile.close();
              }
            }
          }
          catch (Exception localException2)
          {
            break label299;
          }
        }
      }
      catch (Exception localException3)
      {
        while (true)
        {
          Object localObject2;
          File localFile1;
          Object localObject1 = localObject2;
          continue;
          File localFile3 = localFile1;
          continue;
          String str7 = null;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.aa
 * JD-Core Version:    0.6.2
 */