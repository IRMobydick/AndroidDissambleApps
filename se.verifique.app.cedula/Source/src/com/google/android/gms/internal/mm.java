package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.b.a;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import java.io.IOException;

public class mm extends lf
{
  protected mm(Context paramContext, nq paramnq, nw paramnw)
  {
    super(paramContext, paramnq, paramnw);
  }

  public static mm a(String paramString, Context paramContext)
  {
    gb localgb = new gb();
    a(paramString, paramContext, localgb);
    return new mm(paramContext, localgb, new nz(239));
  }

  protected void c(Context paramContext)
  {
    super.c(paramContext);
    try
    {
      mn localmn = h(paramContext);
      long l;
      if (localmn.b())
        l = 1L;
      while (true)
      {
        a(28, l);
        String str = localmn.a();
        if (str != null)
        {
          a(26, 5L);
          a(24, str);
        }
        label60: return;
        l = 0L;
      }
    }
    catch (e locale)
    {
      while (true)
        a(24, f(paramContext));
    }
    catch (IOException localIOException)
    {
      break label60;
    }
    catch (lh locallh)
    {
      break label60;
    }
  }

  protected void d(Context paramContext)
  {
    long l = 1L;
    super.c(paramContext);
    try
    {
      a(24, f(paramContext));
    }
    catch (IOException localIOException2)
    {
      try
      {
        mn localmn = h(paramContext);
        if (localmn.b())
        {
          a(28, l);
          String str = localmn.a();
          if (str == null)
            return;
          a(30, str);
        }
      }
      catch (IOException localIOException1)
      {
        while (true)
        {
          a(28, 1L);
          break;
          localIOException2 = localIOException2;
          break;
          l = 0L;
        }
      }
      catch (e locale)
      {
      }
    }
    catch (lh locallh)
    {
      label17: break label17;
    }
  }

  mn h(Context paramContext)
  {
    int i = 0;
    b localb;
    String str1;
    byte[] arrayOfByte;
    try
    {
      localb = a.b(paramContext);
      str1 = localb.a();
      if ((str1 != null) && (str1.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")))
      {
        arrayOfByte = new byte[16];
        int j = 0;
        while (i < str1.length())
        {
          if ((i == 8) || (i == 13) || (i == 18) || (i == 23))
            i++;
          arrayOfByte[j] = (byte)((Character.digit(str1.charAt(i), 16) << 4) + Character.digit(str1.charAt(i + 1), 16));
          j++;
          i += 2;
        }
      }
    }
    catch (f localf)
    {
      throw new IOException(localf);
    }
    for (String str2 = this.c.a(arrayOfByte, true); ; str2 = str1)
      return new mn(this, str2, localb.b());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mm
 * JD-Core Version:    0.6.0
 */