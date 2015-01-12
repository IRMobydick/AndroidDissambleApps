package com.ubercab.client.core.model;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

public class VehicleViewImage
{
  Integer height;
  String url;
  Integer width;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VehicleViewImage localVehicleViewImage;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localVehicleViewImage = (VehicleViewImage)paramObject;
      if (this.height != null)
      {
        if (this.height.equals(localVehicleViewImage.height));
      }
      else
        while (localVehicleViewImage.height != null)
          return false;
      if (this.url != null)
      {
        if (this.url.equals(localVehicleViewImage.url));
      }
      else
        while (localVehicleViewImage.url != null)
          return false;
      if (this.width == null)
        break;
    }
    while (this.width.equals(localVehicleViewImage.width));
    while (true)
    {
      return false;
      if (localVehicleViewImage.width == null)
        break;
    }
  }

  public int getHeight()
  {
    if (this.height == null)
      return 0;
    return this.height.intValue();
  }

  public Uri getPublicUri()
  {
    if (TextUtils.isEmpty(this.url))
      return Uri.EMPTY;
    return Uri.parse(this.url);
  }

  public Uri getResourceUri(Context paramContext)
  {
    if (TextUtils.isEmpty(this.url))
      return Uri.EMPTY;
    int i = this.url.lastIndexOf(".");
    if (i == -1);
    for (String str1 = this.url; ; str1 = this.url.substring(0, i))
    {
      String str2 = str1.replace("-", "_");
      return new Uri.Builder().scheme("android.resource").authority(paramContext.getPackageName()).appendPath("drawable").appendPath(str2).build();
    }
  }

  public String getUrl()
  {
    return this.url;
  }

  public int getWidth()
  {
    if (this.width == null)
      return 0;
    return this.width.intValue();
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.height != null)
    {
      i = this.height.hashCode();
      j = i * 31;
      if (this.width == null)
        break label77;
    }
    label77: for (int k = this.width.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      String str = this.url;
      int n = 0;
      if (str != null)
        n = this.url.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.VehicleViewImage
 * JD-Core Version:    0.6.2
 */