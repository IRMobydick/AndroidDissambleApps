package com.baidu.mapapi.map;

import android.os.Bundle;

class j
{
  public final byte[] a;
  public final int b;
  public final int c;

  public j(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.c = paramInt1;
    this.b = paramInt2;
    this.a = paramArrayOfByte;
  }

  Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("image_width", this.c);
    localBundle.putInt("image_height", this.b);
    localBundle.putByteArray("image_data", this.a);
    return localBundle;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.j
 * JD-Core Version:    0.6.2
 */