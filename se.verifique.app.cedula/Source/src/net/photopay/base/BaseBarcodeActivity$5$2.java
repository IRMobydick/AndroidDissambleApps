package net.photopay.base;

import net.photopay.recognition.RecognitionData;
import net.photopay.settings.llIIlIlIIl;

final class BaseBarcodeActivity$5$2
  implements Runnable
{
  public final void run()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.llIIlIlIIl.IIlIIIllIl() == 0)
      if ((this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognitionData != null) && (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognitionData.isValid()))
        BaseBarcodeActivity.5.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5, this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognitionData);
    while (true)
    {
      return;
      this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.resetRecognitionState();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseBarcodeActivity.5.2
 * JD-Core Version:    0.6.0
 */