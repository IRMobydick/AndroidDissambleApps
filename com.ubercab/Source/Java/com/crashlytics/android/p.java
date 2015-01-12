package com.crashlytics.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.internal.aQ;

final class p
  implements Runnable
{
  p(Crashlytics paramCrashlytics, Activity paramActivity, u paramu, X paramX, aQ paramaQ)
  {
  }

  public final void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.c);
    q localq = new q(this);
    float f = this.c.getResources().getDisplayMetrics().density;
    int i = Crashlytics.a(this.b, f, 5);
    TextView localTextView = new TextView(this.c);
    localTextView.setAutoLinkMask(15);
    localTextView.setText(this.d.b());
    localTextView.setTextAppearance(this.c, 16973892);
    localTextView.setPadding(i, i, i, i);
    localTextView.setFocusable(false);
    ScrollView localScrollView = new ScrollView(this.c);
    localScrollView.setPadding(Crashlytics.a(this.b, f, 14), Crashlytics.a(this.b, f, 2), Crashlytics.a(this.b, f, 10), Crashlytics.a(this.b, f, 12));
    localScrollView.addView(localTextView);
    localBuilder.setView(localScrollView).setTitle(this.d.a()).setCancelable(false).setNeutralButton(this.d.c(), localq);
    if (this.e.d)
    {
      r localr = new r(this);
      localBuilder.setNegativeButton(this.d.e(), localr);
    }
    if (this.e.f)
    {
      s locals = new s(this);
      localBuilder.setPositiveButton(this.d.d(), locals);
    }
    localBuilder.show();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.p
 * JD-Core Version:    0.6.2
 */