package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  final int a;
  final boolean b;
  final boolean c;
  final String d;
  final String e;
  final String f;
  final String g;
  final String h;

  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    while (true)
    {
      return bool;
      if (!(paramObject instanceof ParcelableCollaborator))
      {
        bool = false;
        continue;
      }
      ParcelableCollaborator localParcelableCollaborator = (ParcelableCollaborator)paramObject;
      bool = this.d.equals(localParcelableCollaborator.d);
    }
  }

  public int hashCode()
  {
    return this.d.hashCode();
  }

  public String toString()
  {
    return "Collaborator [isMe=" + this.b + ", isAnonymous=" + this.c + ", sessionId=" + this.d + ", userId=" + this.e + ", displayName=" + this.f + ", color=" + this.g + ", photoUrl=" + this.h + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableCollaborator
 * JD-Core Version:    0.6.0
 */