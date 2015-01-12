package com.crashlytics.android;

import com.crashlytics.android.internal.au;
import java.io.IOException;
import java.io.InputStream;

final class y
  implements au
{
  y(v paramv, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
  }

  public final void a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    try
    {
      paramInputStream.read(this.a, this.b[0], paramInt);
      int[] arrayOfInt = this.b;
      arrayOfInt[0] = (paramInt + arrayOfInt[0]);
      return;
    }
    finally
    {
      paramInputStream.close();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.y
 * JD-Core Version:    0.6.2
 */