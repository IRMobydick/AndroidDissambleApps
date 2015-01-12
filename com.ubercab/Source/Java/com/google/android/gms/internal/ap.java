package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ap
{
  private final int nJ;
  private final int nK;
  private final ao nL = new ar();
  private Base64OutputStream nM;
  private ByteArrayOutputStream nN;

  public ap(int paramInt)
  {
    this.nK = paramInt;
    this.nJ = 6;
  }

  private String m(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    if ((arrayOfString == null) || (arrayOfString.length == 0))
      return "";
    this.nN = new ByteArrayOutputStream();
    this.nM = new Base64OutputStream(this.nN, 10);
    Arrays.sort(arrayOfString, new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString2.length() - paramAnonymousString1.length();
      }
    });
    int i = 0;
    if ((i < arrayOfString.length) && (i < this.nK))
    {
      if (arrayOfString[i].trim().length() == 0);
      while (true)
      {
        i++;
        break;
        try
        {
          this.nM.write(this.nL.l(arrayOfString[i]));
        }
        catch (IOException localIOException2)
        {
          gs.b("Error while writing hash to byteStream", localIOException2);
        }
      }
    }
    try
    {
      this.nM.flush();
      this.nM.close();
      String str = this.nN.toString();
      return str;
    }
    catch (IOException localIOException1)
    {
      gs.b("HashManager: Unable to convert to base 64", localIOException1);
    }
    return "";
  }

  public String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(((String)localIterator.next()).toLowerCase());
      localStringBuffer.append('\n');
    }
    switch (0)
    {
    default:
      return "";
    case 0:
      return n(localStringBuffer.toString());
    case 1:
    }
    return m(localStringBuffer.toString());
  }

  String n(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\n");
    if ((arrayOfString1 == null) || (arrayOfString1.length == 0))
      return "";
    this.nN = new ByteArrayOutputStream();
    this.nM = new Base64OutputStream(this.nN, 10);
    PriorityQueue localPriorityQueue = new PriorityQueue(this.nK, new Comparator()
    {
      public int a(as.a paramAnonymousa1, as.a paramAnonymousa2)
      {
        return (int)(paramAnonymousa1.value - paramAnonymousa2.value);
      }
    });
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = aq.p(arrayOfString1[i]);
      if (arrayOfString2.length < this.nJ);
      while (true)
      {
        i++;
        break;
        as.a(arrayOfString2, this.nK, this.nJ, localPriorityQueue);
      }
    }
    Iterator localIterator = localPriorityQueue.iterator();
    while (localIterator.hasNext())
    {
      as.a locala = (as.a)localIterator.next();
      try
      {
        this.nM.write(this.nL.l(locala.nQ));
      }
      catch (IOException localIOException2)
      {
        gs.b("Error while writing hash to byteStream", localIOException2);
      }
    }
    try
    {
      this.nM.flush();
      this.nM.close();
      String str = this.nN.toString();
      return str;
    }
    catch (IOException localIOException1)
    {
      gs.b("HashManager: unable to convert to base 64", localIOException1);
    }
    return "";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ap
 * JD-Core Version:    0.6.2
 */