package net.photopay.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class BaseBarcodeActivity$3
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.llIIlIlIIl.setAlertIsBeingShown(false);
    paramDialogInterface.dismiss();
    this.llIIlIlIIl.resumeScanning();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseBarcodeActivity.3
 * JD-Core Version:    0.6.0
 */