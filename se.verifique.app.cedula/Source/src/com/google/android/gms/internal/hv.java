package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class hv
  implements SafeParcelable, ld
{
  public static final lb a = new lb();
  private final int b;
  private final HashMap c;
  private final HashMap d;
  private final ArrayList e;

  public hv()
  {
    this.b = 1;
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = null;
  }

  hv(int paramInt, ArrayList paramArrayList)
  {
    this.b = paramInt;
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = null;
    a(paramArrayList);
  }

  private void a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      hv.a locala = (hv.a)localIterator.next();
      a(locala.c, locala.d);
    }
  }

  int a()
  {
    return this.b;
  }

  public hv a(String paramString, int paramInt)
  {
    this.c.put(paramString, Integer.valueOf(paramInt));
    this.d.put(Integer.valueOf(paramInt), paramString);
    return this;
  }

  public String a(Integer paramInteger)
  {
    String str = (String)this.d.get(paramInteger);
    if ((str == null) && (this.c.containsKey("gms_unknown")))
      str = "gms_unknown";
    return str;
  }

  ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new hv.a(str, ((Integer)this.c.get(str)).intValue()));
    }
    return localArrayList;
  }

  public int c()
  {
    return 7;
  }

  public int d()
  {
    return 0;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lb.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hv
 * JD-Core Version:    0.6.0
 */