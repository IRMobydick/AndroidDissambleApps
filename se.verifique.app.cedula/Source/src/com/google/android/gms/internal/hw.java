package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

final class hw
  implements DialogInterface.OnCancelListener
{
  hw(JsPromptResult paramJsPromptResult)
  {
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.cancel();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hw
 * JD-Core Version:    0.6.0
 */