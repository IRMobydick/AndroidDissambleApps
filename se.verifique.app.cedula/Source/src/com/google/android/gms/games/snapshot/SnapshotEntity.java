package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class SnapshotEntity
  implements SafeParcelable, Snapshot
{
  public static final a a;
  private static final Object b = new Object();
  private final int c;
  private final SnapshotMetadataEntity d;
  private Contents e;

  static
  {
    a = new a();
  }

  SnapshotEntity(int paramInt, SnapshotMetadata paramSnapshotMetadata, Contents paramContents)
  {
    this.c = paramInt;
    this.d = new SnapshotMetadataEntity(paramSnapshotMetadata);
    this.e = paramContents;
  }

  static int a(Snapshot paramSnapshot)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramSnapshot.b();
    arrayOfObject[1] = paramSnapshot.c();
    return kt.a(arrayOfObject);
  }

  static boolean a(Snapshot paramSnapshot, Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof Snapshot))
      i = 0;
    while (true)
    {
      return i;
      if (paramSnapshot == paramObject)
        continue;
      Snapshot localSnapshot = (Snapshot)paramObject;
      if ((kt.a(localSnapshot.b(), paramSnapshot.b())) && (kt.a(localSnapshot.c(), paramSnapshot.c())))
        continue;
      i = 0;
    }
  }

  static String b(Snapshot paramSnapshot)
  {
    kv localkv = kt.a(paramSnapshot).a("Metadata", paramSnapshot.b());
    if (paramSnapshot.c() != null);
    for (boolean bool = true; ; bool = false)
      return localkv.a("HasContents", Boolean.valueOf(bool)).toString();
  }

  public SnapshotMetadata b()
  {
    return this.d;
  }

  public Contents c()
  {
    return this.e;
  }

  public int d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public Snapshot e()
  {
    return this;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public int hashCode()
  {
    return a(this);
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotEntity
 * JD-Core Version:    0.6.0
 */