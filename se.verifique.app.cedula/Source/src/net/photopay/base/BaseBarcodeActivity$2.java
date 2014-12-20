package net.photopay.base;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.widget.Toast;
import mobi.pdf417.Pdf417MobiScanData;
import net.photopay.util.FakeR;

final class BaseBarcodeActivity$2
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiScanData.getBarcodeType() + "\n\n" + this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiScanData.getBarcodeData();
    if (Build.VERSION.SDK_INT >= 11)
      ((android.content.ClipboardManager)this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiScanData.getBarcodeData(), str));
    while (true)
    {
      Toast.makeText(this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity.getApplicationContext(), this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity.llIIlIlIIl.getId("string", "Copied"), 0).show();
      BaseBarcodeActivity localBaseBarcodeActivity = this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity;
      localBaseBarcodeActivity.setResult(2, BaseBarcodeActivity.IlIllIlIIl(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiScanData));
      this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity.finish();
      return;
      ((android.text.ClipboardManager)this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity.getSystemService("clipboard")).setText(str);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseBarcodeActivity.2
 * JD-Core Version:    0.6.0
 */