package com.google.android.gms.internal;

final class fw
  implements ho
{
  fw(String paramString)
  {
  }

  public void a(hk paramhk)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "AFMA_buildAdURL";
    arrayOfObject[1] = this.a;
    String str = String.format("javascript:%s(%s);", arrayOfObject);
    hi.d("About to execute: " + str);
    paramhk.loadUrl(str);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fw
 * JD-Core Version:    0.6.0
 */