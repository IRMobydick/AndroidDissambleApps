package com.ubercab.client.core.model;

import android.content.Context;
import android.content.res.Resources;

public final class LegacyMobileMessage
{
  private String html;
  private String iconUrl;
  private String id;
  private int vehicleViewId;

  public static LegacyMobileMessage createFakeLegacyMobileMessage(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    LegacyMobileMessage localLegacyMobileMessage = new LegacyMobileMessage();
    localLegacyMobileMessage.setId("mobile_message_xyz");
    localLegacyMobileMessage.setVehicleViewId(1);
    localLegacyMobileMessage.setIconUrl(localResources.getString(2131559286));
    localLegacyMobileMessage.setHtml(localResources.getString(2131559285));
    return localLegacyMobileMessage;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LegacyMobileMessage localLegacyMobileMessage;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLegacyMobileMessage = (LegacyMobileMessage)paramObject;
      if (this.vehicleViewId != localLegacyMobileMessage.vehicleViewId)
        return false;
      if (this.html != null)
      {
        if (this.html.equals(localLegacyMobileMessage.html));
      }
      else
        while (localLegacyMobileMessage.html != null)
          return false;
      if (this.iconUrl != null)
      {
        if (this.iconUrl.equals(localLegacyMobileMessage.iconUrl));
      }
      else
        while (localLegacyMobileMessage.iconUrl != null)
          return false;
      if (this.id == null)
        break;
    }
    while (this.id.equals(localLegacyMobileMessage.id));
    while (true)
    {
      return false;
      if (localLegacyMobileMessage.id == null)
        break;
    }
  }

  public String getHtml()
  {
    return this.html;
  }

  public String getIconUrl()
  {
    return this.iconUrl;
  }

  public String getId()
  {
    return this.id;
  }

  public int getVehicleViewId()
  {
    return this.vehicleViewId;
  }

  public int hashCode()
  {
    int i = 31 * this.vehicleViewId;
    int j;
    int k;
    if (this.id != null)
    {
      j = this.id.hashCode();
      k = 31 * (i + j);
      if (this.iconUrl == null)
        break label89;
    }
    label89: for (int m = this.iconUrl.hashCode(); ; m = 0)
    {
      int n = 31 * (k + m);
      String str = this.html;
      int i1 = 0;
      if (str != null)
        i1 = this.html.hashCode();
      return n + i1;
      j = 0;
      break;
    }
  }

  public void setHtml(String paramString)
  {
    this.html = paramString;
  }

  public void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setVehicleViewId(int paramInt)
  {
    this.vehicleViewId = paramInt;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.LegacyMobileMessage
 * JD-Core Version:    0.6.2
 */