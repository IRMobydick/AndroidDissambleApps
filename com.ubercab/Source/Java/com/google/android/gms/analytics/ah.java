package com.google.android.gms.analytics;

import android.content.Context;
import java.util.Map;

class ah extends j<ai>
{
  public ah(Context paramContext)
  {
    super(paramContext, new a());
  }

  private static class a
    implements j.a<ai>
  {
    private final ai BB = new ai();

    public void c(String paramString, int paramInt)
    {
      if ("ga_sessionTimeout".equals(paramString))
      {
        this.BB.BE = paramInt;
        return;
      }
      z.W("int configuration name not recognized:  " + paramString);
    }

    public void d(String paramString, boolean paramBoolean)
    {
      int i = 1;
      if ("ga_autoActivityTracking".equals(paramString))
      {
        ai localai3 = this.BB;
        if (paramBoolean);
        while (true)
        {
          localai3.BF = i;
          return;
          i = 0;
        }
      }
      if ("ga_anonymizeIp".equals(paramString))
      {
        ai localai2 = this.BB;
        if (paramBoolean);
        while (true)
        {
          localai2.BG = i;
          return;
          i = 0;
        }
      }
      if ("ga_reportUncaughtExceptions".equals(paramString))
      {
        ai localai1 = this.BB;
        if (paramBoolean);
        while (true)
        {
          localai1.BH = i;
          return;
          i = 0;
        }
      }
      z.W("bool configuration name not recognized:  " + paramString);
    }

    public ai eY()
    {
      return this.BB;
    }

    public void f(String paramString1, String paramString2)
    {
      this.BB.BI.put(paramString1, paramString2);
    }

    public void g(String paramString1, String paramString2)
    {
      if ("ga_trackingId".equals(paramString1))
      {
        this.BB.BC = paramString2;
        return;
      }
      if ("ga_sampleFrequency".equals(paramString1))
        try
        {
          this.BB.BD = Double.parseDouble(paramString2);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          z.T("Error parsing ga_sampleFrequency value: " + paramString2);
          return;
        }
      z.W("string configuration name not recognized:  " + paramString1);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ah
 * JD-Core Version:    0.6.2
 */