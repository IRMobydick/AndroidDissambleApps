package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class EventRef extends f
  implements Event
{
  public String c()
  {
    return e("name");
  }

  public String c_()
  {
    return e("external_event_id");
  }

  public String d()
  {
    return e("description");
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return h("icon_image_uri");
  }

  public boolean equals(Object paramObject)
  {
    return EventEntity.a(this, paramObject);
  }

  public String f()
  {
    return e("icon_image_url");
  }

  public Player g()
  {
    return new PlayerRef(this.a, this.b);
  }

  public long h()
  {
    return b("value");
  }

  public int hashCode()
  {
    return EventEntity.a(this);
  }

  public String i()
  {
    return e("formatted_value");
  }

  public boolean j()
  {
    return d("visibility");
  }

  public Event k()
  {
    return new EventEntity(this);
  }

  public String toString()
  {
    return EventEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((EventEntity)k()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.EventRef
 * JD-Core Version:    0.6.0
 */