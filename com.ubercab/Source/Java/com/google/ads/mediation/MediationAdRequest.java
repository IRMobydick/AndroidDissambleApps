package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest
{
  private final Date d;
  private final AdRequest.Gender e;
  private final Set<String> f;
  private final boolean g;
  private final Location h;

  public MediationAdRequest(Date paramDate, AdRequest.Gender paramGender, Set<String> paramSet, boolean paramBoolean, Location paramLocation)
  {
    this.d = paramDate;
    this.e = paramGender;
    this.f = paramSet;
    this.g = paramBoolean;
    this.h = paramLocation;
  }

  public Integer getAgeInYears()
  {
    if (this.d != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar1.setTime(this.d);
      Integer localInteger = Integer.valueOf(localCalendar2.get(1) - localCalendar1.get(1));
      if ((localCalendar2.get(2) < localCalendar1.get(2)) || ((localCalendar2.get(2) == localCalendar1.get(2)) && (localCalendar2.get(5) < localCalendar1.get(5))))
        localInteger = Integer.valueOf(-1 + localInteger.intValue());
      return localInteger;
    }
    return null;
  }

  public Date getBirthday()
  {
    return this.d;
  }

  public AdRequest.Gender getGender()
  {
    return this.e;
  }

  public Set<String> getKeywords()
  {
    return this.f;
  }

  public Location getLocation()
  {
    return this.h;
  }

  public boolean isTesting()
  {
    return this.g;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationAdRequest
 * JD-Core Version:    0.6.2
 */