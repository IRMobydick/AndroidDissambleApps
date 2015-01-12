package com.ubercab.client.feature.trip;

import android.text.TextUtils;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import com.ubercab.common.collect.Lists;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import java.util.List;

public final class TripAnalyticsUtils
{
  public static ImpressionEventName convertTripUIStateToV2EventName(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return RiderEvents.Impression.LOOKING;
    case 1:
      return RiderEvents.Impression.CONFIRMING;
    case 2:
      return RiderEvents.Impression.DISPATCHING;
    case 3:
      return RiderEvents.Impression.ACCEPTED;
    case 5:
      return RiderEvents.Impression.ON_TRIP;
    case 4:
    }
    return RiderEvents.Impression.ARRIVING_NOW;
  }

  public static int indexInLocationResultList(List<LocationSearchResult> paramList, LocationSearchResult paramLocationSearchResult)
  {
    return Iterables.indexOf(paramList, new FindByReferencePredicate(paramLocationSearchResult.getReference()));
  }

  public static int indexInLocationResultSublist(List<LocationSearchResult> paramList, LocationSearchResult paramLocationSearchResult)
  {
    return indexInLocationResultList(Lists.newArrayList(Iterables.filter(paramList, new FilterByServiceTypePredicate(paramLocationSearchResult.getServiceType()))), paramLocationSearchResult);
  }

  private static class FilterByServiceTypePredicate
    implements Predicate<LocationSearchResult>
  {
    private final String mServiceType;

    FilterByServiceTypePredicate(String paramString)
    {
      this.mServiceType = paramString;
    }

    public boolean apply(LocationSearchResult paramLocationSearchResult)
    {
      String str = paramLocationSearchResult.getServiceType();
      return (!TextUtils.isEmpty(str)) && (str.equals(this.mServiceType));
    }
  }

  private static class FindByReferencePredicate
    implements Predicate<LocationSearchResult>
  {
    private final String mLocationReference;

    FindByReferencePredicate(String paramString)
    {
      this.mLocationReference = paramString;
    }

    public boolean apply(LocationSearchResult paramLocationSearchResult)
    {
      String str = paramLocationSearchResult.getReference();
      return (!TextUtils.isEmpty(str)) && (str.equals(this.mLocationReference));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripAnalyticsUtils
 * JD-Core Version:    0.6.2
 */