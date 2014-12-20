package net.photopay.hardware;

import net.photopay.util.Log;

public final class llIIlIlIIl
{
  private String IllIIIIllI;
  private String lIlIIIIlIl;

  public llIIlIlIIl(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
      throw new IllegalArgumentException("Device and model cannot be null");
    this.IllIIIIllI = paramString1;
    this.lIlIIIIlIl = paramString2;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof llIIlIlIIl));
    for (boolean bool = false; ; bool = ((llIIlIlIIl)paramObject).lIlIIIIlIl.equals(this.lIlIIIIlIl))
      return bool;
  }

  public final int hashCode()
  {
    return this.lIlIIIIlIl.hashCode();
  }

  public final void llIIIlllll()
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.IllIIIIllI;
    Log.i(this, "Device: {}", arrayOfObject1);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = this.lIlIIIIlIl;
    Log.i(this, "Model: {}", arrayOfObject2);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */