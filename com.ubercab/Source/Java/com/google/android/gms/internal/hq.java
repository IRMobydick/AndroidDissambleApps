package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hq
  implements SafeParcelable
{
  public static final hr CREATOR = new hr();
  final int BR;
  public final String Co;
  public final boolean Cp;
  public final boolean Cq;
  public final String Cr;
  public final hk[] Cs;
  final int[] Ct;
  public final String Cu;
  public final String name;
  public final int weight;

  hq(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, hk[] paramArrayOfhk, int[] paramArrayOfInt, String paramString4)
  {
    this.BR = paramInt1;
    this.name = paramString1;
    this.Co = paramString2;
    this.Cp = paramBoolean1;
    this.weight = paramInt2;
    this.Cq = paramBoolean2;
    this.Cr = paramString3;
    this.Cs = paramArrayOfhk;
    this.Ct = paramArrayOfInt;
    this.Cu = paramString4;
  }

  hq(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, hk[] paramArrayOfhk, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfhk, paramArrayOfInt, paramString4);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof hq;
    boolean bool2 = false;
    if (bool1)
    {
      hq localhq = (hq)paramObject;
      boolean bool3 = this.name.equals(localhq.name);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.Co.equals(localhq.Co);
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = this.Cp;
          boolean bool6 = localhq.Cp;
          bool2 = false;
          if (bool5 == bool6)
            bool2 = true;
        }
      }
    }
    return bool2;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hr.a(this, paramParcel, paramInt);
  }

  public static final class a
  {
    private final List<hk> CA;
    private BitSet CB;
    private String CC;
    private String Cv;
    private boolean Cw;
    private int Cx;
    private boolean Cy;
    private String Cz;
    private final String mName;

    public a(String paramString)
    {
      this.mName = paramString;
      this.Cx = 1;
      this.CA = new ArrayList();
    }

    public a E(boolean paramBoolean)
    {
      this.Cw = paramBoolean;
      return this;
    }

    public a F(boolean paramBoolean)
    {
      this.Cy = paramBoolean;
      return this;
    }

    public a P(int paramInt)
    {
      if (this.CB == null)
        this.CB = new BitSet();
      this.CB.set(paramInt);
      return this;
    }

    public a at(String paramString)
    {
      this.Cv = paramString;
      return this;
    }

    public a au(String paramString)
    {
      this.CC = paramString;
      return this;
    }

    public hq fm()
    {
      int i = 0;
      BitSet localBitSet = this.CB;
      int[] arrayOfInt = null;
      if (localBitSet != null)
      {
        arrayOfInt = new int[this.CB.cardinality()];
        int j = this.CB.nextSetBit(0);
        while (j >= 0)
        {
          int k = i + 1;
          arrayOfInt[i] = j;
          j = this.CB.nextSetBit(j + 1);
          i = k;
        }
      }
      return new hq(this.mName, this.Cv, this.Cw, this.Cx, this.Cy, this.Cz, (hk[])this.CA.toArray(new hk[this.CA.size()]), arrayOfInt, this.CC);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hq
 * JD-Core Version:    0.6.2
 */