package com.baidu.location;

import android.os.Bundle;
import java.util.Locale;

public abstract class BDErrorReport
{
  private String a = null;

  public BDErrorReport()
  {
  }

  public BDErrorReport(BDErrorReport paramBDErrorReport)
  {
    this.a = paramBDErrorReport.a;
  }

  public Bundle getErrorInfo()
  {
    if (this.a == null)
      return null;
    Bundle localBundle = new Bundle();
    localBundle.putString("errInfo", this.a);
    return localBundle;
  }

  public abstract void onReportResult(boolean paramBoolean);

  public int setErrorInfo(boolean paramBoolean1, double paramDouble1, double paramDouble2, boolean paramBoolean2, String paramString1, double paramDouble3, double paramDouble4, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    localStringBuffer.append("&report=1");
    if (paramBoolean1)
    {
      Locale localLocale2 = Locale.CHINA;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Double.valueOf(paramDouble1);
      arrayOfObject2[1] = Double.valueOf(paramDouble2);
      localStringBuffer.append(String.format(localLocale2, "&ell=%.5f|%.5f", arrayOfObject2));
    }
    if (paramBoolean2)
    {
      if ((paramString1 != null) && ((paramString1.equals("gcj02")) || (paramString1.equals("bd09")) || (paramString1.equals("bd09ll")) || (paramString1.equals("gps"))))
      {
        Locale localLocale1 = Locale.CHINA;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = Double.valueOf(paramDouble3);
        arrayOfObject1[1] = Double.valueOf(paramDouble4);
        localStringBuffer.append(String.format(localLocale1, "&ugc=%.5f|%.5f", arrayOfObject1));
        localStringBuffer.append("&ucoord=");
        localStringBuffer.append(paramString1);
      }
    }
    else
    {
      if (paramString2 != null)
      {
        if (paramString2.length() > 60)
          paramString2 = paramString2.substring(0, 60);
        localStringBuffer.append("&ver=");
        localStringBuffer.append(paramString2);
      }
      if (paramString3 != null)
      {
        if (paramString3.length() > 512)
          paramString3 = paramString3.substring(0, 512);
        localStringBuffer.append("&erInfo=");
        localStringBuffer.append(paramString3);
      }
      this.a = localStringBuffer.toString();
      return 0;
    }
    return 1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.BDErrorReport
 * JD-Core Version:    0.6.2
 */