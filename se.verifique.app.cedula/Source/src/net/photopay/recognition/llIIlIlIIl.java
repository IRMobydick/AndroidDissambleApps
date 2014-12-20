package net.photopay.recognition;

import net.photopay.hardware.camera.CameraDataFormat;

public final class llIIlIlIIl
{
  private boolean IIlIlIIlll;
  private boolean IIllllllll;
  private int IlIIIIIlll;
  private int IlIlIlIIlI;
  private byte[] IllIIIIllI;
  private CameraDataFormat lIlIIIIlIl;

  public llIIlIlIIl(byte[] paramArrayOfByte, CameraDataFormat paramCameraDataFormat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.IllIIIIllI = paramArrayOfByte;
    this.IlIlIlIIlI = paramInt1;
    this.IlIIIIIlll = paramInt2;
    this.lIlIIIIlIl = paramCameraDataFormat;
    this.IIlIlIIlll = paramBoolean1;
    this.IIllllllll = paramBoolean2;
  }

  public final boolean IlIlllllII()
  {
    return this.IIlIlIIlll;
  }

  public final int getHeight()
  {
    return this.IlIIIIIlll;
  }

  public final int getWidth()
  {
    return this.IlIlIlIIlI;
  }

  public final boolean llIIlIIIll()
  {
    return this.IIllllllll;
  }

  public final CameraDataFormat llIIlIlIIl()
  {
    return this.lIlIIIIlIl;
  }

  public final byte[] llIIlIlIIl()
  {
    return this.IllIIIIllI;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */