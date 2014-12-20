package android.support.v8.renderscript;

public enum Allocation$MipmapControl
{
  int mID;

  static
  {
    MIPMAP_FULL = new MipmapControl("MIPMAP_FULL", 1, 1);
    MIPMAP_ON_SYNC_TO_TEXTURE = new MipmapControl("MIPMAP_ON_SYNC_TO_TEXTURE", 2, 2);
    MipmapControl[] arrayOfMipmapControl = new MipmapControl[3];
    arrayOfMipmapControl[0] = MIPMAP_NONE;
    arrayOfMipmapControl[1] = MIPMAP_FULL;
    arrayOfMipmapControl[2] = MIPMAP_ON_SYNC_TO_TEXTURE;
    $VALUES = arrayOfMipmapControl;
  }

  private Allocation$MipmapControl(int paramInt)
  {
    this.mID = paramInt;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Allocation.MipmapControl
 * JD-Core Version:    0.6.0
 */