package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m
  implements SafeParcelable, a
{
  public static final Parcelable.Creator CREATOR = new q();
  final int a;
  private final Uri b;
  private final Map c;
  private byte[] d;

  m(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramUri;
    HashMap localHashMap = new HashMap();
    paramBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (DataItemAssetParcelable)paramBundle.getParcelable(str));
    }
    this.c = localHashMap;
    this.d = paramArrayOfByte;
  }

  public String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("DataItemParcelable[");
    localStringBuilder1.append("@");
    localStringBuilder1.append(Integer.toHexString(hashCode()));
    StringBuilder localStringBuilder2 = new StringBuilder().append(",dataSz=");
    Object localObject;
    if (this.d == null)
    {
      localObject = "null";
      localStringBuilder1.append(localObject);
      localStringBuilder1.append(", numAssets=" + this.c.size());
      localStringBuilder1.append(", uri=" + this.b);
      if (paramBoolean)
        break label161;
      localStringBuilder1.append("]");
    }
    for (String str1 = localStringBuilder1.toString(); ; str1 = localStringBuilder1.toString())
    {
      return str1;
      localObject = Integer.valueOf(this.d.length);
      break;
      label161: localStringBuilder1.append("]\n  assets: ");
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder1.append("\n    " + str2 + ": " + this.c.get(str2));
      }
      localStringBuilder1.append("\n  ]");
    }
  }

  public m b()
  {
    return this;
  }

  public Uri c()
  {
    return this.b;
  }

  public byte[] d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public Bundle e()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), new DataItemAssetParcelable((b)localEntry.getValue()));
    }
    return localBundle;
  }

  public String toString()
  {
    return a(Log.isLoggable("DataItem", 3));
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.m
 * JD-Core Version:    0.6.0
 */