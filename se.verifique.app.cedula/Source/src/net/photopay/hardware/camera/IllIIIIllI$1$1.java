package net.photopay.hardware.camera;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import net.photopay.util.Log;

final class IllIIIIllI$1$1
  implements Camera.AutoFocusCallback
{
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(paramBoolean);
    Log.i(this, "focus success: {}", arrayOfObject);
    if (paramBoolean)
      this.llIIlIlIIl.llIIlIlIIl.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.takePicture(null, null, this.llIIlIlIIl.llIIlIlIIl.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$PictureCallback);
    while (true)
    {
      return;
      Log.e(this, "Focusing failed", new Object[0]);
      this.llIIlIlIIl.llIIlIlIIl.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$PictureCallback.onPictureTaken(null, null);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.IllIIIIllI.1.1
 * JD-Core Version:    0.6.0
 */