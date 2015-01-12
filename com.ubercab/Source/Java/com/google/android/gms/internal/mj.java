package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.n.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class mj
  implements SafeParcelable
{
  public static final mk CREATOR = new mk();
  final int BR;
  final List<mp> afr;
  private final String afs;
  private final boolean aft;
  final List<mt> afu;
  final List<String> afv;
  private final Set<mp> afw;
  private final Set<mt> afx;
  private final Set<String> afy;

  mj(int paramInt, List<mp> paramList, String paramString, boolean paramBoolean, List<mt> paramList1, List<String> paramList2)
  {
    this.BR = paramInt;
    List localList1;
    List localList2;
    if (paramList == null)
    {
      localList1 = Collections.emptyList();
      this.afr = localList1;
      if (paramString == null)
        paramString = "";
      this.afs = paramString;
      this.aft = paramBoolean;
      if (paramList1 != null)
        break label117;
      localList2 = Collections.emptyList();
      label52: this.afu = localList2;
      if (paramList2 != null)
        break label127;
    }
    label117: label127: for (List localList3 = Collections.emptyList(); ; localList3 = Collections.unmodifiableList(paramList2))
    {
      this.afv = localList3;
      this.afw = f(this.afr);
      this.afx = f(this.afu);
      this.afy = f(this.afv);
      return;
      localList1 = Collections.unmodifiableList(paramList);
      break;
      localList2 = Collections.unmodifiableList(paramList1);
      break label52;
    }
  }

  private static <E> Set<E> f(List<E> paramList)
  {
    if (paramList.isEmpty())
      return Collections.emptySet();
    return Collections.unmodifiableSet(new HashSet(paramList));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    mj localmj;
    do
    {
      return true;
      if (!(paramObject instanceof mj))
        return false;
      localmj = (mj)paramObject;
    }
    while ((this.afw.equals(localmj.afw)) && (this.aft == localmj.aft) && (this.afx.equals(localmj.afx)) && (this.afy.equals(localmj.afy)));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.afw;
    arrayOfObject[1] = Boolean.valueOf(this.aft);
    arrayOfObject[2] = this.afx;
    arrayOfObject[3] = this.afy;
    return n.hashCode(arrayOfObject);
  }

  @Deprecated
  public String mi()
  {
    return this.afs;
  }

  public boolean mj()
  {
    return this.aft;
  }

  public String toString()
  {
    return n.h(this).a("types", this.afw).a("placeIds", this.afy).a("requireOpenNow", Boolean.valueOf(this.aft)).a("requestedUserDataTypes", this.afx).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mk.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mj
 * JD-Core Version:    0.6.2
 */