package com.ubercab.client.feature.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.util.CharacterUtils;

public class LocationSearchResultWrapper
{
  private Context mContext;
  private int mImageResource;
  private LocationSearchResult mLocationSearchResult;
  private String mSubtitle;
  private String mTag;
  private String mTitle;

  public LocationSearchResultWrapper(Context paramContext, LocationSearchResult paramLocationSearchResult)
  {
    this.mContext = paramContext;
    this.mLocationSearchResult = paramLocationSearchResult;
    this.mTag = paramLocationSearchResult.getTag();
    this.mImageResource = getImageResourceForLocation();
    this.mTitle = getTitleForLocation();
    this.mSubtitle = getSubtitleForLocation();
  }

  public LocationSearchResultWrapper(Context paramContext, LocationSearchResult paramLocationSearchResult, String paramString)
  {
    this.mContext = paramContext;
    this.mLocationSearchResult = paramLocationSearchResult;
    this.mTag = paramString;
    this.mImageResource = getImageResourceForLocation();
    this.mTitle = getTitleForLocation();
    this.mSubtitle = getSubtitleForLocation();
  }

  public LocationSearchResultWrapper(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mTag = paramString;
    this.mImageResource = getImageResourceForLocation();
    Resources localResources = this.mContext.getResources();
    if (isTagHome())
    {
      this.mTitle = localResources.getString(2131558427, new Object[] { CharacterUtils.capitalizeFirstLetter(localResources.getString(2131558891)) });
      this.mImageResource = 2130837762;
    }
    while (!isTagWork())
      return;
    this.mTitle = localResources.getString(2131558427, new Object[] { CharacterUtils.capitalizeFirstLetter(localResources.getString(2131559348)) });
    this.mImageResource = 2130837773;
  }

  private int getImageResourceForLocation()
  {
    if ((this.mLocationSearchResult != null) && (("cache".equals(this.mLocationSearchResult.getType())) || ("cache".equals(this.mLocationSearchResult.getServiceType()))));
    for (int i = 1; isTagHome(); i = 0)
      return 2130837762;
    if (isTagWork())
      return 2130837773;
    if (i != 0)
      return 2130837761;
    return 2130837770;
  }

  private String getSubtitleForLocation()
  {
    if (this.mLocationSearchResult == null)
      return "";
    if (isTagged())
      return this.mLocationSearchResult.getTitle();
    return this.mLocationSearchResult.getSubtitle();
  }

  private String getTitleForLocation()
  {
    Resources localResources = this.mContext.getResources();
    if (isTagHome())
      return CharacterUtils.capitalizeFirstLetter(localResources.getString(2131558891));
    if (isTagWork())
      return CharacterUtils.capitalizeFirstLetter(localResources.getString(2131559348));
    if (this.mLocationSearchResult != null)
      return this.mLocationSearchResult.getTitle();
    return "";
  }

  private boolean isTagHome()
  {
    return LocationSearchResult.isTagHome(this.mTag);
  }

  private boolean isTagWork()
  {
    return LocationSearchResult.isTagWork(this.mTag);
  }

  public int getImageResource()
  {
    return this.mImageResource;
  }

  public LocationSearchResult getLocationSearchResult()
  {
    return this.mLocationSearchResult;
  }

  public String getSubtitle()
  {
    return this.mSubtitle;
  }

  public String getTag()
  {
    return this.mTag;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public int getTitleColor()
  {
    if ((isTagged()) && (this.mLocationSearchResult == null))
      return this.mContext.getResources().getColor(2131296329);
    return this.mContext.getResources().getColor(2131296316);
  }

  public boolean isTagged()
  {
    return !TextUtils.isEmpty(this.mTag);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchResultWrapper
 * JD-Core Version:    0.6.2
 */