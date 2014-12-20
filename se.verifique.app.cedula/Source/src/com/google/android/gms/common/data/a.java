package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class a
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new e();
  final int a;
  ParcelFileDescriptor b;
  final int c;
  private Bitmap d;
  private boolean e;
  private File f;

  a(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramParcelFileDescriptor;
    this.c = paramInt2;
    this.d = null;
    this.e = false;
  }

  // ERROR //
  private java.io.FileOutputStream a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/google/android/gms/common/data/a:f	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 49	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 51
    //   13: invokespecial 54	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 56
    //   19: ldc 58
    //   21: aload_0
    //   22: getfield 47	com/google/android/gms/common/data/a:f	Ljava/io/File;
    //   25: invokestatic 64	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_2
    //   29: new 66	java/io/FileOutputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_3
    //   38: aload_0
    //   39: aload_2
    //   40: ldc 70
    //   42: invokestatic 76	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 34	com/google/android/gms/common/data/a:b	Landroid/os/ParcelFileDescriptor;
    //   48: aload_2
    //   49: invokevirtual 80	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_3
    //   54: areturn
    //   55: astore_1
    //   56: new 49	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 82
    //   62: aload_1
    //   63: invokespecial 85	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore 4
    //   69: new 49	java/lang/IllegalStateException
    //   72: dup
    //   73: ldc 87
    //   75: invokespecial 54	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }

  private void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.w("BitmapTeleporter", "Could not close stream", localIOException);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    byte[] arrayOfByte;
    DataOutputStream localDataOutputStream;
    if (this.b == null)
    {
      localBitmap = this.d;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer(localByteBuffer);
      arrayOfByte = localByteBuffer.array();
      localDataOutputStream = new DataOutputStream(a());
    }
    try
    {
      localDataOutputStream.writeInt(arrayOfByte.length);
      localDataOutputStream.writeInt(localBitmap.getWidth());
      localDataOutputStream.writeInt(localBitmap.getHeight());
      localDataOutputStream.writeUTF(localBitmap.getConfig().toString());
      localDataOutputStream.write(arrayOfByte);
      a(localDataOutputStream);
      e.a(this, paramParcel, paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not write into unlinked file", localIOException);
    }
    finally
    {
      a(localDataOutputStream);
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.a
 * JD-Core Version:    0.6.0
 */