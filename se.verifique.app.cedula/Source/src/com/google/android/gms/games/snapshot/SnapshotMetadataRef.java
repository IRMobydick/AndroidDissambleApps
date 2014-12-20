package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

public final class SnapshotMetadataRef extends f
  implements SnapshotMetadata
{
  private final Game c;
  private final Player d;

  public Player c()
  {
    return this.d;
  }

  public String d()
  {
    return e("external_snapshot_id");
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return h("cover_icon_image_uri");
  }

  public boolean equals(Object paramObject)
  {
    return SnapshotMetadataEntity.a(this, paramObject);
  }

  public String f()
  {
    return e("cover_icon_image_url");
  }

  public float g()
  {
    float f1 = 0.0F;
    float f2 = f("cover_icon_image_height");
    float f3 = f("cover_icon_image_width");
    if (f2 == 0.0F);
    while (true)
    {
      return f1;
      f1 = f3 / f2;
    }
  }

  public String h()
  {
    return e("unique_name");
  }

  public int hashCode()
  {
    return SnapshotMetadataEntity.a(this);
  }

  public String i()
  {
    return e("title");
  }

  public String j()
  {
    return e("description");
  }

  public long k()
  {
    return b("last_modified_timestamp");
  }

  public long l()
  {
    return b("duration");
  }

  public Game l_()
  {
    return this.c;
  }

  public SnapshotMetadata m()
  {
    return new SnapshotMetadataEntity(this);
  }

  public String toString()
  {
    return SnapshotMetadataEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((SnapshotMetadataEntity)m()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataRef
 * JD-Core Version:    0.6.0
 */