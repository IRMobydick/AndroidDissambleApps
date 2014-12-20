package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.drive.Contents;

public abstract interface Snapshot extends Parcelable, d
{
  public abstract SnapshotMetadata b();

  public abstract Contents c();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.Snapshot
 * JD-Core Version:    0.6.0
 */