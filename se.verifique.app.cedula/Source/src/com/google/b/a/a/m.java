package com.google.b.a.a;

import android.util.Log;

class m
  implements as
{
  private at a = at.b;

  private String e(String paramString)
  {
    return Thread.currentThread().toString() + ": " + paramString;
  }

  public at a()
  {
    return this.a;
  }

  public void a(at paramat)
  {
    this.a = paramat;
  }

  public void a(String paramString)
  {
    if (this.a.ordinal() <= at.a.ordinal())
      Log.v("GAV3", e(paramString));
  }

  public void b(String paramString)
  {
    if (this.a.ordinal() <= at.b.ordinal())
      Log.i("GAV3", e(paramString));
  }

  public void c(String paramString)
  {
    if (this.a.ordinal() <= at.c.ordinal())
      Log.w("GAV3", e(paramString));
  }

  public void d(String paramString)
  {
    if (this.a.ordinal() <= at.d.ordinal())
      Log.e("GAV3", e(paramString));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.m
 * JD-Core Version:    0.6.0
 */