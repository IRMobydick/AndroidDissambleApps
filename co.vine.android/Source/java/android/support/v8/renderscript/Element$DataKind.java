package android.support.v8.renderscript;

public enum Element$DataKind
{
  int mID;

  static
  {
    PIXEL_L = new DataKind("PIXEL_L", 1, 7);
    PIXEL_A = new DataKind("PIXEL_A", 2, 8);
    PIXEL_LA = new DataKind("PIXEL_LA", 3, 9);
    PIXEL_RGB = new DataKind("PIXEL_RGB", 4, 10);
    PIXEL_RGBA = new DataKind("PIXEL_RGBA", 5, 11);
    PIXEL_DEPTH = new DataKind("PIXEL_DEPTH", 6, 12);
    PIXEL_YUV = new DataKind("PIXEL_YUV", 7, 13);
    DataKind[] arrayOfDataKind = new DataKind[8];
    arrayOfDataKind[0] = USER;
    arrayOfDataKind[1] = PIXEL_L;
    arrayOfDataKind[2] = PIXEL_A;
    arrayOfDataKind[3] = PIXEL_LA;
    arrayOfDataKind[4] = PIXEL_RGB;
    arrayOfDataKind[5] = PIXEL_RGBA;
    arrayOfDataKind[6] = PIXEL_DEPTH;
    arrayOfDataKind[7] = PIXEL_YUV;
    $VALUES = arrayOfDataKind;
  }

  private Element$DataKind(int paramInt)
  {
    this.mID = paramInt;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Element.DataKind
 * JD-Core Version:    0.6.0
 */