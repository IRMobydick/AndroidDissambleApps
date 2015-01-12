package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;

final class c extends URLSpan
{
  private Activity a;
  private Class b;
  private d c;

  c(URLSpan paramURLSpan, Activity paramActivity, Class paramClass, d paramd)
  {
    super(paramURLSpan.getURL());
    this.a = paramActivity;
    this.b = paramClass;
    this.c = paramd;
  }

  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, this.b);
    this.c.a();
    this.a.startActivity(localIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.c
 * JD-Core Version:    0.6.2
 */