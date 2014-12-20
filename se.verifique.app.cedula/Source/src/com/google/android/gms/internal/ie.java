package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ie extends hy
  implements SafeParcelable
{
  public static final lm a = new lm();
  private final int b;
  private final Parcel c;
  private final int d;
  private final ib e;
  private final String f;
  private int g;
  private int h;

  ie(int paramInt, Parcel paramParcel, ib paramib)
  {
    this.b = paramInt;
    this.c = ((Parcel)kx.a(paramParcel));
    this.d = 2;
    this.e = paramib;
    if (this.e == null);
    for (this.f = null; ; this.f = this.e.d())
    {
      this.g = 2;
      return;
    }
  }

  public static HashMap a(Bundle paramBundle)
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

  private static HashMap a(HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(Integer.valueOf(((hy.a)localEntry.getValue()).g()), localEntry);
    }
    return localHashMap;
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
    case 7:
    case 8:
    case 9:
    case 10:
      while (true)
      {
        return;
        paramStringBuilder.append("\"").append(lr.a(paramObject.toString())).append("\"");
        continue;
        paramStringBuilder.append("\"").append(lo.a((byte[])(byte[])paramObject)).append("\"");
        continue;
        paramStringBuilder.append("\"").append(lo.b((byte[])(byte[])paramObject));
        paramStringBuilder.append("\"");
        continue;
        ls.a(paramStringBuilder, (HashMap)paramObject);
      }
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private void a(StringBuilder paramStringBuilder, hy.a parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.d())
    {
    default:
      throw new IllegalArgumentException("Unknown field out type = " + parama.d());
    case 0:
      a(paramStringBuilder, parama, a(parama, Integer.valueOf(a.g(paramParcel, paramInt))));
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
      while (true)
      {
        return;
        a(paramStringBuilder, parama, a(parama, a.k(paramParcel, paramInt)));
        continue;
        a(paramStringBuilder, parama, a(parama, Long.valueOf(a.i(paramParcel, paramInt))));
        continue;
        a(paramStringBuilder, parama, a(parama, Float.valueOf(a.l(paramParcel, paramInt))));
        continue;
        a(paramStringBuilder, parama, a(parama, Double.valueOf(a.m(paramParcel, paramInt))));
        continue;
        a(paramStringBuilder, parama, a(parama, a.n(paramParcel, paramInt)));
        continue;
        a(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
        continue;
        a(paramStringBuilder, parama, a(parama, a.o(paramParcel, paramInt)));
        continue;
        a(paramStringBuilder, parama, a(parama, a.r(paramParcel, paramInt)));
        continue;
        a(paramStringBuilder, parama, a(parama, a(a.q(paramParcel, paramInt))));
      }
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private void a(StringBuilder paramStringBuilder, hy.a parama, Object paramObject)
  {
    if (parama.c())
      a(paramStringBuilder, parama, (ArrayList)paramObject);
    while (true)
    {
      return;
      a(paramStringBuilder, parama.b(), paramObject);
    }
  }

  private void a(StringBuilder paramStringBuilder, hy.a parama, ArrayList paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      a(paramStringBuilder, parama.b(), paramArrayList.get(j));
    }
    paramStringBuilder.append("]");
  }

  private void a(StringBuilder paramStringBuilder, String paramString, hy.a parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (parama.j())
      a(paramStringBuilder, parama, paramParcel, paramInt);
    while (true)
    {
      return;
      b(paramStringBuilder, parama, paramParcel, paramInt);
    }
  }

  private void a(StringBuilder paramStringBuilder, HashMap paramHashMap, Parcel paramParcel)
  {
    HashMap localHashMap = a(paramHashMap);
    paramStringBuilder.append('{');
    int i = a.b(paramParcel);
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      Map.Entry localEntry = (Map.Entry)localHashMap.get(Integer.valueOf(a.a(k)));
      if (localEntry == null)
        continue;
      if (j != 0)
        paramStringBuilder.append(",");
      a(paramStringBuilder, (String)localEntry.getKey(), (hy.a)localEntry.getValue(), paramParcel, k);
      j = 1;
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    paramStringBuilder.append('}');
  }

  private void b(StringBuilder paramStringBuilder, hy.a parama, Parcel paramParcel, int paramInt)
  {
    if (parama.e())
    {
      paramStringBuilder.append("[");
      switch (parama.d())
      {
      default:
        throw new IllegalStateException("Unknown field type out.");
      case 0:
        ln.a(paramStringBuilder, a.u(paramParcel, paramInt));
        paramStringBuilder.append("]");
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
    }
    while (true)
    {
      return;
      ln.a(paramStringBuilder, a.w(paramParcel, paramInt));
      break;
      ln.a(paramStringBuilder, a.v(paramParcel, paramInt));
      break;
      ln.a(paramStringBuilder, a.x(paramParcel, paramInt));
      break;
      ln.a(paramStringBuilder, a.y(paramParcel, paramInt));
      break;
      ln.a(paramStringBuilder, a.z(paramParcel, paramInt));
      break;
      ln.a(paramStringBuilder, a.t(paramParcel, paramInt));
      break;
      ln.a(paramStringBuilder, a.A(paramParcel, paramInt));
      break;
      throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
      Parcel[] arrayOfParcel = a.D(paramParcel, paramInt);
      int j = arrayOfParcel.length;
      for (int k = 0; k < j; k++)
      {
        if (k > 0)
          paramStringBuilder.append(",");
        arrayOfParcel[k].setDataPosition(0);
        a(paramStringBuilder, parama.l(), arrayOfParcel[k]);
      }
      break;
      switch (parama.d())
      {
      default:
        throw new IllegalStateException("Unknown field type out");
      case 0:
        paramStringBuilder.append(a.g(paramParcel, paramInt));
        break;
      case 1:
        paramStringBuilder.append(a.k(paramParcel, paramInt));
        break;
      case 2:
        paramStringBuilder.append(a.i(paramParcel, paramInt));
        break;
      case 3:
        paramStringBuilder.append(a.l(paramParcel, paramInt));
        break;
      case 4:
        paramStringBuilder.append(a.m(paramParcel, paramInt));
        break;
      case 5:
        paramStringBuilder.append(a.n(paramParcel, paramInt));
        break;
      case 6:
        paramStringBuilder.append(a.c(paramParcel, paramInt));
        break;
      case 7:
        String str2 = a.o(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(lr.a(str2)).append("\"");
        break;
      case 8:
        byte[] arrayOfByte2 = a.r(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(lo.a(arrayOfByte2)).append("\"");
        break;
      case 9:
        byte[] arrayOfByte1 = a.r(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(lo.b(arrayOfByte1));
        paramStringBuilder.append("\"");
        break;
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
          paramStringBuilder.append("\"").append(lr.a(localBundle.getString(str1))).append("\"");
        }
        paramStringBuilder.append("}");
        break;
      case 11:
        Parcel localParcel = a.C(paramParcel, paramInt);
        localParcel.setDataPosition(0);
        a(paramStringBuilder, parama.l(), localParcel);
      }
    }
  }

  public int a()
  {
    return this.b;
  }

  protected Object a(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public HashMap b()
  {
    if (this.e == null);
    for (HashMap localHashMap = null; ; localHashMap = this.e.a(this.f))
      return localHashMap;
  }

  protected boolean b(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public int describeContents()
  {
    return 0;
  }

  public Parcel e()
  {
    switch (this.g)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return this.c;
      this.h = c.a(this.c);
      c.a(this.c, this.h);
      this.g = 2;
      continue;
      c.a(this.c, this.h);
      this.g = 2;
    }
  }

  ib f()
  {
    ib localib;
    switch (this.d)
    {
    default:
      throw new IllegalStateException("Invalid creation type: " + this.d);
    case 0:
      localib = null;
    case 1:
    case 2:
    }
    while (true)
    {
      return localib;
      localib = this.e;
      continue;
      localib = this.e;
    }
  }

  public String toString()
  {
    kx.a(this.e, "Cannot convert to JSON on client side.");
    Parcel localParcel = e();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.e.a(this.f), localParcel);
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lm.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ie
 * JD-Core Version:    0.6.0
 */