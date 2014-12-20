package net.photopay.secured;

public final class llIIlIIlll$llIIlIlIIl
{
  private int lllllIlIll;
  private int mHeight;

  public llIIlIIlll$llIIlIlIIl(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      throw new IllegalArgumentException("Width and mHeight must be larger than zero!");
    this.lllllIlIll = paramInt1;
    this.mHeight = paramInt2;
  }

  public final int getHeight()
  {
    return this.mHeight;
  }

  public final int getWidth()
  {
    return this.lllllIlIll;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.llIIlIIlll.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */