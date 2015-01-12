package com.baidu.location;

import java.io.File;
import java.io.RandomAccessFile;

class e
{
  static e jdField_if;
  int a = 20;
  int jdField_do = 0;
  int jdField_for = 3164;
  String jdField_int = "firll.dat";

  private long a(int paramInt)
  {
    String str1 = c.jdMethod_goto();
    if (str1 == null);
    while (true)
    {
      return -1L;
      String str2 = str1 + File.separator + this.jdField_int;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(str2, "rw");
        localRandomAccessFile.seek(paramInt);
        int i = localRandomAccessFile.readInt();
        long l = localRandomAccessFile.readLong();
        int j = localRandomAccessFile.readInt();
        localRandomAccessFile.close();
        if (i == j)
          return l;
      }
      catch (Exception localException)
      {
      }
    }
    return -1L;
  }

  private void a(int paramInt, long paramLong)
  {
    String str1 = c.jdMethod_goto();
    if (str1 == null)
      return;
    String str2 = str1 + File.separator + this.jdField_int;
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(str2, "rw");
      localRandomAccessFile.seek(paramInt);
      localRandomAccessFile.writeInt(this.jdField_for);
      localRandomAccessFile.writeLong(paramLong);
      localRandomAccessFile.writeInt(this.jdField_for);
      localRandomAccessFile.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static e jdField_do()
  {
    if (jdField_if == null)
      jdField_if = new e();
    return jdField_if;
  }

  public long a()
  {
    return a(this.a);
  }

  public void a(long paramLong)
  {
    a(this.jdField_do, paramLong);
  }

  public long jdField_if()
  {
    return a(this.jdField_do);
  }

  public void jdField_if(long paramLong)
  {
    a(this.a, paramLong);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.e
 * JD-Core Version:    0.6.2
 */