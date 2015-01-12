package com.ubercab.client.core.network;

import android.text.TextUtils;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.model.LocationAutocompleteResponse;
import com.ubercab.client.core.model.LocationSearchResponse;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.network.events.LocationAutocompleteResponseEvent;
import com.ubercab.client.core.network.events.LocationDetailResponseEvent;
import com.ubercab.client.core.network.events.LocationHistoryResponseEvent;
import com.ubercab.client.core.network.events.LocationSearchResponseEvent;
import java.util.Locale;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LocationClientImpl
  implements LocationClient
{
  private static final int FULL_TEXT_SEARCH_ENABLED = 1;
  private final Bus mBus;
  private final LegacyLocationApi mLegacyLocationApi;
  private final LocationApi mLocationApi;
  private final RiderPreferences mRiderPreferences;
  private final SessionPreferences mSessionPreferences;

  public LocationClientImpl(Bus paramBus, LegacyLocationApi paramLegacyLocationApi, LocationApi paramLocationApi, RiderPreferences paramRiderPreferences, SessionPreferences paramSessionPreferences)
  {
    this.mBus = paramBus;
    this.mLegacyLocationApi = paramLegacyLocationApi;
    this.mLocationApi = paramLocationApi;
    this.mSessionPreferences = paramSessionPreferences;
    this.mRiderPreferences = paramRiderPreferences;
  }

  @Deprecated
  private String ensureToken()
  {
    String str = this.mSessionPreferences.getToken();
    if (TextUtils.isEmpty(str))
      throw new IllegalStateException("Token is required");
    return str;
  }

  private boolean isRtApiSearch()
  {
    String str = this.mRiderPreferences.getLocationSearch();
    return (!TextUtils.isEmpty(str)) && (str.equals("rtapi"));
  }

  public void addOrModifyTagWithProphecyReference(String paramString1, String paramString2, String paramString3)
  {
  }

  public void addOrModifyTagWithScavengerId(String paramString1, String paramString2)
  {
  }

  public void autocomplete(double paramDouble1, double paramDouble2, final String paramString)
  {
    Callback local1 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        LocationClientImpl.this.mBus.post(new LocationAutocompleteResponseEvent(paramString, paramAnonymousRetrofitError));
      }

      public void success(LocationAutocompleteResponse paramAnonymousLocationAutocompleteResponse, Response paramAnonymousResponse)
      {
        LocationClientImpl.this.mBus.post(new LocationAutocompleteResponseEvent(paramString, paramAnonymousLocationAutocompleteResponse, paramAnonymousResponse));
      }
    };
    String str1 = ensureToken();
    String str2 = Locale.getDefault().getLanguage();
    if (isRtApiSearch())
    {
      this.mLocationApi.autocomplete(paramDouble1, paramDouble2, paramString, str2, local1);
      return;
    }
    this.mLegacyLocationApi.autocomplete(str1, paramDouble1, paramDouble2, paramString, str2, local1);
  }

  public void deleteTag(String paramString)
  {
  }

  public void details(final String paramString1, final String paramString2)
  {
    Callback local3 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        LocationClientImpl.this.mBus.post(new LocationDetailResponseEvent(paramString1, paramString2, paramAnonymousRetrofitError));
      }

      public void success(LocationSearchResult paramAnonymousLocationSearchResult, Response paramAnonymousResponse)
      {
        LocationClientImpl.this.mBus.post(new LocationDetailResponseEvent(paramString1, paramString2, paramAnonymousLocationSearchResult, paramAnonymousResponse));
      }
    };
    String str1 = ensureToken();
    String str2 = Locale.getDefault().getLanguage();
    if (isRtApiSearch())
    {
      this.mLocationApi.details(paramString1, paramString2, str2, local3);
      return;
    }
    this.mLegacyLocationApi.details(str1, paramString1, paramString2, str2, local3);
  }

  public void frequentLocations()
  {
  }

  public void history(double paramDouble1, double paramDouble2)
  {
    RetrofitCallbackBusAdapter localRetrofitCallbackBusAdapter = new RetrofitCallbackBusAdapter(this.mBus, LocationHistoryResponseEvent.class);
    String str1 = ensureToken();
    String str2 = Locale.getDefault().getLanguage();
    if (isRtApiSearch())
    {
      this.mLocationApi.history(paramDouble1, paramDouble2, str2, localRetrofitCallbackBusAdapter);
      return;
    }
    this.mLegacyLocationApi.history(str1, paramDouble1, paramDouble2, str2, localRetrofitCallbackBusAdapter);
  }

  public void search(double paramDouble1, double paramDouble2, final String paramString)
  {
    Callback local2 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        LocationClientImpl.this.mBus.post(new LocationSearchResponseEvent(paramString, paramAnonymousRetrofitError));
      }

      public void success(LocationSearchResponse paramAnonymousLocationSearchResponse, Response paramAnonymousResponse)
      {
        LocationClientImpl.this.mBus.post(new LocationSearchResponseEvent(paramString, paramAnonymousLocationSearchResponse, paramAnonymousResponse));
      }
    };
    String str1 = ensureToken();
    String str2 = Locale.getDefault().getLanguage();
    if (isRtApiSearch())
    {
      this.mLocationApi.search(paramDouble1, paramDouble2, paramString, str2, Integer.valueOf(1), local2);
      return;
    }
    this.mLegacyLocationApi.search(str1, paramDouble1, paramDouble2, paramString, str2, Integer.valueOf(1), local2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.LocationClientImpl
 * JD-Core Version:    0.6.2
 */