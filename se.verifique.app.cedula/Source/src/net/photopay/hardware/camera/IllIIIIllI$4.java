package net.photopay.hardware.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.os.Build.VERSION;
import net.photopay.util.Log;

final class IllIIIIllI$4
  implements Camera.PictureCallback
{
  public final void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool1 = true;
    if ((paramArrayOfByte != null) && (paramCamera != null) && (this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll != null))
    {
      Log.i(this, "on picture taken", new Object[0]);
      this.llIIlIlIIl.IlIIlIIIII = false;
      if (Build.VERSION.SDK_INT >= 14)
        this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.stopPreview();
      this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll.onCameraImage(paramArrayOfByte, CameraDataFormat.IllIIIllII, paramCamera.getParameters().getPictureSize(), bool1);
      this.llIIlIlIIl.IlIIIIIlll = false;
      return;
    }
    Object[] arrayOfObject = new Object[3];
    boolean bool2;
    label102: boolean bool3;
    if (paramArrayOfByte == null)
    {
      bool2 = bool1;
      arrayOfObject[0] = Boolean.valueOf(bool2);
      if (paramCamera != null)
        break label192;
      bool3 = bool1;
      label118: arrayOfObject[bool1] = Boolean.valueOf(bool3);
      if (this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll != null)
        break label198;
    }
    while (true)
    {
      arrayOfObject[2] = Boolean.valueOf(bool1);
      Log.e(this, "failed to invoke camera delegate: data is null: {}; camera is null: {}; delegate is null: {}", arrayOfObject);
      this.llIIlIlIIl.IlIIIIIlll = false;
      this.llIIlIlIIl.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll.onTakePictureFail();
      this.llIIlIlIIl.resumeFrameGrabbing(ResumeGrabberCaller.llIIIlllll);
      break;
      bool2 = false;
      break label102;
      label192: bool3 = false;
      break label118;
      label198: bool1 = false;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.IllIIIIllI.4
 * JD-Core Version:    0.6.0
 */