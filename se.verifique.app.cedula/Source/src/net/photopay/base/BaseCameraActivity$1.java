package net.photopay.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class BaseCameraActivity$1
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null)
      paramDialogInterface.dismiss();
    this.IlIllIlIIl.setResult(0, null);
    this.IlIllIlIIl.finish();
    this.IlIllIlIIl.setAlertIsBeingShown(false);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseCameraActivity.1
 * JD-Core Version:    0.6.0
 */