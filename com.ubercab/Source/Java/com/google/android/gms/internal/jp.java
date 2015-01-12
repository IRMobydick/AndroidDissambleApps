package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class jp extends ji
  implements SafeParcelable
{
  public static final jq CREATOR = new jq();
  private final int BR;
  private final jm MG;
  private final Parcel MN;
  private final int MO;
  private int MP;
  private int MQ;
  private final String mClassName;

  jp(int paramInt, Parcel paramParcel, jm paramjm)
  {
    this.BR = paramInt;
    this.MN = ((Parcel)o.i(paramParcel));
    this.MO = 2;
    this.MG = paramjm;
    if (this.MG == null);
    for (this.mClassName = null; ; this.mClassName = this.MG.hv())
    {
      this.MP = 2;
      return;
    }
  }

  private jp(SafeParcelable paramSafeParcelable, jm paramjm, String paramString)
  {
    this.BR = 1;
    this.MN = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.MN, 0);
    this.MO = 1;
    this.MG = ((jm)o.i(paramjm));
    this.mClassName = ((String)o.i(paramString));
    this.MP = 2;
  }

  public static <T extends ji,  extends SafeParcelable> jp a(T paramT)
  {
    String str = paramT.getClass().getCanonicalName();
    jm localjm = b(paramT);
    return new jp((SafeParcelable)paramT, localjm, str);
  }

  private static void a(jm paramjm, ji paramji)
  {
    Class localClass1 = paramji.getClass();
    if (!paramjm.b(localClass1))
    {
      HashMap localHashMap = paramji.hf();
      paramjm.a(localClass1, paramji.hf());
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localHashMap.get((String)localIterator.next());
        Class localClass2 = locala.hn();
        if (localClass2 != null)
          try
          {
            a(paramjm, (ji)localClass2.newInstance());
          }
          catch (InstantiationException localInstantiationException)
          {
            throw new IllegalStateException("Could not instantiate an object of type " + locala.hn().getCanonicalName(), localInstantiationException);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new IllegalStateException("Could not access object of type " + locala.hn().getCanonicalName(), localIllegalAccessException);
          }
      }
    }
  }

  private void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown type = " + paramInt);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
      paramStringBuilder.append(paramObject);
      return;
    case 7:
      paramStringBuilder.append("\"").append(jz.bf(paramObject.toString())).append("\"");
      return;
    case 8:
      paramStringBuilder.append("\"").append(js.d((byte[])paramObject)).append("\"");
      return;
    case 9:
      paramStringBuilder.append("\"").append(js.e((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10:
      ka.a(paramStringBuilder, (HashMap)paramObject);
      return;
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private void a(StringBuilder paramStringBuilder, ji.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.he())
    {
    default:
      throw new IllegalArgumentException("Unknown field out type = " + parama.he());
    case 0:
      b(paramStringBuilder, parama, a(parama, Integer.valueOf(a.g(paramParcel, paramInt))));
      return;
    case 1:
      b(paramStringBuilder, parama, a(parama, a.k(paramParcel, paramInt)));
      return;
    case 2:
      b(paramStringBuilder, parama, a(parama, Long.valueOf(a.i(paramParcel, paramInt))));
      return;
    case 3:
      b(paramStringBuilder, parama, a(parama, Float.valueOf(a.l(paramParcel, paramInt))));
      return;
    case 4:
      b(paramStringBuilder, parama, a(parama, Double.valueOf(a.m(paramParcel, paramInt))));
      return;
    case 5:
      b(paramStringBuilder, parama, a(parama, a.n(paramParcel, paramInt)));
      return;
    case 6:
      b(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
      return;
    case 7:
      b(paramStringBuilder, parama, a(parama, a.o(paramParcel, paramInt)));
      return;
    case 8:
    case 9:
      b(paramStringBuilder, parama, a(parama, a.r(paramParcel, paramInt)));
      return;
    case 10:
      b(paramStringBuilder, parama, a(parama, e(a.q(paramParcel, paramInt))));
      return;
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private void a(StringBuilder paramStringBuilder, String paramString, ji.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (parama.hp())
    {
      a(paramStringBuilder, parama, paramParcel, paramInt);
      return;
    }
    b(paramStringBuilder, parama, paramParcel, paramInt);
  }

  private void a(StringBuilder paramStringBuilder, HashMap<String, ji.a<?, ?>> paramHashMap, Parcel paramParcel)
  {
    HashMap localHashMap = b(paramHashMap);
    paramStringBuilder.append('{');
    int i = a.C(paramParcel);
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      Map.Entry localEntry = (Map.Entry)localHashMap.get(Integer.valueOf(a.aD(k)));
      if (localEntry != null)
      {
        if (j != 0)
          paramStringBuilder.append(",");
        a(paramStringBuilder, (String)localEntry.getKey(), (ji.a)localEntry.getValue(), paramParcel, k);
        j = 1;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    paramStringBuilder.append('}');
  }

  private static jm b(ji paramji)
  {
    jm localjm = new jm(paramji.getClass());
    a(localjm, paramji);
    localjm.ht();
    localjm.hs();
    return localjm;
  }

  private static HashMap<Integer, Map.Entry<String, ji.a<?, ?>>> b(HashMap<String, ji.a<?, ?>> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(Integer.valueOf(((ji.a)localEntry.getValue()).hm()), localEntry);
    }
    return localHashMap;
  }

  private void b(StringBuilder paramStringBuilder, ji.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    if (parama.hk())
    {
      paramStringBuilder.append("[");
      switch (parama.he())
      {
      default:
        throw new IllegalStateException("Unknown field type out.");
      case 0:
        jr.a(paramStringBuilder, a.u(paramParcel, paramInt));
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      }
      while (true)
      {
        paramStringBuilder.append("]");
        return;
        jr.a(paramStringBuilder, a.w(paramParcel, paramInt));
        continue;
        jr.a(paramStringBuilder, a.v(paramParcel, paramInt));
        continue;
        jr.a(paramStringBuilder, a.x(paramParcel, paramInt));
        continue;
        jr.a(paramStringBuilder, a.y(paramParcel, paramInt));
        continue;
        jr.a(paramStringBuilder, a.z(paramParcel, paramInt));
        continue;
        jr.a(paramStringBuilder, a.t(paramParcel, paramInt));
        continue;
        jr.a(paramStringBuilder, a.A(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        Parcel[] arrayOfParcel = a.E(paramParcel, paramInt);
        int j = arrayOfParcel.length;
        for (int k = 0; k < j; k++)
        {
          if (k > 0)
            paramStringBuilder.append(",");
          arrayOfParcel[k].setDataPosition(0);
          a(paramStringBuilder, parama.hr(), arrayOfParcel[k]);
        }
      }
    }
    switch (parama.he())
    {
    default:
      throw new IllegalStateException("Unknown field type out");
    case 0:
      paramStringBuilder.append(a.g(paramParcel, paramInt));
      return;
    case 1:
      paramStringBuilder.append(a.k(paramParcel, paramInt));
      return;
    case 2:
      paramStringBuilder.append(a.i(paramParcel, paramInt));
      return;
    case 3:
      paramStringBuilder.append(a.l(paramParcel, paramInt));
      return;
    case 4:
      paramStringBuilder.append(a.m(paramParcel, paramInt));
      return;
    case 5:
      paramStringBuilder.append(a.n(paramParcel, paramInt));
      return;
    case 6:
      paramStringBuilder.append(a.c(paramParcel, paramInt));
      return;
    case 7:
      String str2 = a.o(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(jz.bf(str2)).append("\"");
      return;
    case 8:
      byte[] arrayOfByte2 = a.r(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(js.d(arrayOfByte2)).append("\"");
      return;
    case 9:
      byte[] arrayOfByte1 = a.r(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(js.e(arrayOfByte1));
      paramStringBuilder.append("\"");
      return;
    case 10:
      Bundle localBundle = a.q(paramParcel, paramInt);
      Set localSet = localBundle.keySet();
      localSet.size();
      paramStringBuilder.append("{");
      Iterator localIterator = localSet.iterator();
      for (int i = 1; localIterator.hasNext(); i = 0)
      {
        String str1 = (String)localIterator.next();
        if (i == 0)
          paramStringBuilder.append(",");
        paramStringBuilder.append("\"").append(str1).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(jz.bf(localBundle.getString(str1))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    case 11:
    }
    Parcel localParcel = a.D(paramParcel, paramInt);
    localParcel.setDataPosition(0);
    a(paramStringBuilder, parama.hr(), localParcel);
  }

  private void b(StringBuilder paramStringBuilder, ji.a<?, ?> parama, Object paramObject)
  {
    if (parama.hj())
    {
      b(paramStringBuilder, parama, (ArrayList)paramObject);
      return;
    }
    a(paramStringBuilder, parama.hd(), paramObject);
  }

  private void b(StringBuilder paramStringBuilder, ji.a<?, ?> parama, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      a(paramStringBuilder, parama.hd(), paramArrayList.get(j));
    }
    paramStringBuilder.append("]");
  }

  public static HashMap<String, String> e(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }

  protected Object ba(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  protected boolean bb(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public int describeContents()
  {
    return 0;
  }

  public int getVersionCode()
  {
    return this.BR;
  }

  public HashMap<String, ji.a<?, ?>> hf()
  {
    if (this.MG == null)
      return null;
    return this.MG.be(this.mClassName);
  }

  public Parcel hx()
  {
    switch (this.MP)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return this.MN;
      this.MQ = b.D(this.MN);
      b.H(this.MN, this.MQ);
      this.MP = 2;
      continue;
      b.H(this.MN, this.MQ);
      this.MP = 2;
    }
  }

  jm hy()
  {
    switch (this.MO)
    {
    default:
      throw new IllegalStateException("Invalid creation type: " + this.MO);
    case 0:
      return null;
    case 1:
      return this.MG;
    case 2:
    }
    return this.MG;
  }

  public String toString()
  {
    o.b(this.MG, "Cannot convert to JSON on client side.");
    Parcel localParcel = hx();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.MG.be(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jq.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jp
 * JD-Core Version:    0.6.2
 */