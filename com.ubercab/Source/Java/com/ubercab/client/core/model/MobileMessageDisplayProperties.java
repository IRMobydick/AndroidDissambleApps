package com.ubercab.client.core.model;

import java.util.Map;

public class MobileMessageDisplayProperties
{
  Boolean autoSelectVehicleView;
  Map<String, Float> headerDividerColor;
  Boolean ignoreVehicleViewCallOut;
  String showAfterRequestingVehicleViewId;
  String showAsFareEstimateInfoForVehicleViewId;
  Boolean showAsModalOverRequestView;
  Boolean showAsPersistantAtBottomOfRequestView;
  Long showAsPersistentAfterRequestingWithTimeout;
  Long showAsPersistentOverRequestViewWithTimeout;
  Boolean showAtBottomOfRequestView;
  String showAtBottomOfRequestViewString;
  Boolean showHeaderOnFullScreen;
  Boolean showInDrawer;
  Boolean showMessageDrawerCallout;
  Boolean showNativeShadow;
  String verticalAlignment;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MobileMessageDisplayProperties localMobileMessageDisplayProperties;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMobileMessageDisplayProperties = (MobileMessageDisplayProperties)paramObject;
      if (this.autoSelectVehicleView != null)
      {
        if (this.autoSelectVehicleView.equals(localMobileMessageDisplayProperties.autoSelectVehicleView));
      }
      else
        while (localMobileMessageDisplayProperties.autoSelectVehicleView != null)
          return false;
      if (this.headerDividerColor != null)
      {
        if (this.headerDividerColor.equals(localMobileMessageDisplayProperties.headerDividerColor));
      }
      else
        while (localMobileMessageDisplayProperties.headerDividerColor != null)
          return false;
      if (this.ignoreVehicleViewCallOut != null)
      {
        if (this.ignoreVehicleViewCallOut.equals(localMobileMessageDisplayProperties.ignoreVehicleViewCallOut));
      }
      else
        while (localMobileMessageDisplayProperties.ignoreVehicleViewCallOut != null)
          return false;
      if (this.showAfterRequestingVehicleViewId != null)
      {
        if (this.showAfterRequestingVehicleViewId.equals(localMobileMessageDisplayProperties.showAfterRequestingVehicleViewId));
      }
      else
        while (localMobileMessageDisplayProperties.showAfterRequestingVehicleViewId != null)
          return false;
      if (this.showAsFareEstimateInfoForVehicleViewId != null)
      {
        if (this.showAsFareEstimateInfoForVehicleViewId.equals(localMobileMessageDisplayProperties.showAsFareEstimateInfoForVehicleViewId));
      }
      else
        while (localMobileMessageDisplayProperties.showAsFareEstimateInfoForVehicleViewId != null)
          return false;
      if (this.showAsModalOverRequestView != null)
      {
        if (this.showAsModalOverRequestView.equals(localMobileMessageDisplayProperties.showAsModalOverRequestView));
      }
      else
        while (localMobileMessageDisplayProperties.showAsModalOverRequestView != null)
          return false;
      if (this.showAsPersistantAtBottomOfRequestView != null)
      {
        if (this.showAsPersistantAtBottomOfRequestView.equals(localMobileMessageDisplayProperties.showAsPersistantAtBottomOfRequestView));
      }
      else
        while (localMobileMessageDisplayProperties.showAsPersistantAtBottomOfRequestView != null)
          return false;
      if (this.showAsPersistentOverRequestViewWithTimeout != null)
      {
        if (this.showAsPersistentOverRequestViewWithTimeout.equals(localMobileMessageDisplayProperties.showAsPersistentOverRequestViewWithTimeout));
      }
      else
        while (localMobileMessageDisplayProperties.showAsPersistentOverRequestViewWithTimeout != null)
          return false;
      if (this.showAsPersistentAfterRequestingWithTimeout != null)
      {
        if (this.showAsPersistentAfterRequestingWithTimeout.equals(localMobileMessageDisplayProperties.showAsPersistentAfterRequestingWithTimeout));
      }
      else
        while (localMobileMessageDisplayProperties.showAsPersistentAfterRequestingWithTimeout != null)
          return false;
      if (this.showAtBottomOfRequestView != null)
      {
        if (this.showAtBottomOfRequestView.equals(localMobileMessageDisplayProperties.showAtBottomOfRequestView));
      }
      else
        while (localMobileMessageDisplayProperties.showAtBottomOfRequestView != null)
          return false;
      if (this.showAtBottomOfRequestViewString != null)
      {
        if (this.showAtBottomOfRequestViewString.equals(localMobileMessageDisplayProperties.showAtBottomOfRequestViewString));
      }
      else
        while (localMobileMessageDisplayProperties.showAtBottomOfRequestViewString != null)
          return false;
      if (this.showHeaderOnFullScreen != null)
      {
        if (this.showHeaderOnFullScreen.equals(localMobileMessageDisplayProperties.showHeaderOnFullScreen));
      }
      else
        while (localMobileMessageDisplayProperties.showHeaderOnFullScreen != null)
          return false;
      if (this.showInDrawer != null)
      {
        if (this.showInDrawer.equals(localMobileMessageDisplayProperties.showInDrawer));
      }
      else
        while (localMobileMessageDisplayProperties.showInDrawer != null)
          return false;
      if (this.showMessageDrawerCallout != null)
      {
        if (this.showMessageDrawerCallout.equals(localMobileMessageDisplayProperties.showMessageDrawerCallout));
      }
      else
        while (localMobileMessageDisplayProperties.showMessageDrawerCallout != null)
          return false;
      if (this.showNativeShadow != null)
      {
        if (this.showNativeShadow.equals(localMobileMessageDisplayProperties.showNativeShadow));
      }
      else
        while (localMobileMessageDisplayProperties.showNativeShadow != null)
          return false;
      if (this.verticalAlignment == null)
        break;
    }
    while (this.verticalAlignment.equals(localMobileMessageDisplayProperties.verticalAlignment));
    while (true)
    {
      return false;
      if (localMobileMessageDisplayProperties.verticalAlignment == null)
        break;
    }
  }

  public boolean getAutoSelectVehicleView()
  {
    if (this.autoSelectVehicleView != null)
      return this.autoSelectVehicleView.booleanValue();
    return false;
  }

  public Map<String, Float> getHeaderDividerColor()
  {
    return this.headerDividerColor;
  }

  public Boolean getIgnoreVehicleViewCallOut()
  {
    return this.ignoreVehicleViewCallOut;
  }

  public String getShowAfterRequestingVehicleViewId()
  {
    return this.showAfterRequestingVehicleViewId;
  }

  public String getShowAsFareEstimateInfoForVehicleViewId()
  {
    return this.showAsFareEstimateInfoForVehicleViewId;
  }

  public Boolean getShowAsPersistantAtBottomOfRequestView()
  {
    return this.showAsPersistantAtBottomOfRequestView;
  }

  public long getShowAsPersistentAfterRequestingWithTimeout()
  {
    if (this.showAsPersistentAfterRequestingWithTimeout == null)
      return 0L;
    return this.showAsPersistentAfterRequestingWithTimeout.longValue();
  }

  public Long getShowAsPersistentOverRequestViewWithTimeout()
  {
    return this.showAsPersistentOverRequestViewWithTimeout;
  }

  public Boolean getShowAtBottomOfRequestView()
  {
    return this.showAtBottomOfRequestView;
  }

  public String getShowAtBottomOfRequestViewString()
  {
    return this.showAtBottomOfRequestViewString;
  }

  public Boolean getShowHeaderOnFullScreen()
  {
    return this.showHeaderOnFullScreen;
  }

  public Boolean getShowInDrawer()
  {
    return this.showInDrawer;
  }

  public Boolean getShowMessageDrawerCallout()
  {
    return this.showMessageDrawerCallout;
  }

  public Boolean getShowNativeShadow()
  {
    return this.showNativeShadow;
  }

  public String getVerticalAlignment()
  {
    return this.verticalAlignment;
  }

  public int hashCode()
  {
    int i;
    int k;
    label37: int n;
    label61: int i2;
    label87: int i4;
    label113: int i6;
    label139: int i8;
    label165: int i10;
    label191: int i12;
    label217: int i14;
    label243: int i16;
    label269: int i18;
    label295: int i20;
    label321: int i22;
    label347: int i23;
    if (this.autoSelectVehicleView != null)
    {
      i = this.autoSelectVehicleView.hashCode();
      int j = i * 31;
      if (this.headerDividerColor == null)
        break label417;
      k = this.headerDividerColor.hashCode();
      int m = 31 * (j + k);
      if (this.ignoreVehicleViewCallOut == null)
        break label422;
      n = this.ignoreVehicleViewCallOut.hashCode();
      int i1 = 31 * (m + n);
      if (this.showAfterRequestingVehicleViewId == null)
        break label428;
      i2 = this.showAfterRequestingVehicleViewId.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.showAsPersistentAfterRequestingWithTimeout == null)
        break label434;
      i4 = this.showAsPersistentAfterRequestingWithTimeout.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.showAsModalOverRequestView == null)
        break label440;
      i6 = this.showAsModalOverRequestView.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.showAsPersistantAtBottomOfRequestView == null)
        break label446;
      i8 = this.showAsPersistantAtBottomOfRequestView.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.showAsPersistentOverRequestViewWithTimeout == null)
        break label452;
      i10 = this.showAsPersistentOverRequestViewWithTimeout.hashCode();
      int i11 = 31 * (i9 + i10);
      if (this.showAtBottomOfRequestView == null)
        break label458;
      i12 = this.showAtBottomOfRequestView.hashCode();
      int i13 = 31 * (i11 + i12);
      if (this.showAtBottomOfRequestViewString == null)
        break label464;
      i14 = this.showAtBottomOfRequestViewString.hashCode();
      int i15 = 31 * (i13 + i14);
      if (this.showAsFareEstimateInfoForVehicleViewId == null)
        break label470;
      i16 = this.showAsFareEstimateInfoForVehicleViewId.hashCode();
      int i17 = 31 * (i15 + i16);
      if (this.showHeaderOnFullScreen == null)
        break label476;
      i18 = this.showHeaderOnFullScreen.hashCode();
      int i19 = 31 * (i17 + i18);
      if (this.showInDrawer == null)
        break label482;
      i20 = this.showInDrawer.hashCode();
      int i21 = 31 * (i19 + i20);
      if (this.showMessageDrawerCallout == null)
        break label488;
      i22 = this.showMessageDrawerCallout.hashCode();
      i23 = 31 * (i21 + i22);
      if (this.showNativeShadow == null)
        break label494;
    }
    label417: label422: label428: label434: label440: label446: label452: label458: label464: label470: label476: label482: label488: label494: for (int i24 = this.showNativeShadow.hashCode(); ; i24 = 0)
    {
      int i25 = 31 * (i23 + i24);
      String str = this.verticalAlignment;
      int i26 = 0;
      if (str != null)
        i26 = this.verticalAlignment.hashCode();
      return i25 + i26;
      i = 0;
      break;
      k = 0;
      break label37;
      n = 0;
      break label61;
      i2 = 0;
      break label87;
      i4 = 0;
      break label113;
      i6 = 0;
      break label139;
      i8 = 0;
      break label165;
      i10 = 0;
      break label191;
      i12 = 0;
      break label217;
      i14 = 0;
      break label243;
      i16 = 0;
      break label269;
      i18 = 0;
      break label295;
      i20 = 0;
      break label321;
      i22 = 0;
      break label347;
    }
  }

  public boolean isShowAsModalOverRequestView()
  {
    if (this.showAsModalOverRequestView == null)
      return false;
    return this.showAsModalOverRequestView.booleanValue();
  }

  public MobileMessageDisplayProperties setShowAsModalOverRequestView(boolean paramBoolean)
  {
    this.showAsModalOverRequestView = Boolean.valueOf(paramBoolean);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.MobileMessageDisplayProperties
 * JD-Core Version:    0.6.2
 */