package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class nw extends jj
  implements Moment
{
  public static final nx CREATOR = new nx();
  private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
  String BL;
  final int BR;
  String amP;
  nu amX;
  nu amY;
  final Set<Integer> amc;
  String uO;

  static
  {
    amb.put("id", ji.a.l("id", 2));
    amb.put("result", ji.a.a("result", 4, nu.class));
    amb.put("startDate", ji.a.l("startDate", 5));
    amb.put("target", ji.a.a("target", 6, nu.class));
    amb.put("type", ji.a.l("type", 7));
  }

  public nw()
  {
    this.BR = 1;
    this.amc = new HashSet();
  }

  nw(Set<Integer> paramSet, int paramInt, String paramString1, nu paramnu1, String paramString2, nu paramnu2, String paramString3)
  {
    this.amc = paramSet;
    this.BR = paramInt;
    this.BL = paramString1;
    this.amX = paramnu1;
    this.amP = paramString2;
    this.amY = paramnu2;
    this.uO = paramString3;
  }

  public nw(Set<Integer> paramSet, String paramString1, nu paramnu1, String paramString2, nu paramnu2, String paramString3)
  {
    this.amc = paramSet;
    this.BR = 1;
    this.BL = paramString1;
    this.amX = paramnu1;
    this.amP = paramString2;
    this.amY = paramnu2;
    this.uO = paramString3;
  }

  protected boolean a(ji.a parama)
  {
    return this.amc.contains(Integer.valueOf(parama.hm()));
  }

  protected Object b(ji.a parama)
  {
    switch (parama.hm())
    {
    case 3:
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
    case 2:
      return this.BL;
    case 4:
      return this.amX;
    case 5:
      return this.amP;
    case 6:
      return this.amY;
    case 7:
    }
    return this.uO;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nw))
      return false;
    if (this == paramObject)
      return true;
    nw localnw = (nw)paramObject;
    Iterator localIterator = amb.values().iterator();
    while (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (a(locala))
      {
        if (localnw.a(locala))
        {
          if (!b(locala).equals(localnw.b(locala)))
            return false;
        }
        else
          return false;
      }
      else if (localnw.a(locala))
        return false;
    }
    return true;
  }

  public String getId()
  {
    return this.BL;
  }

  public ItemScope getResult()
  {
    return this.amX;
  }

  public String getStartDate()
  {
    return this.amP;
  }

  public ItemScope getTarget()
  {
    return this.amY;
  }

  public String getType()
  {
    return this.uO;
  }

  public boolean hasId()
  {
    return this.amc.contains(Integer.valueOf(2));
  }

  public boolean hasResult()
  {
    return this.amc.contains(Integer.valueOf(4));
  }

  public boolean hasStartDate()
  {
    return this.amc.contains(Integer.valueOf(5));
  }

  public boolean hasTarget()
  {
    return this.amc.contains(Integer.valueOf(6));
  }

  public boolean hasType()
  {
    return this.amc.contains(Integer.valueOf(7));
  }

  public int hashCode()
  {
    Iterator localIterator = amb.values().iterator();
    int i = 0;
    ji.a locala;
    if (localIterator.hasNext())
    {
      locala = (ji.a)localIterator.next();
      if (!a(locala))
        break label66;
    }
    label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public HashMap<String, ji.a<?, ?>> hf()
  {
    return amb;
  }

  public boolean isDataValid()
  {
    return true;
  }

  public nw ns()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nx.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nw
 * JD-Core Version:    0.6.2
 */