package com.google.b.a.a;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class j
  implements n
{
  private static j a;
  private static final Object b = new Object();
  private final Context c;
  private String d;
  private boolean e = false;
  private final Object f = new Object();

  protected j(Context paramContext)
  {
    this.c = paramContext;
    e();
  }

  public static j a()
  {
    synchronized (b)
    {
      j localj = a;
      return localj;
    }
  }

  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null)
        a = new j(paramContext);
      return;
    }
  }

  private boolean b(String paramString)
  {
    int i = 0;
    try
    {
      ar.c("Storing clientId.");
      FileOutputStream localFileOutputStream = this.c.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      i = 1;
      return i;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
        ar.a("Error creating clientId file.");
    }
    catch (IOException localIOException)
    {
      while (true)
        ar.a("Error writing to clientId file.");
    }
  }

  private String d()
  {
    if (!this.e);
    synchronized (this.f)
    {
      if (!this.e)
        ar.c("Waiting for clientId to load");
      try
      {
        do
          this.f.wait();
        while (!this.e);
        ar.c("Loaded clientId");
        return this.d;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          ar.a("Exception while waiting for clientId: " + localInterruptedException);
      }
    }
  }

  private void e()
  {
    new k(this, "client_id_fetcher").start();
  }

  public String a(String paramString)
  {
    if ("&cid".equals(paramString));
    for (String str = d(); ; str = null)
      return str;
  }

  protected String b()
  {
    String str = UUID.randomUUID().toString().toLowerCase();
    if (!b(str))
      str = "0";
    return str;
  }

  String c()
  {
    Object localObject = null;
    try
    {
      localFileInputStream = this.c.openFileInput("gaClientId");
      byte[] arrayOfByte = new byte[''];
      int i = localFileInputStream.read(arrayOfByte, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        ar.a("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        this.c.deleteFile("gaClientId");
      }
      while (true)
      {
        label61: if (localObject == null)
          localObject = b();
        return localObject;
        if (i > 0)
          break;
        ar.a("clientId file seems empty, deleting it.");
        localFileInputStream.close();
        this.c.deleteFile("gaClientId");
      }
      str = new String(arrayOfByte, 0, i);
    }
    catch (IOException localIOException1)
    {
      while (true)
        try
        {
          FileInputStream localFileInputStream;
          localFileInputStream.close();
          localObject = str;
          continue;
          localIOException1 = localIOException1;
          ar.a("Error reading clientId file, deleting it.");
          this.c.deleteFile("gaClientId");
        }
        catch (IOException localIOException2)
        {
          localObject = str;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          String str;
          localObject = str;
        }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      break label61;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.j
 * JD-Core Version:    0.6.0
 */