package net.photopay.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.pdf417.Pdf417MobiScanData;

final class BaseBarcodeActivity$4
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseBarcodeActivity localBaseBarcodeActivity = this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity;
    localBaseBarcodeActivity.setResult(1, BaseBarcodeActivity.IlIllIlIIl(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiScanData));
    this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity.finish();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseBarcodeActivity.4
 * JD-Core Version:    0.6.0
 */