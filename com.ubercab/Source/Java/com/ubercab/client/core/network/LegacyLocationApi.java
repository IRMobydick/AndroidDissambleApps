package com.ubercab.client.core.network;

import com.ubercab.client.core.model.LocationAutocompleteResponse;
import com.ubercab.client.core.model.LocationHistoryResponse;
import com.ubercab.client.core.model.LocationSearchResponse;
import com.ubercab.client.core.model.LocationSearchResult;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

@Deprecated
public abstract interface LegacyLocationApi
{
  @Deprecated
  @GET("/locations/search/v1/predictions")
  public abstract void autocomplete(@Query("token") String paramString1, @Query("latitude") double paramDouble1, @Query("longitude") double paramDouble2, @Query("query") String paramString2, @Query("language") String paramString3, Callback<LocationAutocompleteResponse> paramCallback);

  @Deprecated
  @GET("/locations/search/v1/prediction/details")
  public abstract void details(@Query("token") String paramString1, @Query("reference") String paramString2, @Query("type") String paramString3, @Query("language") String paramString4, Callback<LocationSearchResult> paramCallback);

  @Deprecated
  @GET("/locations/cache/v1/search")
  public abstract void history(@Query("token") String paramString1, @Query("latitude") double paramDouble1, @Query("longitude") double paramDouble2, @Query("language") String paramString2, Callback<LocationHistoryResponse> paramCallback);

  @Deprecated
  @GET("/locations/search/v1/predictions")
  public abstract void search(@Query("token") String paramString1, @Query("latitude") double paramDouble1, @Query("longitude") double paramDouble2, @Query("query") String paramString2, @Query("language") String paramString3, @Query("full-search") Integer paramInteger, Callback<LocationSearchResponse> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.LegacyLocationApi
 * JD-Core Version:    0.6.2
 */