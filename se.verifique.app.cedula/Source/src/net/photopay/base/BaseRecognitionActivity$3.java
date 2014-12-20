package net.photopay.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class BaseRecognitionActivity$3
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.llIIlIlIIl.setResult(0, null);
    this.llIIlIlIIl.finish();
    this.llIIlIlIIl.setAlertIsBeingShown(false);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseRecognitionActivity.3
 * JD-Core Version:    0.6.0
 */