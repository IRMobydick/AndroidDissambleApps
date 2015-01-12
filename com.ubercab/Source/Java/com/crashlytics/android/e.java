package com.crashlytics.android;

import android.os.Process;
import com.crashlytics.android.internal.ab;
import com.crashlytics.android.internal.ao;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

final class e
{
  private static final AtomicLong a = new AtomicLong(0L);
  private static String b;

  public e(ao paramao)
  {
    byte[] arrayOfByte1 = new byte[10];
    long l1 = new Date().getTime();
    long l2 = l1 / 1000L;
    long l3 = l1 % 1000L;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    byte[] arrayOfByte2 = localByteBuffer.array();
    arrayOfByte1[0] = arrayOfByte2[0];
    arrayOfByte1[1] = arrayOfByte2[1];
    arrayOfByte1[2] = arrayOfByte2[2];
    arrayOfByte1[3] = arrayOfByte2[3];
    byte[] arrayOfByte3 = a(l3);
    arrayOfByte1[4] = arrayOfByte3[0];
    arrayOfByte1[5] = arrayOfByte3[1];
    byte[] arrayOfByte4 = a(a.incrementAndGet());
    arrayOfByte1[6] = arrayOfByte4[0];
    arrayOfByte1[7] = arrayOfByte4[1];
    byte[] arrayOfByte5 = a(Integer.valueOf(Process.myPid()).shortValue());
    arrayOfByte1[8] = arrayOfByte5[0];
    arrayOfByte1[9] = arrayOfByte5[1];
    String str1 = ab.a(paramao.b());
    String str2 = ab.a(arrayOfByte1);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str2.substring(0, 12);
    arrayOfObject[1] = str2.substring(12, 16);
    arrayOfObject[2] = str2.subSequence(16, 20);
    arrayOfObject[3] = str1.substring(0, 12);
    b = String.format(localLocale, "%s-%s-%s-%s", arrayOfObject).toUpperCase(Locale.US);
  }

  private static byte[] a(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.putShort((short)(int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }

  public final String toString()
  {
    return b;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.e
 * JD-Core Version:    0.6.2
 */