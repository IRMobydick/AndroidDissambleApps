package net.photopay.hardware.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import net.photopay.secured.llIIlIlIIl;

final class IllIIIIllI$5
  implements Camera.PreviewCallback
{
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((paramArrayOfByte != null) && (paramCamera != null) && (!this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl.IlIllIlIIl()) && (this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll != null) && (!this.llIIlIlIIl.IlllIIIllI))
    {
      this.llIIlIlIIl.pauseFrameGrabbing();
      this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll.onCameraImage(paramArrayOfByte, CameraDataFormat.IlIllIlIIl, paramCamera.getParameters().getPreviewSize(), false);
    }
    while (true)
    {
      return;
      if ((this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null) && (!this.llIIlIlIIl.IlllIIIllI))
      {
        this.llIIlIlIIl.resumeFrameGrabbing(ResumeGrabberCaller.llIIlIlIIl);
        continue;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.IllIIIIllI.5
 * JD-Core Version:    0.6.0
 */