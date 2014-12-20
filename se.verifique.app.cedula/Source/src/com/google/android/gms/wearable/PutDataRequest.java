package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class PutDataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new f();
  private static final Random b = new SecureRandom();
  final int a;
  private final Uri c;
  private final Bundle d;
  private byte[] e;

  PutDataRequest(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.c = paramUri;
    this.d = paramBundle;
    this.d.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    this.e = paramArrayOfByte;
  }

  public Uri a()
  {
    return this.c;
  }

  public String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("PutDataRequest[");
    StringBuilder localStringBuilder2 = new StringBuilder().append("dataSz=");
    Object localObject;
    if (this.e == null)
    {
      localObject = "null";
      localStringBuilder1.append(localObject);
      localStringBuilder1.append(", numAssets=" + this.d.size());
      localStringBuilder1.append(", uri=" + this.c);
      if (paramBoolean)
        break label138;
      localStringBuilder1.append("]");
    }
    for (String str1 = localStringBuilder1.toString(); ; str1 = localStringBuilder1.toString())
    {
      return str1;
      localObject = Integer.valueOf(this.e.length);
      break;
      label138: localStringBuilder1.append("]\n  assets: ");
      Iterator localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder1.append("\n    " + str2 + ": " + this.d.getParcelable(str2));
      }
      localStringBuilder1.append("\n  ]");
    }
  }

  public byte[] b()
  {
    return this.e;
  }

  public Bundle c()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return a(Log.isLoggable("DataMap", 3));
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * JD-Core Version:    0.6.0
 */