package net.photopay.hardware.camera;

import android.hardware.Camera.Size;

public abstract interface llIIIlllll
{
  public abstract void onCameraImage(byte[] paramArrayOfByte, CameraDataFormat paramCameraDataFormat, Camera.Size paramSize, boolean paramBoolean);

  public abstract void onTakePictureFail();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.llIIIlllll
 * JD-Core Version:    0.6.0
 */