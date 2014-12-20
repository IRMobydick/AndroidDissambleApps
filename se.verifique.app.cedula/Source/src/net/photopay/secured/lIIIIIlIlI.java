package net.photopay.secured;

import java.io.Serializable;
import java.lang.reflect.Array;

public final class lIIIIIlIlI
  implements Serializable, Cloneable
{
  private int IlIIlIIIII;
  private int IlllIIIllI;
  private double[][] llIIlIlIIl;

  private lIIIIIlIlI(int paramInt1, int paramInt2)
  {
    this.IlIIlIIIII = paramInt1;
    this.IlllIIIllI = paramInt2;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    this.llIIlIlIIl = ((double[][])Array.newInstance(Double.TYPE, arrayOfInt));
  }

  public final Object clone()
  {
    lIIIIIlIlI locallIIIIIlIlI = new lIIIIIlIlI(this.IlIIlIIIII, this.IlllIIIllI);
    double[][] arrayOfDouble = locallIIIIIlIlI.llIIlIlIIl;
    for (int i = 0; i < this.IlIIlIIIII; i++)
      for (int j = 0; j < this.IlllIIIllI; j++)
        arrayOfDouble[i][j] = this.llIIlIlIIl[i][j];
    return locallIIIIIlIlI;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.lIIIIIlIlI
 * JD-Core Version:    0.6.0
 */