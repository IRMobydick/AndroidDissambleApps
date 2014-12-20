package net.photopay.secured;

public final class IlIllIlIIl
  implements llIIIlllll
{
  private float IIlIIIllIl;
  private float IlIllIlllI = 0.5F;
  private float IllIIIIllI;
  private float IllIIlIIII = 1.0F;
  private float lIIIIIllll;
  private float lIlIIIIlIl;
  private float llIIlIIlll;
  private float lllIIIlIlI;
  private float lllIlIlIIl = 0.08333334F;

  public final float getX()
  {
    return this.IllIIIIllI;
  }

  public final float getY()
  {
    return this.lIlIIIIlIl;
  }

  public final float getZ()
  {
    return this.llIIlIIlll;
  }

  public final void llIIlIlIIl(float paramFloat)
  {
    this.lllIlIlIIl = paramFloat;
    float f = this.lllIlIlIIl;
    this.IlIllIlllI = (f / (f + this.lllIlIlIIl * this.IllIIlIIII));
  }

  public final void llIIlIlIIl(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.IIlIIIllIl = (paramFloat1 * this.IlIllIlllI + this.IIlIIIllIl * (1.0F - this.IlIllIlllI));
    this.lIIIIIllll = (paramFloat2 * this.IlIllIlllI + this.lIIIIIllll * (1.0F - this.IlIllIlllI));
    this.lllIIIlIlI = (paramFloat3 * this.IlIllIlllI + this.lllIIIlIlI * (1.0F - this.IlIllIlllI));
    this.IllIIIIllI = (paramFloat1 - this.IIlIIIllIl);
    this.lIlIIIIlIl = (paramFloat2 - this.lIIIIIllll);
    this.llIIlIIlll = (paramFloat3 - this.lllIIIlIlI);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.IlIllIlIIl
 * JD-Core Version:    0.6.0
 */