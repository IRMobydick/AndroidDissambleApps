package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ez
public class ax
{
  public static final ax oe = new ax();

  public static ax bb()
  {
    return oe;
  }

  public av a(Context paramContext, bg parambg)
  {
    Date localDate = parambg.getBirthday();
    long l;
    String str1;
    int i;
    List localList;
    label57: boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    SearchAdRequest localSearchAdRequest;
    if (localDate != null)
    {
      l = localDate.getTime();
      str1 = parambg.getContentUrl();
      i = parambg.getGender();
      Set localSet = parambg.getKeywords();
      if (localSet.isEmpty())
        break label161;
      localList = Collections.unmodifiableList(new ArrayList(localSet));
      bool1 = parambg.isTestDevice(paramContext);
      j = parambg.bg();
      localLocation = parambg.getLocation();
      localBundle = parambg.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = parambg.getManualImpressionsEnabled();
      str2 = parambg.getPublisherProvidedId();
      localSearchAdRequest = parambg.bd();
      if (localSearchAdRequest == null)
        break label167;
    }
    label161: label167: for (bj localbj = new bj(localSearchAdRequest); ; localbj = null)
    {
      return new av(4, l, localBundle, i, localList, bool1, j, bool2, str2, localbj, localLocation, str1, parambg.bf());
      l = -1L;
      break;
      localList = null;
      break label57;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ax
 * JD-Core Version:    0.6.2
 */