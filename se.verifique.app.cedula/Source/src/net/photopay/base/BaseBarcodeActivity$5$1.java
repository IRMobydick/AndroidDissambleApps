package net.photopay.base;

import net.photopay.hardware.camera.CameraDataFormat;
import net.photopay.hardware.camera.ResumeGrabberCaller;
import net.photopay.recognition.RecognitionData;
import net.photopay.settings.llIIlIlIIl;

final class BaseBarcodeActivity$5$1
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
      ResumeGrabberCaller localResumeGrabberCaller = ResumeGrabberCaller.IlIllIlIIl;
      if ((this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognitionData != null) && (this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.getLastRecognitionDataFormat() == CameraDataFormat.IllIIIllII))
        localResumeGrabberCaller = ResumeGrabberCaller.IllIIIllII;
      this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.resumeFrameGrabbing(localResumeGrabberCaller);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.prepareForNextRecognition();
      continue;
      this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.resetRecognitionState();
      this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.resumeFrameGrabbing(ResumeGrabberCaller.IlIllIlIIl);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseBarcodeActivity$5.llIIlIlIIl.prepareForNextRecognition();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseBarcodeActivity.5.1
 * JD-Core Version:    0.6.0
 */