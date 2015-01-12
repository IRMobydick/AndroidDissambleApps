package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class jf
  implements SafeParcelable, ji.b<String, Integer>
{
  public static final jg CREATOR = new jg();
  private final int BR;
  private final HashMap<String, Integer> Mt;
  private final HashMap<Integer, String> Mu;
  private final ArrayList<a> Mv;

  public jf()
  {
    this.BR = 1;
    this.Mt = new HashMap();
    this.Mu = new HashMap();
    this.Mv = null;
  }

  jf(int paramInt, ArrayList<a> paramArrayList)
  {
    this.BR = paramInt;
    this.Mt = new HashMap();
    this.Mu = new HashMap();
    this.Mv = null;
    b(paramArrayList);
  }

  private void b(ArrayList<a> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      h(locala.Mw, locala.Mx);
    }
  }

  public String a(Integer paramInteger)
  {
    String str = (String)this.Mu.get(paramInteger);
    if ((str == null) && (this.Mt.containsKey("gms_unknown")))
      str = "gms_unknown";
    return str;
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public jf h(String paramString, int paramInt)
  {
    this.Mt.put(paramString, Integer.valueOf(paramInt));
    this.Mu.put(Integer.valueOf(paramInt), paramString);
    return this;
  }

  ArrayList<a> hc()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Mt.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, ((Integer)this.Mt.get(str)).intValue()));
    }
    return localArrayList;
  }

  public int hd()
  {
    return 7;
  }

  public int he()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jg.a(this, paramParcel, paramInt);
  }

  public static final class a
    implements SafeParcelable
  {
    public static final jh CREATOR = new jh();
    final String Mw;
    final int Mx;
    final int versionCode;

    a(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.Mw = paramString;
      this.Mx = paramInt2;
    }

    a(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.Mw = paramString;
      this.Mx = paramInt;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      jh.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jf
 * JD-Core Version:    0.6.2
 */