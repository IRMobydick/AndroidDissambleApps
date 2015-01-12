package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

@ez
public final class db
{
  public static int a(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.qL[paramErrorCode.ordinal()])
    {
    default:
      return 0;
    case 2:
      return 1;
    case 3:
      return 2;
    case 4:
    }
    return 3;
  }

  public static AdSize b(ay paramay)
  {
    int i = 0;
    AdSize[] arrayOfAdSize = new AdSize[6];
    arrayOfAdSize[0] = AdSize.SMART_BANNER;
    arrayOfAdSize[1] = AdSize.BANNER;
    arrayOfAdSize[2] = AdSize.IAB_MRECT;
    arrayOfAdSize[3] = AdSize.IAB_BANNER;
    arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
    arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    while (i < arrayOfAdSize.length)
    {
      if ((arrayOfAdSize[i].getWidth() == paramay.width) && (arrayOfAdSize[i].getHeight() == paramay.height))
        return arrayOfAdSize[i];
      i++;
    }
    return new AdSize(a.a(paramay.width, paramay.height, paramay.of));
  }

  public static MediationAdRequest d(av paramav)
  {
    if (paramav.nV != null);
    for (HashSet localHashSet = new HashSet(paramav.nV); ; localHashSet = null)
      return new MediationAdRequest(new Date(paramav.nT), k(paramav.nU), localHashSet, paramav.nW, paramav.ob);
  }

  public static AdRequest.Gender k(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return AdRequest.Gender.UNKNOWN;
    case 2:
      return AdRequest.Gender.FEMALE;
    case 1:
    }
    return AdRequest.Gender.MALE;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.db
 * JD-Core Version:    0.6.2
 */