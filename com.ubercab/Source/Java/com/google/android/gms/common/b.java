package com.google.android.gms.common;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class b
{
  static final byte[][] HH;
  static final byte[][] HI;
  static final byte[][] HJ;
  static final byte[][] HK;
  static final byte[][] HL;
  static final byte[][] HM;
  static final byte[][] HN;
  static final byte[][] HO;
  static final byte[][] HP;
  static final byte[][] HQ;
  static final byte[][] HR;
  static final byte[][] HS;
  static final byte[][] HT;
  static final byte[][] HU;
  static final byte[][] HV;
  static final byte[][] HW;
  static final byte[][] HX;
  static final byte[][] HY;
  static final byte[][] HZ;
  static final byte[][] Ia;
  static final byte[][] Ib;
  static final byte[][] Ic;
  static final byte[][] Id;
  static final byte[][] Ie = a(arrayOfByte);
  private static Set<byte[]> If;
  private static Set<byte[]> Ig;
  public static final Comparator Ih = new Comparator()
  {
    public int c(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      int i = Math.min(paramAnonymousArrayOfByte1.length, paramAnonymousArrayOfByte2.length);
      for (int j = 0; j < i; j++)
      {
        int k = 0xFF & paramAnonymousArrayOfByte1[j];
        int m = 0xFF & paramAnonymousArrayOfByte2[j];
        if (k != m)
          return k - m;
      }
      return paramAnonymousArrayOfByte1.length - paramAnonymousArrayOfByte2.length;
    }
  };

  static
  {
    byte[][] arrayOfByte1 = new byte[2][];
    arrayOfByte1[0] = aP("");
    arrayOfByte1[1] = aP("");
    HH = arrayOfByte1;
    byte[][] arrayOfByte2 = new byte[2][];
    arrayOfByte2[0] = aP("");
    arrayOfByte2[1] = aP("");
    HI = arrayOfByte2;
    byte[][] arrayOfByte3 = new byte[1][];
    arrayOfByte3[0] = aP("");
    HJ = arrayOfByte3;
    byte[][] arrayOfByte4 = new byte[2][];
    arrayOfByte4[0] = aP("");
    arrayOfByte4[1] = aP("");
    HK = arrayOfByte4;
    byte[][] arrayOfByte5 = new byte[2][];
    arrayOfByte5[0] = aP("");
    arrayOfByte5[1] = aP("");
    HL = arrayOfByte5;
    byte[][] arrayOfByte6 = new byte[2][];
    arrayOfByte6[0] = aP("");
    arrayOfByte6[1] = aP("");
    HM = arrayOfByte6;
    byte[][] arrayOfByte7 = new byte[2][];
    arrayOfByte7[0] = aP("");
    arrayOfByte7[1] = aP("");
    HN = arrayOfByte7;
    byte[][] arrayOfByte8 = new byte[2][];
    arrayOfByte8[0] = aP("");
    arrayOfByte8[1] = aP("");
    HO = arrayOfByte8;
    byte[][] arrayOfByte9 = new byte[2][];
    arrayOfByte9[0] = aP("");
    arrayOfByte9[1] = aP("");
    HP = arrayOfByte9;
    byte[][] arrayOfByte10 = new byte[2][];
    arrayOfByte10[0] = aP("");
    arrayOfByte10[1] = aP("");
    HQ = arrayOfByte10;
    byte[][] arrayOfByte11 = new byte[2][];
    arrayOfByte11[0] = aP("");
    arrayOfByte11[1] = aP("");
    HR = arrayOfByte11;
    byte[][] arrayOfByte12 = new byte[2][];
    arrayOfByte12[0] = aP("");
    arrayOfByte12[1] = aP("");
    HS = arrayOfByte12;
    byte[][] arrayOfByte13 = new byte[2][];
    arrayOfByte13[0] = aP("");
    arrayOfByte13[1] = aP("");
    HT = arrayOfByte13;
    byte[][] arrayOfByte14 = new byte[2][];
    arrayOfByte14[0] = aP("");
    arrayOfByte14[1] = aP("");
    HU = arrayOfByte14;
    byte[][] arrayOfByte15 = new byte[1][];
    arrayOfByte15[0] = aP("");
    HV = arrayOfByte15;
    byte[][] arrayOfByte16 = new byte[2][];
    arrayOfByte16[0] = aP("");
    arrayOfByte16[1] = aP("");
    HW = arrayOfByte16;
    byte[][] arrayOfByte17 = new byte[2][];
    arrayOfByte17[0] = aP("");
    arrayOfByte17[1] = aP("");
    HX = arrayOfByte17;
    byte[][] arrayOfByte18 = new byte[2][];
    arrayOfByte18[0] = aP("");
    arrayOfByte18[1] = aP("");
    HY = arrayOfByte18;
    byte[][] arrayOfByte19 = new byte[2][];
    arrayOfByte19[0] = aP("");
    arrayOfByte19[1] = aP("");
    HZ = arrayOfByte19;
    byte[][] arrayOfByte20 = new byte[2][];
    arrayOfByte20[0] = aP("");
    arrayOfByte20[1] = aP("");
    Ia = arrayOfByte20;
    byte[][] arrayOfByte21 = new byte[2][];
    arrayOfByte21[0] = aP("");
    arrayOfByte21[1] = aP("");
    Ib = arrayOfByte21;
    byte[][] arrayOfByte22 = new byte[2][];
    arrayOfByte22[0] = aP("");
    arrayOfByte22[1] = aP("");
    Ic = arrayOfByte22;
    byte[][] arrayOfByte23 = new byte[21][];
    arrayOfByte23[0] = HH[0];
    arrayOfByte23[1] = HI[0];
    arrayOfByte23[2] = HK[0];
    arrayOfByte23[3] = HL[0];
    arrayOfByte23[4] = HM[0];
    arrayOfByte23[5] = HN[0];
    arrayOfByte23[6] = HO[0];
    arrayOfByte23[7] = HP[0];
    arrayOfByte23[8] = HQ[0];
    arrayOfByte23[9] = HR[0];
    arrayOfByte23[10] = HS[0];
    arrayOfByte23[11] = HT[0];
    arrayOfByte23[12] = HU[0];
    arrayOfByte23[13] = HV[0];
    arrayOfByte23[14] = HW[0];
    arrayOfByte23[15] = HX[0];
    arrayOfByte23[16] = HY[0];
    arrayOfByte23[17] = HZ[0];
    arrayOfByte23[18] = Ia[0];
    arrayOfByte23[19] = Ib[0];
    arrayOfByte23[20] = Ic[0];
    Id = arrayOfByte23;
    byte[][][] arrayOfByte = new byte[22][][];
    arrayOfByte[0] = HH;
    arrayOfByte[1] = HI;
    arrayOfByte[2] = HJ;
    arrayOfByte[3] = HK;
    arrayOfByte[4] = HL;
    arrayOfByte[5] = HM;
    arrayOfByte[6] = HN;
    arrayOfByte[7] = HO;
    arrayOfByte[8] = HP;
    arrayOfByte[9] = HQ;
    arrayOfByte[10] = HR;
    arrayOfByte[11] = HS;
    arrayOfByte[12] = HT;
    arrayOfByte[13] = HU;
    arrayOfByte[14] = HV;
    arrayOfByte[15] = HW;
    arrayOfByte[16] = HX;
    arrayOfByte[17] = HY;
    arrayOfByte[18] = HZ;
    arrayOfByte[19] = Ia;
    arrayOfByte[20] = Ib;
    arrayOfByte[21] = Ic;
  }

  private static Set<byte[]> a(byte[][] paramArrayOfByte)
  {
    TreeSet localTreeSet = new TreeSet(Ih);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
      localTreeSet.add(paramArrayOfByte[j]);
    return localTreeSet;
  }

  static byte[][] a(byte[][][] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += paramArrayOfByte[j].length;
      j++;
    }
    byte[][] arrayOfByte = new byte[k][];
    int m = paramArrayOfByte.length;
    int n = 0;
    int i2;
    for (int i1 = 0; n < m; i1 = i2)
    {
      byte[][] arrayOfByte1 = paramArrayOfByte[n];
      i2 = i1;
      int i3 = 0;
      while (i3 < arrayOfByte1.length)
      {
        int i4 = i2 + 1;
        arrayOfByte[i2] = arrayOfByte1[i3];
        i3++;
        i2 = i4;
      }
      n++;
    }
    return arrayOfByte;
  }

  private static byte[] aP(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }

  static Set<byte[]> fY()
  {
    if (If == null)
      If = a(Ie);
    return If;
  }

  static Set<byte[]> fZ()
  {
    if (Ig == null)
      Ig = a(Id);
    return Ig;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.b
 * JD-Core Version:    0.6.2
 */