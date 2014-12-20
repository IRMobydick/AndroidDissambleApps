package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new j();
  final int a;
  final Bundle b;

  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = ((Bundle)kx.a(paramBundle));
    this.b.setClassLoader(getClass().getClassLoader());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.b.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      if (g.a(str2) != null)
        continue;
      localArrayList.add(str2);
      Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str2);
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      this.b.remove(str1);
    }
  }

  public Set a()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
      localHashSet.add(g.a((String)localIterator.next()));
    return localHashSet;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i;
    if (this == paramObject)
      i = 1;
    while (true)
    {
      return i;
      if (!(paramObject instanceof MetadataBundle))
      {
        i = 0;
        continue;
      }
      MetadataBundle localMetadataBundle = (MetadataBundle)paramObject;
      Set localSet = this.b.keySet();
      if (!localSet.equals(localMetadataBundle.b.keySet()))
      {
        i = 0;
        continue;
      }
      Iterator localIterator = localSet.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (kt.a(this.b.get(str), localMetadataBundle.b.get(str)))
            continue;
          i = 0;
          break;
        }
      i = 1;
    }
  }

  public int hashCode()
  {
    Iterator localIterator = this.b.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = i * 31 + this.b.get(str).hashCode())
      str = (String)localIterator.next();
    return i;
  }

  public String toString()
  {
    return "MetadataBundle [values=" + this.b + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.MetadataBundle
 * JD-Core Version:    0.6.0
 */