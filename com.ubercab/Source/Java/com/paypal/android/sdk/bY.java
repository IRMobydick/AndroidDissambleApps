package com.paypal.android.sdk;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public final class bY extends bW
{
  private static String[] a = { "image/jpeg", "image/png" };

  protected final void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      super.a(paramMessage);
      return;
    case 0:
      ((Integer)((Object[])paramMessage.obj)[0]).intValue();
      return;
    case 1:
    }
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    Throwable localThrowable = (Throwable)arrayOfObject[0];
    ((byte[])arrayOfObject[1]);
    a(localThrowable, (String)arrayOfObject[3]);
  }

  protected final void a(Throwable paramThrowable, byte[] paramArrayOfByte, String paramString)
  {
    b(a(1, new Object[] { paramThrowable, paramArrayOfByte, paramString }));
  }

  final void a(HttpResponse paramHttpResponse)
  {
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    Header[] arrayOfHeader1 = paramHttpResponse.getHeaders("PayPal-Debug-Id");
    if ((arrayOfHeader1 != null) && (arrayOfHeader1.length > 0));
    Header[] arrayOfHeader2;
    for (String str = arrayOfHeader1[1].getValue(); ; str = null)
    {
      arrayOfHeader2 = paramHttpResponse.getHeaders("Content-Type");
      if (arrayOfHeader2.length == 1)
        break;
      a(new HttpResponseException(localStatusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"), null, str);
      return;
    }
    Header localHeader = arrayOfHeader2[0];
    String[] arrayOfString = a;
    int i = arrayOfString.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      if (arrayOfString[j].equals(localHeader.getValue()))
        k = 1;
      j++;
    }
    if (k == 0)
    {
      a(new HttpResponseException(localStatusLine.getStatusCode(), "Content-Type not allowed!"), null, str);
      return;
    }
    while (true)
    {
      try
      {
        HttpEntity localHttpEntity = paramHttpResponse.getEntity();
        if (localHttpEntity != null)
        {
          localBufferedHttpEntity = new BufferedHttpEntity(localHttpEntity);
          byte[] arrayOfByte2 = EntityUtils.toByteArray(localBufferedHttpEntity);
          arrayOfByte1 = arrayOfByte2;
          if (localStatusLine.getStatusCode() >= 300)
          {
            a(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), arrayOfByte1, str);
            return;
          }
        }
      }
      catch (IOException localIOException)
      {
        a(localIOException, null, str);
        byte[] arrayOfByte1 = null;
        continue;
        int m = localStatusLine.getStatusCode();
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(m);
        arrayOfObject[1] = arrayOfByte1;
        arrayOfObject[2] = str;
        b(a(0, arrayOfObject));
        return;
      }
      BufferedHttpEntity localBufferedHttpEntity = null;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bY
 * JD-Core Version:    0.6.2
 */