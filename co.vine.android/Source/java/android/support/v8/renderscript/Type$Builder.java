package android.support.v8.renderscript;

public class Type$Builder
{
  boolean mDimFaces;
  boolean mDimMipmaps;
  int mDimX = 1;
  int mDimY;
  int mDimZ;
  Element mElement;
  RenderScript mRS;
  int mYuv;

  public Type$Builder(RenderScript paramRenderScript, Element paramElement)
  {
    paramElement.checkValid();
    this.mRS = paramRenderScript;
    this.mElement = paramElement;
  }

  public Type create()
  {
    if (this.mDimZ > 0)
    {
      if ((this.mDimX < 1) || (this.mDimY < 1))
        throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
      if (this.mDimFaces)
        throw new RSInvalidStateException("Cube maps not supported with 3D types.");
    }
    if ((this.mDimY > 0) && (this.mDimX < 1))
      throw new RSInvalidStateException("X dimension required when Y is present.");
    if ((this.mDimFaces) && (this.mDimY < 1))
      throw new RSInvalidStateException("Cube maps require 2D Types.");
    if ((this.mYuv != 0) && ((this.mDimZ != 0) || (this.mDimFaces) || (this.mDimMipmaps)))
      throw new RSInvalidStateException("YUV only supports basic 2D.");
    if (RenderScript.isNative);
    for (Type localType = TypeThunker.create((RenderScriptThunker)this.mRS, this.mElement, this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv); ; localType = new Type(this.mRS.nTypeCreate(this.mElement.getID(this.mRS), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS))
    {
      localType.mElement = this.mElement;
      localType.mDimX = this.mDimX;
      localType.mDimY = this.mDimY;
      localType.mDimZ = this.mDimZ;
      localType.mDimMipmaps = this.mDimMipmaps;
      localType.mDimFaces = this.mDimFaces;
      localType.mDimYuv = this.mYuv;
      localType.calcElementCount();
      return localType;
    }
  }

  public Builder setFaces(boolean paramBoolean)
  {
    this.mDimFaces = paramBoolean;
    return this;
  }

  public Builder setMipmaps(boolean paramBoolean)
  {
    this.mDimMipmaps = paramBoolean;
    return this;
  }

  public Builder setX(int paramInt)
  {
    if (paramInt < 1)
      throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
    this.mDimX = paramInt;
    return this;
  }

  public Builder setY(int paramInt)
  {
    if (paramInt < 1)
      throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
    this.mDimY = paramInt;
    return this;
  }

  public Builder setYuvFormat(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
    case 17:
    case 842094169:
    }
    this.mYuv = paramInt;
    return this;
  }

  public Builder setZ(int paramInt)
  {
    if (paramInt < 1)
      throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
    this.mDimZ = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Type.Builder
 * JD-Core Version:    0.6.0
 */