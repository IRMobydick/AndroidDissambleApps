package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kx;

public final class DataHolder
  implements SafeParcelable
{
  public static final g a = new g();
  private static final c m = new b(new String[0], null);
  Bundle b;
  int[] c;
  int d;
  boolean e = false;
  private final int f;
  private final String[] g;
  private final CursorWindow[] h;
  private final int i;
  private final Bundle j;
  private Object k;
  private boolean l = true;

  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    this.f = paramInt1;
    this.g = paramArrayOfString;
    this.h = paramArrayOfCursorWindow;
    this.i = paramInt2;
    this.j = paramBundle;
  }

  private void a(String paramString, int paramInt)
  {
    if ((this.b == null) || (!this.b.containsKey(paramString)))
      throw new IllegalArgumentException("No such column: " + paramString);
    if (h())
      throw new IllegalArgumentException("Buffer is closed.");
    if ((paramInt < 0) || (paramInt >= this.d))
      throw new CursorIndexOutOfBoundsException(paramInt, this.d);
  }

  public int a(int paramInt)
  {
    int n = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.d))
    {
      bool = true;
      kx.a(bool);
    }
    while (true)
    {
      if (n < this.c.length)
      {
        if (paramInt < this.c[n])
          n--;
      }
      else
      {
        if (n == this.c.length)
          n--;
        return n;
        bool = false;
        break;
      }
      n++;
    }
  }

  public long a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.h[paramInt2].getLong(paramInt1, this.b.getInt(paramString));
  }

  public void a()
  {
    int n = 0;
    this.b = new Bundle();
    for (int i1 = 0; i1 < this.g.length; i1++)
      this.b.putInt(this.g[i1], i1);
    this.c = new int[this.h.length];
    int i2 = 0;
    while (n < this.h.length)
    {
      this.c[n] = i2;
      int i3 = i2 - this.h[n].getStartPosition();
      i2 += this.h[n].getNumRows() - i3;
      n++;
    }
    this.d = i2;
  }

  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }

  int b()
  {
    return this.f;
  }

  public int b(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.h[paramInt2].getInt(paramInt1, this.b.getInt(paramString));
  }

  public String c(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.h[paramInt2].getString(paramInt1, this.b.getInt(paramString));
  }

  String[] c()
  {
    return this.g;
  }

  public boolean d(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    if (Long.valueOf(this.h[paramInt2].getLong(paramInt1, this.b.getInt(paramString))).longValue() == 1L);
    for (int n = 1; ; n = 0)
      return n;
  }

  CursorWindow[] d()
  {
    return this.h;
  }

  public int describeContents()
  {
    return 0;
  }

  public float e(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.h[paramInt2].getFloat(paramInt1, this.b.getInt(paramString));
  }

  public int e()
  {
    return this.i;
  }

  public Bundle f()
  {
    return this.j;
  }

  public byte[] f(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.h[paramInt2].getBlob(paramInt1, this.b.getInt(paramString));
  }

  protected void finalize()
  {
    try
    {
      if ((this.l) && (this.h.length > 0) && (!h()))
        if (this.k != null)
          break label91;
      label91: String str;
      for (Object localObject2 = "internal object: " + toString(); ; localObject2 = str)
      {
        Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + (String)localObject2 + ")");
        i();
        return;
        str = this.k.toString();
      }
    }
    finally
    {
      super.finalize();
    }
    throw localObject1;
  }

  public int g()
  {
    return this.d;
  }

  public Uri g(String paramString, int paramInt1, int paramInt2)
  {
    String str = c(paramString, paramInt1, paramInt2);
    if (str == null);
    for (Uri localUri = null; ; localUri = Uri.parse(str))
      return localUri;
  }

  public boolean h()
  {
    monitorenter;
    try
    {
      boolean bool = this.e;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean h(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return this.h[paramInt2].isNull(paramInt1, this.b.getInt(paramString));
  }

  public void i()
  {
    monitorenter;
    try
    {
      if (!this.e)
      {
        this.e = true;
        for (int n = 0; n < this.h.length; n++)
          this.h[n].close();
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * JD-Core Version:    0.6.0
 */