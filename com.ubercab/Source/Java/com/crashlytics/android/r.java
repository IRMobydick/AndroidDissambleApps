package com.crashlytics.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class r
  implements DialogInterface.OnClickListener
{
  r(p paramp)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.a(false);
    paramDialogInterface.dismiss();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.r
 * JD-Core Version:    0.6.2
 */