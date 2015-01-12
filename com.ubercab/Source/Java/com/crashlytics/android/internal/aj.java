package com.crashlytics.android.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class aj
{
  private final File a;
  private final String b;
  private aq c;
  private File d;
  private File e;

  public aj(File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    this.a = paramFile;
    this.b = paramString2;
    this.d = new File(paramFile, paramString1);
    this.c = new aq(this.d);
    this.e = new File(this.a, this.b);
    if (!this.e.exists())
      this.e.mkdirs();
  }

  public int a()
  {
    return this.c.a();
  }

  public List<File> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = this.e.listFiles();
    int i = arrayOfFile.length;
    for (int j = 0; ; j++)
      if (j < i)
      {
        localArrayList.add(arrayOfFile[j]);
        if (localArrayList.size() <= 0);
      }
      else
      {
        return localArrayList;
      }
  }

  // ERROR //
  public void a(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 37	com/crashlytics/android/internal/aj:c	Lcom/crashlytics/android/internal/aq;
    //   6: invokevirtual 70	com/crashlytics/android/internal/aq:close	()V
    //   9: aload_0
    //   10: getfield 30	com/crashlytics/android/internal/aj:d	Ljava/io/File;
    //   13: astore_3
    //   14: new 25	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: getfield 39	com/crashlytics/android/internal/aj:e	Ljava/io/File;
    //   22: aload_1
    //   23: invokespecial 28	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 4
    //   28: new 72	java/io/FileInputStream
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore 5
    //   38: new 75	java/util/zip/GZIPOutputStream
    //   41: dup
    //   42: new 77	java/io/FileOutputStream
    //   45: dup
    //   46: aload 4
    //   48: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 81	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore 6
    //   56: aload 5
    //   58: aload 6
    //   60: sipush 1024
    //   63: newarray byte
    //   65: invokestatic 86	com/crashlytics/android/internal/ab:a	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
    //   68: aload 5
    //   70: ldc 88
    //   72: invokestatic 91	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   75: aload 6
    //   77: ldc 93
    //   79: invokestatic 91	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   82: aload_3
    //   83: invokevirtual 96	java/io/File:delete	()Z
    //   86: pop
    //   87: aload_0
    //   88: new 32	com/crashlytics/android/internal/aq
    //   91: dup
    //   92: aload_0
    //   93: getfield 30	com/crashlytics/android/internal/aj:d	Ljava/io/File;
    //   96: invokespecial 35	com/crashlytics/android/internal/aq:<init>	(Ljava/io/File;)V
    //   99: putfield 37	com/crashlytics/android/internal/aj:c	Lcom/crashlytics/android/internal/aq;
    //   102: return
    //   103: astore 7
    //   105: aconst_null
    //   106: astore 5
    //   108: aload 5
    //   110: ldc 88
    //   112: invokestatic 91	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   115: aload_2
    //   116: ldc 93
    //   118: invokestatic 91	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   121: aload_3
    //   122: invokevirtual 96	java/io/File:delete	()Z
    //   125: pop
    //   126: aload 7
    //   128: athrow
    //   129: astore 7
    //   131: aconst_null
    //   132: astore_2
    //   133: goto -25 -> 108
    //   136: astore 7
    //   138: aload 6
    //   140: astore_2
    //   141: goto -33 -> 108
    //
    // Exception table:
    //   from	to	target	type
    //   28	38	103	finally
    //   38	56	129	finally
    //   56	68	136	finally
  }

  public void a(List<File> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localFile.getName();
      ab.c(String.format("deleting sent analytics file %s", arrayOfObject));
      localFile.delete();
    }
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    this.c.a(paramArrayOfByte);
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return this.c.a(paramInt1, paramInt2);
  }

  public boolean b()
  {
    return this.c.b();
  }

  public List<File> c()
  {
    return Arrays.asList(this.e.listFiles());
  }

  public void d()
  {
    try
    {
      this.c.close();
      label7: this.d.delete();
      return;
    }
    catch (IOException localIOException)
    {
      break label7;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.aj
 * JD-Core Version:    0.6.2
 */