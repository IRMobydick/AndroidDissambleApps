package com.crashlytics.android;

import android.util.Log;
import com.crashlytics.android.internal.ab;
import com.crashlytics.android.internal.q;
import com.crashlytics.android.internal.v;

final class c
{
  private String a;
  private boolean b;

  public c(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }

  public final void a(String paramString1, String paramString2)
  {
    if ((ab.e(this.a)) && (this.b))
    {
      Log.e("Crashlytics", ".");
      Log.e("Crashlytics", ".     |  | ");
      Log.e("Crashlytics", ".     |  |");
      Log.e("Crashlytics", ".     |  |");
      Log.e("Crashlytics", ".   \\ |  | /");
      Log.e("Crashlytics", ".    \\    /");
      Log.e("Crashlytics", ".     \\  /");
      Log.e("Crashlytics", ".      \\/");
      Log.e("Crashlytics", ".");
      Log.e("Crashlytics", "This app relies on Crashlytics. Configure your build environment here: ");
      Log.e("Crashlytics", String.format("https://crashlytics.com/register/%s/android/%s", new Object[] { paramString1, paramString2 }));
      Log.e("Crashlytics", ".");
      Log.e("Crashlytics", ".      /\\");
      Log.e("Crashlytics", ".     /  \\");
      Log.e("Crashlytics", ".    /    \\");
      Log.e("Crashlytics", ".   / |  | \\");
      Log.e("Crashlytics", ".     |  |");
      Log.e("Crashlytics", ".     |  |");
      Log.e("Crashlytics", ".     |  |");
      Log.e("Crashlytics", ".");
      throw new CrashlyticsMissingDependencyException(paramString1, paramString2);
    }
    if (!this.b)
      v.a().b().a("Crashlytics", "Configured not to require a build ID.");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c
 * JD-Core Version:    0.6.2
 */