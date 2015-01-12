package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class j<T extends i>
{
  Context mContext;
  a<T> xV;

  public j(Context paramContext, a<T> parama)
  {
    this.mContext = paramContext;
    this.xV = parama;
  }

  private T a(XmlResourceParser paramXmlResourceParser)
  {
    try
    {
      paramXmlResourceParser.next();
      int i = paramXmlResourceParser.getEventType();
      if (i != 1)
      {
        if (paramXmlResourceParser.getEventType() == 2)
        {
          str1 = paramXmlResourceParser.getName().toLowerCase();
          if (!str1.equals("screenname"))
            break label114;
          String str8 = paramXmlResourceParser.getAttributeValue(null, "name");
          String str9 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)))
            this.xV.f(str8, str9);
        }
        while (true)
        {
          i = paramXmlResourceParser.next();
          break;
          label114: if (!str1.equals("string"))
            break label208;
          String str6 = paramXmlResourceParser.getAttributeValue(null, "name");
          String str7 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str6)) && (str7 != null))
            this.xV.g(str6, str7);
        }
      }
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      while (true)
      {
        z.T("Error parsing tracker configuration file: " + localXmlPullParserException);
        return this.xV.dW();
        if (!str1.equals("bool"))
          break;
        String str4 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str5 = paramXmlResourceParser.nextText().trim();
        if (!TextUtils.isEmpty(str4))
        {
          boolean bool2 = TextUtils.isEmpty(str5);
          if (!bool2)
            try
            {
              boolean bool3 = Boolean.parseBoolean(str5);
              this.xV.d(str4, bool3);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              z.T("Error parsing bool configuration value: " + str5);
            }
        }
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        String str1;
        label208: z.T("Error parsing tracker configuration file: " + localIOException);
        continue;
        if (str1.equals("integer"))
        {
          String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
          String str3 = paramXmlResourceParser.nextText().trim();
          if (!TextUtils.isEmpty(str2))
          {
            boolean bool1 = TextUtils.isEmpty(str3);
            if (!bool1)
              try
              {
                int j = Integer.parseInt(str3);
                this.xV.c(str2, j);
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                z.T("Error parsing int configuration value: " + str3);
              }
          }
        }
      }
    }
  }

  public T w(int paramInt)
  {
    try
    {
      i locali = a(this.mContext.getResources().getXml(paramInt));
      return locali;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      z.W("inflate() called with unknown resourceId: " + localNotFoundException);
    }
    return null;
  }

  public static abstract interface a<U extends i>
  {
    public abstract void c(String paramString, int paramInt);

    public abstract void d(String paramString, boolean paramBoolean);

    public abstract U dW();

    public abstract void f(String paramString1, String paramString2);

    public abstract void g(String paramString1, String paramString2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.j
 * JD-Core Version:    0.6.2
 */