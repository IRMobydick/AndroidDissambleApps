package net.photopay.util;

import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class IlIllIlIIl
{
  public static ByteBuffer llIIlIlIIl(Resources paramResources, int paramInt)
  {
    InputStream localInputStream;
    ReadableByteChannel localReadableByteChannel;
    if (paramInt != 0)
    {
      localInputStream = paramResources.openRawResource(paramInt);
      localReadableByteChannel = Channels.newChannel(localInputStream);
    }
    while (true)
    {
      try
      {
        int i = localInputStream.available();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(i);
        Log.v(IlIllIlIIl.class, "Count: {}", arrayOfObject2);
        localByteBuffer = ByteBuffer.allocateDirect(i);
        localReadableByteChannel.read(localByteBuffer);
        localInputStream.close();
        return localByteBuffer;
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(paramInt);
        Log.e(IlIllIlIIl.class, localIOException, "Error reading raw file {}", arrayOfObject1);
        localByteBuffer = null;
        continue;
      }
      Log.e(IlIllIlIIl.class, "Resource ID 0 is invalid!", new Object[0]);
      ByteBuffer localByteBuffer = null;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.IlIllIlIIl
 * JD-Core Version:    0.6.0
 */