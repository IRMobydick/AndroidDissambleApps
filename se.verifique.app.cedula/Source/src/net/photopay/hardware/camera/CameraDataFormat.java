package net.photopay.hardware.camera;

public enum CameraDataFormat
{
  private final int lllIIIlIlI;

  static
  {
    IllIIIIllI = new CameraDataFormat("UNKNOWN", 3, 3);
    CameraDataFormat[] arrayOfCameraDataFormat = new CameraDataFormat[4];
    arrayOfCameraDataFormat[0] = IlIllIlIIl;
    arrayOfCameraDataFormat[1] = IllIIIllII;
    arrayOfCameraDataFormat[2] = llIIIlllll;
    arrayOfCameraDataFormat[3] = IllIIIIllI;
    llIIlIlIIl = arrayOfCameraDataFormat;
  }

  private CameraDataFormat(int arg3)
  {
    int j;
    this.lllIIIlIlI = j;
  }

  public final int llIIIlllll()
  {
    return this.lllIIIlIlI;
  }

  public final String toString()
  {
    String str;
    if (this.lllIIIlIlI == 0)
      str = "VideoFrame";
    while (true)
    {
      return str;
      if (this.lllIIIlIlI == 1)
      {
        str = "PhotoFrame";
        continue;
      }
      if (this.lllIIIlIlI == 2)
      {
        str = "Filename";
        continue;
      }
      str = "Unknown";
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.CameraDataFormat
 * JD-Core Version:    0.6.0
 */