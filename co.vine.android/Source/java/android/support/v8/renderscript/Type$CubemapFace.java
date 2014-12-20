package android.support.v8.renderscript;

public enum Type$CubemapFace
{
  int mID;

  static
  {
    NEGATIVE_X = new CubemapFace("NEGATIVE_X", 1, 1);
    POSITIVE_Y = new CubemapFace("POSITIVE_Y", 2, 2);
    NEGATIVE_Y = new CubemapFace("NEGATIVE_Y", 3, 3);
    POSITIVE_Z = new CubemapFace("POSITIVE_Z", 4, 4);
    NEGATIVE_Z = new CubemapFace("NEGATIVE_Z", 5, 5);
    CubemapFace[] arrayOfCubemapFace = new CubemapFace[6];
    arrayOfCubemapFace[0] = POSITIVE_X;
    arrayOfCubemapFace[1] = NEGATIVE_X;
    arrayOfCubemapFace[2] = POSITIVE_Y;
    arrayOfCubemapFace[3] = NEGATIVE_Y;
    arrayOfCubemapFace[4] = POSITIVE_Z;
    arrayOfCubemapFace[5] = NEGATIVE_Z;
    $VALUES = arrayOfCubemapFace;
  }

  private Type$CubemapFace(int paramInt)
  {
    this.mID = paramInt;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Type.CubemapFace
 * JD-Core Version:    0.6.0
 */