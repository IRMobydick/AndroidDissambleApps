package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;

public class l
  implements j
{
  private final hk a;

  public l(Context paramContext, ev paramev)
  {
    this.a = hk.a(paramContext, new al(), false, false, null, paramev);
  }

  public void a()
  {
    gw.a(this.a);
  }

  public void a(k paramk)
  {
    this.a.f().a(new m(this, paramk));
  }

  public void a(String paramString)
  {
    this.a.loadUrl(paramString);
  }

  public void a(String paramString, bb parambb)
  {
    this.a.f().a(paramString, parambb);
  }

  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.a(paramString, paramJSONObject);
  }

  public void b()
  {
    gw.b(this.a);
  }

  public void b(String paramString)
  {
    this.a.f().a(paramString, null);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.l
 * JD-Core Version:    0.6.0
 */