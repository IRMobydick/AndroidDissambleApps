package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class jp
  implements jd
{
  protected MotionEvent a;
  protected DisplayMetrics b;
  protected nq c;
  private nw d;

  protected jp(Context paramContext, nq paramnq, nw paramnw)
  {
    this.c = paramnq;
    this.d = paramnw;
    try
    {
      this.b = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      while (true)
      {
        this.b = new DisplayMetrics();
        this.b.density = 1.0F;
      }
    }
  }

  private String a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      monitorenter;
      try
      {
        a();
        if (paramBoolean1)
          e(paramContext);
        while (true)
        {
          arrayOfByte = b();
          monitorexit;
          if (arrayOfByte.length != 0)
            break label82;
          String str2 = Integer.toString(5);
          localObject1 = str2;
          return localObject1;
          if (!paramBoolean2)
            break;
          d(paramContext);
        }
      }
      finally
      {
        monitorexit;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
      {
        byte[] arrayOfByte;
        localObject1 = Integer.toString(7);
        continue;
        c(paramContext);
        continue;
        String str1 = a(arrayOfByte, paramString);
        localObject1 = str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localObject1 = Integer.toString(7);
    }
    catch (IOException localIOException)
    {
      while (true)
        label82: Object localObject1 = Integer.toString(3);
    }
  }

  private void a()
  {
    this.d.a();
  }

  private byte[] b()
  {
    return this.d.b();
  }

  public String a(Context paramContext)
  {
    return a(paramContext, null, false, false);
  }

  public String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true, false);
  }

  String a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte.length > 239)
    {
      a();
      a(20, 1L);
      paramArrayOfByte = b();
    }
    byte[] arrayOfByte5;
    if (paramArrayOfByte.length < 239)
    {
      arrayOfByte5 = new byte[239 - paramArrayOfByte.length];
      new SecureRandom().nextBytes(arrayOfByte5);
    }
    for (byte[] arrayOfByte1 = ByteBuffer.allocate(240).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).put(arrayOfByte5).array(); ; arrayOfByte1 = ByteBuffer.allocate(240).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).array())
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      byte[] arrayOfByte3 = ByteBuffer.allocate(256).put(arrayOfByte2).put(arrayOfByte1).array();
      byte[] arrayOfByte4 = new byte[256];
      new ic().a(arrayOfByte3, arrayOfByte4);
      if ((paramString != null) && (paramString.length() > 0))
        a(paramString, arrayOfByte4);
      return this.c.a(arrayOfByte4, true);
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null)
      this.a.recycle();
    this.a = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.b.density, paramInt2 * this.b.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }

  protected void a(int paramInt, long paramLong)
  {
    this.d.a(paramInt, paramLong);
  }

  protected void a(int paramInt, String paramString)
  {
    this.d.a(paramInt, paramString);
  }

  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (this.a != null)
        this.a.recycle();
      this.a = MotionEvent.obtain(paramMotionEvent);
    }
  }

  void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString.length() > 32)
      paramString = paramString.substring(0, 32);
    new nn(paramString.getBytes("UTF-8")).a(paramArrayOfByte);
  }

  public String b(Context paramContext)
  {
    return a(paramContext, null, false, true);
  }

  protected abstract void c(Context paramContext);

  protected abstract void d(Context paramContext);

  protected abstract void e(Context paramContext);
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jp
 * JD-Core Version:    0.6.0
 */