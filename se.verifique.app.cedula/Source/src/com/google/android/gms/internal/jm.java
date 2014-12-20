package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class jm
  implements SafeParcelable
{
  public static final mq a = new mq();
  final int b;
  final List c;
  final List d;
  final List e;
  private final String f;
  private final boolean g;
  private final String h;
  private final Set i;
  private final Set j;
  private final Set k;

  jm(int paramInt, List paramList1, String paramString1, boolean paramBoolean, List paramList2, String paramString2, List paramList3)
  {
    this.b = paramInt;
    List localList1;
    List localList2;
    if (paramList1 == null)
    {
      localList1 = Collections.emptyList();
      this.c = localList1;
      if (paramString1 == null)
        paramString1 = "";
      this.f = paramString1;
      this.g = paramBoolean;
      if (paramList2 != null)
        break label132;
      localList2 = Collections.emptyList();
      label52: this.d = localList2;
      if (paramString2 == null)
        paramString2 = "";
      this.h = paramString2;
      if (paramList3 != null)
        break label142;
    }
    label132: label142: for (List localList3 = Collections.emptyList(); ; localList3 = Collections.unmodifiableList(paramList3))
    {
      this.e = localList3;
      this.i = a(this.c);
      this.j = a(this.d);
      this.k = a(this.e);
      return;
      localList1 = Collections.unmodifiableList(paramList1);
      break;
      localList2 = Collections.unmodifiableList(paramList2);
      break label52;
    }
  }

  private static Set a(List paramList)
  {
    if (paramList.isEmpty());
    for (Set localSet = Collections.emptySet(); ; localSet = Collections.unmodifiableSet(new HashSet(paramList)))
      return localSet;
  }

  @Deprecated
  public String a()
  {
    return this.f;
  }

  public boolean b()
  {
    return this.g;
  }

  public String c()
  {
    return this.h;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int m = 1;
    if (this == paramObject);
    while (true)
    {
      return m;
      if (!(paramObject instanceof jm))
      {
        m = 0;
        continue;
      }
      jm localjm = (jm)paramObject;
      if ((this.i.equals(localjm.i)) && (this.g == localjm.g) && (this.h.equals(localjm.h)) && (this.j.equals(localjm.j)) && (this.k.equals(localjm.k)))
        continue;
      m = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.i;
    arrayOfObject[1] = Boolean.valueOf(this.g);
    arrayOfObject[2] = this.j;
    arrayOfObject[3] = this.h;
    arrayOfObject[4] = this.k;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("types", this.i).a("placeIds", this.k).a("requireOpenNow", Boolean.valueOf(this.g)).a("userAccountName", this.h).a("requestedUserDataTypes", this.j).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mq.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jm
 * JD-Core Version:    0.6.0
 */