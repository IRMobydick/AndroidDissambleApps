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

public abstract class h
  implements g
{
  protected MotionEvent kw;
  protected DisplayMetrics kx;
  protected m ky;
  private n kz;

  protected h(Context paramContext, m paramm, n paramn)
  {
    this.ky = paramm;
    this.kz = paramn;
    try
    {
      this.kx = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.kx = new DisplayMetrics();
      this.kx.density = 1.0F;
    }
  }

  private String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      try
      {
        t();
        if (paramBoolean)
          c(paramContext);
        while (true)
        {
          arrayOfByte = u();
          if (arrayOfByte.length != 0)
            break;
          String str2 = Integer.toString(5);
          return str2;
          b(paramContext);
        }
      }
      finally
      {
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      byte[] arrayOfByte;
      return Integer.toString(7);
      String str1 = a(arrayOfByte, paramString);
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return Integer.toString(7);
    }
    catch (IOException localIOException)
    {
    }
    return Integer.toString(3);
  }

  private void t()
  {
    this.kz.reset();
  }

  private byte[] u()
    throws IOException
  {
    return this.kz.A();
  }

  public String a(Context paramContext)
  {
    return a(paramContext, null, false);
  }

  public String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }

  String a(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException
  {
    if (paramArrayOfByte.length > 239)
    {
      t();
      a(20, 1L);
      paramArrayOfByte = u();
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
      new f().a(arrayOfByte3, arrayOfByte4);
      if ((paramString != null) && (paramString.length() > 0))
        a(paramString, arrayOfByte4);
      return this.ky.a(arrayOfByte4, true);
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.kw != null)
      this.kw.recycle();
    this.kw = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.kx.density, paramInt2 * this.kx.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }

  protected void a(int paramInt, long paramLong)
    throws IOException
  {
    this.kz.b(paramInt, paramLong);
  }

  protected void a(int paramInt, String paramString)
    throws IOException
  {
    this.kz.b(paramInt, paramString);
  }

  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (this.kw != null)
        this.kw.recycle();
      this.kw = MotionEvent.obtain(paramMotionEvent);
    }
  }

  void a(String paramString, byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    if (paramString.length() > 32)
      paramString = paramString.substring(0, 32);
    new pe(paramString.getBytes("UTF-8")).o(paramArrayOfByte);
  }

  protected abstract void b(Context paramContext);

  protected abstract void c(Context paramContext);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.h
 * JD-Core Version:    0.6.2
 */