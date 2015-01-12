package com.paypal.android.sdk;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

class D extends y
{
  private static final String a = D.class.getSimpleName();
  private String b;
  private L c;
  private bR d;
  private bR e;
  private d f;

  public D(String paramString1, d paramd, L paramL, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.b = paramString1;
    this.f = paramd;
    this.c = paramL;
    ThreadPoolExecutor localThreadPoolExecutor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    int i;
    boolean bool1;
    if ((!paramString1.equals("live")) && (!paramString1.startsWith("sandbox")) && (!paramString1.equals("mock")))
    {
      i = 1;
      if ((i == 0) || (paramBoolean))
        break label131;
      bool1 = true;
      label70: if (i != 0)
        break label137;
    }
    label131: label137: for (boolean bool2 = true; ; bool2 = false)
    {
      this.d = z.a(paramInt, bool1, bool2, paramString2);
      this.d.a(localThreadPoolExecutor);
      this.e = z.a(paramInt, true, false, paramString3);
      this.e.a(localThreadPoolExecutor);
      return;
      i = 0;
      break;
      bool1 = false;
      break label70;
    }
  }

  private static String a(String paramString1, String paramString2)
  {
    if (!paramString1.endsWith("/"))
      paramString1 = paramString1 + "/";
    return paramString1 + paramString2;
  }

  private Header[] a(al paramal, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramal.x().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new BasicHeader((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    if (paramString != null);
    label108: Header[] arrayOfHeader;
    try
    {
      localArrayList.add(B.a(this.f.e(), localArrayList, paramString));
      arrayOfHeader = (Header[])localArrayList.toArray(new Header[0]);
      int i = arrayOfHeader.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label292;
        localHeader = arrayOfHeader[j];
        if (!paramal.e())
          break;
        new StringBuilder().append(paramal.A()).append(" header: ").append(localHeader.getName()).append("=").append(localHeader.getValue()).toString();
      }
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      break label108;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label108;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        Header localHeader;
        continue;
        new StringBuilder().append(paramal.A()).append(" header: ").append(localHeader.getName()).append("=").append(localHeader.getValue()).toString();
      }
    }
    label292: return arrayOfHeader;
  }

  final void a()
  {
    this.d.a(b.a().b(), true);
    this.e.a(b.a().b(), true);
  }

  final void b()
  {
    this.d.a().getConnectionManager().closeIdleConnections(1L, TimeUnit.MILLISECONDS);
    this.e.a().getConnectionManager().closeIdleConnections(1L, TimeUnit.MILLISECONDS);
  }

  public final boolean b(al paramal)
  {
    if (!b.a().c().a())
    {
      paramal.a(new an(f.b.toString()));
      return false;
    }
    String str1 = paramal.a(paramal.w());
    if (paramal.e())
    {
      new StringBuilder().append(paramal.A()).append(" endpoint: ").append(str1).toString();
      new StringBuilder().append(paramal.A()).append(" request: ").append(paramal.u()).toString();
    }
    bR localbR;
    Object localObject;
    while (true)
    {
      try
      {
        if (!paramal.e())
          break label316;
        localbR = this.e;
        if ((!paramal.e()) && (!(paramal instanceof O)))
          break label325;
        localObject = new G(this, paramal, (byte)0);
        switch (E.a[paramal.w().a().ordinal()])
        {
        default:
          throw new RuntimeException(paramal.w().a() + " not supported.");
        case 1:
        case 2:
        case 3:
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        paramal.a(new an(f.d, localUnsupportedEncodingException));
        return false;
      }
      new StringBuilder().append(paramal.A()).append(" endpoint: ").append(str1).toString();
      new StringBuilder().append(paramal.A()).append(" request: ").append(paramal.u()).toString();
      continue;
      label316: localbR = this.d;
      continue;
      label325: localObject = new F(this, paramal, (byte)0);
    }
    localbR.a(b.a().b(), a(str1, paramal.u()), a(paramal, null), null, (bW)localObject);
    break label469;
    String str2 = paramal.u();
    StringEntity localStringEntity = new StringEntity(str2, Charset.forName("UTF-8").name());
    Context localContext = b.a().b();
    Header[] arrayOfHeader = a(paramal, str2);
    localbR.a(localContext, str1, arrayOfHeader, localStringEntity, null, (bW)localObject);
    break label469;
    this.d.a(b.a().b(), a(str1, paramal.u()), a(paramal, null), new F(this, paramal, (byte)0));
    label469: return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.D
 * JD-Core Version:    0.6.2
 */