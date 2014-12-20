package net.photopay.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class BaseCameraActivity$2
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null)
      paramDialogInterface.dismiss();
    this.IlIllIlIIl.setResult(0, null);
    this.IlIllIlIIl.finish();
    BaseCameraActivity.llIIlIlIIl(this.IlIllIlIIl);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseCameraActivity.2
 * JD-Core Version:    0.6.0
 */