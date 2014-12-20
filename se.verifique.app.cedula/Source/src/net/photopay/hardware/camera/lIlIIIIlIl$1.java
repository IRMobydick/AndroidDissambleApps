package net.photopay.hardware.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import net.photopay.secured.llIIlIlIIl;
import net.photopay.util.Log;

final class lIlIIIIlIl$1
  implements Camera.PreviewCallback
{
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Log.v(this.llIIlIlIIl, "Camera has got the frame!", new Object[0]);
    lIlIIIIlIl locallIlIIIIlIl = this.llIIlIlIIl;
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramArrayOfByte;
    arrayOfObject[1] = paramCamera;
    arrayOfObject[2] = Boolean.valueOf(this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl.IlIllIlIIl());
    arrayOfObject[3] = this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll;
    arrayOfObject[4] = Boolean.valueOf(this.llIIlIlIIl.IlllIIIllI);
    Log.v(locallIlIIIIlIl, "Data: {}, Camera: {}, phone shaking: {}, camera delegate: {}, frame grabbing paused: {}", arrayOfObject);
    if ((paramArrayOfByte != null) && (paramCamera != null) && (!this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl.IlIllIlIIl()) && (this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll != null) && (!this.llIIlIlIIl.IlllIIIllI))
    {
      Log.v(this.llIIlIlIIl, "Raising camera event!", new Object[0]);
      this.llIIlIlIIl.pauseFrameGrabbing();
      this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll.onCameraImage(paramArrayOfByte, CameraDataFormat.IlIllIlIIl, paramCamera.getParameters().getPreviewSize(), this.llIIlIlIIl.IllIIIIllI());
    }
    while (true)
    {
      return;
      if ((this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null) && (!this.llIIlIlIIl.IlllIIIllI))
      {
        this.llIIlIlIIl.resumeFrameGrabbing(ResumeGrabberCaller.llIIlIlIIl);
        Log.v(this.llIIlIlIIl, "Not raising camera event", new Object[0]);
        continue;
      }
      Log.v(this.llIIlIlIIl, "Not raising camera event!", new Object[0]);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.lIlIIIIlIl.1
 * JD-Core Version:    0.6.0
 */