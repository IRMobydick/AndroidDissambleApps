package com.google.android.gms.internal;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

final class ct
{
  public final int a;
  public final ViewGroup.LayoutParams b;
  public final ViewGroup c;

  public ct(hk paramhk)
  {
    this.b = paramhk.getLayoutParams();
    ViewParent localViewParent = paramhk.getParent();
    if ((localViewParent instanceof ViewGroup))
    {
      this.c = ((ViewGroup)localViewParent);
      this.a = this.c.indexOfChild(paramhk);
      this.c.removeView(paramhk);
      paramhk.a(true);
      return;
    }
    throw new cr("Could not get the parent of the WebView for an overlay.");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ct
 * JD-Core Version:    0.6.0
 */