package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class a
{
  public static String[] A(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    String[] arrayOfString;
    if (i == 0)
      arrayOfString = null;
    while (true)
    {
      return arrayOfString;
      arrayOfString = paramParcel.createStringArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static ArrayList B(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    ArrayList localArrayList;
    if (i == 0)
      localArrayList = null;
    while (true)
    {
      return localArrayList;
      localArrayList = paramParcel.createStringArrayList();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static Parcel C(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    Parcel localParcel;
    if (i == 0)
      localParcel = null;
    while (true)
    {
      return localParcel;
      localParcel = Parcel.obtain();
      localParcel.appendFrom(paramParcel, j, i);
      paramParcel.setDataPosition(i + j);
    }
  }

  public static Parcel[] D(Parcel paramParcel, int paramInt)
  {
    Object localObject = null;
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0);
    while (true)
    {
      return localObject;
      int k = paramParcel.readInt();
      Parcel[] arrayOfParcel = new Parcel[k];
      int m = 0;
      if (m < k)
      {
        int n = paramParcel.readInt();
        if (n != 0)
        {
          int i1 = paramParcel.dataPosition();
          Parcel localParcel = Parcel.obtain();
          localParcel.appendFrom(paramParcel, i1, n);
          arrayOfParcel[m] = localParcel;
          paramParcel.setDataPosition(n + i1);
        }
        while (true)
        {
          m++;
          break;
          arrayOfParcel[m] = null;
        }
      }
      paramParcel.setDataPosition(j + i);
      localObject = arrayOfParcel;
    }
  }

  public static int a(int paramInt)
  {
    return 0xFFFF & paramInt;
  }

  public static int a(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }

  public static int a(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536);
    for (int i = 0xFFFF & paramInt >> 16; ; i = paramParcel.readInt())
      return i;
  }

  public static Parcelable a(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    Parcelable localParcelable;
    if (i == 0)
      localParcelable = null;
    while (true)
    {
      return localParcelable;
      localParcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
      paramParcel.setDataPosition(i + j);
    }
  }

  private static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    int i = a(paramParcel, paramInt1);
    if (i != paramInt2)
      throw new b("Expected size " + paramInt2 + " got " + i + " (0x" + Integer.toHexString(i) + ")", paramParcel);
  }

  private static void a(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt3)
      throw new b("Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + Integer.toHexString(paramInt2) + ")", paramParcel);
  }

  public static void a(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0);
    while (true)
    {
      return;
      paramParcel.readList(paramList, paramClassLoader);
      paramParcel.setDataPosition(i + j);
    }
  }

  public static int b(Parcel paramParcel)
  {
    int i = a(paramParcel);
    int j = a(paramParcel, i);
    int k = paramParcel.dataPosition();
    if (a(i) != 20293)
      throw new b("Expected object header. Got 0x" + Integer.toHexString(i), paramParcel);
    int m = k + j;
    if ((m < k) || (m > paramParcel.dataSize()))
      throw new b("Size read is invalid start=" + k + " end=" + m, paramParcel);
    return m;
  }

  public static void b(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(a(paramParcel, paramInt) + paramParcel.dataPosition());
  }

  public static Object[] b(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    Object[] arrayOfObject;
    if (i == 0)
      arrayOfObject = null;
    while (true)
    {
      return arrayOfObject;
      arrayOfObject = paramParcel.createTypedArray(paramCreator);
      paramParcel.setDataPosition(i + j);
    }
  }

  public static ArrayList c(Parcel paramParcel, int paramInt, Parcelable.Creator paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    ArrayList localArrayList;
    if (i == 0)
      localArrayList = null;
    while (true)
    {
      return localArrayList;
      localArrayList = paramParcel.createTypedArrayList(paramCreator);
      paramParcel.setDataPosition(i + j);
    }
  }

  public static boolean c(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    if (paramParcel.readInt() != 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static Boolean d(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    Boolean localBoolean;
    if (i == 0)
    {
      localBoolean = null;
      return localBoolean;
    }
    a(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      localBoolean = Boolean.valueOf(bool);
      break;
    }
  }

  public static byte e(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }

  public static short f(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }

  public static int g(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }

  public static Integer h(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    if (i == 0);
    for (Integer localInteger = null; ; localInteger = Integer.valueOf(paramParcel.readInt()))
    {
      return localInteger;
      a(paramParcel, paramInt, i, 4);
    }
  }

  public static long i(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }

  public static Long j(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    if (i == 0);
    for (Long localLong = null; ; localLong = Long.valueOf(paramParcel.readLong()))
    {
      return localLong;
      a(paramParcel, paramInt, i, 8);
    }
  }

  public static BigInteger k(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0);
    byte[] arrayOfByte;
    for (BigInteger localBigInteger = null; ; localBigInteger = new BigInteger(arrayOfByte))
    {
      return localBigInteger;
      arrayOfByte = paramParcel.createByteArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static float l(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }

  public static double m(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }

  public static BigDecimal n(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0);
    byte[] arrayOfByte;
    int k;
    for (BigDecimal localBigDecimal = null; ; localBigDecimal = new BigDecimal(new BigInteger(arrayOfByte), k))
    {
      return localBigDecimal;
      arrayOfByte = paramParcel.createByteArray();
      k = paramParcel.readInt();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static String o(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    String str;
    if (i == 0)
      str = null;
    while (true)
    {
      return str;
      str = paramParcel.readString();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static IBinder p(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    IBinder localIBinder;
    if (i == 0)
      localIBinder = null;
    while (true)
    {
      return localIBinder;
      localIBinder = paramParcel.readStrongBinder();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static Bundle q(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    Bundle localBundle;
    if (i == 0)
      localBundle = null;
    while (true)
    {
      return localBundle;
      localBundle = paramParcel.readBundle();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static byte[] r(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    byte[] arrayOfByte;
    if (i == 0)
      arrayOfByte = null;
    while (true)
    {
      return arrayOfByte;
      arrayOfByte = paramParcel.createByteArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static byte[][] s(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    Object localObject;
    if (i == 0)
      localObject = (byte[][])null;
    while (true)
    {
      return localObject;
      int k = paramParcel.readInt();
      localObject = new byte[k][];
      for (int m = 0; m < k; m++)
        localObject[m] = paramParcel.createByteArray();
      paramParcel.setDataPosition(j + i);
    }
  }

  public static boolean[] t(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    boolean[] arrayOfBoolean;
    if (i == 0)
      arrayOfBoolean = null;
    while (true)
    {
      return arrayOfBoolean;
      arrayOfBoolean = paramParcel.createBooleanArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static int[] u(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    int[] arrayOfInt;
    if (i == 0)
      arrayOfInt = null;
    while (true)
    {
      return arrayOfInt;
      arrayOfInt = paramParcel.createIntArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static long[] v(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    long[] arrayOfLong;
    if (i == 0)
      arrayOfLong = null;
    while (true)
    {
      return arrayOfLong;
      arrayOfLong = paramParcel.createLongArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static BigInteger[] w(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    BigInteger[] arrayOfBigInteger;
    if (i == 0)
      arrayOfBigInteger = null;
    while (true)
    {
      return arrayOfBigInteger;
      int k = paramParcel.readInt();
      arrayOfBigInteger = new BigInteger[k];
      for (int m = 0; m < k; m++)
        arrayOfBigInteger[m] = new BigInteger(paramParcel.createByteArray());
      paramParcel.setDataPosition(j + i);
    }
  }

  public static float[] x(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    float[] arrayOfFloat;
    if (i == 0)
      arrayOfFloat = null;
    while (true)
    {
      return arrayOfFloat;
      arrayOfFloat = paramParcel.createFloatArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static double[] y(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    double[] arrayOfDouble;
    if (i == 0)
      arrayOfDouble = null;
    while (true)
    {
      return arrayOfDouble;
      arrayOfDouble = paramParcel.createDoubleArray();
      paramParcel.setDataPosition(i + j);
    }
  }

  public static BigDecimal[] z(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    BigDecimal[] arrayOfBigDecimal;
    if (i == 0)
      arrayOfBigDecimal = null;
    while (true)
    {
      return arrayOfBigDecimal;
      int k = paramParcel.readInt();
      arrayOfBigDecimal = new BigDecimal[k];
      for (int m = 0; m < k; m++)
      {
        byte[] arrayOfByte = paramParcel.createByteArray();
        int n = paramParcel.readInt();
        arrayOfBigDecimal[m] = new BigDecimal(new BigInteger(arrayOfByte), n);
      }
      paramParcel.setDataPosition(j + i);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.a
 * JD-Core Version:    0.6.0
 */