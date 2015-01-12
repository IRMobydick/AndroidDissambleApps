package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import com.baidu.platform.comapi.a.d;
import java.util.ArrayList;

public class a
{
  public static double a(d paramd1, d paramd2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putDouble("x1", paramd1.a);
    localBundle.putDouble("y1", paramd1.b);
    localBundle.putDouble("x2", paramd2.a);
    localBundle.putDouble("y2", paramd2.b);
    JNITools.GetDistanceByMC(localBundle);
    return localBundle.getDouble("distance");
  }

  public static com.baidu.platform.comapi.a.a a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
      return null;
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("strkey", paramString);
    JNITools.TransGeoStr2ComplexPt(localBundle1);
    com.baidu.platform.comapi.a.a locala = new com.baidu.platform.comapi.a.a();
    Bundle localBundle2 = localBundle1.getBundle("map_bound");
    if (localBundle2 != null)
    {
      Bundle localBundle5 = localBundle2.getBundle("ll");
      if (localBundle5 != null)
        locala.b = new d((int)localBundle5.getDouble("ptx"), (int)localBundle5.getDouble("pty"));
      Bundle localBundle6 = localBundle2.getBundle("ru");
      if (localBundle6 != null)
        locala.c = new d((int)localBundle6.getDouble("ptx"), (int)localBundle6.getDouble("pty"));
    }
    ParcelItem[] arrayOfParcelItem1 = (ParcelItem[])localBundle1.getParcelableArray("poly_line");
    for (int i = 0; i < arrayOfParcelItem1.length; i++)
    {
      if (locala.d == null)
        locala.d = new ArrayList();
      Bundle localBundle3 = arrayOfParcelItem1[i].getBundle();
      if (localBundle3 != null)
      {
        ParcelItem[] arrayOfParcelItem2 = (ParcelItem[])localBundle3.getParcelableArray("point_array");
        ArrayList localArrayList = new ArrayList();
        for (int j = 0; j < arrayOfParcelItem2.length; j++)
        {
          Bundle localBundle4 = arrayOfParcelItem2[j].getBundle();
          if (localBundle4 != null)
            localArrayList.add(new d((int)localBundle4.getDouble("ptx"), (int)localBundle4.getDouble("pty")));
        }
        localArrayList.trimToSize();
        locala.d.add(localArrayList);
      }
    }
    locala.d.trimToSize();
    locala.a = ((int)localBundle1.getDouble("type"));
    return locala;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.tools.a
 * JD-Core Version:    0.6.2
 */