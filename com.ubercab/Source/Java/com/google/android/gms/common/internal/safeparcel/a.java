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
    if (i == 0)
      return null;
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfString;
  }

  public static int B(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }

  public static ArrayList<Integer> B(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (int m = 0; m < k; m++)
      localArrayList.add(Integer.valueOf(paramParcel.readInt()));
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }

  public static int C(Parcel paramParcel)
  {
    int i = B(paramParcel);
    int j = a(paramParcel, i);
    int k = paramParcel.dataPosition();
    if (aD(i) != 20293)
      throw new a("Expected object header. Got 0x" + Integer.toHexString(i), paramParcel);
    int m = k + j;
    if ((m < k) || (m > paramParcel.dataSize()))
      throw new a("Size read is invalid start=" + k + " end=" + m, paramParcel);
    return m;
  }

  public static ArrayList<String> C(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(i + j);
    return localArrayList;
  }

  public static Parcel D(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, j, i);
    paramParcel.setDataPosition(i + j);
    return localParcel;
  }

  public static Parcel[] E(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
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
    return arrayOfParcel;
  }

  public static int a(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536)
      return 0xFFFF & paramInt >> 16;
    return paramParcel.readInt();
  }

  public static <T extends Parcelable> T a(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Parcelable localParcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i + j);
    return localParcelable;
  }

  private static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    int i = a(paramParcel, paramInt1);
    if (i != paramInt2)
      throw new a("Expected size " + paramInt2 + " got " + i + " (0x" + Integer.toHexString(i) + ")", paramParcel);
  }

  private static void a(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt3)
      throw new a("Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + Integer.toHexString(paramInt2) + ")", paramParcel);
  }

  public static void a(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return;
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(i + j);
  }

  public static int aD(int paramInt)
  {
    return 0xFFFF & paramInt;
  }

  public static void b(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(a(paramParcel, paramInt) + paramParcel.dataPosition());
  }

  public static <T> T[] b(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Object[] arrayOfObject = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + j);
    return arrayOfObject;
  }

  public static <T> ArrayList<T> c(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    ArrayList localArrayList = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(i + j);
    return localArrayList;
  }

  public static boolean c(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }

  public static Boolean d(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    if (i == 0)
      return null;
    a(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
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
    if (i == 0)
      return null;
    a(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }

  public static long i(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }

  public static Long j(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    if (i == 0)
      return null;
    a(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }

  public static BigInteger k(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + j);
    return new BigInteger(arrayOfByte);
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
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    int k = paramParcel.readInt();
    paramParcel.setDataPosition(i + j);
    return new BigDecimal(new BigInteger(arrayOfByte), k);
  }

  public static String o(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    String str = paramParcel.readString();
    paramParcel.setDataPosition(i + j);
    return str;
  }

  public static IBinder p(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + j);
    return localIBinder;
  }

  public static Bundle q(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(i + j);
    return localBundle;
  }

  public static byte[] r(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfByte;
  }

  public static byte[][] s(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return (byte[][])null;
    int k = paramParcel.readInt();
    byte[][] arrayOfByte = new byte[k][];
    for (int m = 0; m < k; m++)
      arrayOfByte[m] = paramParcel.createByteArray();
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }

  public static boolean[] t(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfBoolean;
  }

  public static int[] u(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfInt;
  }

  public static long[] v(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfLong;
  }

  public static BigInteger[] w(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    for (int m = 0; m < k; m++)
      arrayOfBigInteger[m] = new BigInteger(paramParcel.createByteArray());
    paramParcel.setDataPosition(j + i);
    return arrayOfBigInteger;
  }

  public static float[] x(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfFloat;
  }

  public static double[] y(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(i + j);
    return arrayOfDouble;
  }

  public static BigDecimal[] z(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null;
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    for (int m = 0; m < k; m++)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int n = paramParcel.readInt();
      arrayOfBigDecimal[m] = new BigDecimal(new BigInteger(arrayOfByte), n);
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }

  public static class a extends RuntimeException
  {
    public a(String paramString, Parcel paramParcel)
    {
      super();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.a
 * JD-Core Version:    0.6.2
 */