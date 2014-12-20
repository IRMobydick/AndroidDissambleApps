package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class du
  implements SafeParcelable
{
  public static final fo a = new fo();
  public final int b;
  public final String c;
  public final String d;
  public final List e;
  public final int f;
  public final List g;
  public final long h;
  public final boolean i;
  public final long j;
  public final List k;
  public final long l;
  public final int m;
  public final String n;
  public final long o;
  public final String p;
  public final boolean q;
  public final String r;
  public final String s;

  public du(int paramInt)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null);
  }

  public du(int paramInt, long paramLong)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null);
  }

  du(int paramInt1, String paramString1, String paramString2, List paramList1, int paramInt2, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramString2;
    List localList1;
    List localList2;
    if (paramList1 != null)
    {
      localList1 = Collections.unmodifiableList(paramList1);
      this.e = localList1;
      this.f = paramInt2;
      if (paramList2 == null)
        break label152;
      localList2 = Collections.unmodifiableList(paramList2);
      label55: this.g = localList2;
      this.h = paramLong1;
      this.i = paramBoolean1;
      this.j = paramLong2;
      if (paramList3 == null)
        break label158;
    }
    label152: label158: for (List localList3 = Collections.unmodifiableList(paramList3); ; localList3 = null)
    {
      this.k = localList3;
      this.l = paramLong3;
      this.m = paramInt3;
      this.n = paramString3;
      this.o = paramLong4;
      this.p = paramString4;
      this.q = paramBoolean2;
      this.r = paramString5;
      this.s = paramString6;
      return;
      localList1 = null;
      break;
      localList2 = null;
      break label55;
    }
  }

  public du(String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5);
  }

  public du(String paramString1, String paramString2, List paramList1, List paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fo.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.du
 * JD-Core Version:    0.6.0
 */