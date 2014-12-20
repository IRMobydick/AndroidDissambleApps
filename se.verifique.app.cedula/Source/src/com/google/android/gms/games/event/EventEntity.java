package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final a a = new a();
  private final int b;
  private final String c;
  private final String d;
  private final String e;
  private final Uri f;
  private final String g;
  private final PlayerEntity h;
  private final long i;
  private final String j;
  private final boolean k;

  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramUri;
    this.g = paramString4;
    this.h = new PlayerEntity(paramPlayer);
    this.i = paramLong;
    this.j = paramString5;
    this.k = paramBoolean;
  }

  public EventEntity(Event paramEvent)
  {
    this.b = 1;
    this.c = paramEvent.c_();
    this.d = paramEvent.c();
    this.e = paramEvent.d();
    this.f = paramEvent.e();
    this.g = paramEvent.f();
    this.h = ((PlayerEntity)paramEvent.g().a());
    this.i = paramEvent.h();
    this.j = paramEvent.i();
    this.k = paramEvent.j();
  }

  static int a(Event paramEvent)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramEvent.c_();
    arrayOfObject[1] = paramEvent.c();
    arrayOfObject[2] = paramEvent.d();
    arrayOfObject[3] = paramEvent.e();
    arrayOfObject[4] = paramEvent.f();
    arrayOfObject[5] = paramEvent.g();
    arrayOfObject[6] = Long.valueOf(paramEvent.h());
    arrayOfObject[7] = paramEvent.i();
    arrayOfObject[8] = Boolean.valueOf(paramEvent.j());
    return kt.a(arrayOfObject);
  }

  static boolean a(Event paramEvent, Object paramObject)
  {
    int m = 1;
    if (!(paramObject instanceof Event))
      m = 0;
    while (true)
    {
      return m;
      if (paramEvent == paramObject)
        continue;
      Event localEvent = (Event)paramObject;
      if ((kt.a(localEvent.c_(), paramEvent.c_())) && (kt.a(localEvent.c(), paramEvent.c())) && (kt.a(localEvent.d(), paramEvent.d())) && (kt.a(localEvent.e(), paramEvent.e())) && (kt.a(localEvent.f(), paramEvent.f())) && (kt.a(localEvent.g(), paramEvent.g())) && (kt.a(Long.valueOf(localEvent.h()), Long.valueOf(paramEvent.h()))) && (kt.a(localEvent.i(), paramEvent.i())) && (kt.a(Boolean.valueOf(localEvent.j()), Boolean.valueOf(paramEvent.j()))))
        continue;
      m = 0;
    }
  }

  static String b(Event paramEvent)
  {
    return kt.a(paramEvent).a("Id", paramEvent.c_()).a("Name", paramEvent.c()).a("Description", paramEvent.d()).a("IconImageUri", paramEvent.e()).a("IconImageUrl", paramEvent.f()).a("Player", paramEvent.g()).a("Value", Long.valueOf(paramEvent.h())).a("FormattedValue", paramEvent.i()).a("isVisible", Boolean.valueOf(paramEvent.j())).toString();
  }

  public String c()
  {
    return this.d;
  }

  public String c_()
  {
    return this.c;
  }

  public String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public String f()
  {
    return this.g;
  }

  public Player g()
  {
    return this.h;
  }

  public long h()
  {
    return this.i;
  }

  public int hashCode()
  {
    return a(this);
  }

  public String i()
  {
    return this.j;
  }

  public boolean j()
  {
    return this.k;
  }

  public int k()
  {
    return this.b;
  }

  public Event l()
  {
    return this;
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
 * Qualified Name:     com.google.android.gms.games.event.EventEntity
 * JD-Core Version:    0.6.0
 */