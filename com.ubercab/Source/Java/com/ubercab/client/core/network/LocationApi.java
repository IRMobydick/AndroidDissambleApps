package com.ubercab.client.core.network;

import com.ubercab.client.core.model.LocationAutocompleteResponse;
import com.ubercab.client.core.model.LocationHistoryResponse;
import com.ubercab.client.core.model.LocationSearchResponse;
import com.ubercab.client.core.model.LocationSearchResult;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public abstract interface LocationApi
{
  @GET("/rt/locations/predictions")
  public abstract void autocomplete(@Query("latitude") double paramDouble1, @Query("longitude") double paramDouble2, @Query("query") String paramString1, @Query("language") String paramString2, Callback<LocationAutocompleteResponse> paramCallback);

  @GET("/rt/locations/prediction/details")
  public abstract void details(@Query("reference") String paramString1, @Query("type") String paramString2, @Query("language") String paramString3, Callback<LocationSearchResult> paramCallback);

  @GET("/rt/locations/search")
  public abstract void history(@Query("latitude") double paramDouble1, @Query("longitude") double paramDouble2, @Query("language") String paramString, Callback<LocationHistoryResponse> paramCallback);

  @GET("/rt/locations/predictions")
  public abstract void search(@Query("latitude") double paramDouble1, @Query("longitude") double paramDouble2, @Query("query") String paramString1, @Query("language") String paramString2, @Query("full-search") Integer paramInteger, Callback<LocationSearchResponse> paramCallback);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.LocationApi
 * JD-Core Version:    0.6.2
 */